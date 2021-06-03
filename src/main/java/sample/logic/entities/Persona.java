package sample.logic.entities;

import sample.PersonaException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Persona extends Exportable implements Serializable {


    private String name;
    private String lastName;
    private String deathDate;
    //private LocalDate deathDate;
    private String municipality;
    private String department;
    private String typesOfLeader;
    private Enum typeOfLeader;
    private boolean isSindicalVictim;



    public Persona(String name, String lastName,String deathDate,String municipality,String department,String typesOfLeader, Enum typeOfLeader, boolean isSindicalVictim) throws PersonaException {
        this.name = name;
        this.lastName = lastName;
        this.deathDate= deathDate;
        //this.setDeathDateToString(deathDate);
        this.municipality = municipality;
        this.department = department;
        this.typesOfLeader = typesOfLeader;
        this.typeOfLeader = typeOfLeader;
        this.isSindicalVictim = isSindicalVictim;
    }
    public Persona(String name, String lastName,String deathDate,String municipality,String department,String typesOfLeader) throws PersonaException {
        this.name = name;
        this.lastName = lastName;
        this.deathDate= deathDate;
        //this.setDeathDateToString(deathDate);
        this.municipality = municipality;
        this.department = department;
        this.typesOfLeader = typesOfLeader;
    }

    public String getName() {
        return name;
    }
    public String getLastName() {
        return lastName;
    }
    public String getDeathDate() {
        return "The Death Date is " + this.deathDate;
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
        return isSindicalVictim;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /*public void setDeathDateToString(String deathDateInput){
        this.deathDate = LocalDate.parse(deathDateInput);
    }

     */
    public void setDeathDate(String deathDate){
        this.deathDate=deathDate;
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

    //public boolean isVictim(){return isVictim;}

    @Override
    public String toString(){

        return String.format("Nombre=%s, Apellido=%s, Fecha de Fallecimiento=%s, Municipio=%s, Departamento=%s, Tipo de Lider=%s", this.name, this.lastName, this.deathDate, this.municipality, this.department, this.typesOfLeader);
    }

    @Override
    public List<String> toListString() {
        List<String> result = new ArrayList<>();
        result.add(this.name);
        result.add(this.lastName);
        //result.add(this.deathDate);
        result.add(this.municipality);
        result.add(this.department);
        result.add(this.typesOfLeader);
        return result;
    }

    @Override
    public String getHeader() {
        return "name,LastName,deathDate, municipality,department, typesOfLeader";
    }
}