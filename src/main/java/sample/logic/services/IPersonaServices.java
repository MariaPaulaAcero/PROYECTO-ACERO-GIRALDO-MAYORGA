package sample.logic.services;

import sample.logic.entities.Persona;

import java.io.File;
import java.util.List;

public interface IPersonaServices {
    List<Persona> getAll();

    Persona insert(Persona persona);

    void delete(List<Persona> personas);

    void export() throws Exception;

    List<Persona> importPersonas(File file) throws Exception;
}
