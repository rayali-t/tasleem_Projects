/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.PharmacistRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.EnterpriseDirectory;
import Business.Organization.PharmacistOrganization;
import Business.Requirement.Requirement;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.ClaimFundsWorkRequest;
import Business.WorkQueue.MedicineCollectionWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author raunak
 */
public class PharmacistWorkAreaJPanel extends javax.swing.JPanel {

 
    private EcoSystem business;
    private JPanel userProcessContainer;
    private PharmacistOrganization organization;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private EnterpriseDirectory directory;

    /**
     * Creates new form DoctorWorkAreaJPanel
     */
    public PharmacistWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, PharmacistOrganization organization, Enterprise enterprise, EnterpriseDirectory directory,EcoSystem business) {
        initComponents();

        this.userProcessContainer = userProcessContainer;
        this.organization = organization;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.directory = directory;
        this.business = business;
//        valueLabel.setText(enterprise.getName());
        populateRequestTable();
        populateRequirementsTable();
       populateMedsAmountTable();
    }

    
        public void populateRequirementsTable() {
        DefaultTableModel model = (DefaultTableModel) tblRequirements.getModel();

        model.setRowCount(0);
        for (Requirement item : enterprise.getRequirementDirectory().getRequirementDirectory()) {
            if (item.getCategory().equalsIgnoreCase(Requirement.Category.Medicines.getValue())) {
                if (item.getRequirementCount() != 0) {
                    Object[] row = new Object[4];
                    row[0] = item.getCategory();
                    row[1] = item.getArea();
                    row[2] = item;
                    row[3] = item.getRequirementCount();
                    
                    model.addRow(row);
                }
            }
        }
    }
  
    public void populateRequestTable() {
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();

        model.setRowCount(0);
        
        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()) {
            if(request  instanceof MedicineCollectionWorkRequest)
            { Object[] row = new Object[8];
            row[0] = request;
            row[1] = request.getItemCount();
            row[2] = request.getCost();         
            row[3] = request.getRequestDate();
            row[4] = request.getSender(); 
            row[5] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
            row[6] = request.getStatus();
             String result = null;
            //if(request  instanceof MedicineCollectionWorkRequest)
            // result = ((MedicineCollectionWorkRequest)request).getMedicineAck();
             //if(request  instanceof ClaimFundsWorkRequest)
               //   result = ((ClaimFundsWorkRequest)request).getClaimAcknowledgement();
            //row[7] = result == null ? "Pending" : result;
            boolean isClaimAvailed =((MedicineCollectionWorkRequest) request).isIsClaimed(); 
            row[7]= isClaimAvailed?"Yes":"No";

              model.addRow(row);}
        }
        
    }
    
       public void populateMedsAmountTable() {
        DefaultTableModel model = (DefaultTableModel) tblClaimAmount.getModel();

        model.setRowCount(0);
        
        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()) {
            if(request  instanceof ClaimFundsWorkRequest)
            { Object[] row = new Object[6];
            row[0] = request.getCost(); 
            
            row[1] = request.getRequestDate();
            row[2] = request.getSender(); 
            row[3] = request.getReceiver() == null ? null : request.getReceiver().getEmployee().getName();
            row[4] = request.getStatus();
             String result = null;
            //if(request  instanceof MedicineCollectionWorkRequest)
             //result = ((MedicineCollectionWorkRequest)request).getMedicineAck();
             //if(request  instanceof ClaimFundsWorkRequest)
                  result = ((ClaimFundsWorkRequest)request).getClaimAcknowledgement();
            row[5] = result == null ? "Pending" : result;
          

              model.addRow(row);}
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

        jLabel1 = new javax.swing.JLabel();
        btnRefreshReqTable = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRequirements = new javax.swing.JTable();
        processJButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        btnRefreshRequest = new javax.swing.JButton();
        btnClaimFunds = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblClaimAmount = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Donation History : ");

        setBackground(new java.awt.Color(255, 255, 255));

        btnRefreshReqTable.setBackground(new java.awt.Color(0, 153, 255));
        btnRefreshReqTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRefreshReqTable.setForeground(new java.awt.Color(255, 255, 255));
        btnRefreshReqTable.setText("Refresh");
        btnRefreshReqTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshReqTableActionPerformed(evt);
            }
        });

        tblRequirements.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Category", "Area", "Item Name", "Item Count"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
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
        tblRequirements.setSelectionBackground(new java.awt.Color(0, 153, 255));
        jScrollPane1.setViewportView(tblRequirements);
        if (tblRequirements.getColumnModel().getColumnCount() > 0) {
            tblRequirements.getColumnModel().getColumn(0).setResizable(false);
            tblRequirements.getColumnModel().getColumn(1).setResizable(false);
            tblRequirements.getColumnModel().getColumn(2).setResizable(false);
            tblRequirements.getColumnModel().getColumn(3).setResizable(false);
        }

        processJButton.setBackground(new java.awt.Color(0, 153, 255));
        processJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        processJButton.setForeground(new java.awt.Color(255, 255, 255));
        processJButton.setText("Process");
        processJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processJButtonActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 255));
        jLabel2.setText("Requirement : ");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 255));
        jLabel3.setText("History : ");

        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Name", "Item Count", "Cost", "Date", "Sender", "Receiver", "Status", "Funds Claimed"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        workRequestJTable.setSelectionBackground(new java.awt.Color(0, 153, 255));
        jScrollPane2.setViewportView(workRequestJTable);

        btnRefreshRequest.setBackground(new java.awt.Color(0, 153, 255));
        btnRefreshRequest.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRefreshRequest.setForeground(new java.awt.Color(255, 255, 255));
        btnRefreshRequest.setText("Refresh");
        btnRefreshRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshRequestActionPerformed(evt);
            }
        });

        btnClaimFunds.setBackground(new java.awt.Color(0, 153, 255));
        btnClaimFunds.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnClaimFunds.setForeground(new java.awt.Color(255, 255, 255));
        btnClaimFunds.setText("Claim funds");
        btnClaimFunds.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClaimFundsActionPerformed(evt);
            }
        });

        tblClaimAmount.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cost", "Date", "Sender", "Receiver", "Status", "Result"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblClaimAmount.setSelectionBackground(new java.awt.Color(0, 153, 255));
        jScrollPane3.setViewportView(tblClaimAmount);
        if (tblClaimAmount.getColumnModel().getColumnCount() > 0) {
            tblClaimAmount.getColumnModel().getColumn(0).setResizable(false);
            tblClaimAmount.getColumnModel().getColumn(1).setResizable(false);
            tblClaimAmount.getColumnModel().getColumn(2).setResizable(false);
            tblClaimAmount.getColumnModel().getColumn(3).setResizable(false);
            tblClaimAmount.getColumnModel().getColumn(4).setResizable(false);
            tblClaimAmount.getColumnModel().getColumn(5).setResizable(false);
        }

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 255));
        jLabel4.setText("Claim History : ");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("PHARMACIST DASHBOARD");

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
                            .addComponent(jScrollPane2)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnClaimFunds)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRefreshRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(processJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRefreshReqTable, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1))
                        .addGap(274, 274, 274))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 917, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(272, 272, 272))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnRefreshReqTable)
                    .addComponent(processJButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btnRefreshRequest)
                    .addComponent(btnClaimFunds))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshReqTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshReqTableActionPerformed
        populateRequirementsTable();
    }//GEN-LAST:event_btnRefreshReqTableActionPerformed

    private void processJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processJButtonActionPerformed

        int selectedRow = tblRequirements.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a request.");
            return;
        }

        Requirement request = (Requirement) tblRequirements.getValueAt(selectedRow, 2);
