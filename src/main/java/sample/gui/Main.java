package sample.gui;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sample.PersonaException;
import sample.logic.entities.Persona;
import sample.logic.entities.LeaderTypeEnum;
import sample.logic.services.impl.PersonaServices;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Main extends Application {

    // Visual Properties
    private Scene scene;
    private TableView<Persona> personasTable;
    private TextField nameInput;
    private TextField lastNameInput;
    private TextField deathDateInput;
    private TextField municipalityInput;
    private TextField departmentInput;
    private TextField typesOfLeaderInput;
    private TextField professionInput;
    private TextField isVictimInput;

    private Button addPersona;
    private Button deletePersona;
    private Button openReport;

    // Menu
    private MenuBar menuBar;
    private Map<String, MenuItem> fileMenuItems;

    // Logic Properties
    private PersonaServices personaServices;


    //CRUD -
    @Override
    public void start(Stage primaryStage) throws Exception {

        setUp();
        behavior(primaryStage);

        primaryStage.setTitle("final project");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void behavior(Stage stage) {
        this.personaServices = new PersonaServices();
        try {
            this.personaServices.insert(new Persona("Edwin", "Antonio Indaburo", "07/01/2021", "Nechi", "Antoquia","Campesino", LeaderTypeEnum.CAMPESINO,true));
            this.personaServices.insert(new Persona("Alfredo", "Garcia", "10/01/2021", "Ituango", "Antoquia","Campesino", LeaderTypeEnum.CAMPESINO,true));
            this.personaServices.insert(new Persona("Yordan Eduardo", "Guetio", "02/02/2021", "Corinto", "Cauca","Campesino", LeaderTypeEnum.CAMPESINO,true));
            this.personaServices.insert(new Persona("Albeiro", "Hoyos", "05/04/2021", "Anori", "Antoquia","Campesino", LeaderTypeEnum.CAMPESINO,true));
            this.personaServices.insert(new Persona("Wilson", "Lopez", "28/04/2021", "Aguadas", "Caldas","Campesino", LeaderTypeEnum.CAMPESINO,true));
            this.personaServices.insert(new Persona("Aldinever", "Cruz Guaraca", "09/05/2021", "Aipe", "Huila","Campesino", LeaderTypeEnum.CAMPESINO,true));

            this.personaServices.insert(new Persona("Robinson", "Quino Bonilla", "15/01/2021","Yondo","Antoquia","Comunal", LeaderTypeEnum.COMUNAL,true));
            this.personaServices.insert(new Persona("Janeth", "Zapata", "21/01/2021","Dosquebradas","Risaralda","Comunal", LeaderTypeEnum.COMUNAL,true));
            this.personaServices.insert(new Persona("Jose Miguel", "Barrientos Uribe", "28/01/2021","Yarumal","Antoquia","Comunal", LeaderTypeEnum.COMUNAL,true));
            this.personaServices.insert(new Persona("Arcenio", "Quinayas Ruiz", "30/01/2021","San Agustin","Huila","Comunal", LeaderTypeEnum.COMUNAL,true));
            this.personaServices.insert(new Persona("Remberto", "Arrieta Bohorquez", "31/01/2021","Taraza","Antoquia","Comunal", LeaderTypeEnum.COMUNAL,true));
            this.personaServices.insert(new Persona("Yordan Eduardo", "Guetio","02/02/2021","Corinto","Cauca","Comunal", LeaderTypeEnum.COMUNAL,true));
            this.personaServices.insert(new Persona("Ovidio de Jesus", "Salazar","02/02/2021","Herveo","Tolima","Comunal", LeaderTypeEnum.COMUNAL,true));
            this.personaServices.insert(new Persona("Juan Carlos", "Aguirre","14/04/2021","La macarena","Meta","Comunal", LeaderTypeEnum.COMUNAL,true));
            this.personaServices.insert(new Persona("Justiniano", "Torres Garcia","19/04/2021","Bucaramanga","Santander","Comunal", LeaderTypeEnum.COMUNAL,true));
            this.personaServices.insert(new Persona("Jorge Emilio", "Ramirez Venegas","09/05/2021","Aipe","Huila","Comunal", LeaderTypeEnum.COMUNAL,true));

            this.personaServices.insert(new Persona("Gerardo", "Leon", "01/01/2021","Puerto Gaitan","Meta","Sindical", LeaderTypeEnum.SINDICAL,true));
            this.personaServices.insert(new Persona("Diego", "Betancourt Higuera", "01/01/2021","El Yopal","Casanare","Sindical", LeaderTypeEnum.SINDICAL,true));
            this.personaServices.insert(new Persona("Carlos Alberto", "Vidal", "29/03/2021","Florida","Valle del Cauca","Sindical", LeaderTypeEnum.SINDICAL,true));
            this.personaServices.insert(new Persona("Beatriz", "Moreno Mosquera", "03/05/2021","Buenaventura","Valle","Sindical", LeaderTypeEnum.SINDICAL,true));

            this.personaServices.insert(new Persona("Andres", "Moreno", "10/04/2021","Mosquera","Cauca","LGTBIQ", LeaderTypeEnum.LGTBIQ,true));
            this.personaServices.insert(new Persona("Gonzalo ", "Cardona Molina", "2021/01/11", "Tulua", "Valle del Cauca", "Ambientalista",LeaderTypeEnum.AMBIENTALISTA,true));
            this.personaServices.insert(new Persona("Geovanny", "Cabezas Cruz", "2021/05/15", "Jamundí", "Valle del Cauca", "Indigena",LeaderTypeEnum.INDIGENA,true));
            this.personaServices.insert(new Persona("Orlando", "Manuel Chima", "2021/02/14", "Cáceres", "Antioquia", "Indigena",LeaderTypeEnum.INDIGENA,true));
            this.personaServices.insert(new Persona("Rafael", "Domico Carupia", "2021-04-06", "Dabeiba", "Antioquia", "Indigena",LeaderTypeEnum.INDIGENA,true));
            this.personaServices.insert(new Persona("Alejandro", "Manugama Cheche", "2021/02/17", "Bágado", "Choco", "Indigena",LeaderTypeEnum.INDIGENA,true));
            this.personaServices.insert(new Persona("Luz Aida", "Conchave Lana", "2021/02/19", "Alto Baudo", "Choco", "Indigena",LeaderTypeEnum.INDIGENA,true));
            this.personaServices.insert(new Persona("Pedro Nel", "Valencia Evao", "2021/04/18", "Certegui", "Choco", "Indigena",LeaderTypeEnum.INDIGENA,true));
            this.personaServices.insert(new Persona("Marcos", "Pai", "2021/02/21", "Tumaco", "Nariño", "Indigena",LeaderTypeEnum.INDIGENA,true));
            this.personaServices.insert(new Persona("John Albeiro", "Pai Pascal", "2021/02/24", "Tumaco", "Nariño", "Indigena",LeaderTypeEnum.INDIGENA,true));
            this.personaServices.insert(new Persona("Carmen Ofelia", "Cumbalaza", "2021/03/03", "Cumbal", "Nariño", "Indigena",LeaderTypeEnum.INDIGENA,true));
            this.personaServices.insert(new Persona("Miguel", "Garcia Pai", "2021/03/16", "Tumaco", "Nariño", "Indigena",LeaderTypeEnum.INDIGENA,true));
            this.personaServices.insert(new Persona("Alvaro", "Pascal Garcia", "2021/03/16", "Tumaco", "Nariño", "Indigena",LeaderTypeEnum.INDIGENA,true));
            this.personaServices.insert(new Persona("Jose", "Santos Lopez", "2021/03/28", "Tumaco", "Nariño", "Indigena",LeaderTypeEnum.INDIGENA,true));
            this.personaServices.insert(new Persona("Maria Ofelia", "Garcia", "2021/03/31", "Tumaco", "Nariño", "Indigena",LeaderTypeEnum.INDIGENA,true));
            this.personaServices.insert(new Persona("Dionisio", "Pai Pascal", "2021/04/18", "Tumaco", "Nariño", "Indigena",LeaderTypeEnum.INDIGENA,true));
            this.personaServices.insert(new Persona("Jaime", "Basilio", "2021/03/01", "San Basilio", "Sucre", "Indigena",LeaderTypeEnum.INDIGENA,true));
            this.personaServices.insert(new Persona("Maria Bernarda", " Juajibioy", "2021/03/17", "Orito", "Putumayo", "Indigena",LeaderTypeEnum.INDIGENA,true));
            this.personaServices.insert(new Persona("Gilberto", "Findicue Achicue", "2021/03/22", "Inza", "Cauca", "Indigena",LeaderTypeEnum.INDIGENA,true));
            this.personaServices.insert(new Persona("Ramiro", "Ascue Yule", "2021/03/28", "Toribio", "Cauca", "Indigena",LeaderTypeEnum.INDIGENA,true));
            this.personaServices.insert(new Persona("Fernando", "Lozada Franco", "2021/04/04", "Caloto", "Cauca", "Indigena",LeaderTypeEnum.INDIGENA,true));
            this.personaServices.insert(new Persona("Sandra Liliana", "Peña", "2021/04/20", "Caldono", "Cauca", "Indigena",LeaderTypeEnum.INDIGENA,true));
            this.personaServices.insert(new Persona("Aura Esther", "Garcia Peñalver", "2021/03/31", "Uribia", "La Guajira", "Indigena",LeaderTypeEnum.INDIGENA,true));
            this.personaServices.insert(new Persona("Aura Esther", "Garcia Peñalver", "2021/03/31", "Uribia", "La Guajira", "Indigena",LeaderTypeEnum.INDIGENA,true));

        } catch (PersonaException e) {
            e.printStackTrace();
        }
        personasTable.setItems((ObservableList<Persona>) this.personaServices.getAll());

        addPersona.setOnAction(e -> {
            try {
                Persona p = new Persona(nameInput.getText(), lastNameInput.getText(), deathDateInput.getText(), municipalityInput.getText(), departmentInput.getText(),typesOfLeaderInput.getText());
                this.personaServices.insert(p);
                nameInput.clear();
                lastNameInput.clear();
                deathDateInput.clear();
                municipalityInput.clear();
                departmentInput.clear();
                typesOfLeaderInput.clear();
            } catch (PersonaException personaException) {
                personaException.printStackTrace();
            }
        });

        deletePersona.setOnAction(e -> {
            this.personaServices.delete(personasTable.getSelectionModel().getSelectedItems());
        });

        fileMenuItems.get("Export").setOnAction(e -> {
            try {
                this.personaServices.export();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
        fileMenuItems.get("Import").setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select personas file");
            File file = fileChooser.showOpenDialog(stage);
            if (file == null) {
                System.out.println("No file");
            } else {
                try {
                    this.personaServices.importPersonas(file);
                    this.personaServices.getAll().stream().forEach(p -> System.out.println(p));
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        openReport.setOnAction(e -> {
            new ReportScene();
        });
    }

    private void setUp() {
        setupTable();
        setupInputs();
        setupMenu();
        setUpCrud();

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10, 10, 10, 10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(nameInput, lastNameInput, deathDateInput, municipalityInput, departmentInput, typesOfLeaderInput, addPersona, deletePersona, openReport);

        //Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(personasTable, hBox);

        BorderPane layout2 = new BorderPane();
        layout2.setTop(menuBar);
        layout2.setCenter(layout);

        //Scene
        //scene = new Scene(layout, 770, 300);
        scene = new Scene(layout2, 400, 400);

    }

    private void setUpCrud() {
        addPersona = new Button("Add");
        addPersona.setMinWidth(30);

        deletePersona = new Button("Delete");
        deletePersona.setMinWidth(30);

        openReport = new Button("Open Report");
        openReport.setMinWidth(90);
    }

    private void setupInputs() {
        nameInput = new TextField();
        nameInput.setPromptText("name");
        nameInput.setMinWidth(30);

        lastNameInput = new TextField();
        lastNameInput.setPromptText("last name");
        lastNameInput.setMinWidth(30);

        deathDateInput = new TextField();
        deathDateInput.setPromptText("death date");
        deathDateInput.setMinWidth(30);

        municipalityInput = new TextField();
        municipalityInput.setPromptText("municipality");
        municipalityInput.setMinWidth(30);

        departmentInput = new TextField();
        departmentInput.setPromptText("department");
        departmentInput.setMinWidth(30);

        typesOfLeaderInput = new TextField();
        typesOfLeaderInput.setPromptText("Type of Leader");
        typesOfLeaderInput.setMinWidth(30);
    }

    private void setupTable() {
        //Name column
        TableColumn<Persona, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMaxWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //LastName column
        TableColumn<Persona, String> lastNameColumn = new TableColumn<>("LastName");
        lastNameColumn.setMaxWidth(200);
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        //Death Date column
        TableColumn<Persona, Integer> deathDateColumn = new TableColumn<>("Death Date");
        deathDateColumn.setMaxWidth(200);
        deathDateColumn.setCellValueFactory(new PropertyValueFactory<>("deathDate"));

        //Municipality column
        TableColumn<Persona, Integer> municipalityColumn = new TableColumn<>("Municipality");
        municipalityColumn.setMaxWidth(200);
        municipalityColumn.setCellValueFactory(new PropertyValueFactory<>("municipality"));

        //Department column
        TableColumn<Persona, Integer> departmentColumn = new TableColumn<>("Department");
        departmentColumn.setMaxWidth(200);
        departmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));

        //Department column
        TableColumn<Persona, Integer> typesOfLeaderColumn = new TableColumn<>("Type of Leader");
        typesOfLeaderColumn.setMaxWidth(200);
        typesOfLeaderColumn.setCellValueFactory(new PropertyValueFactory<>("typesOfLeader"));

        //Table
        personasTable = new TableView<>();
        personasTable.getColumns().addAll(nameColumn, lastNameColumn, deathDateColumn, municipalityColumn, departmentColumn ,typesOfLeaderColumn);
    }

    private void setupMenu() {

        Menu fileMenu = new Menu("File");

        fileMenuItems = new HashMap<>();
        fileMenuItems.put("Import", new MenuItem("Import"));
        fileMenuItems.put("Export", new MenuItem("Export"));

        fileMenu.getItems().add(fileMenuItems.get("Import"));
        fileMenu.getItems().add(fileMenuItems.get("Export"));

        menuBar = new MenuBar();
        menuBar.getMenus().add(fileMenu);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
