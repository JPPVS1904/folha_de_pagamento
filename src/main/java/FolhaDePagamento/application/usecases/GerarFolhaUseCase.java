package FolhaDePagamento.application.usecases;

import FolhaDePagamento.domain.entities.Funcionario;
import FolhaDePagamento.domain.entities.ItemFolha;
import FolhaDePagamento.domain.entities.ResultadoFolha;
import FolhaDePagamento.domain.calculators.Impostos.CalcularImposto;
import FolhaDePagamento.domain.calculators.Impostos.ImpostoFactory;
import FolhaDePagamento.domain.calculators.Proventos.*;
import FolhaDePagamento.domain.calculators.Descontos.*;
import FolhaDePagamento.repositories.FuncionarioRepository;
import FolhaDePagamento.repositories.ResultadoFolhaRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
public class GerarFolhaUseCase {

    private final FuncionarioRepository funcionarioRepository;
    private final ResultadoFolhaRepository resultadoFolhaRepository;

    public GerarFolhaUseCase(FuncionarioRepository funcionarioRepository, ResultadoFolhaRepository resultadoFolhaRepository) {
        this.funcionarioRepository = funcionarioRepository;
        this.resultadoFolhaRepository = resultadoFolhaRepository;
    }

    @Transactional
    public ResultadoFolha executar(
            Long funcionarioId,
            int mesFolha,
            int anoFolha,
            boolean feriasNoMes) {

        Funcionario f = funcionarioRepository.findById(funcionarioId)
                .orElseThrow(() -> new IllegalArgumentException("Funcionário não encontrado"));

        CalcularImposto imposto = ImpostoFactory.criar(anoFolha);

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

        return resultadoFolhaRepository.save(r);
    }
}