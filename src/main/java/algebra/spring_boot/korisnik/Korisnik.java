package algebra.spring_boot.korisnik;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Korisnik {

    private Long id;

    private String ime;

    private String prezime;

    private String email;

    private String password;

    private String oib;

    private Integer datumRodenja;
}
