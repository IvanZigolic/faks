package com.example.faks.service;

import com.example.faks.dto.PolaznikDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface PolaznikService {
    List<PolaznikDTO> findAll();
    PolaznikDTO findById(Long id);
    PolaznikDTO addNew(PolaznikDTO polaznikDTO);
    Optional<PolaznikDTO> update(Long id, PolaznikDTO polaznikDTO);
    ResponseEntity<PolaznikDTO> delete(Long id);
}
