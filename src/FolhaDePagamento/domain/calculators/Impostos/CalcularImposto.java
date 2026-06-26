package FolhaDePagamento.domain.calculators.Impostos;

public interface CalcularImposto {

    double calcularINSS(double salario);

    double calcularIRRF(double salario);

    double calcularFGTS(double salario);

}
