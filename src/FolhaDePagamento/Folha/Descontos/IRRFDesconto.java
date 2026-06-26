package FolhaDePagamento.Folha.Descontos;

import FolhaDePagamento.Folha.ItemFolha;

import FolhaDePagamento.Impostos.CalcularImposto;

public class IRRFDesconto implements CalculadorDesconto {
    @Override
    public ItemFolha calcular(double baseDeCalculo, CalcularImposto calculoImposto) {
        return new ItemFolha("IRRF", calculoImposto.calcularIRRF(baseDeCalculo));
    }
}
