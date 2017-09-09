
package com.jamr.medicalsysbusiness.entity;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Transient;


@Entity
@NamedQueries({
    @NamedQuery(name = Medico.FIND_MEDICO_BY_ID,query = "SELECT m FROM Medico m WHERE m.id=medicoId")
})
public class Medico extends Persona implements Comparable<Medico>, Serializable {
    
    @Transient
    private Long medicoId;
    @Transient
   private Especialidad especialidad;
    @Transient
   private Horario horario;
    
     public final static String FIND_MEDICO_BY_ID="buscarMedicoPorId";
    
    @OneToMany(mappedBy = "medico")
    private List<Cita> citaList;
    

    public Long getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(Long medicoId) {
        this.medicoId = medicoId;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }


    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    @Override
    public String toString(){
        return "" + cedula + "" + nombre + "" + apellido + "" + fechanac + "" + sexo + "" + telefono + "" + especialidad+"";
    }
    
    
    
    @Override
    public int compareTo(Medico o) {
        return this.getNombre().compareTo(o.getNombre());
    }
   
    public static Comparator<Medico> NombresComparator = new Comparator<Medico>(){

       @Override
       public int compare(Medico o1, Medico o2) {
           return o1.getNombre().compareTo(o2.getNombre());
       }
       
   };
    
    
    public static Comparator<Medico> ApellidosComparator = new Comparator<Medico>(){

       @Override
       public int compare(Medico o1, Medico o2) {
           return o1.getApellido().compareTo(o2.getApellido());
       }
       
   };
    
    public boolean equals(Object object){
        
        if (object instanceof Medico){
            Medico medico = (Medico) object;
            
            if (this.nombre.equals(medico.getNombre())
                && this.apellido.equals(medico.getApellido())
                && this.medicoId.equals(medico.getId())
                && this.id.equals(medico.getId())){
                
                        return true;
    
                    }
                }
                return false;
    }
    
  @Override
    public int hashCode() {
       int size=0;
       if (this.getNombre() != null
                && this.getApellido() != null
                && this.getFechanac() != null
                && this.getMedicoId() != null
                && this.getDireccion() != null
               && this.getCorreo() != null
                && this.getEspecialidad() != null
                && this.getHorario() != null
                && this.getId() != null) {
                size = this.nombre.length()+this.apellido.length()+this.medicoId.intValue()+this.direccion.length()+this.correo.length() / this.id.intValue();
                    }
        return (int) Math.sqrt(size);
    }

    public void setCitaList(List<Cita> citaList) {
        this.citaList = citaList;
    }
    
    
    
    
}
