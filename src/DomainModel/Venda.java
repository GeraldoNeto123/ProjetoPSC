package DomainModel;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "venda")

public class Venda {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long codigo;
    @Column
    private float valorTotal;
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data;
   
    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    } 
    
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
