
package com.jamr.medicalsysbusiness.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@NamedQueries({
    @NamedQuery(name = Horario.FIND_HORARIO_BY_ID,query = "SELECT h FROM Horario h WHERE h.id=horario")
})
public class Horario extends Catalogo {
    
    public final static String FIND_HORARIO_BY_ID="buscarHorarioPorId";
     
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_horario")
    private Long id;
    
    public Long getId(){
        return id;    
    }
    
    public void setId(Long id){
        this.id = id;
    }
     
     
}
