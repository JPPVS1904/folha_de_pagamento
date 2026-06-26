package FolhaDePagamento.Folha.Descontos;

import FolhaDePagamento.Folha.ItemFolha;

import FolhaDePagamento.Impostos.CalcularImposto;

public class INSSDesconto implements CalculadorDesconto {
    @Override
    public ItemFolha calcular(double baseDeCalculo, CalcularImposto calculoImposto) {
        return new ItemFolha("INSS", calculoImposto.calcularINSS(baseDeCalculo));
    }
}
