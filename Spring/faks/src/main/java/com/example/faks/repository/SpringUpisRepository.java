package com.example.faks.repository;

import com.example.faks.domain.Polaznik;
import com.example.faks.domain.ProgramObrazovanja;
import com.example.faks.domain.Upis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringUpisRepository extends JpaRepository<Upis, Long> {
    Upis deleteAllByPolaznik(Polaznik polaznik);

    Upis deleteAllByProgramObrazovanja(ProgramObrazovanja programObrazovanja);
}
