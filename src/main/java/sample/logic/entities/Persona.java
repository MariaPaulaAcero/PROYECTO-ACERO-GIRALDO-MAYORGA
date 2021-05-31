package sample.logic.entities;

import sample.PersonaException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Persona extends Exportable implements Serializable {


    private String name;
    private String lastName;
    private String deathDate;
    private String municipality;
    private String department;
    private Enum profession;
    private boolean isVictim;



    public Persona(String name, String lastName, String deathDate, String municipality, String department, Enum profession, boolean isVictim) throws PersonaException {
        this.name = name;
        this.lastName = lastName;
        this.deathDate= deathDate;
        this.municipality = municipality;
        this.department = department;
        this.profession = profession;
        this.isVictim = isVictim;
    }
    public Persona(String name, String lastName, String deathDate, String municipality, String department ) throws PersonaException {
        this.name = name;
        this.lastName = lastName;
        this.deathDate= deathDate;
        this.municipality = municipality;
        this.department = department;
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
    public Enum getProfession() {
        return profession;
    }
    public boolean isVictim() {
        return isVictim;
    }

    /*public void setDeathDate(String deathDateInput) throws PersonaException {
        try {
            String deathDate = JOptionPane.showInputDialog(deathDateInput);

            if (deathDate > LocalDate.now()) throw new PersonaException(PersonaException.BAD_DETHDATE_LOWER);
            if (deathDate > 120) throw new PersonaException(PersonaException.BAD_DETHDATE_UPPER);

            this.deathDate = deathDate;
        } catch (NumberFormatException er) {
            throw new PersonaException(PersonaException.BAD_AGE + " : " + er.getMessage());
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
        return result;
    }

    @Override
    public String getHeader() {
        return "name,LastName,deathDate, municipality,department";
    }
}