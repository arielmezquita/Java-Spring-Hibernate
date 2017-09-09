
package com.jamr.medicalsysbusiness.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;

@Entity
@NamedQueries({
    @NamedQuery(name = Procedimiento.FIND_PROCEDIMIENTO_ALL,query = "SELECT p FROM Procedimiento p"),
    @NamedQuery(name = Procedimiento.FIND_PROCEDIMIENTO_BY_ID,query = "SELECT p FROM Procedimiento p WHERE p.id=:procedimientoId")
})
public class Procedimiento extends Catalogo implements Serializable {
    
    public final static String FIND_PROCEDIMIENTO_BY_ID="buscarProcedimientoPorId";
    public final static String FIND_PROCEDIMIENTO_ALL="buscarProcedimientoTodos";
    
    @Transient
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_procedimiento")
    private Long id;
   
    @Transient
    private Diagnostico diagnostico;
    
       public Long getId(){
        return id;    
    }
    
    public void setId(Long id){
        this.id = id;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }
    
}
