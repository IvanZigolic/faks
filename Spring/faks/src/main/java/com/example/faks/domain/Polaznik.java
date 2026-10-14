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
public class Polaznik {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long PolaznikID;
    private String ime;
    private String prezime;

    @OneToMany(mappedBy = "polaznik")
    private List<Upis> upisi = new ArrayList<>();
}
