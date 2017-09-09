
package com.jamr.medicalsysbusiness.services.impl;

import com.jamr.medicalsysbusiness.entity.Medico;
import com.jamr.medicalsysbusiness.repository.MedicoRepository;
import com.jamr.medicalsysbusiness.services.MedicoService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MedicoServiceImpl implements MedicoService{
    
    private MedicoRepository medicoRepository;

    public MedicoServiceImpl(MedicoRepository medicoRepository) {
        this.medicoRepository = medicoRepository;
    }

    @Override
    public void guardarMedico(Medico medico) {
       medicoRepository.guardar(medico);
    }

    @Override
    public Medico buscarporId(Long id) {
        return medicoRepository.buscarporId(id);
    }

    @Override
    public List<Medico> buscarTodo() {
        return medicoRepository.buscarTodo();
    }
    
    
}
