package FolhaDePagamento.Folha;

public class ItemFolha {
    private String descricao;
    private double valor;

    public ItemFolha(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }
}
