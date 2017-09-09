
package com.jamr.medicalsysbusiness.services;

import com.jamr.medicalsysbusiness.entity.Especialidad;
import java.util.List;


public interface EspecialidadService {
    
    void guardarEspecialidad(Especialidad especialidad);
    Especialidad buscarporId(Long id);
    List<Especialidad> buscarTodo();
}
