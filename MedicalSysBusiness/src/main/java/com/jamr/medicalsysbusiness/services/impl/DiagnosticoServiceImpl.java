
package com.jamr.medicalsysbusiness.services.impl;

import com.jamr.medicalsysbusiness.entity.Diagnostico;
import com.jamr.medicalsysbusiness.repository.DiagnosticoRepository;
import com.jamr.medicalsysbusiness.services.DiagnosticoService;


public class DiagnosticoServiceImpl implements DiagnosticoService{
  
    private DiagnosticoRepository diagnosticoRepository;

    public DiagnosticoServiceImpl(DiagnosticoRepository diagnosticoRepository) {
        this.diagnosticoRepository = diagnosticoRepository;
    }

    @Override
    public Diagnostico buscarporId(Long id) {
        return diagnosticoRepository.buscarporId(id);
    }

    @Override
    public void guardarDiagnostico(Diagnostico diagnostico) {
        diagnosticoRepository.guardar(diagnostico);
    }
}
