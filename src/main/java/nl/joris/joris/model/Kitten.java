package nl.joris.joris.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Kitten {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String naam;

    @ManyToOne
    @JsonBackReference
    private Kat kat;

    public Kitten() {}

    public Kitten(String naam, Kat kat) {
        this.naam = naam;
        this.kat = kat;
    }

    public Long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Kat getKat() {
        return kat;
    }

    public void setKat(Kat kat) {
        this.kat = kat;
    }
}
