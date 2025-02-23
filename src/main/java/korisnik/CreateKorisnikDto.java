package korisnik;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class CreateKorisnikDto {

    private String ime;

    private String prezime;

    private String email;

    private String password;

    private String oib;

    private Integer datumRodenja;
}
