package FolhaDePagamento.Folha.Proventos;

import FolhaDePagamento.Folha.ItemFolha;

import FolhaDePagamento.Funcionario;

public class SalarioBaseProvento implements CalculadorProvento {
    @Override
    public ItemFolha calcular(Funcionario f, int mesFolha, int anoFolha, boolean feriasNoMes) {
        return new ItemFolha("Salário Base", f.getCargo().getSalarioBase());
    }
}
