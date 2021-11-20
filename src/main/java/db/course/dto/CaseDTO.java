package db.course.dto;

import db.course.domain.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class CaseDTO {
    private Case aCase;
    private List<String> listOfEvidences;
    private ArrayList<String> listOfPerformers;
    private ArrayList<String> listOfCriminals;
    private ArrayList<String> listOfSources;

    public Case getaCase() {
        return aCase;
    }

    public void setaCase(Case aCase) {
        this.aCase = aCase;
    }

    public List<String> getListOfEvidences() {
        return listOfEvidences;
    }

    public void setListOfEvidences(List<String> listOfEvidences) {
        this.listOfEvidences = listOfEvidences;
    }

    public ArrayList<String> getListOfPerformers() {
        return listOfPerformers;
    }

    public void setListOfPerformers(ArrayList<String> listOfPerformers) {
        ArrayList<String> newList = new ArrayList<>();
        String temp;
        for (int i = 0; i < listOfPerformers.toArray().length; i++){
            temp = listOfPerformers.get(i);
            newList.add(temp.replace(',', ' '));
        }
        this.listOfPerformers = newList;
    }

    public ArrayList<String> getListOfCriminals() {
        return listOfCriminals;
    }

    public void setListOfCriminals(ArrayList<String> listOfCriminals) {
        ArrayList<String> newList = new ArrayList<>();
        String temp;
        for (int i = 0; i < listOfCriminals.toArray().length; i++){
            temp = listOfCriminals.get(i);
            newList.add(temp.replace(',', ' '));
        }
        this.listOfCriminals = newList;
    }

    public ArrayList<String> getListOfSources() {
        return listOfSources;
    }

    public void setListOfSources(ArrayList<String> listOfSources) {
        this.listOfSources = listOfSources;
    }
}
