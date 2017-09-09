
package com.jamr.medicalsysbusiness.enums;


public enum ServiceEnum {
    MEDICO_SERVICE("medicoService"),
    PACIENTE_SERVICE("pacienteService"),
    EXPEDIENTE_SERVICE("expedienteService"),
    CITA_SERVICE("citaService"),
    PROCEDIMIENTO_SERVICE("procedimientoService"),
    DIAGNOSTICO_SERVICE("diagnosticoService"), 
    ESPECIALIDAD_SERVICE("especialidadService"),
    HORARIO_SERVICE("horarioService");
    
    
    ServiceEnum(String service){
       this.value=service;
    }
    
    private String value;

    public String getValue() {
        return value;
    }
    
    
}
