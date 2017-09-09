
package com.jamr.medicalsysbusiness.services;

import com.jamr.medicalsysbusiness.entity.Medico;
import com.jamr.medicalsysbusiness.repository.MedicoRepository;


public class MedicalService {
    private MedicoRepository medicoRepository=null;
    
    public void guardarMedico(Medico medico){
        medicoRepository.guardar(medico);
    }
}
