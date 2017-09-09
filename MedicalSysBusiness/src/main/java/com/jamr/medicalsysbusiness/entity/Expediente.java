
package com.jamr.medicalsysbusiness.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@Entity
@NamedQueries({
    @NamedQuery (name = Expediente.FIND_EXPEDIENTE_ALL,query= "SELECT e FROM Expediente e"), 
    @NamedQuery (name = Expediente.FIND_EXPEDIENTE_BY_ID,query= "SELECT e FROM Expediente e WHERE e.id=:expediienteid")
})
public class Expediente implements Serializable {

    public final static String FIND_EXPEDIENTE_BY_ID="buscarExpedientePorId";
    
    public final static String FIND_EXPEDIENTE_ALL="buscarExpedienteTodos";
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_expediente")
    private Long id;
    
    private Paciente paciente;
    private Diagnostico diagnostico;

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }
    
    
    
}
