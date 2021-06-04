package sample.logic.services.impl;


import sample.gui.Main;
import sample.logic.services.IPersonaServices;
import sample.logic.services.IReportServices;


public class ReportServices implements IReportServices {

    private IPersonaServices personaServices;

    public ReportServices() {
        personaServices = Main.personaServices;
    }

    /*

    @Override
    public List<Report> getReportPersonasByLeader() {
        List<Persona> personas = personaServices.getAll();
        //return getReportPersonasByProfession();
        return this.getReportPersonasByLeader(personas);//habia puesto personas
    }

    @Override
    public List<Report> getReportPersonasByLeader(List<Persona> personas) {
        List<Report>reports = FXCollections.observableArrayList();
        reports.add(new Report());

        for (LeaderTypeEnum leaderTypeEnum : LeaderTypeEnum.values()) {
            reports.add(new Report(leaderTypeEnum.toString(), 0, String.format("Report of count of personas in profession %s", leaderTypeEnum.toString())));
        }

        for (Persona p : personas) {
            //Objects.requireNonNull(reports.get(p.getTypesOfLeader().toString())).getCriteria();
            reports.add(getCountOfVictims());
        }

        return reports;

    }

    public Report getCountOfVictims() {

        List<Persona> personas = personaServices.getAll();
        int numOfVictims = (int) personas.stream().filter(Persona::isVictim).count();
        //int numOfVictims = (int) personas.stream().filter(p -> p.isCampesinoVictim()).count();

        return new Report("Victims", numOfVictims,"This is the number of victims during the strikes");
    }

     */


}