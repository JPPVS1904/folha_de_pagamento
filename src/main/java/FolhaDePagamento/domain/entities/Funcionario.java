package FolhaDePagamento.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.CascadeType;

@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne(cascade = CascadeType.ALL)
    private Cargo cargo;

    private int mesContratacao;
    private int anoContratacao;
    private double horasExtras;

    public Funcionario() {}

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
