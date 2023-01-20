package HibernateSorusu.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class SiparisKalemi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne(cascade = CascadeType.ALL)
    private Urun urun;
    private int alinanUrunAdedi;

    public SiparisKalemi(Urun urun, int alinanUrunAdedi) {
        this.urun = urun;
        this.alinanUrunAdedi = alinanUrunAdedi;
    }
}
