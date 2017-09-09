
package com.jamr.medicalsysbusiness.services.impl;

import com.jamr.medicalsysbusiness.entity.Cita;
import com.jamr.medicalsysbusiness.repository.CitaRepository;
import com.jamr.medicalsysbusiness.services.CitaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class CitaServiceImpl implements CitaService {
    
    private CitaRepository citaRepository;

    public CitaServiceImpl(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }

    @Override
    public void guardarCita(Cita cita) {
        citaRepository.guardar(cita);
    }

    @Override
    public Cita buscarporId(Long id) {
        return citaRepository.buscarporId(id);
    }
    
    
}
