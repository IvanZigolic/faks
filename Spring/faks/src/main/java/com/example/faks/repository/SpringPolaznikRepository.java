package com.example.faks.repository;

import com.example.faks.domain.Polaznik;
import com.example.faks.domain.ProgramObrazovanja;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public interface SpringPolaznikRepository extends JpaRepository<Polaznik, Long> {
    Polaznik findByImeAndPrezime(String ime, String prezime);
}
