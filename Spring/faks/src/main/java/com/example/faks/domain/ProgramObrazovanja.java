package com.example.faks.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProgramObrazovanja {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long ProgramObrazovanjaID;

    @Column(name = "Naziv")
    private String naziv;

    @Column(name = "CSVET")
    private int CSVET;

    @OneToMany(mappedBy = "programObrazovanja")
    private List<Upis> upisi = new ArrayList<>();
}
