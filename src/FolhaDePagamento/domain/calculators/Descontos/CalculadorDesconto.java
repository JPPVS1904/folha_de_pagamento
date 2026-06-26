package FolhaDePagamento.domain.calculators.Descontos;

import FolhaDePagamento.domain.entities.ItemFolha;
import FolhaDePagamento.domain.calculators.Impostos.CalcularImposto;

public interface CalculadorDesconto {
    ItemFolha calcular(double baseDeCalculo, CalcularImposto calculoImposto);
}
