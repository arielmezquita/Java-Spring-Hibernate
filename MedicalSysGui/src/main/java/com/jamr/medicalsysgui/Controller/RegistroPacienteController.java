package com.jamr.medicalsysgui.Controller;

import com.jamr.medicalsysbusiness.entity.Paciente;
import com.jamr.medicalsysbusiness.enums.ServiceEnum;
import com.jamr.medicalsysbusiness.repository.PacienteRepository;
import com.jamr.medicalsysbusiness.services.PacienteService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RegistroPacienteController implements Initializable {
    private PacienteRepository pacienteRepository;
    @FXML private TextField txtNombre;
    @FXML private TextField txtApellido;
    @FXML private TextField txtCedula;
    @FXML private TextField txtDireccion;
    @FXML private TextField txtTelefono;
    @FXML private TextField txtCorreo;
    @FXML private TextField txtGenero;
    @FXML private DatePicker fechanac;
    
    private ApplicationContext context;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         context =  new ClassPathXmlApplicationContext("/spring/applicationContext.xml");

    } 
    
    
     @FXML
    public void guardarPaciente(ActionEvent event){
              
        PacienteService pacienteService=(PacienteService) 
                context.getBean(ServiceEnum.PACIENTE_SERVICE.getValue());
    
        Paciente paciente = new Paciente();
        paciente.setNombre(txtNombre.getText());
        paciente.setApellido(txtApellido.getText());
        paciente.setCedula(txtCedula.getText());
        //paciente.setFechanac(fechanac.getText());
        paciente.setDireccion(txtDireccion.getText());
        paciente.setTelefono(txtTelefono.getText());
        paciente.setCorreo(txtCorreo.getText());
        
        pacienteService.guardarPaciente(paciente);
        
        JOptionPane.showMessageDialog(null, "Paciente Guardado con exito");
       
    }
    
    
    @FXML 
    public void limpiarPaciente(ActionEvent event){
        txtNombre.setText("");
        txtApellido.setText("");
        txtCedula.setText("");
        txtDireccion.setText("");
        txtCorreo.setText("");
        txtTelefono.setText("");
        txtGenero.setText("");
  
        txtNombre.setCursor(Cursor.TEXT);
    }

    
}
