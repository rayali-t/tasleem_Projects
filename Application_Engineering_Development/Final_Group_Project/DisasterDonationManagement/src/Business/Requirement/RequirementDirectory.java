/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Requirement;

import java.util.ArrayList;

/**
 *
 * @author Eshanee Thakur
 */
public class RequirementDirectory {

    private ArrayList<Requirement> requirementDirectory;
    private ArrayList<String> areaList;
    private double cashDonation;

    public RequirementDirectory() {
        requirementDirectory = new ArrayList();
        areaList = new ArrayList();
        cashDonation = 0;
    }

    public ArrayList<Requirement> getRequirementDirectory() {
        return requirementDirectory;
    }

    public void setRequirementDirectory(ArrayList<Requirement> requirementDirectory) {
        this.requirementDirectory = requirementDirectory;
    }

    public void createRequirement(Requirement requirement) {
        requirementDirectory.add(requirement);
    }

    public void deleteRequirement(Requirement requirement) {
        requirementDirectory.remove(requirement);
    }

    public ArrayList<String> getAreaList() {
        return areaList;
    }

    public void addAreaList(String area) {
        areaList.add(area);
    }

    public void deleteArea(String area) {
        areaList.remove(area);
    }

    public double getCashDonation() {
        return cashDonation;
    }

    public void setCashDonation(double cashDonation) {
        this.cashDonation = cashDonation;
    }
}
