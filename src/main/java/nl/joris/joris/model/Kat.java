package nl.joris.joris.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.data.relational.core.sql.In;

import java.util.ArrayList;
import java.util.List;

// One to one
// many to one
// one to many
// many to many


@Entity
public class Kat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String naam;
    private Integer leeftijd;

    @OneToOne
    @JoinColumn(name = "chip_id")
    private Chip chip;

    @OneToMany
    @JsonManagedReference
    private List<Kitten> kittens = new ArrayList<>();

    // Eigenaarskant van de relatie
    @ManyToMany
    @JoinTable(
            name = "katten_mensen",
            joinColumns = @JoinColumn(name = "kat_id"),
            inverseJoinColumns = @JoinColumn(name = "mens_id")
    )
    private List<Mens> mensen = new ArrayList<>();

    // default constructor
    public Kat() {}

    // constructor om alle velden behalve id te zetten
    public Kat(String naam, Integer leeftijd) {
        this.naam = naam;
        this.leeftijd = leeftijd;
    }

    public Long getId() {
        return id;
    }

    public Chip getChip() {
        return chip;
    }

    public void setChip(Chip chip) {
        this.chip = chip;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Integer getLeeftijd() {
        return leeftijd;
    }

    public void setLeeftijd(Integer leeftijd) {
        this.leeftijd = leeftijd;
    }

    public List<Kitten> getKittens() {
        return kittens;
    }

    public void setKittens(List<Kitten> kittens) {
        this.kittens = kittens;
    }
}
