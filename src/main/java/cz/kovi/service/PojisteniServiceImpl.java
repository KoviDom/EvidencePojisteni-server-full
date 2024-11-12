package cz.kovi.service;

import cz.kovi.dto.PojisteniDTO;
import cz.kovi.dto.mapper.PojisteniMapper;
import cz.kovi.entity.PojisteniEntity;
import cz.kovi.entity.repository.PojisteniRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.stream.Collectors;

public class PojisteniServiceImpl implements PojisteniService{

    private final PojisteniMapper pojisteniMapper;
    private final PojisteniRepository pojisteniRepository;

    @Autowired
    public PojisteniServiceImpl(PojisteniMapper pojisteniMapper, PojisteniRepository pojisteniRepository) {
        this.pojisteniMapper = pojisteniMapper;
        this.pojisteniRepository = pojisteniRepository;
    }

    @Override
    public PojisteniDTO pridatPojisteni(PojisteniDTO pojisteniDTO) {
        PojisteniEntity entity = pojisteniMapper.toEntity(pojisteniDTO);
        entity = pojisteniRepository.save(entity);
        return pojisteniMapper.toDTO(entity);
    }

    @Override
    public void smazatPojisteni(long id) {

        PojisteniEntity entity = fetchPojisteniPodleId(id);
        pojisteniRepository.delete(entity);

    }

    @Override
    public List<PojisteniDTO> seznamVsechPojistenich() {
        return pojisteniRepository.findAll()
                .stream()
                .map(pojisteniMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PojisteniDTO dostatPojistenihoPodleId(long id) {
        return pojisteniMapper.toDTO(fetchPojisteniPodleId(id));
    }

    @Override
    public PojisteniDTO upravaPojisteniho(long id, PojisteniDTO pojisteniDTO) {

        PojisteniEntity existujiciEntita = fetchPojisteniPodleId(id);

        existujiciEntita.setPredmetPojisteni(pojisteniDTO.getPredmetPojisteni());
        existujiciEntita.setCastka(pojisteniDTO.getCastka());
        existujiciEntita.setPlatnostOd(pojisteniDTO.getPlatnostOd());
        existujiciEntita.setPlatnostDo(pojisteniDTO.getPlatnostDo());

        return pojisteniMapper.toDTO(existujiciEntita);
    }

    //Pomocná metoda pro vyhledání pojisteni v databázi a vyhození výjimky, pokud není nalezena.
    private PojisteniEntity fetchPojisteniPodleId(long id) {
        return pojisteniRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Pojisteni s ID " + id + "nebyla nalezena v DB."));
    }

}
