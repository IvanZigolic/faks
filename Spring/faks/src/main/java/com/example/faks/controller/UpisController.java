package com.example.faks.controller;

import com.example.faks.dto.PolaznikDTO;
import com.example.faks.dto.ProgramObrazovanjaDTO;
import com.example.faks.dto.UpisDTO;
import com.example.faks.service.UpisService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("upis")
@AllArgsConstructor
public class UpisController {
    private UpisService upisService;

    @GetMapping
    public List<UpisDTO> findAll(){
        return upisService.findAll();
    }
    @GetMapping("/{id}")
    public UpisDTO findById(@PathVariable Long id){
        return upisService.findById(id);
    }
    @PostMapping("/new")
    public UpisDTO addNew(@RequestBody UpisDTO upisDTO){
        return upisService.addNew(upisDTO);
    }
    @PutMapping("/{id}")
    public Optional<UpisDTO> update(@PathVariable Long id, @RequestBody UpisDTO upisDTO){
        return upisService.update(id, upisDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<UpisDTO> delete(@PathVariable Long id){
        return upisService.delete(id);
    }
}
