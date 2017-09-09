
package com.jamr.medicalsysbusiness.entity;

import java.io.Serializable;
import java.util.Comparator;
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
    @NamedQuery(name = Paciente.FIND_PACIENTE_ALL,query = "SELECT p FROM Paciente p"),
    @NamedQuery(name = Paciente.FIND_PACIENTE_BY_ID,query= "SELECT p FROM Paciente p WHERE p.id=:pacienteId")
})
public class Paciente extends Persona implements Serializable {
    
    public final static String FIND_PACIENTE_BY_ID="buscarPacientePorId";
     public final static String FIND_PACIENTE_ALL="buscarPacienteTodos";
    
        
    @Transient
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paciente")
    private Long id;
    
    @Transient
    private String codigo;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    
    @Override
    public String toString() {
        return "" + nombre + " " + apellido + " " + fechanac + "" + cedula + ""+ sexo + "" + telefono + "" + direccion + "" + correo + "" + codigo + "";
    }

    public static Comparator<Paciente> NombresComparator = new Comparator<Paciente>() {

        @Override
        public int compare(Paciente o1, Paciente o2) {
            return o1.getNombre().compareTo(o2.getNombre());

        }
    };

    public static Comparator<Paciente> ApellidosComparator = new Comparator<Paciente>() {
        @Override
        public int compare(Paciente o1, Paciente o2) {
            return o1.getApellido().compareTo(o2.getApellido());

        }

    };

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Paciente) {
            Paciente paciente = (Paciente) obj;

            if (this.nombre.equals(paciente.getNombre())
                    && this.apellido.equals(paciente.getApellido())
                    && this.codigo.equals(paciente.getCodigo())
                    && this.id.intValue()==paciente.getId().intValue()) {
                return true;
            }
        }
        return false;

    }

    @Override
    public int hashCode() {
        if (this.nombre != null
                && this.apellido != null
                && this.id != null
                && this.codigo != null) {
            return (int) 7 * this.nombre.length() + this.apellido.length()+ this.id.intValue() + this.codigo.length();
        }
        return 45;
    }
    
    
}
