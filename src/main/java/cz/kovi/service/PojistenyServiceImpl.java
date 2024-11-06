package cz.kovi.service;

import cz.kovi.dto.PojistenyDTO;
import cz.kovi.dto.mapper.PojistenyMapper;
import cz.kovi.entity.PojistenyEntity;
import cz.kovi.entity.repository.PojistenyRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.stream.Collectors;

public class PojistenyServiceImpl implements PojistenyService{

    private final PojistenyMapper pojistenyMapper;
    private final PojistenyRepository pojistenyRepository;

    @Autowired
    public PojistenyServiceImpl(PojistenyMapper pojistenyMapper, PojistenyRepository pojistenyRepository) {
        this.pojistenyMapper = pojistenyMapper;
        this.pojistenyRepository = pojistenyRepository;
    }

    @Override
    public PojistenyDTO pridatPojisteny(PojistenyDTO pojistenyDTO) {
        PojistenyEntity entity = pojistenyMapper.toEntity(pojistenyDTO);
        entity = pojistenyRepository.save(entity);
        return pojistenyMapper.toDTO(entity);
    }

    @Override
    public void smazatPojisteny(long id) {

        PojistenyEntity entity = fetchPojistenyPodleId(id);
        pojistenyRepository.delete(entity);

    }

    @Override
    public List<PojistenyDTO> seznamVsechPojistenych() {
        return pojistenyRepository.findAll()
                .stream()
                .map(pojistenyMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PojistenyDTO dostatPojistenyhoPodleId(long id) {
        return pojistenyMapper.toDTO(fetchPojistenyPodleId(id));
    }

    @Override
    public PojistenyDTO upravaPojistenyho(long id, PojistenyDTO pojistenyDTO) {

        // Najdi existující fakturu podle ID
        PojistenyEntity existujiciPojisteny = fetchPojistenyPodleId(id);

        // Aktualizace existující faktury s novými daty
        existujiciPojisteny.setJmeno(pojistenyDTO.getJmeno());
        existujiciPojisteny.setPrijmeni(pojistenyDTO.getPrijmeni());
        existujiciPojisteny.setVek(pojistenyDTO.getVek());
        existujiciPojisteny.setEmail(pojistenyDTO.getEmail());
        existujiciPojisteny.setTelefonniCislo(pojistenyDTO.getTelefonniCislo());
        existujiciPojisteny.setUlice(pojistenyDTO.getUlice());
        existujiciPojisteny.setMesto(pojistenyDTO.getMesto());
        existujiciPojisteny.setPsc(pojistenyDTO.getPsc());

        // Vrácení aktualizovaného DTO
        return pojistenyMapper.toDTO(existujiciPojisteny);
    }

    //Pomocná metoda pro vyhledání pojistenyho v databázi a vyhození výjimky, pokud není nalezena.
    private PojistenyEntity fetchPojistenyPodleId(long id) {
        return pojistenyRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Pojisteny s ID " + id + "nebyl nalezen v DB."));
    }

}
