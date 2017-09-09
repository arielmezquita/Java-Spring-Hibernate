
package com.jamr.medicalsysgui.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;


public class RegistroScreenController implements Initializable {
 
    @FXML private BorderPane mainLayout;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        System.out.println("Inicializando Registro Screen....");   
    }   
    
    @FXML
    public void cargarRegistroPaciente(ActionEvent evt) throws IOException{
        System.out.println("Registrando un Paciente");
         Parent pacienteScene = FXMLLoader.load(getClass().getResource("/fxml/FXMLRegistroPaciente.fxml"));
            mainLayout.setCenter(pacienteScene);
    }
    
   @FXML
    public void cargarRegistroMedico(ActionEvent evt) throws IOException{
        System.out.println("Registrando un Medico");
         Parent medicoScene = FXMLLoader.load(getClass().getResource("/fxml/FXMLRegistroMedico.fxml"));
            mainLayout.setCenter(medicoScene);
    }
    
    @FXML
    public void cargarRegistroProcedimiento(ActionEvent evt) throws IOException{
        System.out.println("Registrando un Procedimiento");
         Parent procedimientoScene = FXMLLoader.load(getClass().getResource("/fxml/FXMLRegistroProcedimiento.fxml"));
            mainLayout.setCenter(procedimientoScene);
    }
    
    
    @FXML
    public void cargarRegistroCita(ActionEvent evt) throws IOException{
        System.out.println("Registrando una Cita");
         Parent citaScene = FXMLLoader.load(getClass().getResource("/fxml/FXMLRegistroCita.fxml"));
            mainLayout.setCenter(citaScene);
    }
    
    
    @FXML
    public void cargarInfo(ActionEvent evt) throws IOException{
        System.out.println("Cargando Info");
         Parent infoScene = FXMLLoader.load(getClass().getResource("/fxml/FXMLInfoMedical.fxml"));
            mainLayout.setCenter(infoScene);
    }
}
