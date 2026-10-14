package com.example.faks.service;

import com.example.faks.domain.ProgramObrazovanja;
import com.example.faks.dto.PolaznikDTO;
import com.example.faks.dto.ProgramObrazovanjaDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ProgramObrazovanjaService {
    List<ProgramObrazovanjaDTO> findAll();
    ProgramObrazovanjaDTO findById(Long id);
    ProgramObrazovanjaDTO addNew(ProgramObrazovanjaDTO programObrazovanjaDTO);
    Optional<ProgramObrazovanjaDTO> update(Long id, ProgramObrazovanjaDTO programObrazovanjaDTO);
    ResponseEntity<ProgramObrazovanjaDTO> delete(Long id);
}
