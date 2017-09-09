
package com.jamr.medicalsysbusiness.services;

import com.jamr.medicalsysbusiness.entity.Paciente;
import java.util.List;



public interface PacienteService {
 
    void guardarPaciente(Paciente paciente);
    Paciente buscarporId(Long id);
    List<Paciente> buscarTodos();
}
