package cz.kovi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PojisteniDTO {

    @JsonProperty("_id")
    private long id;

    private int castka;

    private String predmetPojisteni;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate platnostOd;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate platnostDo;

}
