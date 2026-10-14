package com.example.faks.dto;

import com.example.faks.domain.Upis;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class UpisDTO {
    @NotBlank(message = "Ime nesmije ostati prazno!")
    private String imeP;
    @NotBlank(message = "Prezime nesmije ostati prazno!")
    private String prezimeP;
    @NotBlank(message = "Naziv programa nesmije ostati prazan!")
    private String nazivPO;
    private LocalDate dUpisa;

    public UpisDTO(Upis u) {
        this.imeP = u.getPolaznik().getIme();
        this.prezimeP = u.getPolaznik().getPrezime();
        this.nazivPO = u.getProgramObrazovanja().getNaziv();
        this.dUpisa = u.getDUpisa();
    }
}
