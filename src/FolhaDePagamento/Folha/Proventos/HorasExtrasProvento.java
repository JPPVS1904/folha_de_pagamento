package FolhaDePagamento.Folha.Proventos;

import FolhaDePagamento.Folha.ItemFolha;

import FolhaDePagamento.Funcionario;

public class HorasExtrasProvento implements CalculadorProvento {
    @Override
    public ItemFolha calcular(Funcionario f, int mesFolha, int anoFolha, boolean feriasNoMes) {
        double salarioBase = f.getCargo().getSalarioBase();
        double valorHora = salarioBase / 220;
        double horasExtras = f.getHorasExtras() * valorHora * 1.5;
        return new ItemFolha("Horas Extras", horasExtras);
    }
}
