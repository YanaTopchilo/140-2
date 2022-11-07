/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxexample2;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Modality;
/**
 *
 * @author Topchilo
 */
public class DomainStage {
    private Stage stage;
    private Person person;
    
    public  DomainStage(Person person){
        this.person = person;
    }
    
    public void show(){
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        VBox root = new VBox();
        
        List<DomainTable> DomainTableList = new RepositoryImpl().getDomainByPerson(person).stream().map(domain -> {
            return new DomainTable(domain.getWebname(), domain.getDomainName(), domain.getIP(),domain.getDateReg(), domain.getCountry() );
        }).collect(Collectors.toList());
        
        ObservableList<DomainTable> observableList = FXCollections.observableArrayList(DomainTableList);
        TableView<DomainTable> table = new TableView<DomainTable>(observableList);
        
        TableColumn<DomainTable, String> webnameColumn = new TableColumn<>("Имя домена");
        webnameColumn.setCellValueFactory(new PropertyValueFactory<DomainTable, String>("webname"));
        table.getColumns().add(webnameColumn);
        
         TableColumn<DomainTable, String> domainNameColumn = new TableColumn<>("Доменная зона");
        domainNameColumn.setCellValueFactory(new PropertyValueFactory<DomainTable, String>("domainName"));
        table.getColumns().add(domainNameColumn);
        
        TableColumn<DomainTable, String> IPColumn = new TableColumn<>("IP");
       IPColumn.setCellValueFactory(new PropertyValueFactory<DomainTable, String>("IP"));
        table.getColumns().add(IPColumn);
        
        TableColumn<DomainTable, LocalDate> dateRegColumn = new TableColumn<>("Дата регистрации");
        dateRegColumn.setCellValueFactory(new PropertyValueFactory<DomainTable, LocalDate>("dateReg"));
        table.getColumns().add(dateRegColumn);
        
        TableColumn<DomainTable, String> countryColumn = new TableColumn<>("Страна");
        countryColumn.setCellValueFactory(new PropertyValueFactory<DomainTable, String>("country"));
        table.getColumns().add(countryColumn);
        
        
        
        root.getChildren().add(table);
        Scene scene = new Scene(root, 600, 250);
        
        stage.setTitle("Список доменов " + person.getFullname());
        stage.setScene(scene);
        stage.show();
    }
}

