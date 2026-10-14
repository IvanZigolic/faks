package com.example.faks.service;

import com.example.faks.dto.ProgramObrazovanjaDTO;
import com.example.faks.dto.UpisDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UpisService {
    List<UpisDTO> findAll();
    UpisDTO findById(Long id);
    UpisDTO addNew(UpisDTO upisDTO);
    Optional<UpisDTO> update(Long id, UpisDTO upisDTO);
    ResponseEntity<UpisDTO> delete(Long id);
}
