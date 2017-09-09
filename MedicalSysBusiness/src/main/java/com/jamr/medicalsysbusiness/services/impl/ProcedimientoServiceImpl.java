
package com.jamr.medicalsysbusiness.services.impl;

import com.jamr.medicalsysbusiness.entity.Procedimiento;
import com.jamr.medicalsysbusiness.repository.ProcedimientoRepository;
import com.jamr.medicalsysbusiness.services.ProcedimientoService;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProcedimientoServiceImpl implements ProcedimientoService {
    
    private ProcedimientoRepository procedimientoRepository;

    public ProcedimientoServiceImpl(ProcedimientoRepository procedimientoRepository) {
        this.procedimientoRepository = procedimientoRepository;
    }
   

    @Override
    public void guardarProcedimiento(Procedimiento procedimiento) {
        procedimientoRepository.guardar(procedimiento);
    }

    @Override
    public Procedimiento buscarporId(Long id) {
       return procedimientoRepository.buscarporId(id);
    }

    @Override
    public List<Procedimiento> buscarTodo() {
        return procedimientoRepository.buscarTodo();
    }
    
}
