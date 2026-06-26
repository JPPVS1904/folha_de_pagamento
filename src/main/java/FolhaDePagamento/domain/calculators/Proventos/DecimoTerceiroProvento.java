package FolhaDePagamento.domain.calculators.Proventos;

import FolhaDePagamento.domain.entities.ItemFolha;
import FolhaDePagamento.domain.entities.Funcionario;

public class DecimoTerceiroProvento implements CalculadorProvento {
    @Override
    public ItemFolha calcular(Funcionario f, int mesFolha, int anoFolha, boolean feriasNoMes) {
        double salarioBase = f.getCargo().getSalarioBase();
        double decimoTerceiro = 0;

        if (mesFolha == 11 || mesFolha == 12) {
            decimoTerceiro = salarioBase / 2;
        }

        return new ItemFolha("13º Salário", decimoTerceiro);
    }
}
