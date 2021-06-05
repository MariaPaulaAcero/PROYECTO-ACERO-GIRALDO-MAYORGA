package sample.logic.entities;


import sample.PersonaException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Persona extends Exportable implements Serializable {


    private String name;
    private String lastName;
    private LocalDate deathDate;
    private String municipality;
    private String department;
    private String typesOfLeader;
    private LocalDate actualDate = LocalDate.now();
    private int Date;


    private Enum typeOfLeader;
    private boolean isVictim;


    public Persona(String name, String lastName, String deathDate, String municipality, String department, String typesOfLeader, Enum typeOfLeader, boolean isVictim, String actualDate) throws PersonaException {
        this.name = name;
        this.lastName = lastName;
        this.setDeathDateToString(deathDate);
        this.municipality = municipality;
        this.department = department;
        this.typesOfLeader = typesOfLeader;
        this.typeOfLeader = typeOfLeader;
        this.isVictim = isVictim;

    }

    public String getName() {
        return name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setDeathDateToString(String deathDateInput) {
        this.deathDate = LocalDate.parse(deathDateInput);
    }
    public LocalDate getDeathDate() {
        return this.deathDate;
    }
    public LocalDate getActualDate(){
        return this.actualDate;
    }
    public String getMunicipality() {
        return municipality;
    }
    public String getDepartment() {
        return department;
    }
    public String getTypesOfLeader() {
        return typesOfLeader;
    }

    public boolean isVictim() {
        return isVictim;
    }
    public Enum getTypeOfLeader() {
        return typeOfLeader;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setTypesOfLeader(String typesOfLeader) {
        this.typesOfLeader = typesOfLeader;
    }
    public void setTypeOfLeader(Enum typeOfLeader) {
        this.typeOfLeader = typeOfLeader;
    }
    public void setIsVictim(boolean isVictim) {
        isVictim = isVictim;
    }


    //public boolean isVictim(){return isVictim;}

    @Override
    public String toString(){

        return String.format("Nombre=%s, Apellido=%s, Fecha de Fallecimiento=%s, Municipio=%s, Departamento=%s, Tipo de Lider=%s, Fecha actual=%s", this.name, this.lastName, this.deathDate, this.municipality, this.department, this.typesOfLeader, this.actualDate);
    }

    @Override
    public List<String> toListString() {

        List<String> result = new ArrayList<>();
        result.add(this.name);
        result.add(this.lastName);
        result.add(String.valueOf(this.deathDate));
        result.add(this.municipality);
        result.add(this.department);
        result.add(this.typesOfLeader);
        result.add(String.valueOf(this.actualDate));
        return result;
    }

    @Override
    public String getHeader() {
        return "name,LastName,deathDate, municipality,department, typesOfLeader, actualDate";
    }
}