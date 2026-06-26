package FolhaDePagamento.domain.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ResultadoFolha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String nome;
    public String cargo;
    public int mesFolha;
    public int anoFolha;

    @ElementCollection
    public List<ItemFolha> proventos = new ArrayList<>();
    
    @ElementCollection
    public List<ItemFolha> descontos = new ArrayList<>();
    
    @ElementCollection
    public List<ItemFolha> informativos = new ArrayList<>();

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

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