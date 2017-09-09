
package com.jamr.medicalsysgui.Controller;

import com.jamr.medicalsysbusiness.entity.Procedimiento;
import com.jamr.medicalsysbusiness.enums.ServiceEnum;
import com.jamr.medicalsysbusiness.services.ProcedimientoService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class RegistroProcedimientoController implements Initializable {

    @FXML private TextField txtDescripcion;
      
    private ApplicationContext context;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        context = new ClassPathXmlApplicationContext("/spring/applicationContext.xml");
       
    }   
    
    
    @FXML 
    public void guardarProcedimiento(ActionEvent event){

         ProcedimientoService procedimientoService=(ProcedimientoService)
            context.getBean(ServiceEnum.PROCEDIMIENTO_SERVICE.getValue());
        
        Procedimiento procedimiento = new Procedimiento();
        procedimiento.setDescripcion(txtDescripcion.getText());
        
        procedimientoService.guardarProcedimiento(procedimiento);
        
        JOptionPane.showConfirmDialog(null, "Procedimiento guardado Exitosamente");
        
    }
    
}
