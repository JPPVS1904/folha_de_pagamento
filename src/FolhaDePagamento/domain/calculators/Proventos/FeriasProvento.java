package FolhaDePagamento.domain.calculators.Proventos;

import FolhaDePagamento.domain.entities.ItemFolha;
import FolhaDePagamento.domain.entities.Funcionario;

public class FeriasProvento implements CalculadorProvento {
    @Override
    public ItemFolha calcular(Funcionario f, int mesFolha, int anoFolha, boolean feriasNoMes) {
        double ferias = 0;
        double adicionalFerias = 0;

        if (feriasNoMes) {
            ferias = f.getCargo().getSalarioBase();
            adicionalFerias = ferias / 3;
        }

        return new ItemFolha("Férias + 1/3", ferias + adicionalFerias);
    }
}
