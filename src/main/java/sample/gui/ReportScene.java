package sample.gui;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToolBar;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.logic.entities.LeaderTypeEnum;
import sample.logic.entities.Persona;
import sample.logic.entities.Report;
import sample.logic.services.IPersonaServices;
import sample.logic.services.IReportServices;
import sample.logic.services.impl.PersonaServices;
import sample.logic.services.impl.ReportServices;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

public class ReportScene {
    //Vbox
    private VBox summaryLayout = new VBox();

    //Hbox
    private HBox hBox1;

    //VisualProperties
    private Scene scene;

    private Stage stage;

    //URL
    private URI url;

    private javafx.scene.control.Label label;
    private javafx.scene.control.Label label1;
    private javafx.scene.control.Label label2;
    private javafx.scene.control.Label label3;
    private javafx.scene.control.Label label4;
    private javafx.scene.control.Label label5;
    private javafx.scene.control.Label label6;
    private javafx.scene.control.Label label7;
    private javafx.scene.control.Label label8;
    private javafx.scene.control.Label label9;
    private javafx.scene.control.Label totalVictim;



    private javafx.scene.control.Label leaderVictimsCampesinoNumber;
    private javafx.scene.control.Label leaderVictimsAfrodescendientesNumber;
    private javafx.scene.control.Label leaderVictimsAmbientalistaNumber;
    private javafx.scene.control.Label leaderVictimsSindicalNumber;
    private javafx.scene.control.Label leaderVictimsCivicoNumber;
    private javafx.scene.control.Label leaderVictimsComunalNumber;
    private javafx.scene.control.Label leaderVictimsIndigenaNumber;
    private javafx.scene.control.Label leaderVictimsLGTBIQNumber;
    private javafx.scene.control.Label leaderVictimsToralNumber;


    //Logic Properties
    private IPersonaServices personaServices;

