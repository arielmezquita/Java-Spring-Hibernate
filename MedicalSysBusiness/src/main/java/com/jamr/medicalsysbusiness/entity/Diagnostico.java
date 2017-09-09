
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
    @NamedQuery(name = Diagnostico.FIND_DIAGNOSTICO_ALL,query = "SELECT d FROM Diagnostico d"),
    @NamedQuery(name = Diagnostico.FIND_DIAGNOSTICO_BY_ID,query = "SELECT d FROM Diagnostico d WHERE d.id=diagnosticoid" )
})
public class Diagnostico extends Catalogo implements Serializable {
    
    public final static String FIND_DIAGNOSTICO_BY_ID="buscarDiagnosticoPorId";
        
    public final static String FIND_DIAGNOSTICO_ALL="buscarDiagnosticoTodos";
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_diagnostico")
    private Long id;
    
    private Cita cita;
    private Medico medico;
    private Paciente paciente;
    
    
    public Long getId(){
        return id;    
    }
    
    public void setId(Long id){
        this.id = id;
    }
    
    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    
}
