/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Business.Airliner;
import Business.AirlinerDirectory;
import Business.Flight;
import Business.FlightDirectory;
import java.awt.CardLayout;
import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Shailly
 */
public class CreateFleet extends javax.swing.JPanel {

    /**
     * Creates new form CreateFleet
     */
     private FlightDirectory flightDir;
     private AirlinerDirectory ad;
    JPanel panelRight;
    public CreateFleet(JPanel panelRight, FlightDirectory flightDir,AirlinerDirectory ad) {
        initComponents();
        this.flightDir = flightDir;
        this.panelRight = panelRight;
        this.ad = ad;
         populateComboBox();
    }
    
    
    
        private void populateComboBox(){
        for(Airliner a: ad.getAirlinerDirectory()){
            airlinercombobox.addItem(a.getAirLinerName());
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnCreate = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        airlinercombobox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        flightnameTextField = new javax.swing.JTextField();
        flightidTextField = new javax.swing.JTextField();
        sourceTextField = new javax.swing.JTextField();
        destTextField = new javax.swing.JTextField();
        deptTextField = new javax.swing.JTextField();
        arrivalTextField = new javax.swing.JTextField();
        dateTextField = new javax.swing.JTextField();
        chargeTextField = new javax.swing.JTextField();
        haltTextField = new javax.swing.JTextField();

        jLabel1.setText("Create Flight");

        jLabel2.setText("Airliner Name");

        jLabel3.setText("Flight Id :");

        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        airlinercombobox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select" }));
        airlinercombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                airlinercomboboxActionPerformed(evt);
            }
        });

        jLabel4.setText("Flight Name :");

        jLabel5.setText("Source :");

        jLabel6.setText("Destination :");

        jLabel7.setText("Departure :");

        jLabel8.setText("Arrival :");

        jLabel20.setText("Date :");

        jLabel21.setText("Flight Charges :");

        jLabel22.setText("Halts :");

        sourceTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sourceTextFieldActionPerformed(evt);
            }
        });

        deptTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deptTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(airlinercombobox, 0, 96, Short.MAX_VALUE)
                            .addComponent(flightnameTextField)
                            .addComponent(flightidTextField)
                            .addComponent(sourceTextField)
                            .addComponent(destTextField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 157, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addComponent(jLabel1)
                        .addGap(24, 24, 24)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(deptTextField)
                    .addComponent(arrivalTextField)
                    .addComponent(dateTextField)
                    .addComponent(chargeTextField)
                    .addComponent(haltTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(177, 177, 177)
                .addComponent(btnCreate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(194, 194, 194))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(airlinercombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(deptTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(flightidTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(arrivalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(flightnameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(sourceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(chargeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel22)
                    .addComponent(destTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(haltTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack)
                    .addComponent(btnCreate))
                .addContainerGap(116, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // TODO add your handling code here:
       Flight f = new Flight();
       
        if (flightidTextField.getText().isEmpty()||flightnameTextField.getText().isEmpty()|| sourceTextField.getText().isEmpty()
      || destTextField.getText().isEmpty()|| deptTextField.getText().isEmpty()|| arrivalTextField.getText().isEmpty()
      || dateTextField.getText().isEmpty() || chargeTextField.getText().isEmpty() || haltTextField.getText().isEmpty()){
            
         JOptionPane.showMessageDialog(null, "required field is empty!", "Error", JOptionPane.ERROR_MESSAGE);
         return; 
        }
             else{
            if(flightidTextField.getText() == null || flightidTextField.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Flight ID can't be empty");
                    return;             
                            }
            
                            
            if(flightnameTextField.getText().equals("")){
            JOptionPane.showMessageDialog(null, "enter valid Flight name");
                return;             
                 }
            
            if(sourceTextField.getText() == null|| sourceTextField.getText().equals("")){
            JOptionPane.showMessageDialog(null, "please enter correct source");
             return;             
             }
            
            if(destTextField.getText() == null|| destTextField.getText().equals("")){
            JOptionPane.showMessageDialog(null, "please enter correct destination");
             return;             
             }
            
            if(deptTextField.getText().equals("")){
            JOptionPane.showMessageDialog(null, "enter correct departure time");
                return;             
                 }
            if(arrivalTextField.getText().equals("")){
            JOptionPane.showMessageDialog(null, "enter correct arrival time");
                return;             
                 }
            
                         try{
                Integer.parseInt(chargeTextField.getText());
            } catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Please enter number format in flight charges");
                return;
            }
                         
                                   
            try{
                Integer.parseInt(haltTextField.getText());
            } catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Please enter number format in flight halt");
                return;
            }
            
            if(dateTextField.getText().equals("")){
            JOptionPane.showMessageDialog(null, "enter correct correct Date");
                return;             
                 }
            
            String bookDate = dateTextField.getText();
        String format = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setLenient(false);
        Date bookingDate = new Date();
        try {
            bookingDate = sdf.parse(bookDate);

        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Please enter date in correct format dd/mm/yyyy");
            return;
        }
            

      }   
      
       
       
       f.setFlightID(flightidTextField.getText());
       f.setFlightname(flightnameTextField.getText());
       f.setSource(sourceTextField.getText());
       f.setDestination(destTextField.getText());
       f.setDeparture(deptTextField.getText());
       f.setArrival(arrivalTextField.getText());
       f.setDate(dateTextField.getText());
       f.setFlightcharges(Integer.parseInt(chargeTextField.getText()));
       f.setHalts(Integer.parseInt(haltTextField.getText()));
       
       String airliner=(String) airlinercombobox.getSelectedItem();
        for(Airliner a: ad.getAirlinerDirectory())
            if(a.getAirLinerName().equals(airliner)){
                f.setAirliner(a);
            }
        
          flightDir.addflight(f);

        
        JOptionPane.showMessageDialog(null,"Flight created successfully"); 
        
        flightidTextField.setText("");
        flightnameTextField.setText("");
        sourceTextField.setText("");
        destTextField.setText("");
        deptTextField.setText("");
        arrivalTextField.setText("");
        dateTextField.setText("");
        chargeTextField.setText("");
        haltTextField.setText("");        
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        panelRight.remove(this);
        CardLayout layout = (CardLayout) panelRight.getLayout();
        Component[] comps=this.panelRight.getComponents();
        for(Component comp:comps){
            if (comp instanceof ManageFleet)
            {
                ManageFleet manageFleet =(ManageFleet) comp;
                manageFleet.populate(flightDir.getFlightdirectory());
            }
        }
        layout.previous(panelRight);
    }//GEN-LAST:event_btnBackActionPerformed

    private void sourceTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sourceTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sourceTextFieldActionPerformed

    private void deptTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deptTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deptTextFieldActionPerformed

    private void airlinercomboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_airlinercomboboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_airlinercomboboxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox airlinercombobox;
    private javax.swing.JTextField arrivalTextField;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCreate;
    private javax.swing.JTextField chargeTextField;
    private javax.swing.JTextField dateTextField;
    private javax.swing.JTextField deptTextField;
    private javax.swing.JTextField destTextField;
    private javax.swing.JTextField flightidTextField;
    private javax.swing.JTextField flightnameTextField;
    private javax.swing.JTextField haltTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField sourceTextField;
    // End of variables declaration//GEN-END:variables
}
