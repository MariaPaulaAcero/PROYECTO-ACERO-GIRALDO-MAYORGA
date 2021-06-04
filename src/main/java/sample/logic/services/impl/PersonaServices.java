package sample.logic.services.impl;

import javafx.collections.FXCollections;
import sample.logic.entities.Exportable;
import sample.logic.entities.LeaderTypeEnum;
import sample.logic.entities.Persona;
import sample.logic.persistence.IExport;
import sample.logic.persistence.IPersonaPersistence;
import sample.logic.persistence.impl.Export;
import sample.logic.persistence.impl.PersonaPersistence;
import sample.logic.services.IPersonaServices;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonaServices implements IPersonaServices {
    private List<Persona> personas;
    private List<Persona> campesino = new ArrayList<>();
    private List<Persona> ambientalista = new ArrayList<>();
    private List<Persona> afrodescendiente = new ArrayList<>();
    private List<Persona> sindical = new ArrayList<>();
    private List<Persona> civico = new ArrayList<>();
    private List<Persona> comunal = new ArrayList<>();
    private List<Persona> lgtbiq = new ArrayList<>();
    private List<Persona> indigena = new ArrayList<>();
    private List<Persona> victims = new ArrayList<Persona>();

    private IPersonaPersistence personaPersistence;
    private static IExport export = new Export();

    public PersonaServices() throws IOException, ClassNotFoundException {
        this.personas = FXCollections.observableArrayList();
        try {
            this.personaPersistence = new PersonaPersistence();
            this.export = new Export();
            this.personas.addAll(this.personaPersistence.read("lideres.colombia"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Persona> getAll() {
        return this.personas;
    }

    @Override
    public Persona insert(Persona persona) {
        personas.add(persona);
        getAllVictims(persona);
        try {
            personaPersistence.save(persona);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        return persona;
    }


    @Override
    public void delete(List<Persona> personasToDelete) {
        personasToDelete.forEach(this.personas::remove);
    }

    // método para importar y exportar
    @Override
    public void export() throws Exception {
        List<Exportable> e = new ArrayList<>();
        this.personas.stream().forEach(p -> e.add(p));
        this.export.export(e, Exportable.CSV);
    }

    @Override
    public Persona update(Persona persona, Persona persona2) {
        if (!this.personas.contains(persona2)){

            persona.setName(persona2.getName());
            persona.setLastName(persona2.getLastName());
            persona.setDeathDate(persona2.getDeathDate());
            persona.setMunicipality(persona2.getMunicipality());
            persona.setDepartment(persona2.getDepartment());
            persona.setTypesOfLeader(persona2.getTypesOfLeader());

        }
        return persona;
    }

    @Override
    public List<Persona> importPersonas(File file) throws Exception {
        List<Persona> importedPersonas = new ArrayList<>();
        List<String> read = this.personaPersistence.importPersonas(file);

        for (String line : read) {
            String[] tokens = line.split(Exportable.CSV.toString());
            Persona persona = new Persona(tokens[0], tokens[1], tokens[2],tokens[3],tokens[4],tokens[5],LeaderTypeEnum.CAMPESINO,true);
            importedPersonas.add(persona);
            this.insert(persona);
        }

        return importedPersonas;

        //return null;
    }

    @Override
    public Persona getAllVictims(Persona persona){
        if (persona.isVictim())
        {
            victims.add(persona);
            if (persona.getTypeOfLeader().equals(LeaderTypeEnum.CAMPESINO))
                campesino.add(persona);
            if (persona.getTypeOfLeader().equals(LeaderTypeEnum.AMBIENTALISTA))
                ambientalista.add(persona);
            if (persona.getTypeOfLeader().equals(LeaderTypeEnum.AFRODESCENDIENTES))
                afrodescendiente.add(persona);
            if (persona.getTypeOfLeader().equals(LeaderTypeEnum.SINDICAL))
                sindical.add(persona);
            if (persona.getTypeOfLeader().equals(LeaderTypeEnum.CIVICO))
                civico.add(persona);
            if (persona.getTypeOfLeader().equals(LeaderTypeEnum.COMUNAL))
                comunal.add(persona);
            if (persona.getTypeOfLeader().equals(LeaderTypeEnum.INDIGENA))
                indigena.add(persona);
            if (persona.getTypeOfLeader().equals(LeaderTypeEnum.LGTBIQ))
                lgtbiq.add(persona);
        }
        return persona;
    }

    public List<Persona> getPersonas() {
            return personas;
    }
    public List<Persona> getCampesino() {
        return campesino;
    }

    public List<Persona> getAmbientalista() {
        return ambientalista;
    }

    public List<Persona> getAfrodescendiente() {
        return afrodescendiente;
    }

    public List<Persona> getSindical() {
        return sindical;
    }

    public List<Persona> getCivico() {
        return civico;
    }

    public List<Persona> getComunal() {
        return comunal;
    }

    public List<Persona> getLgtbiq() {
        return lgtbiq;
    }

    public List<Persona> getIndigena() {
        return indigena;
    }

    public List<Persona> getVictims() {
        return victims;
    }
}

