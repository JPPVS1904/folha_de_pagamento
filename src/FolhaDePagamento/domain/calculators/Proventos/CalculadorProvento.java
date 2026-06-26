package FolhaDePagamento.domain.calculators.Proventos;

import FolhaDePagamento.domain.entities.ItemFolha;
import FolhaDePagamento.domain.entities.Funcionario;

public interface CalculadorProvento {
    ItemFolha calcular(Funcionario f, int mesFolha, int anoFolha, boolean feriasNoMes);
}
