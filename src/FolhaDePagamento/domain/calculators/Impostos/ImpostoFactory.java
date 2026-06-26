package FolhaDePagamento.domain.calculators.Impostos;

public class ImpostoFactory {

    public static CalcularImposto criar(int ano) {

        if (ano <= 2025) {
            return new Impostos2025();
        }

        if (ano == 2026) {
            return new Impostos2026();
        }

        throw new IllegalArgumentException("Não existem regras de imposto para o ano: " + ano);
    }
}
