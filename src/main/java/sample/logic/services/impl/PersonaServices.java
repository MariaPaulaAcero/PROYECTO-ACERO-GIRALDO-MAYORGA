package sample.logic.services.impl;

import javafx.collections.FXCollections;
import sample.logic.entities.Exportable;
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
    private IPersonaPersistence personaPersistence;
    private IPersonaServices personaServices;
    private IExport export;
    private List<Persona> personas;

    public PersonaServices() {
        this.personas = FXCollections.observableArrayList();
        try {
            this.personaPersistence = new PersonaPersistence();
            this.export = new Export();
            //this.personas.addAll(this.personaPersistence.read());
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
    public List<Persona> importPersonas(File file) throws Exception {
        return null;
    }
}

