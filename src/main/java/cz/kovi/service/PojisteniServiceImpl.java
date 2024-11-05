package cz.kovi.service;

import cz.kovi.dto.PojisteniDTO;

import java.util.List;

public class PojisteniServiceImpl implements PojisteniService{

    @Override
    public PojisteniDTO pridatPojisteni(PojisteniDTO pojisteniDTO) {
        return null;
    }

    @Override
    public void smazatPojisteni(long id) {

    }

    @Override
    public List<PojisteniDTO> seznamVsechPojistenich() {
        return List.of();
    }

    @Override
    public PojisteniDTO dostatPojistenihoPodleId(long id) {
        return null;
    }

    @Override
    public PojisteniDTO upravaPojisteniho(long id, PojisteniDTO pojisteniDTO) {
        return null;
    }

}
