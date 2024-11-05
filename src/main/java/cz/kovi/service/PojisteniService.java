package cz.kovi.service;

import cz.kovi.dto.PojisteniDTO;

import java.util.List;

public interface PojisteniService {

    PojisteniDTO pridatPojisteni(PojisteniDTO pojisteniDTO);

    void smazatPojisteni(long id);

    List<PojisteniDTO> seznamVsechPojistenich();

    PojisteniDTO dostatPojistenihoPodleId(long id);

    PojisteniDTO upravaPojisteniho(long id, PojisteniDTO pojisteniDTO);

}
