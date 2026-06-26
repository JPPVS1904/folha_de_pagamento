package FolhaDePagamento.adapters.in.web;

public class GerarFolhaRequest {
    private Long funcionarioId;
    private int mesFolha;
    private int anoFolha;
    private boolean feriasNoMes;

    public Long getFuncionarioId() {
        return funcionarioId;
    }
    public void setFuncionarioId(Long funcionarioId) {
        this.funcionarioId = funcionarioId;
    }
    public int getMesFolha() {
        return mesFolha;
    }
    public void setMesFolha(int mesFolha) {
        this.mesFolha = mesFolha;
    }
    public int getAnoFolha() {
        return anoFolha;
    }
    public void setAnoFolha(int anoFolha) {
        this.anoFolha = anoFolha;
    }
    public boolean isFeriasNoMes() {
        return feriasNoMes;
    }
    public void setFeriasNoMes(boolean feriasNoMes) {
        this.feriasNoMes = feriasNoMes;
    }
}
