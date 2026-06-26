package FolhaDePagamento.domain.entities;

import java.math.BigDecimal;

public class Funcionario {

    private String nome;
    private Cargo cargo;
    private int mesContratacao;
    private int anoContratacao;
    private double horasExtras;

    public Funcionario(
            String nome,
            Cargo cargo,
            int mesContratacao,
            int anoContratacao,
            double horasExtras)
    {
        this.nome = nome;
        this.cargo = cargo;
        this.mesContratacao = mesContratacao;
        this.anoContratacao = anoContratacao;
        this.horasExtras = horasExtras;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public int getMesContratacao() {
        return mesContratacao;
    }

    public void setMesContratacao(int mesContratacao) {
        this.mesContratacao = mesContratacao;
    }

    public int getAnoContratacao() {
        return anoContratacao;
    }

    public void setAnoContratacao(int anoContratacao) {
        this.anoContratacao = anoContratacao;
    }

    public double getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(double horasExtras) {
        this.horasExtras = horasExtras;
    }

    // CALCULA TEMPO TRABALHADO
    public boolean temDireitoFerias(int mesFolha, int anoFolha) {

        int meses =
                (anoFolha - anoContratacao) * 12 +
                        (mesFolha - mesContratacao);

        return meses >= 12;
    }
}
