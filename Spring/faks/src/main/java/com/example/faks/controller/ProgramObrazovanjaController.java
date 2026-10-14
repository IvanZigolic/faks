package com.example.faks.controller;

import com.example.faks.domain.ProgramObrazovanja;
import com.example.faks.dto.PolaznikDTO;
import com.example.faks.dto.ProgramObrazovanjaDTO;
import com.example.faks.service.ProgramObrazovanjaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("po")
@AllArgsConstructor
public class ProgramObrazovanjaController {
    private ProgramObrazovanjaService programObrazovanjaService;

    @GetMapping
    public List<ProgramObrazovanjaDTO> findAll(){
        return programObrazovanjaService.findAll();
    }
    @GetMapping("/{id}")
    public ProgramObrazovanjaDTO findById(@PathVariable Long id){
        return programObrazovanjaService.findById(id);
    }
    @PostMapping("/new")
    public ProgramObrazovanjaDTO addNew(@RequestBody ProgramObrazovanjaDTO programObrazovanjaDTO){
        return  programObrazovanjaService.addNew(programObrazovanjaDTO);
    }
    @PutMapping("/{id}")
    public Optional<ProgramObrazovanjaDTO> update(@PathVariable Long id, @RequestBody ProgramObrazovanjaDTO programObrazovanjaDTO){
        return programObrazovanjaService.update(id, programObrazovanjaDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ProgramObrazovanjaDTO> delete(@PathVariable Long id){
        return programObrazovanjaService.delete(id);
    }
}
