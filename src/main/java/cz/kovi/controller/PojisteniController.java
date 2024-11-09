package cz.kovi.controller;

import cz.kovi.dto.PojisteniDTO;
import cz.kovi.service.PojisteniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pojisteni")
public class PojisteniController {

    private final PojisteniService pojisteniService;

    @Autowired
    public PojisteniController(PojisteniService pojisteniService) {
        this.pojisteniService = pojisteniService;
    }

    @PostMapping("/novy")
    public PojisteniDTO pridatPojisteni(@RequestBody PojisteniDTO pojisteniDTO) {
        return pojisteniService.pridatPojisteni(pojisteniDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void smazatPojisteni(@PathVariable long id) {
        pojisteniService.smazatPojisteni(id);
    }

    @GetMapping("")
    public List<PojisteniDTO> seznamVsechPojistenich() {
        return pojisteniService.seznamVsechPojistenich();
    }

    @GetMapping("/detail/{id}")
    public PojisteniDTO dostatPojistenihoPodleId(@PathVariable long id) {
        return pojisteniService.dostatPojistenihoPodleId(id);
    }

    @PutMapping("{id}")
    public PojisteniDTO upravaPojisteniho(@PathVariable long id, @RequestBody PojisteniDTO pojisteniDTO) {
        return pojisteniService.upravaPojisteniho(id, pojisteniDTO);
    }

}
