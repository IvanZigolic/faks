package com.example.faks.dto;

import com.example.faks.domain.Polaznik;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PolaznikDTO {
    @NotBlank(message = "Ime nesmije ostati prazno!")
    private String Ime;
    @NotBlank(message = "Prezime nesmije ostati prazno!")
    private String Prezime;

    public PolaznikDTO(Polaznik polaznik) {
        Ime = polaznik.getIme();
        Prezime = polaznik.getPrezime();
    }
}
