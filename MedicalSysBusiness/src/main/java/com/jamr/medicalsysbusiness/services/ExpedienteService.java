
package com.jamr.medicalsysbusiness.services;

import com.jamr.medicalsysbusiness.entity.Expediente;
import java.util.List;


public interface ExpedienteService {
   
    void guardarExpediente(Expediente expediente);
    Expediente buscarporId(Long id);
    List<Expediente> buscarTodo();
}