    public ReportScene() {
        stage = new Stage();

        try {
            behaviour(stage);
            setUp();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        stage.setTitle("Report");
        stage.setScene(scene);
        stage.show();

    }

    private void behaviour(Stage stage) throws IOException, ClassNotFoundException {

        personaServices = Main.personaServices;

    }

    private void setUpLabels() {

        label = new javafx.scene.control.Label("LIDERES VICTIMAS DE LA VIOLENCIA EN COLOMBIA");
        label.setMinWidth(650);
        label.setPadding(new Insets(50, 0, 0, 250));
        label.setAlignment(Pos.CENTER);
        label.setFont(new Font(30));


        label1 = new javafx.scene.control.Label("Lideres Campesinos");
        label1.setMinWidth(350);
        label1.setPadding(new Insets(0, 0, 0, 20));
        label1.setAlignment(Pos.CENTER_LEFT);
        label1.setFont(new Font(15));

        label2 = new javafx.scene.control.Label("Lideres Ambientalistas");
        label2.setMinWidth(350);
        label2.setPadding(new Insets(0, 0, 0, 20));
        label2.setAlignment(Pos.CENTER_LEFT);
        label2.setFont(new Font(15));


        label3 = new javafx.scene.control.Label("Lideres Afrodescendientes");
        //label3.setMinWidth(350);
        label3.setPadding(new Insets(5, 0, 0, 20));
        label3.setAlignment(Pos.CENTER_LEFT);
        label3.setFont(new Font(15));

        label5 = new javafx.scene.control.Label("Lideres Sindicales");
        //label5.setMaxWidth(10000);
        label5.setPadding(new Insets(5, 0, 0, 20));
        label5.setAlignment(Pos.CENTER_LEFT);
        label5.setFont(new Font(15));


        label6 = new javafx.scene.control.Label("Lideres Civicos");
        //label6.setMaxWidth(10000);
        label6.setPadding(new Insets(5, 0, 0, 20));
        label6.setAlignment(Pos.CENTER_LEFT);
        label6.setFont(new Font(15));

        label7 = new javafx.scene.control.Label("Lideres Comunales");
        //label7.setMaxWidth(10000);
        label7.setPadding(new Insets(5, 0, 0, 20));
        label7.setAlignment(Pos.CENTER_LEFT);
        label7.setFont(new Font(15));

        label8 = new javafx.scene.control.Label("Lideres Indigenas");
        //label8.setMaxWidth(10000);
        label8.setPadding(new Insets(5, 0, 0, 20));
        label8.setAlignment(Pos.CENTER_LEFT);
        label8.setFont(new Font(15));

        label9 = new javafx.scene.control.Label("Lideres LGTBIQ");
        //label9.setMaxWidth(10000);
        label9.setPadding(new Insets(5, 0, 0, 20));
        label9.setAlignment(Pos.CENTER_LEFT);
        label9.setFont(new Font(15));

        totalVictim = new javafx.scene.control.Label("Victimas Totales");
       // totalVictim.setMaxWidth(10000);
        totalVictim.setPadding(new Insets(5, 0, 0, 20));
        totalVictim.setAlignment(Pos.CENTER_LEFT);
        totalVictim.setFont(new Font(15));

        //InfoLabelsNumbers

        leaderVictimsToralNumber = new javafx.scene.control.Label();
        //leaderVictimsToralNumber.setMinWidth(650);
        //leaderVictimsToralNumber.setPadding(new Insets(-1160, -400, 0, 0));
        leaderVictimsToralNumber.setAlignment(Pos.CENTER_RIGHT);
        leaderVictimsToralNumber.setFont(new Font(35));

        leaderVictimsCampesinoNumber = new javafx.scene.control.Label();
        //leaderVictimsCampesinoNumber.setMinWidth(650);
        //leaderVictimsCampesinoNumber.setPadding(new Insets(-1000, -400, 0, 0));
        leaderVictimsCampesinoNumber.setAlignment(Pos.CENTER_RIGHT);
        leaderVictimsCampesinoNumber.setFont(new Font(40));

        leaderVictimsAfrodescendientesNumber = new javafx.scene.control.Label();
        //leaderVictimsAfrodescendientesNumber.setMinWidth(650);
        //leaderVictimsAfrodescendientesNumber.setPadding(new Insets(0, 0, 0, 0));
        leaderVictimsAfrodescendientesNumber.setAlignment(Pos.CENTER_RIGHT);
        leaderVictimsAfrodescendientesNumber.setFont(new Font(40));

        leaderVictimsSindicalNumber = new javafx.scene.control.Label();
        //leaderVictimsSindicalNumber.setMinWidth(650);
        //leaderVictimsSindicalNumber.setPadding(new Insets(0, 0, 0, 0));
        leaderVictimsSindicalNumber.setAlignment(Pos.CENTER_RIGHT);
        leaderVictimsSindicalNumber.setFont(new Font(35));

        leaderVictimsCivicoNumber = new javafx.scene.control.Label();
        //leaderVictimsCivicoNumber.setMinWidth(650);
        leaderVictimsCivicoNumber.setPadding(new Insets(0, 0, 0, 70));
        leaderVictimsCivicoNumber.setAlignment(Pos.CENTER_RIGHT);
        leaderVictimsCivicoNumber.setFont(new Font(35));

        leaderVictimsComunalNumber = new javafx.scene.control.Label();
        //leaderVictimsComunalNumber.setMinWidth(650);
        leaderVictimsComunalNumber.setPadding(new Insets(0, 0, 0, 70));
        leaderVictimsComunalNumber.setAlignment(Pos.CENTER_RIGHT);
        leaderVictimsComunalNumber.setFont(new Font(35));

        leaderVictimsIndigenaNumber = new javafx.scene.control.Label();
        //leaderVictimsIndigenaNumber.setMinWidth(650);
        //leaderVictimsIndigenaNumber.setPadding(new Insets(0, 0, 0, 0));
        leaderVictimsIndigenaNumber.setAlignment(Pos.CENTER_RIGHT);
        leaderVictimsIndigenaNumber.setFont(new Font(35));

        leaderVictimsLGTBIQNumber = new javafx.scene.control.Label();
        //leaderVictimsLGTBIQNumber.setMinWidth(650);
        leaderVictimsLGTBIQNumber.setPadding(new Insets(0, 0, 0, 70));
        leaderVictimsLGTBIQNumber.setAlignment(Pos.CENTER_RIGHT);
        leaderVictimsLGTBIQNumber.setFont(new Font(35));

        leaderVictimsAmbientalistaNumber = new javafx.scene.control.Label();
        leaderVictimsAmbientalistaNumber.setMinWidth(650);
        leaderVictimsAmbientalistaNumber.setPadding(new Insets(0, 0, 0, 70));
        leaderVictimsAmbientalistaNumber.setAlignment(Pos.CENTER_RIGHT);
        leaderVictimsAmbientalistaNumber.setFont(new Font(35));
    }

    private void setUp() {

        setUpLabels();

        HBox f = new HBox();
        f.setAlignment(Pos.CENTER_LEFT);
        f.setPadding(new Insets(20, 0, 0, 80));
        f.getChildren().addAll(label);

        HBox f1 = new HBox();
        f1.setAlignment(Pos.CENTER_LEFT);
        f1.setPadding(new Insets(20, 0, 0, 80));
        f1.getChildren().addAll(label1,label2,label3);

        HBox f2 = new HBox();
        f2.setAlignment(Pos.BOTTOM_CENTER);
        f2.setPadding(new Insets(20, 0, 0, 80));
        f2.getChildren().addAll(label5,label6,label7);

        HBox f3 = new HBox();
        f3.setAlignment(Pos.BOTTOM_RIGHT);
        f3.setPadding(new Insets(20, 0, 0, 0));
        f3.getChildren().addAll(label8,label9);

        HBox f4 = new HBox();
        f4.setAlignment(Pos.BOTTOM_CENTER);
        f4.setPadding(new Insets(20, 0, 0, 0));
        f4.getChildren().addAll(leaderVictimsCampesinoNumber,leaderVictimsAmbientalistaNumber,leaderVictimsAfrodescendientesNumber,leaderVictimsSindicalNumber,leaderVictimsCivicoNumber,leaderVictimsComunalNumber,leaderVictimsIndigenaNumber,leaderVictimsLGTBIQNumber);


        VBox reportLayout = new VBox();
        reportLayout.getChildren().addAll(f, f1,f2,f3);

        Image image = new Image("/image/reporte.png");
        ImageView imageView = new ImageView(image);

        BorderPane layout = new BorderPane();
        layout.getChildren().add(imageView);
        reportLayout.getChildren().add(layout);


        Hyperlink hyperlink = new Hyperlink();
        Scene hyp = new Scene(hyperlink,200,200);

        try {
            url = new URI("https://n9.cl/42gor");
        } catch (URISyntaxException ex) {}

        javafx.scene.control.Label label = new Label("");

        hyperlink.setText(" https://n9.cl/42gor");
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

        stage.setScene(hyp);
        reportLayout.getChildren().add(hyperlink);

        reportLayout.getChildren().addAll(label, label1, label2, label3, label5,label6,label7,label8,label9, leaderVictimsCampesinoNumber,leaderVictimsAfrodescendientesNumber,leaderVictimsAmbientalistaNumber,
                leaderVictimsCivicoNumber,leaderVictimsComunalNumber,leaderVictimsSindicalNumber,leaderVictimsToralNumber,
                leaderVictimsLGTBIQNumber,leaderVictimsIndigenaNumber);



        scene = new Scene(reportLayout, 200, 200);

    }



/*
    private void setUplayout() {
        setUpLabels();

        layout2 = new VBox();
        infoLayout = new VBox();
        layout3 = new VBox();
        layout3.getChildren().addAll(personasTable);

        selectPersona.setMinWidth(550);
        selectPersona.setAlignment(Pos.BOTTOM_CENTER);

        VBox h1 = new VBox();
        h1.getChildren().addAll(isVictimChoice,isVictim);
        VBox h3 = new VBox();
        h3.getChildren().addAll(aggressionChoice,aggression);

        hBox3 = new HBox();
        hBox3.getChildren().addAll(h1,h3);
        hBox3.setSpacing(12);

        crudVBox= new VBox();
        crudVBox.getChildren().addAll(hBox1);

        infoLayout.getChildren().addAll(ageInfo,sideInfo,victimInfo,aggressionInfo,selectPersona);
        layout2.getChildren().addAll(nameTitle,infoLayout,crudVBox);

        //Summary menu layout

        HBox f = new HBox();
        f.setPadding(new Insets(20,0,0,80));
        f.getChildren().addAll(totalVictimsNumber,totalVictim);

        HBox f1 = new HBox();
        f1.setPadding(new Insets(80,0,0,80));
        f1.getChildren().addAll(le,totalPoliceVictims,pViolenciaConArmasNumber,pViolenciaConArmas,pViolenciaHomicidaNumber,pViolenciaHomicida,pViolenciaSexualNumber,pViolenciaSexual);

        HBox f2 = new HBox();
        f2.setPadding(new Insets(80,0,0,80));
        f2.getChildren().addAll(totalCiviliansVictimsNumber,totalCiviliansVictims,mViolenciaConArmasNumber,mViolenciaConArmas,mViolenciaHomicidaNumber,mViolenciaHomicida,mViolenciaSexualNumber,mViolenciaSexual);

        summaryLayout.getChildren().addAll(f,f1,f2);
    }*/


}


