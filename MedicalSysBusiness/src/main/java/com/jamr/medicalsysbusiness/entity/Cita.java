
package com.jamr.medicalsysbusiness.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@NamedQueries({
    @NamedQuery(name = Cita.FIND_CITA_ALL,query = "SELECT c FROM Cita c"),
    @NamedQuery(name = Cita.FIND_CITA_BY_ID,query = "SELECT c FROM Cita c WHERE c.id=:citaid")
})
public class Cita implements Serializable {
    
    public final static String FIND_CITA_BY_ID="buscarCitaPorId";
    
    public final static String FIND_CITA_ALL="buscarCitaTodos";
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cita")
    protected Long id;
//    @ManyToOne
//    @JoinColumn(name = "id_medico")
    protected Medico medico;
    
//    @ManyToOne
//    @JoinColumn(name = "id_paciente")
    protected Paciente paciente;
    
    @Temporal(TemporalType.DATE)
    protected Date fechacita;
    protected int horacita;
    
//    @ManyToOne
//    @JoinColumn(name = "id_procedimiento")
    protected Procedimiento procedimiento;
    
//    @ManyToOne
//    @JoinColumn(name = "id_diagnostico")
    protected Diagnostico diagnostico;

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Procedimiento getProcedimiento() {
        return procedimiento;
    }

    public void setProcedimiento(Procedimiento procedimiento) {
        this.procedimiento = procedimiento;
    }

    public Diagnostico getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(Diagnostico diagnostico) {
        this.diagnostico = diagnostico;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechacita() {
        return fechacita;
    }

    public void setFechacita(Date fechacita) {
        this.fechacita = fechacita;
    }

    public int getHoracita() {
        return horacita;
    }

    public void setHoracita(int horacita) {
        this.horacita = horacita;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

 
    
    
}
