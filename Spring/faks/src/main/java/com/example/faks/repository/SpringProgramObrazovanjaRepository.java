package com.example.faks.repository;

import com.example.faks.domain.ProgramObrazovanja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringProgramObrazovanjaRepository extends JpaRepository<ProgramObrazovanja, Long> {
    ProgramObrazovanja findByNaziv(String naziv);
}
