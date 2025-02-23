package korisnik;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/korisnici")
@RequiredArgsConstructor
public class KorisnikController {

    private final KorisnikService korisnikService;

    @GetMapping("/{id}")
    public Korisnik findById(@PathVariable Long id){
        return korisnikService.findById(1L);
    }

    @GetMapping()
    public List<Korisnik> fetchAll() {
        return korisnikService.fetchAll();
    }

    @PostMapping()
    public Korisnik create(@RequestBody CreateKorisnikDto dto) {
        return korisnikService.create(dto);
    }

    @PutMapping("/{id}")
    public Korisnik update(@RequestBody UpdateKorisnikDto dto,@PathVariable Long id){
        return korisnikService.update(id,dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        korisnikService.delete(id);
    }


    //test
}
