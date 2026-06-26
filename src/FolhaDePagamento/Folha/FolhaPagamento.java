package FolhaDePagamento.Folha;

import FolhaDePagamento.Funcionario;
import FolhaDePagamento.Impostos.CalcularImposto;
import FolhaDePagamento.Folha.Proventos.*;
import FolhaDePagamento.Folha.Descontos.*;
import java.util.Arrays;
import java.util.List;

public class FolhaPagamento {

    public static ResultadoFolha gerarFolha(
            Funcionario f,
            int mesFolha,
            int anoFolha,
            boolean feriasNoMes,
            CalcularImposto imposto) {

        ResultadoFolha r = new ResultadoFolha();
        r.nome = f.getNome();
        r.cargo = f.getCargo().getNome();
        r.mesFolha = mesFolha;
        r.anoFolha = anoFolha;

        // Lista de Proventos configurados (Scalability point)
        List<CalculadorProvento> calculadoresProvento = Arrays.asList(
                new SalarioBaseProvento(),
                new HorasExtrasProvento(),
                new DecimoTerceiroProvento(),
                new FeriasProvento()
        );

        // Processa proventos
        for (CalculadorProvento calc : calculadoresProvento) {
            ItemFolha item = calc.calcular(f, mesFolha, anoFolha, feriasNoMes);
            if (item.getValor() > 0) {
                r.proventos.add(item);
            }
        }

        double bruto = r.getTotalProventos();

        // Lista de Descontos configurados
        List<CalculadorDesconto> calculadoresDesconto = Arrays.asList(
                new INSSDesconto(),
                new IRRFDesconto()
        );

        // Processa descontos
        for (CalculadorDesconto calc : calculadoresDesconto) {
            ItemFolha item = calc.calcular(bruto, imposto);
            if (item.getValor() > 0) {
                r.descontos.add(item);
            }
        }

        // Lista de Informativos configurados
        List<CalculadorDesconto> calculadoresInformativos = Arrays.asList(
                new FGTSInformativo()
        );

        for (CalculadorDesconto calc : calculadoresInformativos) {
            ItemFolha item = calc.calcular(bruto, imposto);
            if (item.getValor() > 0) {
                r.informativos.add(item);
            }
        }

        return r;
    }
}