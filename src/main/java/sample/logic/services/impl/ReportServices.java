package sample.logic.services.impl;


import javafx.beans.InvalidationListener;
import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import sample.gui.Main;
import sample.logic.entities.Persona;
import sample.logic.entities.LeaderTypeEnum;
import sample.logic.entities.Report;
import sample.logic.services.IPersonaServices;

import java.util.*;

public class ReportServices {

    private IPersonaServices personaServices;


    public ReportServices() {
        personaServices = Main.personaServices;
    }

    public List<Report> getReportPersonasByProfession() {

        List<Persona> personas = personaServices.getAll();
        //return getReportPersonasByProfession();
        return this.getReportPersonasByProfession(personas);//habia puesto personas
    }

    public List<Report> getReportPersonasByProfession(List<Persona> personas) {
        List<Report>reports = FXCollections.observableArrayList();
        reports.add(new Report());

        for (LeaderTypeEnum profession : LeaderTypeEnum.values()) {
            reports.add(new Report(profession.toString(), 0, String.format("Report of count of personas in profession %s", profession.toString())));
        }

        for (Persona p : personas) {
            //Objects.requireNonNull(reports.get(p.getTypesOfLeader().toString())).incrementCount();
            reports.add(getCountOfVictims());
        }

        return reports;

    }

    public Report getCountOfVictims() {

        List<Persona> personas = personaServices.getAll();
        int numOfVictims = (int) personas.stream().filter(Persona::isVictim).count();
        //int numOfVictims = (int) personas.stream().filter(p -> p.isVictim()).count();

        return new Report("Victims", numOfVictims, "This is the number of victims during the strikes");
    }

}