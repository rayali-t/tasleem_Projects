/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.PharmacistOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import userinterface.PharmacistRole.PharmacistWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public class PharmacistRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        //Assuming just 1 network here
        Network network = business.getNetworkList().get(0);     
        return new PharmacistWorkAreaJPanel(userProcessContainer, account, (PharmacistOrganization)organization, enterprise, network.getEnterpriseDirectory(),business);
     
    }
    
    
}
