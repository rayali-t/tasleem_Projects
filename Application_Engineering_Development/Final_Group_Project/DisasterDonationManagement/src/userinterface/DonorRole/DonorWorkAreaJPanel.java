/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.DonorRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.EnterpriseDirectory;
import Business.Organization.HumanResource;
import Business.Organization.Organization;
import Business.Requirement.Requirement;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.CashDonationWorkRequest;
import Business.WorkQueue.DonationWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import userinterface.AdministrativeRole.LeaderBoardJpanel;

/**
 *
 * @author tashu
 */
public class DonorWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem business;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private EnterpriseDirectory directory;
    private HumanResource humanResource;

    /**
     * Creates new form DonorWorkAreaJPanel
     */
    public DonorWorkAreaJPanel(JPanel userProcessContainer, UserAccount account, Organization organization, EcoSystem business, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.userAccount = account;
        this.business = business;
        this.humanResource = (HumanResource) organization;

        populateRequestTable();
        populateRequirementsTable();
    }

    public void populateRequirementsTable() {
        DefaultTableModel model = (DefaultTableModel) tblRequirements.getModel();

        model.setRowCount(0);
        for (Requirement item : enterprise.getRequirementDirectory().getRequirementDirectory()) {
            if (!item.getCategory().equalsIgnoreCase(Requirement.Category.Medicines.getValue())) {
                if (item.getRequirementCount() != 0) {
                    Object[] row = new Object[5];
                    row[0] = item.getCategory();
                    row[1] = item.getArea();
                    row[2] = item;
                    row[3] = item.getRequirementCount();
                    row[4] = item.getCollectedCount();
                    model.addRow(row);
                }
            }
        }
    }

    public void populateRequestTable() {
        DefaultTableModel model = (DefaultTableModel) workRequestJTable.getModel();

        model.setRowCount(0);
        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()) {
            if (request instanceof DonationWorkRequest) {
                Object[] row = new Object[5];
                row[0] = request;
                row[1] = request.getItemCount();
                row[2] = request.getRequestDate();
                row[3] = request.getReceiver();
                row[4] = request.getStatus();
                model.addRow(row);
            }
        }

        DefaultTableModel cashModel = (DefaultTableModel) tblCashHistory.getModel();

        cashModel.setRowCount(0);
        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()) {
            if (request instanceof CashDonationWorkRequest) {
                Object[] row = new Object[4];
                row[0] = request;
                row[1] = ((CashDonationWorkRequest) request).getCashDonation();
                row[2] = ((CashDonationWorkRequest) request).getDonorMessage();
                row[3] = request.getStatus();

                cashModel.addRow(row);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        workRequestJTable = new javax.swing.JTable();
        btnRefreshReqTable = new javax.swing.JButton();
        btnGoodsDonation = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblRequirements = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnRefreshRequest = new javax.swing.JButton();
        btnCashDonation = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCashHistory = new javax.swing.JTable();
        btnRefreshCashGrid = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnLeaderBoard = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        workRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Name", "Item Count", "Date", "Receiver", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class
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
        jScrollPane1.setViewportView(workRequestJTable);
        if (workRequestJTable.getColumnModel().getColumnCount() > 0) {
            workRequestJTable.getColumnModel().getColumn(3).setHeaderValue("Receiver");
        }

        btnRefreshReqTable.setBackground(new java.awt.Color(0, 153, 255));
        btnRefreshReqTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRefreshReqTable.setForeground(new java.awt.Color(255, 255, 255));
        btnRefreshReqTable.setText("Refresh");
        btnRefreshReqTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshReqTableActionPerformed(evt);
            }
        });

        btnGoodsDonation.setBackground(new java.awt.Color(0, 153, 255));
        btnGoodsDonation.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnGoodsDonation.setForeground(new java.awt.Color(255, 255, 255));
        btnGoodsDonation.setText("Goods Donation");
        btnGoodsDonation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoodsDonationActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 255));
        jLabel1.setText("Goods Donation History : ");

        tblRequirements.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Category", "Area", "Item Name", "Requirement", "Collected Count"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblRequirements);
        if (tblRequirements.getColumnModel().getColumnCount() > 0) {
            tblRequirements.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 255));
        jLabel2.setText("Requirement : ");

        btnRefreshRequest.setBackground(new java.awt.Color(0, 153, 255));
        btnRefreshRequest.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRefreshRequest.setForeground(new java.awt.Color(255, 255, 255));
        btnRefreshRequest.setText("Refresh");
        btnRefreshRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshRequestActionPerformed(evt);
            }
        });

        btnCashDonation.setBackground(new java.awt.Color(0, 153, 255));
        btnCashDonation.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCashDonation.setForeground(new java.awt.Color(255, 255, 255));
        btnCashDonation.setText("Cash Donation");
        btnCashDonation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCashDonationActionPerformed(evt);
            }
        });

        tblCashHistory.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tblCashHistory);

        btnRefreshCashGrid.setBackground(new java.awt.Color(0, 153, 255));
        btnRefreshCashGrid.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRefreshCashGrid.setForeground(new java.awt.Color(255, 255, 255));
        btnRefreshCashGrid.setText("Refresh");
        btnRefreshCashGrid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshCashGridActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 255));
        jLabel3.setText("Cash Donation History : ");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("DONOR DASHBOARD");

        btnLeaderBoard.setBackground(new java.awt.Color(255, 255, 255));
        btnLeaderBoard.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnLeaderBoard.setForeground(new java.awt.Color(0, 153, 255));
        btnLeaderBoard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/free-trophy-icon-11.jpg"))); // NOI18N
        btnLeaderBoard.setText("LEADERBOARD");
        btnLeaderBoard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeaderBoardActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(83, 83, 83)
                        .addComponent(btnRefreshRequest, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(51, 51, 51)
                        .addComponent(btnRefreshCashGrid))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(848, 848, 848)
                        .addComponent(btnRefreshReqTable)
                        .addGap(3, 3, 3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnCashDonation)
                                .addGap(18, 18, 18)
                                .addComponent(btnGoodsDonation))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnLeaderBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLeaderBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(btnRefreshReqTable))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCashDonation)
                    .addComponent(btnGoodsDonation))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnRefreshRequest))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRefreshCashGrid)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshReqTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshReqTableActionPerformed
        populateRequirementsTable();

    }//GEN-LAST:event_btnRefreshReqTableActionPerformed

    private void btnGoodsDonationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoodsDonationActionPerformed
        int selectedRow = tblRequirements.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select atleast one requirement to make a donation.");
            return;
        }

        Requirement req = (Requirement) tblRequirements.getValueAt(selectedRow, 2);

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("RequestDonationJPanel", new RequestDonationJPanel(userProcessContainer, userAccount, enterprise, directory, req));
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnGoodsDonationActionPerformed

    private void btnRefreshRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshRequestActionPerformed
        populateRequestTable();
    }//GEN-LAST:event_btnRefreshRequestActionPerformed

    private void btnCashDonationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCashDonationActionPerformed
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("CashDonationJPanel", new CashDonationJPanel(userProcessContainer, userAccount, enterprise, directory));
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnCashDonationActionPerformed

    private void btnRefreshCashGridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshCashGridActionPerformed
        populateRequestTable();
    }//GEN-LAST:event_btnRefreshCashGridActionPerformed

    private void btnLeaderBoardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeaderBoardActionPerformed
        // TODO add your handling code here:
        LeaderBoardJpanel leaderboardJPanel = new LeaderBoardJpanel(userProcessContainer, enterprise.getOrganizationDirectory());
        userProcessContainer.add("leaderboardJPanel", leaderboardJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnLeaderBoardActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCashDonation;
    private javax.swing.JButton btnGoodsDonation;
    private javax.swing.JButton btnLeaderBoard;
    private javax.swing.JButton btnRefreshCashGrid;
    private javax.swing.JButton btnRefreshReqTable;
    private javax.swing.JButton btnRefreshRequest;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblCashHistory;
    private javax.swing.JTable tblRequirements;
    private javax.swing.JTable workRequestJTable;
    // End of variables declaration//GEN-END:variables
}