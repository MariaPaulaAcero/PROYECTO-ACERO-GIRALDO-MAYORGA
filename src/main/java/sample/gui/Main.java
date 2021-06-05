package sample.gui;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sample.DateException;
import sample.PersonaException;
import sample.logic.entities.Persona;
import sample.logic.entities.LeaderTypeEnum;
import sample.logic.services.impl.PersonaServices;

import javax.swing.text.Element;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class Main extends Application {

    // Visual Properties
    private URI url;
    private Scene scene;
    private TableView<Persona> personasTable;
    private TextField nameInput;
    private TextField lastNameInput;
    private TextField deathDateInput;
    private TextField municipalityInput;
    private TextField departmentInput;
    private TextField typesOfLeaderInput;
    private TextField isVictimInput;

    private Button addPersona;
    private Button deletePersona;
    private Button openReport;
    private Button updatePersona;

    // Menu
    private MenuBar menuBar;
    private Map<String, MenuItem> fileMenuItems;

    private MenuBar menuBar2;
    private Map<String, MenuItem> fileMenuItems2;

    private MenuBar menuBar3;
    private Map<String, MenuItem> fileMenuItems3;

    // Logic Properties
    public static PersonaServices personaServices;



    //CRUD -
    @Override
    public void start(Stage primaryStage) throws Exception {

        setUp();
        behavior(primaryStage);

        primaryStage.setTitle("final project");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void behavior(Stage stage) throws IOException, ClassNotFoundException {
        this.personaServices = new PersonaServices();
        try {
            this.personaServices.insert(new Persona("Edwin", "Antonio Indaburo", "2021-01-07", "Nechi", "Antoquia","Campesino", LeaderTypeEnum.CAMPESINO,true));
            this.personaServices.insert(new Persona("Alfredo", "Garcia", "2021-01-10", "Ituango", "Antoquia","Campesino", LeaderTypeEnum.CAMPESINO,true));
            this.personaServices.insert(new Persona("Yordan Eduardo", "Guetio", "2021-02-02", "Corinto", "Cauca","Campesino", LeaderTypeEnum.CAMPESINO,true));
            this.personaServices.insert(new Persona("Albeiro", "Hoyos", "2021-04-05", "Anori", "Antoquia","Campesino", LeaderTypeEnum.CAMPESINO,true));
            this.personaServices.insert(new Persona("Wilson", "Lopez", "2021-04-28", "Aguadas", "Caldas","Campesino", LeaderTypeEnum.CAMPESINO,true));
            this.personaServices.insert(new Persona("Aldinever", "Cruz Guaraca", "2021-05-09", "Aipe", "Huila","Campesino", LeaderTypeEnum.CAMPESINO,true));

            this.personaServices.insert(new Persona("Robinson", "Quino Bonilla", "2021-01-15","Yondo","Antoquia","Comunal", LeaderTypeEnum.COMUNAL,true));
            this.personaServices.insert(new Persona("Janeth", "Zapata", "2021-01-21","Dosquebradas","Risaralda","Comunal", LeaderTypeEnum.COMUNAL,true));
            this.personaServices.insert(new Persona("Jose Miguel", "Barrientos Uribe", "2021-01-28","Yarumal","Antoquia","Comunal", LeaderTypeEnum.COMUNAL,true));
            this.personaServices.insert(new Persona("Arcenio", "Quinayas Ruiz", "2021-01-30","San Agustin","Huila","Comunal", LeaderTypeEnum.COMUNAL,true));
            this.personaServices.insert(new Persona("Remberto", "Arrieta Bohorquez", "2021-01-31","Taraza","Antoquia","Comunal", LeaderTypeEnum.COMUNAL,true));
            this.personaServices.insert(new Persona("Yordan Eduardo", "Guetio","2021-02-02","Corinto","Cauca","Comunal", LeaderTypeEnum.COMUNAL,true));
            this.personaServices.insert(new Persona("Ovidio de Jesus", "Salazar","2021-02-02","Herveo","Tolima","Comunal", LeaderTypeEnum.COMUNAL,true));
            this.personaServices.insert(new Persona("Juan Carlos", "Aguirre","2021-04-14","La macarena","Meta","Comunal", LeaderTypeEnum.COMUNAL,true));
            this.personaServices.insert(new Persona("Justiniano", "Torres Garcia","2021-04-19","Bucaramanga","Santander","Comunal", LeaderTypeEnum.COMUNAL,true));
            this.personaServices.insert(new Persona("Jorge Emilio", "Ramirez Venegas","2021-05-09","Aipe","Huila","Comunal", LeaderTypeEnum.COMUNAL,true));

            this.personaServices.insert(new Persona("Gerardo", "Leon", "2021-01-01","Puerto Gaitan","Meta","Sindical", LeaderTypeEnum.SINDICAL,true));
            this.personaServices.insert(new Persona("Diego", "Betancourt Higuera", "2021-01-01","El Yopal","Casanare","Sindical", LeaderTypeEnum.SINDICAL,true));
            this.personaServices.insert(new Persona("Carlos Alberto", "Vidal", "2021-03-29","Florida","Valle del Cauca","Sindical", LeaderTypeEnum.SINDICAL,true));
            this.personaServices.insert(new Persona("Beatriz", "Moreno Mosquera", "2021-05-03","Buenaventura","Valle","Sindical", LeaderTypeEnum.SINDICAL,true));

            this.personaServices.insert(new Persona("Andres", "Moreno", "2021-04-10","Mosquera","Cauca","LGTBIQ", LeaderTypeEnum.LGTBIQ,true));

            this.personaServices.insert(new Persona("Gonzalo ", "Cardona Molina", "2021-01-11", "Tulua", "Valle del Cauca", "Ambientalista",LeaderTypeEnum.AMBIENTALISTA,true));

            this.personaServices.insert(new Persona("Geovanny", "Cabezas Cruz", "2021-05-15", "Jamundí", "Valle del Cauca", "Indigena",LeaderTypeEnum.INDIGENA,true));
            this.personaServices.insert(new Persona("Orlando", "Manuel Chima", "2021-02-14", "Caceres", "Antioquia", "Indigena",LeaderTypeEnum.INDIGENA,true));
            this.personaServices.insert(new Persona("Rafael", "Domico Carupia", "2021-04-06", "Dabeiba", "Antioquia", "Indigena",LeaderTypeEnum.INDIGENA,true));
            this.personaServices.insert(new Persona("Alejandro", "Manugama Cheche", "2021-02-17", "Bagado", "Choco", "Indigena",LeaderTypeEnum.INDIGENA,true));
            this.personaServices.insert(new Persona("Luz Aida", "Conchave Lana", "2021-02-19", "Alto Baudo", "Choco", "Indigena",LeaderTypeEnum.INDIGENA,true));
            this.personaServices.insert(new Persona("Pedro Nel", "Valencia Evao", "2021-04-18", "Certegui", "Choco", "Indigena",LeaderTypeEnum.INDIGENA,true));
            this.personaServices.insert(new Persona("Marcos", "Pai", "2021-02-21", "Tumaco", "Nariño", "Indigena",LeaderTypeEnum.INDIGENA,true));
            this.personaServices.insert(new Persona("John Albeiro", "Pai Pascal", "2021-02-24", "Tumaco", "Nariño", "Indigena",LeaderTypeEnum.INDIGENA,true));
            this.personaServices.insert(new Persona("Carmen Ofelia", "Cumbalaza", "2021-03-03", "Cumbal", "Nariño", "Indigena",LeaderTypeEnum.INDIGENA,true));
            this.personaServices.insert(new Persona("Miguel", "Garcia Pai", "2021-03-16", "Tumaco", "Nariño", "Indigena",LeaderTypeEnum.INDIGENA,true));
            this.personaServices.insert(new Persona("Alvaro", "Pascal Garcia", "2021-03-16", "Tumaco", "Nariño", "Indigena",LeaderTypeEnum.INDIGENA,true));
            this.personaServices.insert(new Persona("Jose", "Santos Lopez", "2021-03-28", "Tumaco", "Nariño", "Indigena",LeaderTypeEnum.INDIGENA,true));
            this.personaServices.insert(new Persona("Maria Ofelia", "Garcia", "2021-03-31", "Tumaco", "Nariño", "Indigena",LeaderTypeEnum.INDIGENA,true));
            this.personaServices.insert(new Persona("Dionisio", "Pai Pascal", "2021-04-18", "Tumaco", "Nariño", "Indigena",LeaderTypeEnum.INDIGENA,true));
            this.personaServices.insert(new Persona("Jaime", "Basilio", "2021-03-01", "San Basilio", "Sucre", "Indigena",LeaderTypeEnum.INDIGENA,true));
            this.personaServices.insert(new Persona("Maria Bernarda", " Juajibioy", "2021-03-17", "Orito", "Putumayo", "Indigena",LeaderTypeEnum.INDIGENA,true));
            this.personaServices.insert(new Persona("Gilberto", "Findicue Achicue", "2021-03-22", "Inza", "Cauca", "Indigena",LeaderTypeEnum.INDIGENA,true));
            this.personaServices.insert(new Persona("Ramiro", "Ascue Yule", "2021-03-28", "Toribio", "Cauca", "Indigena",LeaderTypeEnum.INDIGENA,true));
            this.personaServices.insert(new Persona("Fernando", "Lozada Franco", "2021-04-04", "Caloto", "Cauca", "Indigena",LeaderTypeEnum.INDIGENA,true));
            this.personaServices.insert(new Persona("Sandra Liliana", "Peña", "2021-04-20", "Caldono", "Cauca", "Indigena",LeaderTypeEnum.INDIGENA,true));
            this.personaServices.insert(new Persona("Aura Esther", "Garcia Peñalver", "2021-03-31", "Uribia", "La Guajira", "Indigena",LeaderTypeEnum.INDIGENA,true));
            this.personaServices.insert(new Persona("Aura Esther", "Garcia Peñalver", "2021-03-31", "Uribia", "La Guajira", "Indigena",LeaderTypeEnum.INDIGENA,true));

            this.personaServices.insert(new Persona("Ricardo", "Cortes Rozo", "2021-01-02", "Bogota", "Bogota", "Civico",LeaderTypeEnum.CIVICO,true));
            this.personaServices.insert(new Persona("Carlos Erlid", "González Cortés", "2021-01-10", "Buga", "Valle del Cauca", "Civico",LeaderTypeEnum.CIVICO,true));
            this.personaServices.insert(new Persona("Fermiliano", "Meneses", "2021-01-15", "Argelia", "Cauca", "Civico",LeaderTypeEnum.CIVICO,true));
            this.personaServices.insert(new Persona("William Antonio", "Rodriguez", "2021-01-16", "Cucuta", "Norte de Santander", "Civico",LeaderTypeEnum.CIVICO,true));
            this.personaServices.insert(new Persona("Linda", "Díaz Romero", "2021-01-19", "Cáceres", "Antioquia", "Civico",LeaderTypeEnum.CIVICO,true));
            this.personaServices.insert(new Persona("Jose", "Abadia Parra", "2021-01-20", "Pereira", "Risaralda", "Civico",LeaderTypeEnum.CIVICO,true));
            this.personaServices.insert(new Persona("Julian Sneider", "Muñoz", "2021-01-23", "Cali", "Valle del Cauca", "Civico",LeaderTypeEnum.CIVICO,true));
            this.personaServices.insert(new Persona("Giovanis", "Carranza Castillo", "2021-01-27", "Valledupar", "Cesar", "Civico",LeaderTypeEnum.CIVICO,true));
            this.personaServices.insert(new Persona("Yecid Andres", "Bolaño", "2021-02-08", "Barranquilla", "Atlántico", "Civico",LeaderTypeEnum.CIVICO,true));
            this.personaServices.insert(new Persona("Jose Ever", "Alvarez", "2021-02-25", "Rio de Oro", "Cesar", "Civico",LeaderTypeEnum.CIVICO,true));
            this.personaServices.insert(new Persona("Luis", "Hermides Alvarez", "2021-03-03", "Río de Oro", "Cesar", "Civico",LeaderTypeEnum.CIVICO,true));
            this.personaServices.insert(new Persona("Karina Paola", "Cuesta Ortega", "2021-03-25", "Tierralta", "Córdoba", "Civico",LeaderTypeEnum.CIVICO,true));
            this.personaServices.insert(new Persona("German", "Medina Triviño", "2021-03-30", "Florencia", "Caquetá", "Civico",LeaderTypeEnum.CIVICO,true));
            this.personaServices.insert(new Persona("Alvaro Farid", "Rodriguez", "2021-04-13", "Algeciras", "Huila", "Civico",LeaderTypeEnum.CIVICO,true));
            this.personaServices.insert(new Persona("Luis Octavio", "Gutierrez Montes", "2021-04-14", "Caucasia", "Antioquia", "Civico",LeaderTypeEnum.CIVICO,true));
            this.personaServices.insert(new Persona("Francisco", "Giacometto Gomez", "2021-04-17", "Santa Marta", "Magdalena", "Civico",LeaderTypeEnum.CIVICO,true));
            this.personaServices.insert(new Persona("Yovani", "Laguna", "2021-05-01", "San Miguel", "Putumayo", "Civico",LeaderTypeEnum.CIVICO,true));
            this.personaServices.insert(new Persona("Juan David", "García Naranjo", "2021-05-02", "San Luís", "Antioquia", "Civico",LeaderTypeEnum.CIVICO,true));
            this.personaServices.insert(new Persona("Cecilia", "Valderrama", "2021-05-11", "Chaparral", "Tolima", "Civico",LeaderTypeEnum.CIVICO,true));
            this.personaServices.insert(new Persona("Armando", "Alvarez", "2021-05-24", "Cali", "Valle del Cauca", "Civico",LeaderTypeEnum.CIVICO,true));

            this.personaServices.insert(new Persona("Fredman", "Herazo Padilla", "2021-01-15", "La Apartada", "Córdoba", "Afrodescendiente",LeaderTypeEnum.AFRODESCENDIENTES,true));
            this.personaServices.insert(new Persona("José", "Riascos", "2021-04-08", "Nuquí", "Chocó", "Afrodescendiente",LeaderTypeEnum.AFRODESCENDIENTES,true));
            this.personaServices.insert(new Persona("Margarito", "Salas", "2021-04-08", "Nuquí", "Chocó", "Afrodescendiente",LeaderTypeEnum.AFRODESCENDIENTES,true));

        } catch (PersonaException | DateException e) {
            e.printStackTrace();
        }
        personasTable.setItems((ObservableList<Persona>) this.personaServices.getAll());

        addPersona.setOnAction(e -> {
            try {
                Persona p = new Persona(nameInput.getText(), lastNameInput.getText(), deathDateInput.getText(), municipalityInput.getText(), departmentInput.getText(),typesOfLeaderInput.getText());
                //this.personaServices.insert(p);
                this.personaServices.getAll().add(p);
                nameInput.clear();
                lastNameInput.clear();
                deathDateInput.clear();
                municipalityInput.clear();
                departmentInput.clear();
                typesOfLeaderInput.clear();

            } catch (PersonaException | DateException personaException) {
                personaException.printStackTrace();
            }
        });

        deletePersona.setOnAction(e -> {
            this.personaServices.delete(personasTable.getSelectionModel().getSelectedItems());
        });

        EventHandler<MouseEvent> eventHandler = e -> {
            Persona persona = this.personasTable.getSelectionModel().getSelectedItem();

            this.nameInput.setText(persona.getName());
            this.lastNameInput.setText(persona.getLastName());
            this.deathDateInput.setText(persona.getDeathDate().toString());
            this.municipalityInput.setText(persona.getMunicipality());
            this.departmentInput.setText(persona.getDepartment());
            this.typesOfLeaderInput.setText(persona.getTypesOfLeader().toString());
        };

        personasTable.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);

        updatePersona.setOnAction(e -> {
            try {
                Persona personaModify = this.personasTable.getSelectionModel().getSelectedItem();
                Persona newPersona = new Persona(nameInput.getText(),lastNameInput.getText(),deathDateInput.getText(), municipalityInput.getText(), departmentInput.getText(),typesOfLeaderInput.getText());
                this.personaServices.update(personaModify, newPersona);

                this.personasTable.refresh();

                nameInput.clear();
                lastNameInput.clear();
                deathDateInput.clear();
                municipalityInput.clear();
                departmentInput.clear();
                typesOfLeaderInput.clear();

            } catch (PersonaException | DateException personaException) {
                personaException.printStackTrace();
            }
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
                    this.personaServices.getAll().forEach(System.out::println);
                    //this.personaServices.getAll().stream().forEach(p -> System.out.println(p));
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });

        openReport.setOnAction(e -> {
            new ReportScene();
        });


        //Menu campesino

        fileMenuItems.get("¿Que son los lideres sociales?").setOnAction(e ->  {

            Stage reportStage = new Stage();
            //fileMenuItems.get("Campesino").setOnAction(n-> System.out.println(ProfessionEnum.CAMPESINO));
            VBox reportLayout = new VBox(10);
            Scene reportScene = new Scene(reportLayout,200,200);

            Hyperlink hyperlink = new Hyperlink();
            Scene hyp = new Scene(hyperlink,200,200);

            try {
                url = new URI("https://www.larepublica.co/especiales/lideres-sociales-en-colombia/se-habla-mucho-de-ellos-pero-que-es-y-que-hace-un-lider-social-3123581");
            } catch (URISyntaxException ex) {}

            Label label = new Label("¿Que es un lider social en Colombia? \n" +
                    "\n"+
                    "Es una persona que dirige un partido politico, una poblacion o una comunidad,\n" +
                    " en Colombia hay varios tipos de lideres sociales entre ellos estan: Campesinos,\n" +
                    " ambientalistas, afrodescendientes,\n" +
                    " sindical, civico, comunal, indigena y LGTBIQ+.  \n"+
                    "\n"+
                    "¿Cual ha sido el porcentaje de muertes de líderes sociales en\n" +
                    " Colombia a lo largo del 2021? \n" +
                    "\n"+
                    "Campesino de 9%, Ambientalista de 2%, Afrodescendientes de 5%,\n" +
                    " Comunal de 16%, Indigena de 32%,\n" +
                    " LGTBIQ+\n" +
                    " de 2%, Sindical de 6% y Civico de 28%. ");

            hyperlink.setText("https://www.larepublica.co/especiales/lideres-sociales-en-colombia/se-habla-mucho-de-ellos-pero-que-es-y-que-hace-un-lider-social-3123581");
            hyperlink.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() :null;
                    if ( desktop != null && desktop.isSupported(Desktop.Action.BROWSE) ) {
                        try {
                            desktop.browse(url);
                        } catch ( Exception ex ) {
                            System.err.println( ex.getMessage() );
                        }
                    }
                }
            });
            label.setMaxWidth(100000);
            label.setPadding(new Insets(0,0,20,0));
            label.setAlignment(Pos.CENTER_LEFT);
            label.setFont(new Font(20));


            Image image = new Image("/image/sociales.jpg");
            ImageView imageView = new ImageView(image);
            BorderPane layout = new BorderPane();
            layout.getChildren().add(imageView);
            reportLayout.getChildren().add(layout);

            reportStage.setScene(hyp);
            reportLayout.getChildren().add(hyperlink);
            reportStage.setTitle("¿Que son los lideres sociales?");
            reportLayout.getChildren().add(label);
            reportStage.setScene(reportScene);
            reportStage.show();
        });


        fileMenuItems.get("Campesino").setOnAction(e -> {
            Stage reportStage = new Stage();
            //fileMenuItems.get("Campesino").setOnAction(n-> System.out.println(ProfessionEnum.CAMPESINO));
            VBox reportLayout = new VBox(10);
            Scene reportScene = new Scene(reportLayout, 200, 200);
            this.personaServices = new PersonaServices();
            try {

                this.personaServices.insert(new Persona("Edwin", "Antonio Indaburo", "2021-01-07", "Nechi", "Antoquia","Campesino", LeaderTypeEnum.CAMPESINO,true));
                this.personaServices.insert(new Persona("Alfredo", "Garcia", "2021-01-10", "Ituango", "Antoquia","Campesino", LeaderTypeEnum.CAMPESINO,true));
                this.personaServices.insert(new Persona("Yordan Eduardo", "Guetio", "2021-02-02", "Corinto", "Cauca","Campesino", LeaderTypeEnum.CAMPESINO,true));
                this.personaServices.insert(new Persona("Albeiro", "Hoyos", "2021-04-05", "Anori", "Antoquia","Campesino", LeaderTypeEnum.CAMPESINO,true));
                this.personaServices.insert(new Persona("Wilson", "Lopez", "2021-04-28", "Aguadas", "Caldas","Campesino", LeaderTypeEnum.CAMPESINO,true));
                this.personaServices.insert(new Persona("Aldinever", "Cruz Guaraca", "2021-05-09", "Aipe", "Huila","Campesino", LeaderTypeEnum.CAMPESINO,true));
                personasTable.setItems((ObservableList<Persona>) this.personaServices.getAll());

            } catch (Exception exception) {
                exception.printStackTrace();
            }

            Hyperlink hyperlink = new Hyperlink();
            Scene hyp = new Scene(hyperlink,200,200);

            Label label = new Label("Funcionalidad lider Campesino:\n" +
                    "\n"+
                    " Sustitucion de cultivos,conservacion ambiental y \n" +
                    "reclamos por propiedad de terrenos.");
            try {
                url = new URI("https://n9.cl/ya9ma");
            } catch (URISyntaxException ex) {}

            hyperlink.setText("https://n9.cl/ya9ma");
            hyperlink.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent e) {
                    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() :null;
                    if ( desktop != null && desktop.isSupported(Desktop.Action.BROWSE) ) {
                        try {
                            desktop.browse(url);
                        } catch ( Exception ex ) {
                            System.err.println( ex.getMessage() );
                        }
                    }
                }
            });
            label.setMaxWidth(100000);
            label.setPadding(new Insets(0,0,20,0));
            label.setAlignment(Pos.CENTER_LEFT);
            label.setFont(new Font(20));

            Image image = new Image("/image/ambientalista.png");
            ImageView imageView = new ImageView(image);
            BorderPane layout = new BorderPane();
            layout.getChildren().add(imageView);
            reportLayout.getChildren().add(layout);

            reportStage.setScene(hyp);
            reportLayout.getChildren().add(hyperlink);
            reportLayout.getChildren().add(label);
            reportStage.setTitle("CAMPESINOS");
            reportStage.setScene(reportScene);
            reportStage.show();
        });


        fileMenuItems.get("Afrodescendiente").setOnAction(e ->  {
            Stage reportStage = new Stage();
            //fileMenuItems.get("Campesino").setOnAction(n-> System.out.println(ProfessionEnum.CAMPESINO));
            VBox reportLayout = new VBox(10);
            Scene reportScene = new Scene(reportLayout,200,200);

            this.personaServices = new PersonaServices();

            try {
                this.personaServices.insert(new Persona("Fredman", "Herazo Padilla", "2021-01-15", "La Apartada", "Córdoba", "Afrodescendiente"));
                this.personaServices.insert(new Persona("José", "Riascos", "2021-04-08", "Nuquí", "Chocó", "Afrodescendiente"));
                this.personaServices.insert(new Persona("Margarito", "Salas", "2021-04-08", "Nuquí", "Chocó", "Afrodescendiente"));
                personasTable.setItems((ObservableList<Persona>) this.personaServices.getAll());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            Hyperlink hyperlink = new Hyperlink();
            Scene hyp = new Scene(hyperlink,200,200);

            Label label = new Label("Funcionalidad lider Afrodescendientes:\n" +
                    "\n"+
                    " Defienden territorios, los derechos humanos, \n" +
                    "se centran en que la educacion sea buena y que \n" +
                    "la exista una proteccion hacia las diferentes\n" +
                    " comunidades." );
            try {
                url = new URI("https://n9.cl/nr3y");
            } catch (URISyntaxException ex) {}

            hyperlink.setText("https://n9.cl/nr3y");
            hyperlink.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent e) {
                    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() :null;
                    if ( desktop != null && desktop.isSupported(Desktop.Action.BROWSE) ) {
                        try {
                            desktop.browse(url);
                        } catch ( Exception ex ) {
                            System.err.println( ex.getMessage() );
                        }
                    }
                }
            });
            label.setMaxWidth(100000);
            label.setPadding(new Insets(0,0,20,0));
            label.setAlignment(Pos.TOP_CENTER);
            label.setFont(new Font(20));

            Image image = new Image("/image/colombia3.jpg");
            ImageView imageView = new ImageView(image);
            BorderPane layout = new BorderPane();
            layout.getChildren().add(imageView);
            reportLayout.getChildren().add(layout);

            reportStage.setScene(hyp);
            reportLayout.getChildren().add(hyperlink);
            reportLayout.getChildren().add(label);
            reportStage.setTitle("Afrodescendiente");
            reportStage.setScene(reportScene);
            reportStage.show();
        });


        // Menu Ambientalista

        fileMenuItems.get("Ambientalista").setOnAction(e ->  {
            Stage reportStage = new Stage();
            //fileMenuItems.get("Campesino").setOnAction(n-> System.out.println(ProfessionEnum.CAMPESINO));
            VBox reportLayout = new VBox(10);
            Scene reportScene = new Scene(reportLayout,200,200);

            this.personaServices = new PersonaServices();
            try {
                this.personaServices.insert(new Persona("Gonzalo ", "Cardona Molina", "2021-01-11", "Tulua", "Valle del Cauca", "Ambientalista",LeaderTypeEnum.AMBIENTALISTA,true));
                personasTable.setItems((ObservableList<Persona>) this.personaServices.getAll());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            Hyperlink hyperlink = new Hyperlink();
            Scene hyp = new Scene(hyperlink,200,200);

            Label label = new Label("Funcionalidad lider Ambientalista:\n" +
                    "\n"+
                    " Genera intercambio de roles, conocimiento, experiencias,\n" +
                    "valores, con el fin de hacer a la comunidad reflexionar \n " +
                    "sobre la transformacion de situaciones ambientales. \n" );

            label.setMaxWidth(1000);
            label.setPadding(new Insets(0,0,20,0));
            label.setAlignment(Pos.CENTER_LEFT);
            label.setFont(new Font(20));

            try {
                url = new URI("https://n9.cl/q2x1u");
            } catch (URISyntaxException ex) {}

            hyperlink.setText("https://n9.cl/q2x1u");
            hyperlink.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent e) {
                    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() :null;
                    if ( desktop != null && desktop.isSupported(Desktop.Action.BROWSE) ) {
                        try {
                            desktop.browse(url);
                        } catch ( Exception ex ) {
                            System.err.println( ex.getMessage() );
                        }
                    }
                }
            });

            label.setMaxWidth(100000);
            label.setPadding(new Insets(0,0,20,0));
            label.setAlignment(Pos.CENTER_LEFT);
            label.setFont(new Font(20));

            Image image = new Image("/image/ambientalista1.png");
            ImageView imageView = new ImageView(image);
            BorderPane layout = new BorderPane();
            layout.getChildren().add(imageView);
            reportLayout.getChildren().add(layout);

            reportStage.setScene(hyp);
            reportLayout.getChildren().add(hyperlink);
            reportLayout.getChildren().add(label);
            reportStage.setTitle("Ambientalistas");
            reportStage.setScene(reportScene);
            reportStage.show();
        });

        // Menu Comunal

        fileMenuItems.get("Comunal").setOnAction(e ->  {
            Stage reportStage = new Stage();
            //fileMenuItems.get("Campesino").setOnAction(n-> System.out.println(ProfessionEnum.CAMPESINO));
            VBox reportLayout = new VBox(10);
            Scene reportScene = new Scene(reportLayout,200,200);

            this.personaServices = new PersonaServices();
            try {
                this.personaServices.insert(new Persona("Robinson", "Quino Bonilla", "2021-01-15","Yondo","Antoquia","Comunal", LeaderTypeEnum.COMUNAL,true));
                this.personaServices.insert(new Persona("Janeth", "Zapata", "2021-01-21","Dosquebradas","Risaralda","Comunal", LeaderTypeEnum.COMUNAL,true));
                this.personaServices.insert(new Persona("Jose Miguel", "Barrientos Uribe", "2021-01-28","Yarumal","Antoquia","Comunal", LeaderTypeEnum.COMUNAL,true));
                this.personaServices.insert(new Persona("Arcenio", "Quinayas Ruiz", "2021-01-30","San Agustin","Huila","Comunal", LeaderTypeEnum.COMUNAL,true));
                this.personaServices.insert(new Persona("Remberto", "Arrieta Bohorquez", "2021-01-31","Taraza","Antoquia","Comunal", LeaderTypeEnum.COMUNAL,true));
                this.personaServices.insert(new Persona("Yordan Eduardo", "Guetio","2021-02-02","Corinto","Cauca","Comunal", LeaderTypeEnum.COMUNAL,true));
                this.personaServices.insert(new Persona("Ovidio de Jesus", "Salazar","2021-02-02","Herveo","Tolima","Comunal", LeaderTypeEnum.COMUNAL,true));
                this.personaServices.insert(new Persona("Juan Carlos", "Aguirre","2021-04-14","La macarena","Meta","Comunal", LeaderTypeEnum.COMUNAL,true));
                this.personaServices.insert(new Persona("Justiniano", "Torres Garcia","2021-04-19","Bucaramanga","Santander","Comunal", LeaderTypeEnum.COMUNAL,true));
                this.personaServices.insert(new Persona("Jorge Emilio", "Ramirez Venegas","2021-05-09","Aipe","Huila","Comunal", LeaderTypeEnum.COMUNAL,true));
                personasTable.setItems((ObservableList<Persona>) this.personaServices.getAll());
            } catch (Exception exception) {
                exception.printStackTrace();
            }

            Hyperlink hyperlink = new Hyperlink();
            Scene hyp = new Scene(hyperlink,200,200);

            Label label = new Label("Funcionalidad lider Comunal:\n" +
                    "\n"+
                    " Defienden el territorio, los derechos humanos de la comunidad y\n " +
                    "se enfocan en que haya una participacion en la politica por parte de las personas" );
            try {
                url = new URI("https://n9.cl/p9yzy");
            } catch (URISyntaxException ex) {}

            hyperlink.setText("https://n9.cl/p9yzy");
            hyperlink.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent e) {
                    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() :null;
                    if ( desktop != null && desktop.isSupported(Desktop.Action.BROWSE) ) {
                        try {
                            desktop.browse(url);
                        } catch ( Exception ex ) {
                            System.err.println( ex.getMessage() );
                        }
                    }
                }
            });
            label.setMaxWidth(100000);
            label.setPadding(new Insets(0,0,20,0));
            label.setAlignment(Pos.CENTER_LEFT);
            label.setFont(new Font(20));

            Image image = new Image("/image/comunal.jpeg");
            ImageView imageView = new ImageView(image);
            BorderPane layout = new BorderPane();
            layout.getChildren().add(imageView);
            reportLayout.getChildren().add(layout);


            reportStage.setScene(hyp);
            reportLayout.getChildren().add(hyperlink);
            reportLayout.getChildren().add(label);
            reportStage.setTitle("Comunal");
            reportStage.setScene(reportScene);
            reportStage.show();
        });

        // Menu Indigenas

        fileMenuItems.get("Indigena").setOnAction(e ->  {
            Stage reportStage = new Stage();
            //fileMenuItems.get("Campesino").setOnAction(n-> System.out.println(ProfessionEnum.CAMPESINO));
            VBox reportLayout = new VBox(10);
            Scene reportScene = new Scene(reportLayout,200,200);
            this.personaServices = new PersonaServices();

            try {
                this.personaServices.insert(new Persona("Geovanny", "Cabezas Cruz", "2021-05-15", "Jamundí", "Valle del Cauca", "Indigena",LeaderTypeEnum.INDIGENA,true));
                this.personaServices.insert(new Persona("Orlando", "Manuel Chima", "2021-02-14", "Caceres", "Antioquia", "Indigena",LeaderTypeEnum.INDIGENA,true));
                this.personaServices.insert(new Persona("Rafael", "Domico Carupia", "2021-04-06", "Dabeiba", "Antioquia", "Indigena",LeaderTypeEnum.INDIGENA,true));
                this.personaServices.insert(new Persona("Alejandro", "Manugama Cheche", "2021-02-17", "Bagado", "Choco", "Indigena",LeaderTypeEnum.INDIGENA,true));
                this.personaServices.insert(new Persona("Luz Aida", "Conchave Lana", "2021-02-19", "Alto Baudo", "Choco", "Indigena",LeaderTypeEnum.INDIGENA,true));
                this.personaServices.insert(new Persona("Pedro Nel", "Valencia Evao", "2021-04-18", "Certegui", "Choco", "Indigena",LeaderTypeEnum.INDIGENA,true));
                this.personaServices.insert(new Persona("Marcos", "Pai", "2021-02-21", "Tumaco", "Nariño", "Indigena",LeaderTypeEnum.INDIGENA,true));
                this.personaServices.insert(new Persona("John Albeiro", "Pai Pascal", "2021-02-24", "Tumaco", "Nariño", "Indigena",LeaderTypeEnum.INDIGENA,true));
                this.personaServices.insert(new Persona("Carmen Ofelia", "Cumbalaza", "2021-03-03", "Cumbal", "Nariño", "Indigena",LeaderTypeEnum.INDIGENA,true));
                this.personaServices.insert(new Persona("Miguel", "Garcia Pai", "2021-03-16", "Tumaco", "Nariño", "Indigena",LeaderTypeEnum.INDIGENA,true));
                this.personaServices.insert(new Persona("Alvaro", "Pascal Garcia", "2021-03-16", "Tumaco", "Nariño", "Indigena",LeaderTypeEnum.INDIGENA,true));
                this.personaServices.insert(new Persona("Jose", "Santos Lopez", "2021-03-28", "Tumaco", "Nariño", "Indigena",LeaderTypeEnum.INDIGENA,true));
                this.personaServices.insert(new Persona("Maria Ofelia", "Garcia", "2021-03-31", "Tumaco", "Nariño", "Indigena",LeaderTypeEnum.INDIGENA,true));
                this.personaServices.insert(new Persona("Dionisio", "Pai Pascal", "2021-04-18", "Tumaco", "Nariño", "Indigena",LeaderTypeEnum.INDIGENA,true));
                this.personaServices.insert(new Persona("Jaime", "Basilio", "2021-03-01", "San Basilio", "Sucre", "Indigena",LeaderTypeEnum.INDIGENA,true));
                this.personaServices.insert(new Persona("Maria Bernarda", " Juajibioy", "2021-03-17", "Orito", "Putumayo", "Indigena",LeaderTypeEnum.INDIGENA,true));
                this.personaServices.insert(new Persona("Gilberto", "Findicue Achicue", "2021-03-22", "Inza", "Cauca", "Indigena",LeaderTypeEnum.INDIGENA,true));
                this.personaServices.insert(new Persona("Ramiro", "Ascue Yule", "2021-03-28", "Toribio", "Cauca", "Indigena",LeaderTypeEnum.INDIGENA,true));
                this.personaServices.insert(new Persona("Fernando", "Lozada Franco", "2021-04-04", "Caloto", "Cauca", "Indigena",LeaderTypeEnum.INDIGENA,true));
                this.personaServices.insert(new Persona("Sandra Liliana", "Peña", "2021-04-20", "Caldono", "Cauca", "Indigena",LeaderTypeEnum.INDIGENA,true));
                this.personaServices.insert(new Persona("Aura Esther", "Garcia Peñalver", "2021-03-31", "Uribia", "La Guajira", "Indigena",LeaderTypeEnum.INDIGENA,true));
                this.personaServices.insert(new Persona("Aura Esther", "Garcia Peñalver", "2021-03-31", "Uribia", "La Guajira", "Indigena",LeaderTypeEnum.INDIGENA,true));
                personasTable.setItems((ObservableList<Persona>) this.personaServices.getAll());

            } catch (Exception exception) {
                exception.printStackTrace();
            }

            Hyperlink hyperlink = new Hyperlink();
            Scene hyp = new Scene(hyperlink,200,200);

            Label label = new Label("Funcionalidad lider Indigena:\n" +
                    "\n"+
                    " Seguridad campesina, protección del territorio,\n " +
                    "mejoras de calidad en las vías de la comunidad, \n" +
                    "mejoras en la salud y educacion.");
            try {
                url = new URI("https://n9.cl/a2tci");
            } catch (URISyntaxException ex) {}

            hyperlink.setText("https://n9.cl/a2tci");
            hyperlink.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent e) {
                    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() :null;
                    if ( desktop != null && desktop.isSupported(Desktop.Action.BROWSE) ) {
                        try {
                            desktop.browse(url);
                        } catch ( Exception ex ) {
                            System.err.println( ex.getMessage() );
                        }
                    }
                }
            });
            label.setMaxWidth(100000);
            label.setPadding(new Insets(0,0,20,0));
            label.setAlignment(Pos.CENTER_RIGHT);
            label.setFont(new Font(20));

            Image image = new Image("/image/colombia1.jpg");
            ImageView imageView = new ImageView(image);
            BorderPane layout = new BorderPane();
            layout.getChildren().add(imageView);
            reportLayout.getChildren().add(layout);

            reportStage.setScene(hyp);
            reportLayout.getChildren().add(hyperlink);
            reportLayout.getChildren().add(label);
            reportStage.setTitle("Indígenas");
            reportStage.setScene(reportScene);
            reportStage.show();
        });


        // Menu LGTBIQ
        fileMenuItems.get("LGTBIQ").setOnAction(e ->  {
            Stage reportStage = new Stage();
            //fileMenuItems.get("Campesino").setOnAction(n-> System.out.println(ProfessionEnum.CAMPESINO));
            VBox reportLayout = new VBox(10);
            Scene reportScene = new Scene(reportLayout,200,200);

            this.personaServices = new PersonaServices();
            try {
                this.personaServices.insert(new Persona("Andres", "Moreno", "2021-04-10","Mosquera","Cauca","LGTBIQ", LeaderTypeEnum.LGTBIQ,true));
                personasTable.setItems((ObservableList<Persona>) this.personaServices.getAll());
            } catch (Exception exception) {
                exception.printStackTrace();
            }

            Hyperlink hyperlink = new Hyperlink();
            Scene hyp = new Scene(hyperlink,200,200);

            Label label = new Label("Funcionalidad lider LGTBIQ:\n" +
                    "\n"+
                    " Se empeñan en que la igualdad de genero cada vez sea mayor y \n" +
                    " la discriminacion incremente, de igual forma defienden \n" +
                    "los derechos humanos.");

            try {
                url = new URI("http://www.scielo.org.co/pdf/luaz/n34/n34a13.pdf");
            } catch (URISyntaxException ex) {}

            hyperlink.setText("http://www.scielo.org.co/pdf/luaz/n34/n34a13.pdf");
            hyperlink.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent e) {
                    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() :null;
                    if ( desktop != null && desktop.isSupported(Desktop.Action.BROWSE) ) {
                        try {
                            desktop.browse(url);
                        } catch ( Exception ex ) {
                            System.err.println( ex.getMessage() );
                        }
                    }
                }
            });
            label.setMaxWidth(100000);
            label.setPadding(new Insets(0,0,20,0));
            label.setAlignment(Pos.BOTTOM_RIGHT);
            label.setFont(new Font(20));

            Image image = new Image("/image/LGT.png");
            ImageView imageView = new ImageView(image);
            BorderPane layout = new BorderPane();
            layout.getChildren().add(imageView);
            reportLayout.getChildren().add(layout);

            reportStage.setScene(hyp);
            reportLayout.getChildren().add(hyperlink);
            reportLayout.getChildren().add(label);
            reportStage.setTitle("LGTBIQ");
            reportStage.setScene(reportScene);
            reportStage.show();
        });


        // Menu Sindical
        fileMenuItems.get("Sindical").setOnAction(e ->  {
            Stage reportStage = new Stage();
            //fileMenuItems.get("Campesino").setOnAction(n-> System.out.println(ProfessionEnum.CAMPESINO));
            VBox reportLayout = new VBox(10);
            Scene reportScene = new Scene(reportLayout,200,200);

            this.personaServices = new PersonaServices();
            try {
                this.personaServices.insert(new Persona("Gerardo", "Leon", "2021-01-01","Puerto Gaitan","Meta","Sindical", LeaderTypeEnum.SINDICAL,true));
                this.personaServices.insert(new Persona("Diego", "Betancourt Higuera", "2021-01-01","El Yopal","Casanare","Sindical", LeaderTypeEnum.SINDICAL,true));
                this.personaServices.insert(new Persona("Carlos Alberto", "Vidal", "2021-03-29","Florida","Valle del Cauca","Sindical", LeaderTypeEnum.SINDICAL,true));
                this.personaServices.insert(new Persona("Beatriz", "Moreno Mosquera", "2021-05-03","Buenaventura","Valle","Sindical", LeaderTypeEnum.SINDICAL,true));

                personasTable.setItems((ObservableList<Persona>) this.personaServices.getAll());
            } catch (Exception exception) {
                exception.printStackTrace();
            }

            Hyperlink hyperlink = new Hyperlink();
            BackgroundFill background_fill = new BackgroundFill(Color.PINK,
                    CornerRadii.EMPTY, Insets.EMPTY);

            // create Background
            Background background = new Background(background_fill);
            hyperlink.setBackground(background);
            Scene hyp = new Scene(hyperlink,200,200);

            Label label = new Label("Funcionalidad lider Sindical:\n" +
                    "\n"+
                    " Es un defensor de los derechos laborales de su comunidad,\n" +
                    " se encargan de velar por una mejor en el ambito profesional y socioeconomico,\n" +
                    " es un lider cercano al poder publico.  ");
            try {
                url = new URI("https://www.elespectador.com/judicial/continua-la-tragedia-gerardo-leon-primer-lider-social-asesinado-en-2021-article/ ");
            } catch (URISyntaxException ex) {}

            hyperlink.setText("https://www.elespectador.com/judicial/continua-la-tragedia-gerardo-leon-primer-lider-social-asesinado-en-2021-article/ ");
            hyperlink.setOnAction(new EventHandler<ActionEvent>() {


                @Override
                public void handle(ActionEvent e) {
                    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() :null;
                    if ( desktop != null && desktop.isSupported(Desktop.Action.BROWSE) ) {
                        try {
                            desktop.browse(url);
                        } catch ( Exception ex ) {
                            System.err.println( ex.getMessage() );
                        }
                    }
                }
            });
            label.setMaxWidth(100000);
            label.setPadding(new Insets(0,0,20,0));
            label.setAlignment(Pos.CENTER_LEFT);
            label.setFont(new Font(20));

            Image image = new Image("/image/sindical1.png");
            ImageView imageView = new ImageView(image);
            BorderPane layout = new BorderPane();
            layout.getChildren().add(imageView);
            reportLayout.getChildren().add(layout);

            reportStage.setScene(hyp);
            reportLayout.getChildren().add(hyperlink);
            reportLayout.getChildren().add(label);
            reportStage.setTitle("Sindical");
            reportStage.setScene(reportScene);
            reportStage.show();
        });

        // Menu Sindical
        fileMenuItems.get("Civico").setOnAction(e ->  {
            Stage reportStage = new Stage();
            //fileMenuItems.get("Campesino").setOnAction(n-> System.out.println(ProfessionEnum.CAMPESINO));
            VBox reportLayout = new VBox(10);
            Scene reportScene = new Scene(reportLayout,200,200);

            this.personaServices = new PersonaServices();
            try {
                this.personaServices.insert(new Persona("Ricardo", "Cortes Rozo", "2021-01-02", "Bogota", "Bogotá", "Civico",LeaderTypeEnum.CIVICO,true));
                this.personaServices.insert(new Persona("Carlos Erlid", "González Cortés", "2021-01-10", "Buga", "Valle del Cauca", "Civico",LeaderTypeEnum.CIVICO,true));
                this.personaServices.insert(new Persona("Fermiliano", "Meneses", "2021-01-15", "Argelia", "Cauca", "Civico",LeaderTypeEnum.CIVICO,true));
                this.personaServices.insert(new Persona("William Antonio", "Rodriguez", "2021-01-16", "Cucuta", "Norte de Santander", "Civico",LeaderTypeEnum.CIVICO,true));
                this.personaServices.insert(new Persona("Linda", "Díaz Romero", "2021-01-19", "Cáceres", "Antioquia", "Civico",LeaderTypeEnum.CIVICO,true));
                this.personaServices.insert(new Persona("Jose", "Abadia Parra", "2021-01-20", "Pereira", "Risaralda", "Civico",LeaderTypeEnum.CIVICO,true));
                this.personaServices.insert(new Persona("Julian Sneider", "Muñoz", "2021-01-23", "Cali", "Valle del Cauca", "Civico",LeaderTypeEnum.CIVICO,true));
                this.personaServices.insert(new Persona("Giovanis", "Carranza Castillo", "2021-01-27", "Valledupar", "Cesar", "Civico",LeaderTypeEnum.CIVICO,true));
                this.personaServices.insert(new Persona("Yecid Andres", "Bolaño", "2021-02-08", "Barranquilla", "Atlántico", "Civico",LeaderTypeEnum.CIVICO,true));
                this.personaServices.insert(new Persona("Jose Ever", "Alvarez", "2021-02-25", "Rio de Oro", "Cesar", "Civico",LeaderTypeEnum.CIVICO,true));
                this.personaServices.insert(new Persona("Luis", "Hermides Alvarez", "2021-03-03", "Río de Oro", "Cesar", "Civico",LeaderTypeEnum.CIVICO,true));
                this.personaServices.insert(new Persona("Karina Paola", "Cuesta Ortega", "2021-03-25", "Tierralta", "Córdoba", "Civico",LeaderTypeEnum.CIVICO,true));
                this.personaServices.insert(new Persona("German", "Medina Triviño", "2021-03-30", "Florencia", "Caquetá", "Civico",LeaderTypeEnum.CIVICO,true));
                this.personaServices.insert(new Persona("Alvaro Farid", "Rodriguez", "2021-04-13", "Algeciras", "Huila", "Civico",LeaderTypeEnum.CIVICO,true));
                this.personaServices.insert(new Persona("Luis Octavio", "Gutierrez Montes", "2021-04-14", "Caucasia", "Antioquia", "Civico",LeaderTypeEnum.CIVICO,true));
                this.personaServices.insert(new Persona("Francisco", "Giacometto Gomez", "2021-04-17", "Santa Marta", "Magdalena", "Civico",LeaderTypeEnum.CIVICO,true));
                this.personaServices.insert(new Persona("Yovani", "Laguna", "2021-05-01", "San Miguel", "Putumayo", "Civico",LeaderTypeEnum.CIVICO,true));
                this.personaServices.insert(new Persona("Juan David", "García Naranjo", "2021-05-02", "San Luís", "Antioquia", "Civico",LeaderTypeEnum.CIVICO,true));
                this.personaServices.insert(new Persona("Cecilia", "Valderrama", "2021-05-11", "Chaparral", "Tolima", "Civico",LeaderTypeEnum.CIVICO,true));
                this.personaServices.insert(new Persona("Armando", "Alvarez", "2021-05-24", "Cali", "Valle del Cauca", "Civico",LeaderTypeEnum.CIVICO,true));
                personasTable.setItems((ObservableList<Persona>) this.personaServices.getAll());
            } catch (Exception exception) {
                exception.printStackTrace();
            }

            Hyperlink hyperlink = new Hyperlink();
            BackgroundFill background_fill = new BackgroundFill(Color.PINK,
                    CornerRadii.EMPTY, Insets.EMPTY);

            // create Background
            Background background = new Background(background_fill);
            hyperlink.setBackground(background);
            Scene hyp = new Scene(hyperlink,200,200);

            Label label = new Label("Funcionalidad lider Cívico: \n" +
                    "\n"+
                    "Es la imagen del cambio social, se enfoca en resolver las problematicas sociales.  ");
            try {
                url = new URI("https://www.eltiempo.com/justicia/delitos/detalles-del-homicidio-de-ricardo-cortes-rozo-exalcalde-de-sesquile-en-bogota-558584 ");
            } catch (URISyntaxException ex) {}

            hyperlink.setText("https://www.eltiempo.com/justicia/delitos/detalles-del-homicidio-de-ricardo-cortes-rozo-exalcalde-de-sesquile-en-bogota-558584 ");
            hyperlink.setOnAction(new EventHandler<ActionEvent>() {


                @Override
                public void handle(ActionEvent e) {
                    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() :null;
                    if ( desktop != null && desktop.isSupported(Desktop.Action.BROWSE) ) {
                        try {
                            desktop.browse(url);
                        } catch ( Exception ex ) {
                            System.err.println( ex.getMessage() );
                        }
                    }
                }
            });
            label.setMaxWidth(100000);
            label.setPadding(new Insets(0,0,20,0));
            label.setAlignment(Pos.CENTER_LEFT);
            label.setFont(new Font(20));

            Image image = new Image("/image/sindical.png");
            ImageView imageView = new ImageView(image);
            BorderPane layout = new BorderPane();
            layout.getChildren().add(imageView);
            reportLayout.getChildren().add(layout);

            reportStage.setScene(hyp);
            reportLayout.getChildren().add(hyperlink);
            reportLayout.getChildren().add(label);
            reportStage.setTitle("Civico");
            reportStage.setScene(reportScene);
            reportStage.show();
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
        hBox.getChildren().addAll(nameInput, lastNameInput, deathDateInput, municipalityInput, departmentInput, typesOfLeaderInput, addPersona, deletePersona, openReport ,updatePersona);

        //Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(personasTable, hBox);

        BorderPane layout2 = new BorderPane();
        layout2.setTop(menuBar);
        layout2.setCenter(layout);


        BackgroundFill background_fill = new BackgroundFill(Color.LIGHTGREY,
                CornerRadii.EMPTY, Insets.EMPTY);
        BackgroundFill background_fill1 = new BackgroundFill(Color.ALICEBLUE,
                CornerRadii.EMPTY, Insets.EMPTY);

        // create Background
        Background background = new Background(background_fill);
        Background background1 = new Background(background_fill1);
        // set background
        hBox.setBackground(background);
        layout.setBackground(background1);


        //Scene
        //scene = new Scene(layout, 770, 300);
        scene = new Scene(layout2, 400, 400);
    }

    private void setUpCrud() {
        addPersona = new Button("Add");
        addPersona.setMinWidth(30);

        deletePersona = new Button("Delete");
        deletePersona.setMinWidth(30);

        updatePersona = new Button("UpdatePersona");
        updatePersona.setMinWidth(30);

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

        //PRIMER MENU

        Menu fileMenu = new Menu("File");
        fileMenuItems = new HashMap<>();
        fileMenuItems.put("Import", new MenuItem("Import"));
        fileMenuItems.put("Export", new MenuItem("Export"));
        fileMenuItems.put("¿Que son los lideres sociales?", new MenuItem("¿Que son los lideres sociales?"));
        fileMenuItems.put("Campesino", new MenuItem("Campesino"));
        fileMenuItems.put("Ambientalista", new MenuItem("Ambientalista"));
        fileMenuItems.put("Afrodescendiente", new MenuItem("Afrodescendiente"));
        fileMenuItems.put("Comunal", new MenuItem("Comunal"));
        fileMenuItems.put("Indigena", new MenuItem("Indigena"));
        fileMenuItems.put("LGTBIQ", new MenuItem("LGTBIQ"));
        fileMenuItems.put("Sindical", new MenuItem("Sindical"));
        fileMenuItems.put("Civico", new MenuItem("Civico"));

        fileMenu.getItems().add(fileMenuItems.get("Import"));
        fileMenu.getItems().add(fileMenuItems.get("Export"));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(fileMenuItems.get("¿Que son los lideres sociales?"));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(fileMenuItems.get("Campesino"));
        fileMenu.getItems().add(fileMenuItems.get("Ambientalista"));
        fileMenu.getItems().add(fileMenuItems.get("Afrodescendiente"));
        fileMenu.getItems().add(fileMenuItems.get("Comunal"));
        fileMenu.getItems().add(fileMenuItems.get("Indigena"));
        fileMenu.getItems().add(fileMenuItems.get("LGTBIQ"));
        fileMenu.getItems().add(fileMenuItems.get("Sindical"));
        fileMenu.getItems().add(fileMenuItems.get("Civico"));

        menuBar = new MenuBar();
        menuBar.getMenus().add(fileMenu);

        // SEGUNDO MENU


    }

    public static void main(String[] args) {
        launch(args);
    }
}