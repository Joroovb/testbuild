package nl.joris.joris.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Chip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long code;

    @OneToOne(mappedBy = "chip")
    @JsonIgnore
    private Kat kat;

    public Chip() {}

    public Chip(Long code, Kat kat) {
        this.code = code;
        this.kat = kat;
    }

    public Long getId() {
        return id;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Kat getKat() {
        return kat;
    }

    public void setKat(Kat kat) {
        this.kat = kat;
    }
}
