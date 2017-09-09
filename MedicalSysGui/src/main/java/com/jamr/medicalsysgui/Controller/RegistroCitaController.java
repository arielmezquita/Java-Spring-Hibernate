package com.jamr.medicalsysgui.Controller;

import com.jamr.medicalsysbusiness.entity.Medico;
import com.jamr.medicalsysbusiness.entity.Paciente;
import com.jamr.medicalsysbusiness.entity.Procedimiento;
import com.jamr.medicalsysbusiness.enums.ServiceEnum;
import com.jamr.medicalsysbusiness.services.MedicoService;
import com.jamr.medicalsysbusiness.services.PacienteService;
import com.jamr.medicalsysbusiness.services.ProcedimientoService;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RegistroCitaController implements Initializable {
    
    @FXML ObservableList pacienteList = FXCollections.observableArrayList();
    @FXML ObservableList procedimientoList = FXCollections.observableArrayList();
    @FXML ObservableList medicoList = FXCollections.observableArrayList();
    @FXML private ComboBox cboPaciente;
    @FXML private ComboBox cboProcedimiento;
    @FXML private ComboBox cboMedico;
    

    private ApplicationContext context;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        context =  new ClassPathXmlApplicationContext("/spring/applicationContext.xml");
        obtenerMedico();
        obtenerPaciente();
        obtenerProcedimiento();
        
    }   
    
    
    @FXML
    public void obtenerMedico(){
        MedicoService medicoService = (MedicoService)
                context.getBean(ServiceEnum.MEDICO_SERVICE.getValue());
        
        
        if(!medicoList.isEmpty())
            medicoList.clear();
        medicoList = FXCollections.observableList((List<Medico>) medicoService.buscarTodo());
 
        cboMedico.setItems(medicoList);
          
    }
    
    @FXML
    public void obtenerPaciente(){
        PacienteService pacienteService = (PacienteService)
                context.getBean(ServiceEnum.PACIENTE_SERVICE.getValue());
        
        
        if(!pacienteList.isEmpty())
            pacienteList.clear();
        pacienteList = FXCollections.observableList((List<Paciente>) pacienteService.buscarTodos());
 
        cboPaciente.setItems(pacienteList);
          
    }
    
    @FXML
    public void obtenerProcedimiento(){
        ProcedimientoService procedimientoService = (ProcedimientoService)
                context.getBean(ServiceEnum.PROCEDIMIENTO_SERVICE.getValue());
        
        
        if(!procedimientoList.isEmpty())
            procedimientoList.clear();
        procedimientoList = FXCollections.observableList((List<Procedimiento>) procedimientoService.buscarTodo());
 
        cboProcedimiento.setItems(procedimientoList);
      
    }
    
}
