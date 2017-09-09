
package com.jamr.medicalsysbusiness.services.impl;

import com.jamr.medicalsysbusiness.entity.Especialidad;
import com.jamr.medicalsysbusiness.repository.EspecialidadRepository;
import com.jamr.medicalsysbusiness.services.EspecialidadService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EspecialidadServiceImpl implements EspecialidadService {
   
    private EspecialidadRepository especialidadRepository;

    public EspecialidadServiceImpl(EspecialidadRepository especialidadRepository) {
        this.especialidadRepository = especialidadRepository;
    }
    
  
    @Override
    public Especialidad buscarporId(Long id) {
        return especialidadRepository.buscarporId(id);
    }

    @Override
    public void guardarEspecialidad(Especialidad especialidad) {
        especialidadRepository.guardar(especialidad);
    }

    @Override
    public List<Especialidad> buscarTodo() {
        return especialidadRepository.buscarTodo();
    }
       
}
