/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.OnsiteVolunteerRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.HumanResource;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.CashDonationWorkRequest;
import Business.WorkQueue.PackageDeliveryWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eshanee Thakur
 */
public class OnsiteVolunteerWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private HumanResource humanResource;
    private Network network;

    /**
     * Creates new form OnsiteVolunteerWorkAreaJPanel
     */
    public OnsiteVolunteerWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        initComponents();
        this.network = business.getNetworkList().get(0);
        this.userProcessContainer = userProcessContainer;
        this.userAccount = account;
        this.enterprise = enterprise;
        this.humanResource = (HumanResource) organization;

        populatePackageTable();
        populateDonationTable();
    }

    public void populatePackageTable() {
        DefaultTableModel model = (DefaultTableModel) tblPackagesReceived.getModel();
        model.setRowCount(0);

        for (WorkRequest request : humanResource.getWorkQueue().getWorkRequestList()) {
            if (request instanceof PackageDeliveryWorkRequest) {
                Object[] row = new Object[5];
                row[0] = (PackageDeliveryWorkRequest) request;
                row[1] = ((PackageDeliveryWorkRequest) request).getPackageName();
                row[2] = ((PackageDeliveryWorkRequest) request).getDriverName();
                row[3] = ((PackageDeliveryWorkRequest) request).getCarNumber();
                row[4] = request.getStatus();

                model.addRow(row);
            }
        }
    }

    public void populateDonationTable() {
        DefaultTableModel model = (DefaultTableModel) tblDonations.getModel();
        model.setRowCount(0);

        for (WorkRequest request : humanResource.getWorkQueue().getWorkRequestList()) {
            if (request instanceof CashDonationWorkRequest) {
                Object[] row = new Object[4];
                row[0] = (CashDonationWorkRequest) request;
                row[1] = ((CashDonationWorkRequest) request).getCashDonation();
                row[2] = ((CashDonationWorkRequest) request).getDonorMessage();
                row[3] = request.getStatus();

                model.addRow(row);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        tblDonations = new javax.swing.JTable();
        btnAcknowledge = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblPackagesReceived = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnCashAck = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        tblDonations.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Donor Name", "Amount", "Message", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblDonations);

        btnAcknowledge.setBackground(new java.awt.Color(0, 153, 255));
        btnAcknowledge.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnAcknowledge.setForeground(new java.awt.Color(255, 255, 255));
        btnAcknowledge.setText("Acknowledge");
        btnAcknowledge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcknowledgeActionPerformed(evt);
            }
        });

        tblPackagesReceived.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Area", "Package", "Driver", "Car No", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblPackagesReceived);
        if (tblPackagesReceived.getColumnModel().getColumnCount() > 0) {
            tblPackagesReceived.getColumnModel().getColumn(3).setHeaderValue("Car No");
        }

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 255));
        jLabel1.setText("Goods :");

        btnCashAck.setBackground(new java.awt.Color(0, 153, 255));
        btnCashAck.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCashAck.setForeground(new java.awt.Color(255, 255, 255));
        btnCashAck.setText("Acknowledge");
        btnCashAck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCashAckActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 255));
        jLabel2.setText("Cash Donations:");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("ONSITE VOLUNTEER DASHBOARD");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 948, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAcknowledge, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCashAck, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 948, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(166, 166, 166)
                .addComponent(btnAcknowledge)
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCashAck)
                .addContainerGap(44, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(101, 101, 101)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(333, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAcknowledgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcknowledgeActionPerformed
        int selectedRow = tblPackagesReceived.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a request.");
            return;
        }

        PackageDeliveryWorkRequest request = (PackageDeliveryWorkRequest) tblPackagesReceived.getValueAt(selectedRow, 0);
        if (request.getStatus().equalsIgnoreCase("Received Successfully")) {
            JOptionPane.showMessageDialog(null, "Selected request has already been completed. Please select another request.");
            return;
        }

        request.setStatus("Received Successfully");
        request.setResolveDate(new Date());
        populatePackageTable();

        for (WorkRequest req : request.getShippedRequests()) {
            req.setStatus("Received Successfully");
        }
//        String area = request.getDestination();
//        String itemName = request.getItemName();
//        int receivedCount = request.getItemCount();

//        for (Requirement r : enterprise.getRequirementDirectory().getRequirementDirectory()) {
//            if(r.getArea().equalsIgnoreCase(area) ) {
//                
//            }
//        }
    }//GEN-LAST:event_btnAcknowledgeActionPerformed

    private void btnCashAckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCashAckActionPerformed
        int selectedRow = tblDonations.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a request to acknowledge.");
            return;
        }

        CashDonationWorkRequest request = (CashDonationWorkRequest) tblDonations.getValueAt(selectedRow, 0);

        if (request.getStatus().equalsIgnoreCase("Received Successfully")) {
            JOptionPane.showMessageDialog(null, "Selected request has already been completed. Please select another request.");
            return;
        }

        request.setStatus("Received Successfully");
        request.setResolveDate(new Date());
        populateDonationTable();

    }//GEN-LAST:event_btnCashAckActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcknowledge;
    private javax.swing.JButton btnCashAck;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblDonations;
    private javax.swing.JTable tblPackagesReceived;
    // End of variables declaration//GEN-END:variables
}
