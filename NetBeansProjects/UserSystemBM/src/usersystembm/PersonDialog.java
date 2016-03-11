/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usersystembm;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Locale;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import javafx.util.Callback;

/**
 *
 * @author honzik
 */
public class PersonDialog extends Stage{
    
    private Person osoba = null;

    public Person getOsoba() {
        return osoba;
    }
    
    public PersonDialog(Window window){
      
        
        setTitle("Nova osoba");
        setWidth(350);
        setHeight(250);
        
        initStyle(StageStyle.UTILITY);
        initModality(Modality.WINDOW_MODAL);
        initOwner(window);
        setScene(createScene());
    }
      private Scene createScene(){
          
          //Add VBox
          VBox box = new VBox();
          box.setAlignment(Pos.CENTER);
          box.setSpacing(20);
        
          //Grid with TextFields and Labels
          GridPane grid = new GridPane();
          grid.setAlignment(Pos.CENTER);
          grid.setPadding(new Insets(10));
          grid.setHgap(10);
          grid.setVgap(10);
          
          //komponenty
          final TextField nameTextField = new TextField(); //final pro pristup z vnitrni tridy
          final TextField emailTextField = new TextField();
          Label nameLabel = new Label("Jméno");
          Label emailLabel = new Label("Email");
          
          grid.add(nameLabel, 0, 0);
          grid.add(emailLabel, 0, 1);
          grid.add(nameTextField, 1,0);
          //grid.add(birthTextField,1,1);
          grid.add(emailTextField, 1,1);
          
          //button
          Button button = new Button("Ok");
         
          button.setOnAction((ActionEvent event) -> {  
              try {
               
                  
                  
                  osoba = new Person(nameTextField.getText(),2, emailTextField.getText());
                  hide();
              } catch (IllegalArgumentException ex) {
                  System.out.println("Chyba: "+ ex.getMessage());
              }
              
          });
            
    
          box.getChildren().addAll(grid,button);
          return new Scene(box);
      }    
    
}
