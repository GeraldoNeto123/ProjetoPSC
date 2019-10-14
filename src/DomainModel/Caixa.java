package DomainModel;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "caixa")

public class Caixa {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data;    
    @Column
    private float saldo;
    @Column
    private float retiradas;
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    

    
    public float getRetiradas() {
        return retiradas;
    }

    public void setRetiradas(float retiradas) {
        this.retiradas = retiradas;
    }
}
