package FolhaDePagamento.Folha;

import java.util.ArrayList;
import java.util.List;

public class ResultadoFolha {

    public String nome;
    public String cargo;
    public int mesFolha;
    public int anoFolha;

    public List<ItemFolha> proventos = new ArrayList<>();
    public List<ItemFolha> descontos = new ArrayList<>();
    public List<ItemFolha> informativos = new ArrayList<>();

    public double getTotalProventos() {
        return proventos.stream().mapToDouble(ItemFolha::getValor).sum();
    }

    public double getTotalDescontos() {
        return descontos.stream().mapToDouble(ItemFolha::getValor).sum();
    }

    public double getLiquido() {
        return getTotalProventos() - getTotalDescontos();
    }
}