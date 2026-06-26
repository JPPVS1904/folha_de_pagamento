package FolhaDePagamento.Folha.Proventos;

import FolhaDePagamento.Folha.ItemFolha;

import FolhaDePagamento.Funcionario;

public interface CalculadorProvento {
    ItemFolha calcular(Funcionario f, int mesFolha, int anoFolha, boolean feriasNoMes);
}
