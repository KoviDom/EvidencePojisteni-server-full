package cz.kovi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PojistenyDTO {

    @JsonProperty("_id")
    private long id;

    private String jmeno;

    private String prijmeni;

    private String email;

    private int vek;

    private String telefonniCislo;

    private String ulice;

    private String mesto;

    private String psc;

}
