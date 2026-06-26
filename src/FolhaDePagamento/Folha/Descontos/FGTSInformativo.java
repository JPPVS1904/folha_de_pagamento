package FolhaDePagamento.Folha.Descontos;

import FolhaDePagamento.Folha.ItemFolha;

import FolhaDePagamento.Impostos.CalcularImposto;

public class FGTSInformativo implements CalculadorDesconto {
    @Override
    public ItemFolha calcular(double baseDeCalculo, CalcularImposto calculoImposto) {
        return new ItemFolha("FGTS (informativo)", calculoImposto.calcularFGTS(baseDeCalculo));
    }
}