 /*
    // Visual Properties
    private Stage reportStage;
    private Label label;
    private Scene scene;
    //ERROR private TableView reportTable;
    private TableView<Report> reportTable;

    // Logic properties
    private ReportServices reportServices;
    private IReportServices reportServices1;
    private PersonaServices personaServices;

    private Label leaderVictimsCampesinoNumber;
    private Label leaderVictimsAfrodescendientesNumber;
    private Label leaderVictimsAmbientalistaNumber;
    private Label leaderVictimsSindicalNumber;
    private Label leaderVictimsCivicoNumber;
    private Label leaderVictimsComunalNumber;
    private Label leaderVictimsIndigenaNumber;
    private Label leaderVictimsLGTBIQNumber;
    private Label leaderVictimsToralNumber;

    public ReportScene() {
        Stage stage = new Stage();

        setUp();
        behavior(stage);

        stage.setTitle("Report");
        stage.setScene(scene);
        stage.show();

    }

    private void setUp() {
        setupLabels();

        VBox reportLayout = new VBox();
        reportLayout.getChildren().addAll(label, label1, label2, label3, label4, label5,
                label6, leaderVictimsCampesinoNumber,leaderVictimsAfrodescendientesNumbe,leaderVictimsAmbientalistaNumber,
                leaderVictimsCivicoNumber,leaderVictimsComunalNumber,leaderVictimsSindicalNumber,leaderVictimsToralNumber,
                leaderVictimsLGTBIQNumber,leaderVictimsIndigenaNumber);

        scene = new Scene(reportLayout, 200, 200);
    }

    private void setupLabels() {

        //InfoLabels
        javafx.scene.control.Label label = new javafx.scene.control.Label("Lideres victimas \n" +
                "de la violencia");
        label.setMaxWidth(10000);
        label.setPadding(new Insets(0, 0, 0, 0));
        label.setAlignment(Pos.TOP_CENTER);
        label.setFont(new Font(40));


        javafx.scene.control.Label label1 = new javafx.scene.control.Label("Victimas de los\n" +
                " lideres Campesinos");
        label1.setMaxWidth(10000);
        label1.setPadding(new Insets(-40, 0, 10, 100));
        label1.setAlignment(Pos.CENTER_LEFT);
        label1.setFont(new Font(25));


        javafx.scene.control.Label label2 = new javafx.scene.control.Label("Victimas de los lideres\n " +
                "Afrodescendientes");
        label2.setMaxWidth(10000);
        label2.setPadding(new Insets(-60, 0, 0, 0));
        label2.setAlignment(Pos.CENTER);
        label2.setFont(new Font(25));

        javafx.scene.control.Label label3 = new javafx.scene.control.Label("Victimas de los\n " +
                " lideres Ambientalista");
        label3.setMaxWidth(10000);
        label3.setPadding(new Insets(-90, 80, 0, 0));
        label3.setAlignment(Pos.CENTER_RIGHT);
        label3.setFont(new Font(25));


        javafx.scene.control.Label label4 = new javafx.scene.control.Label("Victimas de los\n" +
                " lideres Comunal");
        label4.setMaxWidth(10000);
        label4.setPadding(new Insets(300, 0, 0, 100));
        label4.setAlignment(Pos.BOTTOM_LEFT);
        label4.setFont(new Font(25));

        javafx.scene.control.Label label5 = new javafx.scene.control.Label("Victimas de los\n " +
                "lideres Indigena");
        label5.setMaxWidth(10000);
        label5.setPadding(new Insets(-300, 0, 0, 0));
        label5.setAlignment(Pos.BOTTOM_CENTER);
        label5.setFont(new Font(25));

        javafx.scene.control.Label label6 = new javafx.scene.control.Label("Victimas de los \n" +
                "lideres LGTBIQ");
        label6.setMaxWidth(10000);
        label6.setPadding(new Insets(-220, 100, 0, 0));
        label6.setAlignment(Pos.BOTTOM_RIGHT);
        label6.setFont(new Font(25));

        //.........


        javafx.scene.control.Label leaderVictimsToralNumber = new javafx.scene.control.Label("1");
        leaderVictimsToralNumber.setMinWidth(650);
        leaderVictimsToralNumber.setPadding(new Insets(0,0,0,0));
        leaderVictimsToralNumber.setAlignment(Pos.CENTER_LEFT);
        leaderVictimsToralNumber.setFont(new Font(30));

        javafx.scene.control.Label leaderVictimsCampesinoNumber = new javafx.scene.control.Label("2");
        leaderVictimsCampesinoNumber.setMinWidth(650);
        leaderVictimsCampesinoNumber.setPadding(new Insets(0,0,0,0));
        leaderVictimsCampesinoNumber.setAlignment(Pos.CENTER_LEFT);
        leaderVictimsCampesinoNumber.setFont(new Font(30));

        javafx.scene.control.Label leaderVictimsAfrodescendientesNumbe = new javafx.scene.control.Label("3");
        leaderVictimsAfrodescendientesNumbe.setMinWidth(650);
        leaderVictimsAfrodescendientesNumbe.setPadding(new Insets(0,0,0,0));
        leaderVictimsAfrodescendientesNumbe.setAlignment(Pos.CENTER_RIGHT);
        leaderVictimsAfrodescendientesNumbe.setFont(new Font(30));

        javafx.scene.control.Label leaderVictimsSindicalNumber = new javafx.scene.control.Label("4");
        leaderVictimsSindicalNumber.setMinWidth(650);
        leaderVictimsSindicalNumber.setPadding(new Insets(0,0,0,0));
        leaderVictimsSindicalNumber.setAlignment(Pos.BOTTOM_LEFT);
        leaderVictimsSindicalNumber.setFont(new Font(30));

        javafx.scene.control.Label leaderVictimsCivicoNumber = new javafx.scene.control.Label("5");
        leaderVictimsCivicoNumber.setMinWidth(650);
        leaderVictimsCivicoNumber.setPadding(new Insets(0,0,0,0));
        leaderVictimsCivicoNumber.setAlignment(Pos.BOTTOM_CENTER);
        leaderVictimsCivicoNumber.setFont(new Font(30));

        javafx.scene.control.Label leaderVictimsComunalNumber = new javafx.scene.control.Label("6");
        leaderVictimsComunalNumber.setMinWidth(650);
        leaderVictimsComunalNumber.setPadding(new Insets(0,0,0,0));
        leaderVictimsComunalNumber.setAlignment(Pos.BOTTOM_RIGHT);
        leaderVictimsComunalNumber.setFont(new Font(30));

        javafx.scene.control.Label leaderVictimsIndigenaNumber = new javafx.scene.control.Label("7");
        leaderVictimsIndigenaNumber.setMinWidth(650);
        leaderVictimsIndigenaNumber.setPadding(new Insets(0,0,0,0));
        leaderVictimsIndigenaNumber.setAlignment(Pos.CENTER);
        leaderVictimsIndigenaNumber.setFont(new Font(30));

        javafx.scene.control.Label leaderVictimsLGTBIQNumber = new javafx.scene.control.Label("8");
        leaderVictimsLGTBIQNumber.setMinWidth(650);
        leaderVictimsLGTBIQNumber.setPadding(new Insets(0,0,0,0));
        leaderVictimsLGTBIQNumber.setAlignment(Pos.TOP_LEFT);
        leaderVictimsLGTBIQNumber.setFont(new Font(30));

        javafx.scene.control.Label leaderVictimsAmbientalistaNumber = new javafx.scene.control.Label("9");
        leaderVictimsAmbientalistaNumber.setMinWidth(650);
        leaderVictimsAmbientalistaNumber.setPadding(new Insets(0,0,0,0));
        leaderVictimsAmbientalistaNumber.setAlignment(Pos.TOP_RIGHT);
        leaderVictimsAmbientalistaNumber.setFont(new Font(30));

    }

        /*

        reportLayout.getChildren().addAll(label, label1, label2, label3, label4, label5,
                label6, leaderVictimsCampesinoNumber,leaderVictimsAfrodescendientesNumbe,leaderVictimsAmbientalistaNumber,
                leaderVictimsCivicoNumber,leaderVictimsComunalNumber,leaderVictimsSindicalNumber,leaderVictimsToralNumber,
                leaderVictimsLGTBIQNumber,leaderVictimsIndigenaNumber);

        leaderVictimsToralNumber.setText(String.valueOf(personaServices.getVictims().size()));
        leaderVictimsCampesinoNumber.setText(String.valueOf(personaServices.getCampesino().size()));
        leaderVictimsAmbientalistaNumber.setText(String.valueOf(personaServices.getAmbientalista().size()));
        leaderVictimsAfrodescendientesNumber.setText(String.valueOf(personaServices.getAfrodescendiente().size()));
        leaderVictimsSindicalNumber.setText(String.valueOf(personaServices.getSindical().size()));
        leaderVictimsCivicoNumber.setText(String.valueOf(personaServices.getCivico().size()));
        leaderVictimsComunalNumber.setText(String.valueOf(personaServices.getComunal().size()));
        leaderVictimsIndigenaNumber.setText(String.valueOf(personaServices.getIndigena().size()));
        leaderVictimsLGTBIQNumber.setText(String.valueOf(personaServices.getLgtbiq().size()));

/*
    private void behavior(Stage stage) {
        EventHandler<ActionEvent> eventHandler = e -> {
            boolean victim = false;
            Enum leaderTypeEnum = LeaderTypeEnum.NO_APLICA;

            if (leaderTypeEnum.equals(LeaderTypeEnum.CAMPESINO))
                victim = true;
            if (leaderTypeEnum.equals(LeaderTypeEnum.AMBIENTALISTA))
                victim = true;
            if (leaderTypeEnum.equals(LeaderTypeEnum.AFRODESCENDIENTES))
                victim = true;
            if (leaderTypeEnum.equals(LeaderTypeEnum.SINDICAL))
                victim = true;
            if (leaderTypeEnum.equals(LeaderTypeEnum.CIVICO))
                victim = true;
            if (leaderTypeEnum.equals(LeaderTypeEnum.COMUNAL))
                victim = true;
            if (leaderTypeEnum.equals(LeaderTypeEnum.INDIGENA))
                victim = true;
            if (leaderTypeEnum.equals(LeaderTypeEnum.LGTBIQ))
                victim = true;

        };
/*
        VBox h1 = new VBox();
        h1.getChildren().addAll(isVictimChoice, isVictim);

        VBox h3 = new VBox();
        h3.getChildren().addAll(aggressionChoice, aggression);

        hBox3 = new HBox();
        hBox3.getChildren().addAll(h1,h3);
        hBox3.setSpacing(12);

        crudVBox = new VBox();
        crudVBox.getChildren().addAll(hBox2, hBox3, hBox1);

        infoLayout.getChildren().addAll(ageInfo, sideInfo, victimInfo, aggressionInfo, selectPersona);
        layout2.getChildren().addAll(nameTitle, infoLayout, crudVBox);

        //Summary menu layout

        HBox f = new HBox();
        f.setPadding(new Insets(20, 0, 0, 80));
        f.getChildren().addAll(leaderVictimsToralNumber, totalVictim);

        HBox f2 = new HBox();
        f2.setPadding(new Insets(80, 0, 0, 80));
        f2.getChildren().addAll(leaderVictimsCampesinoNumber,leaderVictimsAfrodescendientesNumber, leaderVictimsAmbientalistaNumber, leaderVictimsSindicalNumber,leaderVictimsIndigenaNumber,leaderVictimsComunalNumber,leaderVictimsCivicoNumber,leaderVictimsLGTBIQNumber,leaderVictimsToralNumber);

        summaryLayout.getChildren().addAll(f,f2);


    }

    private void setUpTableReport() {
    }
}


*/
