package sample.gui;

import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.logic.entities.Report;
import sample.logic.services.IReportServices;
import sample.logic.services.impl.ReportServices;

import java.awt.*;
import java.util.Map;

public class ReportScene {
    // Visual Properties
    private Stage stage;
    private Label label;
    private Scene scene;
    //ERROR private TableView reportTable;
    private TableView<Report> reportTable;

    // Logic properties
    private ReportServices reportServices;
    private IReportServices reportServices1;

    public ReportScene() {
        stage  = new Stage();

        setUp();
        behavior(stage);

        stage.setTitle("Report");
        stage.setScene(scene);
        stage.show();
    }

    private void setUp() {

        //javafx.scene.control.Label label = new javafx.scene.control.Label("im a label");
        setUpTableReport();
        VBox reportLayout = new VBox(10);
        reportLayout.getChildren().add(reportTable);//table or label
        scene = new Scene(reportLayout, 200, 200);
    }

    private void behavior(Stage stage) {

        this.reportServices = new ReportServices();
        reportTable.setItems((ObservableList<Report>) reportServices.getReportPersonasByProfession());

        //reportTable.setItems((List<Report>) reportPersonasByProfession.values());//getValues

    }

    private void setUpTableReport() {

        // Profession Name
        //TableColumn<Report,String> professionNameColumn = new TableColumn<>();
        TableColumn<Report, String> professionNameColumn = new TableColumn<Report, String>();
        professionNameColumn.setMaxWidth(200);
        professionNameColumn.setCellValueFactory(new PropertyValueFactory("criteria"));

        // Count
        //TableColumn<Report, Integer> countColumn = new TableColumn<>();
        TableColumn<Report, Integer> countColumn = new TableColumn<Report, Integer>();
        countColumn.setMaxWidth(200);
        countColumn.setCellValueFactory(new PropertyValueFactory("count"));

       reportTable = new TableView<>();
       reportTable.getColumns().addAll(professionNameColumn, countColumn);
/*
        reportTable = new javafx.scene.control.TableView<>();
        reportTable.getColumns().addAll(professionNameColumn, countColumn);

 */
    }
}
