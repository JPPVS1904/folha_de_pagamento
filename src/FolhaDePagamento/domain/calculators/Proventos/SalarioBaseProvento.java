package FolhaDePagamento.domain.calculators.Proventos;

import FolhaDePagamento.domain.entities.ItemFolha;
import FolhaDePagamento.domain.entities.Funcionario;

public class SalarioBaseProvento implements CalculadorProvento {
    @Override
    public ItemFolha calcular(Funcionario f, int mesFolha, int anoFolha, boolean feriasNoMes) {
        return new ItemFolha("Salário Base", f.getCargo().getSalarioBase());
    }
}
