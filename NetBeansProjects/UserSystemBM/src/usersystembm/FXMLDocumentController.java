/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usersystembm;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author honzik
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label labelToday;
    @FXML
    private Label label;
    @FXML
    private ListView<Person> personsList;
    @FXML
    private Label labelName;
    @FXML
    private Label labelEmail;

    @FXML
    private MenuItem menuItemNewUser;
    @FXML
    private Button buttonAddUser;
    @FXML
    private TextField textFieldName;
    @FXML
    private TextField textFieldEmail;

    private final PersonManager personManager = new PersonManager();

    Stage prevStage;

    @FXML
    public void handleListClicked() {
        Person person = (Person) personsList.getSelectionModel().getSelectedItem();
        if (person != null) {
            labelName.setText(personManager.getName(person));
            labelEmail.setText(personManager.getEmail(person));
        }
    }

    @FXML
    public void handleCloseClicked(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    public void handleButtonNewUser(ActionEvent event) throws IOException {
        PersonDialog dialog = new PersonDialog(label.getScene().getWindow());
        dialog.showAndWait();
        Person person = dialog.getOsoba();
        if(person != null){
            try {
                personManager.addPerson(person);
            } catch (SQLException ex) {
                System.err.println("Chyba vloceni uzivatele "+ex.getMessage());
            }
        }
      
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (url.toString().contains("FXMLDocument")) {

            labelToday.setText(Datum.formatDate(Calendar.getInstance()));
            try {
                personsList.setItems(personManager.getPersons());
                if (!personManager.getPersons().isEmpty()) {
                    personsList.getSelectionModel().select(0);
                }
            } catch (SQLException ex) {
                System.err.println("Spatne cteni " + ex.getMessage());
            }
        }
    }
}
