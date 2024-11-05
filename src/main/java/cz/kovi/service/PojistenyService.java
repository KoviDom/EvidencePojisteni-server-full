package cz.kovi.service;

import cz.kovi.dto.PojistenyDTO;

import java.util.List;

public interface PojistenyService {

    /**
     * pridani Pojistenyho
     * @param pojistenyDTO
     * @return pridani novyho Pojistenyho
     */
    PojistenyDTO pridatPojisteny(PojistenyDTO pojistenyDTO);

    /**
     * odstraneni pojistenyho podle ID
     * @param id
     */
    void smazatPojisteny(long id);

    /**
     * seznam vsech pojistenych
     * @return List/seznam vsech pojistenych
     */
    List<PojistenyDTO> seznamVsechPojistenych();

    /**
     * pojistenyho, ktery chceme zobrazit a jeho detaily
     * @param id
     * @return detail osoby podle ID
     */
    PojistenyDTO dostatPojistenyhoPodleId(long id);

    /**
     * uprava pojistenyho
     * @param id
     * @param pojistenyDTO
     * @return uprava pojistenyho podle ID
     */
    PojistenyDTO upravaPojistenyho(long id, PojistenyDTO pojistenyDTO);

}
