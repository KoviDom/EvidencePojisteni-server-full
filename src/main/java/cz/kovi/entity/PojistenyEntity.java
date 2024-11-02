package cz.kovi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "pojisteny")
@Getter
@Setter
public class PojistenyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String jmeno;

    @Column(nullable = false)
    private String prijmeni;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private int vek;

    private String telefonniCislo;

    private String ulice;

    private String mesto;

    private String psc;

}
