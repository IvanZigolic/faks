package com.example.faks.dto;

import com.example.faks.domain.ProgramObrazovanja;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProgramObrazovanjaDTO {
    @NotBlank(message = "Naziv nesmije ostati prazan!")
    private String naziv;
    @NotBlank(message = "CSVET nesmije ostati prazan!")
    @Positive(message = "Mora biti pozitivan!")
    private int CSVET;

    public ProgramObrazovanjaDTO(ProgramObrazovanja po) {
        this.naziv = po.getNaziv();
        this.CSVET = po.getCSVET();
    }
}
