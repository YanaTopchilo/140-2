/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxexample2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableRow;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.*;

/**
 *
 * @author Topchilo
 */
public class PersonStage{
    
   private Stage stage;
    
    public void show(){
        stage = new Stage();
        VBox root = new VBox();
        List<PersonTable> personTableList = new ArrayList<>();
        
        List<Person> personList = new RepositoryImpl().getPersons();
        for(Person person : personList){
            int qtyOfDomains = new RepositoryImpl().getDomainByPerson(person).size();
            personTableList.add(new PersonTable(person.getId(), 
                    person.getJobtitle(), 
                    person.getFullname(), 
                    person.getPhone(), 
                    person.getEmail(), 
                    qtyOfDomains));
        }
        ObservableList<PersonTable> observableList = FXCollections.observableArrayList(personTableList);
        TableView<PersonTable> table = new TableView<PersonTable>(observableList);
        
        TableColumn<PersonTable, Integer> idColumn = new TableColumn<>("Идентификатор");
        idColumn.setCellValueFactory(new PropertyValueFactory<PersonTable, Integer>("id"));
        table.getColumns().add(idColumn);
        
        TableColumn<PersonTable, String> jobtitleColumn = new TableColumn<>("Должность");
        jobtitleColumn.setCellValueFactory(new PropertyValueFactory<PersonTable, String>("jobtitle"));
        table.getColumns().add(jobtitleColumn);
        
        TableColumn<PersonTable, String> fullnameColumn = new TableColumn<>("ФИО");
        fullnameColumn.setCellValueFactory(new PropertyValueFactory<PersonTable, String>("fullname"));
        table.getColumns().add(fullnameColumn);
        
        TableColumn<PersonTable, String> phoneColumn = new TableColumn<>("Телефон");
        phoneColumn.setCellValueFactory(new PropertyValueFactory<PersonTable, String>("phone"));
        table.getColumns().add(phoneColumn);
        
        TableColumn<PersonTable, String> emailColumn = new TableColumn<>("Электрон. почта");
        emailColumn.setCellValueFactory(new PropertyValueFactory<PersonTable, String>("email"));
        table.getColumns().add(emailColumn);
         
        TableColumn<PersonTable, Integer> qtyOfDomainsColumn = new TableColumn<>("кол-во доменов");
        qtyOfDomainsColumn.setCellValueFactory(new PropertyValueFactory<PersonTable, Integer>("qtyOfDomains"));
        table.getColumns().add(qtyOfDomainsColumn);
        
         table.setOnMouseClicked(e->{
            if(e.getClickCount()==2){
                PersonTable personTable = table.getSelectionModel().getSelectedItem();
                Person person = new RepositoryImpl().getPersonById(personTable.getId());
                DomainStage domainStage = new DomainStage(person);
                domainStage.show();
            }
        });
    
                 
        root.getChildren().add(table);
        Scene scene = new Scene(root, 1000, 400);
        
        stage.setTitle("Clients");
        stage.setScene(scene);
        stage.show();
    }
}
