package FromJsonToMysql.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Prodotto {

    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private String name;
    private double prezzo;
    private double prezzo_scontato;


}
