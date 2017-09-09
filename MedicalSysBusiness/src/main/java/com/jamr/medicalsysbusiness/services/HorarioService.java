
package com.jamr.medicalsysbusiness.services;

import com.jamr.medicalsysbusiness.entity.Horario;


public interface HorarioService {
    
    void guardarHorario(Horario horario);
    Horario buscarporId(Long id);
}
