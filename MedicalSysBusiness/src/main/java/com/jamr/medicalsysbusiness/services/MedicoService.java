
package com.jamr.medicalsysbusiness.services;

import com.jamr.medicalsysbusiness.entity.Medico;
import com.jamr.medicalsysbusiness.entity.Procedimiento;
import java.util.List;


public interface MedicoService {
    
    void guardarMedico(Medico medico);
    Medico buscarporId(Long id);
    List<Medico> buscarTodo();
    
}
