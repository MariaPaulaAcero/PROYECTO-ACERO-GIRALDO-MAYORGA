package sample.logic.services;

import sample.logic.entities.Persona;

import java.io.File;
import java.util.List;

public interface IPersonaServices {
    List<Persona> getAll();

    Persona insert(Persona persona);
    void delete(List<Persona> personas);

    Persona update(Persona persona, Persona persona2);

    void export() throws Exception;

    Persona getAllVictims(Persona persona);

    List<Persona> importPersonas(File file) throws Exception;
}
