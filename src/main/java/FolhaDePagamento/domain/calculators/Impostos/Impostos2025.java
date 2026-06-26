package FolhaDePagamento.domain.calculators.Impostos;

public class Impostos2025 implements CalcularImposto {

    public double calcularINSS(double salario) {
        if (salario <= 1412) return salario * 0.075;
        else if (salario <= 2666.68) return salario * 0.09;
        else if (salario <= 4000) return salario * 0.12;
        else return salario * 0.14;
    }

    public double calcularIRRF(double salario) {
        if (salario <= 2112) return 0;
        else if (salario <= 2826.65) return salario * 0.075;
        else if (salario <= 3751.05) return salario * 0.15;
        else if (salario <= 4664.68) return salario * 0.225;
        else return salario * 0.275;
    }

    public double calcularFGTS(double salario) {
        return salario * 0.08;
    }
}
