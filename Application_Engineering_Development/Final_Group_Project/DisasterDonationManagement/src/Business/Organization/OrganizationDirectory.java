/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.Type;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class OrganizationDirectory {

    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }

    public Organization createOrganization(Type type) {
        Organization organization = null;
        int id =0;
        if (type.getValue().equals(Type.Pharmacist.getValue())) {
            organization = new PharmacistOrganization();
            id = organizationList.size();
            organization.setOrganizationID(id);
            organizationList.add(organization);
        } 
        else if (type.getValue().equals(Type.GoodsManagement.getValue())) {
            organization = new GoodsManagement();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(Type.HumanResource.getValue())) {
            organization = new HumanResource();
            id = organizationList.size();
            organization.setOrganizationID(id);
            organizationList.add(organization);
        } 
        else if (type.getValue().equals(Type.ReliefFund.getValue())) {
            organization = new ReliefFundOrganization();
            id = organizationList.size();
            organization.setOrganizationID(id);
            organizationList.add(organization);
        } 
        else if (type.getValue().equals(Type.Transport.getValue())) {
            organization = new TransportOrganization();
            id = organizationList.size();
            organization.setOrganizationID(id);
            organizationList.add(organization);
        }

        return organization;
    }
    
    public void deleteOrganization(Organization organization)
    {
        organizationList.remove(organization);
    }
    
}
