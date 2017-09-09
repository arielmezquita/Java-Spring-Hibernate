
package com.jamr.medicalsysbusiness.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Especialidad")
@NamedQueries({
    @NamedQuery(name = Especialidad.FIND_ESPECIALIDAD_ALL,query = "SELECT e FROM Especialidad e"),
    @NamedQuery(name = Especialidad.FIND_ESPECIALIDAD_BY_ID,query = "SELECT e FROM Especialidad e WHERE e.id=:especialidadId")
})
public class Especialidad extends Catalogo implements Serializable {
 
    public final static String FIND_ESPECIALIDAD_BY_ID="buscarEspecialidadPorId";
    public final static String FIND_ESPECIALIDAD_ALL="buscarEspecialidadTodos";
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_especialidad")
    private Long id;
    
    public Long getId(){
        return id;    
    }
    
    public void setId(Long id){
        this.id = id;
    }
    
}
