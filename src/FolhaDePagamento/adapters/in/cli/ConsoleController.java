package FolhaDePagamento.adapters.in.cli;

import FolhaDePagamento.domain.entities.Cargo;
import FolhaDePagamento.domain.entities.Funcionario;
import FolhaDePagamento.domain.entities.ResultadoFolha;
import FolhaDePagamento.domain.calculators.Impostos.CalcularImposto;
import FolhaDePagamento.domain.calculators.Impostos.ImpostoFactory;
import FolhaDePagamento.application.usecases.GerarFolhaUseCase;
import FolhaDePagamento.adapters.out.cli.ConsolePresenter;

import java.util.Calendar;
import java.util.Scanner;

public class ConsoleController {

    Scanner sc = new Scanner(System.in);
    int continuar = 1;
    Calendar data = Calendar.getInstance();

    private Cargo escolherCargo() {
        int opcao;
        double salarioPersonalizado = 0;

        System.out.println("""
                Escolha o cargo:
                
                1 - Auxiliar
                
                2 - Encarregado
                
                3 - Gerente
                
                4 - Personalizado""");

        while (true) {
            opcao = sc.nextInt();

            if (opcao < 1 || opcao > 4) {
                System.out.println("Opção Inválida.");
            } else {
                break;
            }
        }

        if (opcao == 4) {
            System.out.print("Informe o salário do cargo personalizado: ");
            salarioPersonalizado = sc.nextDouble();
        }

        return switch (opcao) {
            case 1 -> new Cargo("Auxiliar", 1621);
            case 2 -> new Cargo("Encarregado", 2500);
            case 3 -> new Cargo("Gerente", 5000);
            case 4 -> new Cargo("Personalizado", salarioPersonalizado);
            default -> new Cargo("Auxiliar", 1621);
        };
    }

    public void iniciar() {
        while (continuar == 1) {
            Funcionario f = new Funcionario(null, null, 0, 0, 0);

            System.out.print("\nNome do funcionário: ");
            f.setNome(sc.next());

            // DEFINE O CARGO
            f.setCargo(escolherCargo());


            while (true) {
                System.out.print("Ano de contratação: ");
                f.setAnoContratacao(sc.nextInt());

                if (f.getAnoContratacao() > data.get(Calendar.YEAR)) {
                    System.out.println("Erro de cálculo: Ano maior que o atual");
                } else {
                    break;
                }
            }

            while (true) {
                System.out.print("Mês de contratação: ");
                f.setMesContratacao(sc.nextInt());

                if (f.getMesContratacao() < 1 || f.getMesContratacao() > 12) {
                    System.out.println("Erro de cálculo: Mês informado inválido");
                } else {
                    if (f.getAnoContratacao() == data.get(Calendar.YEAR)
                            && f.getMesContratacao() > data.get(Calendar.MONTH)) {
                        System.out.println("Erro de cálculo: Mês informado inválido.");
                    } else {
                        break;
                    }
                }
            }

            int anoFolha;
            while (true) {
                System.out.print("Informe o ano da folha: ");
                anoFolha = sc.nextInt();

                if (anoFolha < f.getAnoContratacao() ||
                        anoFolha > data.get(Calendar.YEAR)) {
                    System.out.println("Erro de cálculo: Ano informado inválido.");
                } else {
                    break;
                }
            }

            int mesFolha;
            while (true) {
                System.out.print("Informe o mês da folha: ");
                mesFolha = sc.nextInt();

                if (mesFolha < 1 || mesFolha > 12) {
                    System.out.println("Erro de cálculo: Mês informado inválido");
                } else {
                    if (anoFolha == data.get(Calendar.YEAR)
                            && mesFolha > data.get(Calendar.MONTH)) {
                        System.out.println("Erro de cálculo: Mês maior que o atual.");
                    } else {
                        break;
                    }
                }
            }

            // VERIFICA FÉRIAS
            boolean feriasNoMes = false;
            if (f.temDireitoFerias(mesFolha, anoFolha)) {
                System.out.println("""
                        Funcionário esteve de férias nesse mês?
                        
                        1 - SIM
                        
                        2 - NÃO""");

                feriasNoMes = (sc.nextInt() == 1);
            }

            // HORAS EXTRAS
            if (!feriasNoMes) {
                while (true) {
                    System.out.print("Horas extras do mês: ");
                    f.setHorasExtras(sc.nextDouble());

                    if (f.getHorasExtras() < 0) {
                        System.out.println("Erro de Cálculo: Horas informadas inválidas");
                    } else {
                        break;
                    }
                }
            }

            // DEFINE OS IMPOSTOS DO ANO
            CalcularImposto imposto = ImpostoFactory.criar(anoFolha);

            ResultadoFolha resultado =
                    GerarFolhaUseCase.executar(
                            f,
                            mesFolha,
                            anoFolha,
                            feriasNoMes,
                            imposto
                    );

            ConsolePresenter.imprimir(resultado);

            System.out.println("""
                    
                    Deseja calcular outro funcionário?
                    
                    1 - SIM
                    
                    2 - NÃO""");

            continuar = sc.nextInt();
        }

        System.out.println("Fim do programa. ( o-o)b");
        sc.close();
    }
}