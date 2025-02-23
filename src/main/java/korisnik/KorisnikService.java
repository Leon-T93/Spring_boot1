package korisnik;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class KorisnikService {

    public Korisnik create (CreateKorisnikDto dto) {
        return new Korisnik(1L,dto.getIme(),dto.getPrezime(),dto.getEmail(),dto.getPassword(),dto.getOib(),dto.getDatumRodenja());
    }

    public Korisnik update (Long id, UpdateKorisnikDto dto) {
     Korisnik korisnikFromDb= new Korisnik(id,"Marko","Maric","mmaric@email.com","password","12345678910",20010901);

     korisnikFromDb.setIme(dto.getIme());
     korisnikFromDb.setPrezime(dto.getPrezime());
     korisnikFromDb.setEmail(dto.getEmail());
     korisnikFromDb.setPassword(dto.getPassword());
     korisnikFromDb.setOib(dto.getOib());
     korisnikFromDb.setDatumRodenja(dto.getDatumRodenja());

     return korisnikFromDb;
    }

    public Korisnik findById (Long id) {
        return new Korisnik(id,"Ana","Anic", "aanic@email.com","pasword2","10987654321",20190709);

    }

    public List<Korisnik> fetchAll () {
        return List.of(new Korisnik(2L,"Ana","Anic", "aanic@email.com","pasword2","10987654321",20190709),new Korisnik(1L,"Marko","Maric","mmaric@email.com","password","12345678910",20010901));
    }

    public void delete (Long id) {
        System.out.println("Korisnik se brise po ID-u: " +id);
    }
}
