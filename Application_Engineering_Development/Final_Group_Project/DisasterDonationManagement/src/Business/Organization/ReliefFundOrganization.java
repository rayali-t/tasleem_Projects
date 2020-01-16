/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.InsurorRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Eshanee Thakur
 */
public class ReliefFundOrganization extends Organization {

    public ReliefFundOrganization() {
        super(Organization.Type.ReliefFund.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new InsurorRole());
        return roles;
    }

}
