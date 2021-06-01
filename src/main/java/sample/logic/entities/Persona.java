package sample.logic.entities;

import sample.PersonaException;

import javax.swing.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Persona extends Exportable implements Serializable {


    private String name;
    private String lastName;
    private String deathDate;
    private String municipality;
    private String department;
    private String typesOfLeader;
    private Enum typeOfLeader;
    private boolean isSindicalVictim;



    public Persona(String name, String lastName,String deathDate,String municipality,String department,String typesOfLeader, Enum typeOfLeader, boolean isSindicalVictim) throws PersonaException {
        this.name = name;
        this.lastName = lastName;
        this.deathDate= deathDate;
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

    /*public void setDeathDate(String deathDateInput) throws PersonaException {
        try {
            String deathDate = JOptionPane.showInputDialog(deathDateInput);

            if (this.deathDate > LocalDate.now()) throw new PersonaException(PersonaException.BAD_DEATHDATE_LOWER);
            if (deathDate > 120) throw new PersonaException(PersonaException.BAD_DEATHDATE_UPPER);

            this.deathDate = deathDate;
        } catch (NumberFormatException er) {
            throw new PersonaException(PersonaException.BAD_DEATHDATE+ " : " + er.getMessage());
        }

    }

     */


    @Override
    public List<String> toListString() {
        List<String> result = new ArrayList<>();
        result.add(this.name);
        result.add(this.lastName);
        result.add(this.deathDate);
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