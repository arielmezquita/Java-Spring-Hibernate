
package com.jamr.medicalsysbusiness.services;

import com.jamr.medicalsysbusiness.entity.Especialidad;
import com.jamr.medicalsysbusiness.entity.Procedimiento;
import java.util.List;


public interface ProcedimientoService {
    
    void guardarProcedimiento(Procedimiento procedimiento);
    Procedimiento buscarporId(Long id);
    List<Procedimiento> buscarTodo();
}
