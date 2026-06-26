package FolhaDePagamento.Folha.Descontos;

import FolhaDePagamento.Folha.ItemFolha;

import FolhaDePagamento.Impostos.CalcularImposto;

public interface CalculadorDesconto {
    ItemFolha calcular(double baseDeCalculo, CalcularImposto calculoImposto);
}
