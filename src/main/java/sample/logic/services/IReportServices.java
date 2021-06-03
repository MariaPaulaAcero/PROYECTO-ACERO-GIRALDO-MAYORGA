package sample.logic.services;

import sample.logic.entities.Persona;
import sample.logic.entities.Report;

import java.util.List;
import java.util.Map;

public interface IReportServices {
    List<Report> getReportPersonasByProfession();
    List<Report> getReportPersonasByProfession(List<Persona> personas);

    Report getCountOfVictims();

}
