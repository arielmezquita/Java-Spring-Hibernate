
package com.jamr.medicalsysbusiness.services.impl;

import com.jamr.medicalsysbusiness.entity.Horario;
import com.jamr.medicalsysbusiness.repository.HorarioRepository;
import com.jamr.medicalsysbusiness.services.HorarioService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HorarioServiceImpl implements HorarioService {

    private HorarioRepository horarioRepository;

    public HorarioServiceImpl(HorarioRepository horarioRepository) {
        this.horarioRepository = horarioRepository;
    }
    
    
    @Override
    public Horario buscarporId(Long id) {
        return horarioRepository.buscarporId(id);
    }

    @Override
    public void guardarHorario(Horario horario) {
        horarioRepository.guardar(horario);
    }
    
}
