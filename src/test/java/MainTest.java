import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import sample.PersonaException;
import sample.gui.Main;
import sample.logic.entities.Exportable;
import sample.logic.entities.LeaderTypeEnum;
import sample.logic.entities.Persona;
import sample.logic.services.impl.PersonaServices;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainTest {
    static PersonaServices personaServices;
    static Persona persona;
    static Persona personat;
    static Persona persona1;
    static Persona persona2;
    static Persona persona3;
    static Persona persona4;
    static Persona persona5;
    static Persona persona6;
    static Persona persona7;
    static Persona persona8;
    static Persona persona9;
    static Persona persona10;
    static Persona persona11;
    static Persona persona12;
    static Persona persona13;
    static Persona persona14;
    static Persona persona15;
    static Persona persona16;

    static List<Persona> personas;
    static List<Persona> personasCampesinos;
    static List<Persona> personasAmbientales;
    static List<Persona> personasAfrodescendientes;
    static List<Persona> personasSindicales;
    static List<Persona> personasCivicos;
    static List<Persona> personasComunales;
    static List<Persona> personasIndigenas;
    static List<Persona> personasLgtbiq;
    static List<Exportable> exportable;
    static Character CSV;
    static File file= new File("export-2021-JUNE-4-csv");
    static List<Persona> personasImported;


    @BeforeAll
    static void setUp() throws IOException, ClassNotFoundException, PersonaException {
        personaServices = new PersonaServices();
        try {
            persona=new Persona("Edwin", "Antonio Indaburo", "2021-01-07", "Nechi", "Antoquia","Campesino", LeaderTypeEnum.CAMPESINO,true);
            persona1=new Persona("Fredman", "Herazo Padilla", "2021-01-15", "La Apartada", "Córdoba", "Afrodescendiente",LeaderTypeEnum.AFRODESCENDIENTES,true);
            persona2=new Persona("Gonzalo ", "Cardona Molina", "2021-01-11", "Tulua", "Valle del Cauca", "Ambientalista",LeaderTypeEnum.AMBIENTALISTA,true);
            persona3=new Persona("Gerardo", "Leon", "2021-01-01","Puerto Gaitan","Meta","Sindical", LeaderTypeEnum.SINDICAL,true);
            persona4=new Persona("Armando", "Alvarez", "2021-05-24", "Cali", "Valle del Cauca", "Civico",LeaderTypeEnum.CIVICO,true);
            persona5=new Persona("Geovanny", "Cabezas Cruz", "2021-05-15", "Jamundí", "Valle del Cauca", "Indigena",LeaderTypeEnum.INDIGENA,true);
            persona6=new Persona("Robinson", "Quino Bonilla", "2021-01-15","Yondo","Antoquia","Comunal", LeaderTypeEnum.COMUNAL,true);
            persona7=new Persona("Andres", "Moreno", "2021-04-10","Mosquera","Cauca","LGTBIQ", LeaderTypeEnum.LGTBIQ,true);

            persona9=new Persona("Albeiro", "Hoyos", "2021-04-05","Anorí","Antioquia","Campesino", LeaderTypeEnum.CAMPESINO,true);
            persona10=new Persona("Gonzalo ", "Cardona Molina", "2021-01-11", "Tulua", "Valle del Cauca", "Ambientalista",LeaderTypeEnum.AMBIENTALISTA,true);
            persona11=new Persona("Margarito", "Salas", "2021-04-10","Nuquí","Chocó","Afrodescendiente", LeaderTypeEnum.AFRODESCENDIENTES,true);
            persona12=new Persona("Diego", "Betancourt", "2021-01-01","Yopal","Casanare","Sindical", LeaderTypeEnum.SINDICAL,true);
            persona13=new Persona("Cecilia", "Valderrama", "2021-05-11", "Chaparral", "Tolima", "Civico",LeaderTypeEnum.CIVICO,true);
            persona14=new Persona("Yordan Eduardo", "Guetio","2021-02-02","Corinto","Cauca","Comunal", LeaderTypeEnum.COMUNAL,true);
            persona15=new Persona("Alejandro", "Manugama Cheche", "2021-02-17", "Bagado", "Choco", "Indigena",LeaderTypeEnum.INDIGENA,true);
            persona16=new Persona("Andres", "Moreno", "2021-04-10","Mosquera","Cauca","LGTBIQ", LeaderTypeEnum.LGTBIQ,true);

            personas = new ArrayList<>();
            personasCampesinos = new ArrayList<>();
            personasAmbientales = new ArrayList<>();
            personasAfrodescendientes = new ArrayList<>();
            personasSindicales = new ArrayList<>();
            personasCivicos = new ArrayList<>();
            personasComunales = new ArrayList<>();
            personasIndigenas = new ArrayList<>();
            personasLgtbiq = new ArrayList<>();

            personas.add(persona);
            personas.add(persona1);
            personas.add(persona2);
            personas.add(persona3);
            personas.add(persona4);
            personas.add(persona5);
            personas.add(persona6);
            personas.add(persona7);
            personas.add(persona8);

            personasCampesinos.add(persona);
            personasCampesinos.add(persona9);
            personasAmbientales.add(persona1);
            personasAmbientales.add(persona10);
            personasAfrodescendientes.add(persona2);
            personasAfrodescendientes.add(persona11);
            personasSindicales.add(persona3);
            personasSindicales.add(persona12);
            personasCivicos.add(persona4);
            personasCivicos.add(persona13);
            personasComunales.add(persona5);
            personasComunales.add(persona14);
            personasIndigenas.add(persona6);
            personasIndigenas.add(persona15);
            personasLgtbiq.add(persona7);
            personasLgtbiq.add(persona16);

        } catch (PersonaException e) {
            e.printStackTrace();
        };

    }

    @Test
    void shouldAddVictim() throws ClassNotFoundException, IOException, PersonaException {

        personaServices.insert(persona);
        Assertions.assertTrue(personaServices.getAll().contains(persona));
    }
    @Test
    void shouldDeleteVictim() throws ClassNotFoundException, IOException, PersonaException {
        personaServices.delete(Collections.singletonList(persona));
        Assertions.assertFalse(personaServices.getAll().contains(persona));
    }
    @Test
    void shouldUpdateVictim() throws ClassNotFoundException, IOException, PersonaException {

        Persona p = null;
        p = personaServices.update(persona,persona1);
        Assertions.assertFalse(personaServices.getAll().contains(p));

    }
    @Test
    void shouldAddCampesinoVictim() throws ClassNotFoundException, IOException, PersonaException {

        personaServices.insert(persona);
        Assertions.assertTrue(personaServices.getCampesino().contains(persona));
        //Assertions.assertFalse(personaServices.getCampesino().contains(persona));

    }
    @Test
    void shouldAddAfrodecendienteVictim() throws ClassNotFoundException, IOException, PersonaException {

        personaServices.insert(persona1);
        //Assertions.assertFalse(personaServices.getAfrodescendiente().contains(persona1));
        Assertions.assertTrue(personaServices.getAfrodescendiente().contains(persona1));
    }
    @Test
    void shouldAddAmbientalistaVictim() throws ClassNotFoundException, IOException, PersonaException {

        personaServices.insert(persona2);
        //Assertions.assertFalse(personaServices.getAmbientalista().contains(persona2));
        Assertions.assertTrue(personaServices.getAmbientalista().contains(persona2));
    }
    @Test
    void shouldAddSindicalVictim() throws ClassNotFoundException, IOException, PersonaException {

        personaServices.insert(persona3);
        //Assertions.assertFalse(personaServices.getSindical().contains(persona3));
        Assertions.assertTrue(personaServices.getSindical().contains(persona3));
    }
    @Test
    void shouldAddCivicoVictim() throws ClassNotFoundException, IOException, PersonaException {

        personaServices.insert(persona4);
        //Assertions.assertFalse(personaServices.getCivico().contains(persona4));
        Assertions.assertTrue(personaServices.getCivico().contains(persona4));
    }
    @Test
    void shouldAddIndigenaVictim() throws ClassNotFoundException, IOException, PersonaException {

        personaServices.insert(persona5);
        //Assertions.assertFalse(personaServices.getIndigena().contains(persona5));
        Assertions.assertTrue(personaServices.getIndigena().contains(persona5));
    }

    @Test
    void shouldAddComunalVictim() throws ClassNotFoundException, IOException, PersonaException {

        personaServices.insert(persona6);
        //Assertions.assertFalse(personaServices.getComunal().contains(persona6));
        Assertions.assertTrue(personaServices.getComunal().contains(persona6));
    }
    @Test
    void shouldAddLgtbiqVictim() throws ClassNotFoundException, IOException, PersonaException {
        personaServices.insert(persona7);
        //Assertions.assertFalse(personaServices.getLgtbiq().contains(persona7));
        Assertions.assertTrue(personaServices.getLgtbiq().contains(persona7));
    }


    @Test
    void shouldDeleteTotalVictims() throws ClassNotFoundException, IOException, PersonaException {
        personaServices.delete(personas);
        Assertions.assertFalse(personaServices.getCampesino().contains(persona1));
    }

    @Test
    void shouldDeletePersonasCampesinosVictims() throws ClassNotFoundException, IOException, PersonaException {

        personaServices.delete(personasCampesinos);
        Assertions.assertFalse(personaServices.getCampesino().contains(persona9));
    }

    @Test
    void shouldDeletePersonasAmbientalesVictims() throws ClassNotFoundException, IOException, PersonaException {
        personaServices.delete(personasCampesinos);
        Assertions.assertFalse(personaServices.getAmbientalista().contains(persona1));
    }
    @Test
    void shouldDeletePersonasAfrodescendientesVictims() throws ClassNotFoundException, IOException, PersonaException {
        personaServices.delete(personasAfrodescendientes);
        Assertions.assertFalse(personaServices.getAfrodescendiente().contains(persona2));
    }
    @Test
    void shouldDeletePersonasSindicalesVictim() throws ClassNotFoundException, IOException, PersonaException {
        personaServices.delete(personasSindicales);
        Assertions.assertFalse(personaServices.getSindical().contains(persona3));
    }
    @Test
    void shouldDeletePersonasCivicosVictims() throws ClassNotFoundException, IOException, PersonaException {
        personaServices.delete(personasCivicos);
        Assertions.assertFalse(personaServices.getCivico().contains(persona4));
    }
    @Test
    void shouldDeletePersonasComunalesVictim() throws ClassNotFoundException, IOException, PersonaException {
        personaServices.delete(personasComunales);
        Assertions.assertFalse(personaServices.getComunal().contains(persona5));
    }
    @Test
    void shouldDeletePersonasIndigenaVictim() throws ClassNotFoundException, IOException, PersonaException {
        personaServices.delete(personasIndigenas);
        Assertions.assertFalse(personaServices.getIndigena().contains(persona6));
    }
    @Test
    void shouldDeletePersonasLgtbiqVictim() throws ClassNotFoundException, IOException, PersonaException {
        personaServices.delete(personasLgtbiq);
        Assertions.assertFalse(personaServices.getLgtbiq().contains(persona7));
    }
    @Test
    void shouldExportPersonasFile() throws ClassNotFoundException, IOException, PersonaException {


    }
    @Test
    void shouldImportPersonasFile() throws ClassNotFoundException, IOException, PersonaException {
        try {
            personasImported = personaServices.importPersonas(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assertions.assertNotNull(personasImported);
    }

}
