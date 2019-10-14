package DomainModel;
import javax.persistence.*;

@Entity
@Table(name = "vendaMercadoria")

public class VendaMercadoria {
    @Id
    private int idVenda;
    @Id
    private int idMercadoria;
    @Column
    private int quantidade;
    @Column
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public long getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public long getIdMercadoria() {
        return idMercadoria;
    }

    public void setIdMercadoria(int idMercadoria) {
        this.idMercadoria = idMercadoria;
    }


}
