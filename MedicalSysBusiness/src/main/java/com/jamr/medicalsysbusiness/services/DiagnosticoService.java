
package com.jamr.medicalsysbusiness.services;

import com.jamr.medicalsysbusiness.entity.Diagnostico;


public interface DiagnosticoService {
    
    void guardarDiagnostico(Diagnostico diganostico);
    Diagnostico buscarporId(Long id);
}
