package com.example.faks.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Upis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UpisID;
    @Column (name = "DUpisa")
    private LocalDate dUpisa;

    @ManyToOne
    @JoinColumn(name = "IDPolaznik")
    private Polaznik polaznik;

    @ManyToOne
    @JoinColumn(name = "IDProgramObrazovanja")
    private ProgramObrazovanja programObrazovanja;
}
