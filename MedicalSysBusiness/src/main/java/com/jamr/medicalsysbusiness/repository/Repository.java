
package com.jamr.medicalsysbusiness.repository;

import java.util.List;

public interface Repository<R, ID> {
    void guardar(R entity);
    void actualizar(R entity);
    R buscarporId(ID id);
    List<R> buscarTodo(); 
}
