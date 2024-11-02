package cz.kovi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class PojisteniEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private int castka;

    @Column(nullable = false)
    private String predmetPojisteni;

    @Column(nullable = false)
    private LocalDate platnostOd;

    @Column(nullable = false)
    private LocalDate platnostDo;

}
