package sample.logic.services.impl;


import javafx.beans.InvalidationListener;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableMap;
import sample.logic.entities.Persona;
import sample.logic.entities.LeaderTypeEnum;
import sample.logic.entities.Report;
import sample.logic.services.IPersonaServices;

import java.util.*;

public class ReportServices {

    private IPersonaServices personaServices1;
    private PersonaServices personaServices;

    public ReportServices() {
        personaServices = new PersonaServices();
    }

    public Map<String, Report> getReportPersonasByProfession() {

        List<Persona> personas = personaServices.getAll();
        return this.getReportPersonasByProfession(personas);//habia puesto personas
    }

    public Map<String, Report> getReportPersonasByProfession(List<Persona> personas) {

        Map<String, Report> reports = new ObservableMap<String, Report>() {
            @Override
            public void addListener(MapChangeListener<? super String, ? super Report> listener) {
            }

            @Override
            public void removeListener(MapChangeListener<? super String, ? super Report> listener) {
            }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean containsKey(Object key) {
                return false;
            }

            @Override
            public boolean containsValue(Object value) {
                return false;
            }

            @Override
            public Report get(Object key) {
                return null;
            }

            @Override
            public Report put(String key, Report value) {
                return null;
            }

            @Override
            public Report remove(Object key) {
                return null;
            }

            @Override
            public void putAll(Map<? extends String, ? extends Report> m) {

            }

            @Override
            public void clear() {

            }

            @Override
            public Set<String> keySet() {
                return null;
            }

            @Override
            public Collection<Report> values() {
                return null;
            }

            @Override
            public Set<Entry<String, Report>> entrySet() {
                return null;
            }

            @Override
            public void addListener(InvalidationListener listener) {

            }

            @Override
            public void removeListener(InvalidationListener listener) {

            }
        };

        for (LeaderTypeEnum profession : LeaderTypeEnum.values()) {
            reports.put(profession.toString(), new Report(profession.toString(), 0, String.format("Report of count of personas in profession %s", profession.toString())));
        }

        for (Persona p : personas) {
            Objects.requireNonNull(reports.get(p.getTypesOfLeader().toString())).incrementCount();
            //reports.get(p.getTypesOfLeader().toString()).incrementCount();
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