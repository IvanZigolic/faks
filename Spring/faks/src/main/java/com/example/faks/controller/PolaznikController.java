package com.example.faks.controller;

import com.example.faks.domain.Polaznik;
import com.example.faks.dto.PolaznikDTO;
import com.example.faks.service.PolaznikService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("polaznik")
@AllArgsConstructor
public class PolaznikController {
    private PolaznikService polaznikService;

    @GetMapping
    public List<PolaznikDTO> findAll(){
        return polaznikService.findAll();
    }
    @GetMapping("/{id}")
    public PolaznikDTO findById(@PathVariable Long id){
        return polaznikService.findById(id);
    }
    @PostMapping("/new")
    public PolaznikDTO addNew(@RequestBody PolaznikDTO polaznikDTO){
        return  polaznikService.addNew(polaznikDTO);
    }
    @PutMapping("/{id}")
    public Optional<PolaznikDTO> update(@PathVariable Long id, @RequestBody PolaznikDTO polaznikDTO){
        return polaznikService.update(id, polaznikDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<PolaznikDTO> delete(@PathVariable Long id){
        return polaznikService.delete(id);
    }
}
