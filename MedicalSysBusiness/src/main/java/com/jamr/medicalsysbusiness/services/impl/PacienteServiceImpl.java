
package com.jamr.medicalsysbusiness.services.impl;

import com.jamr.medicalsysbusiness.entity.Paciente;
import com.jamr.medicalsysbusiness.repository.PacienteRepository;
import com.jamr.medicalsysbusiness.services.PacienteService;
import java.util.List;

public class PacienteServiceImpl implements PacienteService {

    
    private PacienteRepository pacienteRepository;

    public PacienteServiceImpl(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }
    
    
    @Override
    public void guardarPaciente(Paciente paciente) {
       pacienteRepository.guardar(paciente);
    }

    @Override
    public Paciente buscarporId(Long id) {
        return pacienteRepository.buscarporId(id);
    }

    @Override
    public List<Paciente> buscarTodos() {
        return pacienteRepository.buscarTodo();
    }
    
}
