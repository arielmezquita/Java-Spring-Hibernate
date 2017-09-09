
package com.jamr.medicalsysgui.Controller;

import com.jamr.medicalsysbusiness.entity.Especialidad;
import com.jamr.medicalsysbusiness.entity.Medico;
import com.jamr.medicalsysbusiness.enums.ServiceEnum;
import com.jamr.medicalsysbusiness.repository.MedicoRepository;
import com.jamr.medicalsysbusiness.services.EspecialidadService;
import com.jamr.medicalsysbusiness.services.MedicoService;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class RegistroMedicoController implements Initializable {
    
    private MedicoRepository medicoRepository;
    @FXML ObservableList especialidadList = FXCollections.observableArrayList();
    @FXML private TextField txtNombre;
    @FXML private TextField txtApellido;
    @FXML private TextField txtCedula;
    @FXML private TextField txtDireccion;
    @FXML private TextField txtTelefono;
    @FXML private TextField txtCorreo;
    @FXML private ComboBox<String> cboEspecialidad;
    @FXML private DatePicker fechanac;
    
    
    private ApplicationContext context;
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
            context =  new ClassPathXmlApplicationContext("/spring/applicationContext.xml");
         
        obternerEspecialidad();
            
        }    
    
    @FXML
    public void guardarMedico(ActionEvent event){
              
        MedicoService medicoService=(MedicoService) 
                context.getBean(ServiceEnum.MEDICO_SERVICE.getValue());
    
        Medico medico = new Medico();
        medico.setNombre(txtNombre.getText());
        medico.setApellido(txtApellido.getText());
        medico.setCorreo(txtCorreo.getText());
        medico.setCedula(txtCedula.getText());
        //medico.setFechanac(fechanac.getText());
        medico.setDireccion(txtDireccion.getText());
        medico.setTelefono(txtTelefono.getText());
        medico.setCorreo(txtCorreo.getText());
        
        medicoService.guardarMedico(medico);
        
        JOptionPane.showMessageDialog(null, "Fuardado con exito");
       
    }
    
    
    @FXML
    public void obternerEspecialidad(){
        EspecialidadService especialidadService = (EspecialidadService)
                context.getBean(ServiceEnum.ESPECIALIDAD_SERVICE.getValue());
        
        if(!especialidadList.isEmpty())
            especialidadList.clear();
        especialidadList = FXCollections.observableList((List<Especialidad>) especialidadService.buscarTodo());
 
        cboEspecialidad.setItems(especialidadList);
           
    }
        
    @FXML 
    public void limpiarMedico(ActionEvent event){
        txtNombre.setText("");
        txtApellido.setText("");
        txtCedula.setText("");
        txtDireccion.setText("");
        txtCorreo.setText("");
        txtTelefono.setText("");
       
        txtNombre.setCursor(Cursor.TEXT);
    }
     
}
