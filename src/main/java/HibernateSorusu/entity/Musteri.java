package HibernateSorusu.entity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Musteri {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;
    private String lastName;
    @OneToMany(mappedBy = "musteri",fetch = FetchType.EAGER)
    private List<Siparis> siparis;


    public Musteri(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
