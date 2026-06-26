package FolhaDePagamento.domain.calculators.Descontos;

import FolhaDePagamento.domain.entities.ItemFolha;
import FolhaDePagamento.domain.calculators.Impostos.CalcularImposto;

public class INSSDesconto implements CalculadorDesconto {
    @Override
    public ItemFolha calcular(double baseDeCalculo, CalcularImposto calculoImposto) {
        return new ItemFolha("INSS", calculoImposto.calcularINSS(baseDeCalculo));
    }
}
