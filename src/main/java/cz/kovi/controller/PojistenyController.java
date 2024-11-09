package cz.kovi.controller;

import cz.kovi.dto.PojistenyDTO;
import cz.kovi.service.PojistenyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pojistenci")
public class PojistenyController {

    private final PojistenyService pojistenyService;

    @Autowired
    public PojistenyController(PojistenyService pojistenyService) {
        this.pojistenyService = pojistenyService;
    }

    @PostMapping("/novy")
    public PojistenyDTO pridatPojisteny(@RequestBody PojistenyDTO pojistenyDTO) {
        return pojistenyService.pridatPojisteny(pojistenyDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void smazatPojisteny(@PathVariable long id) {
        pojistenyService.smazatPojisteny(id);
    }

    @GetMapping("")
    public List<PojistenyDTO> seznamVsechPojistenych() {
        return pojistenyService.seznamVsechPojistenych();
    }

    @GetMapping("/detail/{id}")
    public PojistenyDTO dostatPojistenyhoPodleId(@PathVariable long id) {
        return pojistenyService.dostatPojistenyhoPodleId(id);
    }

    @PutMapping("{id}")
    public PojistenyDTO upravaPojistenyho(@PathVariable long id, @RequestBody PojistenyDTO pojistenyDTO) {
        return pojistenyService.upravaPojistenyho(id, pojistenyDTO);
    }

}
