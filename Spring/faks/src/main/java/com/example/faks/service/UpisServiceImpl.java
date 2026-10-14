package com.example.faks.service;

import com.example.faks.domain.Polaznik;
import com.example.faks.domain.ProgramObrazovanja;
import com.example.faks.domain.Upis;
import com.example.faks.dto.ProgramObrazovanjaDTO;
import com.example.faks.dto.UpisDTO;
import com.example.faks.repository.SpringPolaznikRepository;
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
public class UpisServiceImpl implements UpisService{
    private SpringPolaznikRepository polaznikRepository;
    private SpringProgramObrazovanjaRepository programObrazovanjaRepository;
    private SpringUpisRepository upisRepository;
    @Override
    public List<UpisDTO> findAll() {
        return upisRepository.findAll().stream().map(this::toDTO).toList();
    }
    public UpisDTO findById(Long id){
        return toDTO(upisRepository.findById(id).get());
    }
    public UpisDTO toDTO(Upis upis){
        return new UpisDTO(upis);
    }
    public Upis fromDTO(UpisDTO upis){
        return new Upis(null, null, polaznikRepository.findByImeAndPrezime(upis.getImeP(), upis.getPrezimeP()), programObrazovanjaRepository.findByNaziv(upis.getNazivPO()));
    }
    public UpisDTO addNew(UpisDTO upisDTO){
        return toDTO(upisRepository.save(fromDTO(upisDTO)));
    }
    @Transactional
    public Optional<UpisDTO> update(Long id, UpisDTO dto) {
        return upisRepository.findById(id).map(upis -> {
            Polaznik polaznik = polaznikRepository
                    .findByImeAndPrezime(dto.getImeP(), dto.getPrezimeP());
            if (polaznik == null) {
                throw new IllegalArgumentException("Polaznik ne postoji: "
                        + dto.getImeP() + " " + dto.getPrezimeP());
            }

            ProgramObrazovanja program =
                    programObrazovanjaRepository.findByNaziv(dto.getNazivPO());
            if (program == null) {
                throw new IllegalArgumentException("Program ne postoji: " + dto.getNazivPO());
            }
            upis.setDUpisa(dto.getDUpisa());
            upis.setPolaznik(polaznik);
            upis.setProgramObrazovanja(program);
            return toDTO(upisRepository.save(upis));
        });
    }
    @Transactional
    public ResponseEntity<UpisDTO> delete(Long id){
        Optional<Upis> upis = upisRepository.findById(id);
        if(upis.isPresent()){
            upisRepository.deleteById(id);
            return ResponseEntity.accepted().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
}
