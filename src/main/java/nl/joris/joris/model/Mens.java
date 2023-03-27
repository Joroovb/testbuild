package nl.joris.joris.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Mens {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String naam;


    // Bezeten/geeigend kant van de relatie
    @ManyToMany(mappedBy = "mensen")
    @JsonIgnore
    private List<Kat> katten = new ArrayList<>();
}
