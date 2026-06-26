package FolhaDePagamento.domain.calculators.Impostos;

import java.math.BigDecimal;

public class FaixaImposto {

    private BigDecimal limite;
    private BigDecimal aliquota;

    public FaixaImposto(double limite, double aliquota) {
        this.limite = BigDecimal.valueOf(limite);
        this.aliquota = BigDecimal.valueOf(aliquota);
    }

    public BigDecimal getLimite() {
        return limite;
    }

    public BigDecimal getAliquota() {
        return aliquota;
    }
}
