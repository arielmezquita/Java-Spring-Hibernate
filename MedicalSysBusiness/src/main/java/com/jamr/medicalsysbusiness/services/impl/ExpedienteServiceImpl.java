
package com.jamr.medicalsysbusiness.services.impl;

import com.jamr.medicalsysbusiness.entity.Expediente;
import com.jamr.medicalsysbusiness.repository.ExpedienteRepository;
import com.jamr.medicalsysbusiness.services.ExpedienteService;
import java.util.List;


public class ExpedienteServiceImpl implements ExpedienteService {

    private ExpedienteRepository expedienteRepository;

    public ExpedienteServiceImpl(ExpedienteRepository expedienteRepository) {
        this.expedienteRepository = expedienteRepository;
    }
    
    @Override
    public void guardarExpediente(Expediente expediente) {
        this.expedienteRepository.guardar(expediente);
    }

    @Override
    public Expediente buscarporId(Long id) {
        return expedienteRepository.buscarporId(id);
    }

    @Override
    public List<Expediente> buscarTodo() {
        return expedienteRepository.buscarTodo();
    }
    
}
