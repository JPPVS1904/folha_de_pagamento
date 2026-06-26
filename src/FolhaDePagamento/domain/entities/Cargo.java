package FolhaDePagamento.domain.entities;

public class Cargo {

    private String nome;
    private double salarioBase;

    public Cargo(String nome, double salarioBase) {
        this.nome = nome;
        this.salarioBase = salarioBase;
    }

    public String getNome() {
        return nome;
    }

    public double getSalarioBase() {
        return salarioBase;
    }
}