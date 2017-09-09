
package com.jamr.medicalsysbusiness.services;

import com.jamr.medicalsysbusiness.entity.Cita;


public interface CitaService {
    
    void guardarCita(Cita cita);
    Cita buscarporId(Long id);
}
