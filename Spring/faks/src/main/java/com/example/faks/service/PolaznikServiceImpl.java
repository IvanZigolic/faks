package com.example.faks.service;

import com.example.faks.domain.Polaznik;
import com.example.faks.dto.PolaznikDTO;
import com.example.faks.repository.SpringPolaznikRepository;
import com.example.faks.repository.SpringUpisRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PolaznikServiceImpl implements PolaznikService{
    private SpringPolaznikRepository polaznikRepository;
    private SpringUpisRepository upisRepository;

    @Override
    public List<PolaznikDTO> findAll() {
        return polaznikRepository.findAll().stream().map(this::toDTO).toList();
    }
    public PolaznikDTO findById(Long id){
        return toDTO(polaznikRepository.findById(id).get());
    }
    public PolaznikDTO addNew(PolaznikDTO polaznikDTO){
        return toDTO(polaznikRepository.save(fromDTO(polaznikDTO)));
    }
    public PolaznikDTO toDTO(Polaznik polaznik){
        return new PolaznikDTO(polaznik);
    }
    public Polaznik fromDTO(PolaznikDTO polaznikDTO){
        return new Polaznik(null, polaznikDTO.getIme(), polaznikDTO.getPrezime(),  null);
    }
    public Optional<PolaznikDTO> update(Long id, PolaznikDTO polaznikDTO){
        Optional<Polaznik> stari = polaznikRepository.findById(id);
        if(stari.isPresent()){
            Polaznik novi = stari.get();
            novi.setIme(polaznikDTO.getIme());
            novi.setPrezime(polaznikDTO.getPrezime());
            polaznikRepository.save(novi);
            return  Optional.of(toDTO(novi));
        }
        else{
            return Optional.empty();
        }
    }
    @Transactional
    public ResponseEntity<PolaznikDTO> delete(Long id){
        Optional<Polaznik> polaznik = polaznikRepository.findById(id);
        if(polaznik.isPresent()){
            upisRepository.deleteAllByPolaznik(polaznik.get());
            polaznikRepository.delete(polaznik.get());
            return ResponseEntity.accepted().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}