//
//        if (request.getSender().getRole().toString().equals("Business.Role.PharmacistRole")) {
//            ProcessPharmacistWorkRequestJPanel processWorkRequestJPanel = new ProcessPharmacistWorkRequestJPanel(userProcessContainer, (TrackingMedicineWorkRequest) request);
//            userProcessContainer.add("processWorkRequestJPanel", processWorkRequestJPanel);
//        } else if (request.getSender().getRole().toString().equals("Business.Role.DonorRole")) {
//            ProcessDonorWorkRequestJPanel processDonationWorkRequestJPanel = new ProcessDonorWorkRequestJPanel(userProcessContainer, userAccount, enterpriseDirectory, (DonationWorkRequest) request);
//            userProcessContainer.add("processDonationWorkRequestJPanel", processDonationWorkRequestJPanel);
//        }
        
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("RequestMedicineCollectionJPanel", new RequestMedicineCollectionJPanel(userProcessContainer, userAccount, enterprise, directory, request));
        layout.next(userProcessContainer);
        //JOptionPane.showMessageDialog(null, request.getSender().getRole() + "Creation successful");
       // request.setStatus("Processing");
    }//GEN-LAST:event_processJButtonActionPerformed

    private void btnRefreshRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshRequestActionPerformed
        populateRequestTable();
    }//GEN-LAST:event_btnRefreshRequestActionPerformed

    private void btnClaimFundsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClaimFundsActionPerformed
        // TODO add your handling code here:
        
        int selectedRow = workRequestJTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a request.");
            return;
        }
        
         MedicineCollectionWorkRequest request = (MedicineCollectionWorkRequest) workRequestJTable.getValueAt(selectedRow, 0);  
         if(!request.getStatus().equals("Completed"))
        { JOptionPane.showMessageDialog(null, "Request still in process.\nPlease select a completed request");
            return;}
         
          if(request.isIsClaimed())
        { JOptionPane.showMessageDialog(null, "Request already claimed. \nPlease select another request");
            return;}

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("ClaimFundsJPanel", new ClaimFundsJPanel(userProcessContainer, userAccount, enterprise, directory, request));
        layout.next(userProcessContainer);
        populateMedsAmountTable();

        //request.setIsClaimed(true);
    }//GEN-LAST:event_btnClaimFundsActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClaimFunds;
    private javax.swing.JButton btnRefreshReqTable;
    private javax.swing.JButton btnRefreshRequest;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton processJButton;
    private javax.swing.JTable tblClaimAmount;
    private javax.swing.JTable tblRequirements;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}
