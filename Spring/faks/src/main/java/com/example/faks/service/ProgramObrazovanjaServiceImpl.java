package com.example.faks.service;

import com.example.faks.domain.Polaznik;
import com.example.faks.domain.ProgramObrazovanja;
import com.example.faks.dto.PolaznikDTO;
import com.example.faks.dto.ProgramObrazovanjaDTO;
import com.example.faks.repository.SpringProgramObrazovanjaRepository;
import com.example.faks.repository.SpringUpisRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProgramObrazovanjaServiceImpl implements ProgramObrazovanjaService{
    private SpringProgramObrazovanjaRepository programObrazovanjaRepository;
    private SpringUpisRepository upisRepository;

    @Override
    public List<ProgramObrazovanjaDTO> findAll() {
        return programObrazovanjaRepository.findAll().stream().map(this::toDTO).toList();
    }
    public ProgramObrazovanjaDTO findById(Long id){
        return toDTO(programObrazovanjaRepository.findById(id).get());
    }
    public ProgramObrazovanjaDTO toDTO(ProgramObrazovanja programObrazovanja){
        return new ProgramObrazovanjaDTO(programObrazovanja);
    }
    public ProgramObrazovanjaDTO addNew(ProgramObrazovanjaDTO programObrazovanjaDTO){
        return toDTO(programObrazovanjaRepository.save(fromDTO(programObrazovanjaDTO)));
    }
    public ProgramObrazovanja fromDTO(ProgramObrazovanjaDTO programObrazovanjaDTO){
        return new ProgramObrazovanja(null, programObrazovanjaDTO.getNaziv(), programObrazovanjaDTO.getCSVET(),  null);
    }
    public Optional<ProgramObrazovanjaDTO> update(Long id, ProgramObrazovanjaDTO programObrazovanjaDTO){
        Optional<ProgramObrazovanja> stari = programObrazovanjaRepository.findById(id);
        if(stari.isPresent()){
            ProgramObrazovanja novi = stari.get();
            novi.setNaziv(programObrazovanjaDTO.getNaziv());
            novi.setCSVET(programObrazovanjaDTO.getCSVET());
            programObrazovanjaRepository.save(novi);
            return  Optional.of(toDTO(novi));
        }
        else{
            return Optional.empty();
        }
    }
    @Transactional
    public ResponseEntity<ProgramObrazovanjaDTO> delete(Long id){
        Optional<ProgramObrazovanja> programObrazovanja = programObrazovanjaRepository.findById(id);
        if(programObrazovanja.isPresent()){
            upisRepository.deleteAllByProgramObrazovanja(programObrazovanja.get());
            programObrazovanjaRepository.delete(programObrazovanja.get());
            return ResponseEntity.accepted().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}
