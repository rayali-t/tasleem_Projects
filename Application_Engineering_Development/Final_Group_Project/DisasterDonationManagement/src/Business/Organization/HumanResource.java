/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.DonorRole;
import Business.Role.OnsiteVolunteer;
import Business.Role.Role;
import Business.Role.VolunteerRole;
import java.util.ArrayList;

/**
 *
 * @author Eshanee Thakur
 */
public class HumanResource extends Organization {

    public HumanResource() {
        super(Organization.Type.HumanResource.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new VolunteerRole());
        roles.add(new DonorRole());
        roles.add(new OnsiteVolunteer());
        return roles;
    }

}
