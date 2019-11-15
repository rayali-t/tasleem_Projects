/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface;

import Business.Airliner;
import Business.AirlinerDirectory;
import Business.BookingDirectory;
import Business.Flight;
import Business.FlightDirectory;
import Business.Users.Customer;
import java.awt.CardLayout;
import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Eshanee Thakur
 */
public class CustomerMainScreen extends javax.swing.JPanel {

    /**
     * Creates new form CustomerMainScreen
     */
    private Customer customer;
    private JPanel rightPanel;
    private FlightDirectory flightDirectory;
    private AirlinerDirectory airlinerDirectory;
    private BookingDirectory bookingDirectory;

    public CustomerMainScreen() {
        initComponents();
    }

    public CustomerMainScreen(JPanel rightPanel, Customer customer, FlightDirectory flightDirectory, AirlinerDirectory airlinerDirectory, BookingDirectory bookingDirectory) {
        initComponents();
        this.customer = customer;
        this.rightPanel = rightPanel;
        this.flightDirectory = flightDirectory;
        this.airlinerDirectory = airlinerDirectory;
        this.bookingDirectory = bookingDirectory;

        lblHeader.setText(lblHeader.getText() + " " + customer.getUsername() + " !");
        drpdwnAirliner.removeAllItems();

//        //Eshanee - Hack to populate flight details
//        airlinerDirectory.setAirlinerDirectory(populateAirlinerDirectory());
//        flightDirectory.setFlightdirectory(populateFlightDirectory());
        drpdwnAirliner.addItem("Select Option");
        for (Airliner a : airlinerDirectory.getAirlinerDirectory()) {
            drpdwnAirliner.addItem(a.getAirLinerName());
        }
    }

    private ArrayList<Flight> populateFlights(String source, String destination, String dateOfTravel) {
        //Pre-requisite filters
        ArrayList<Flight> filteredList = new ArrayList<>();

        for (Flight flight : flightDirectory.getFlightdirectory()) {
            if (flight.getDestination().equalsIgnoreCase(destination) && flight.getSource().equalsIgnoreCase(source) && flight.getDate().equalsIgnoreCase(dateOfTravel)) {
                filteredList.add(flight);
            }
        }

        if (txtMinPrice.getText() != null && !txtMinPrice.getText().equals("") && txtMaxPrice.getText() != null && !txtMaxPrice.getText().equals("")) {

            double minFlightPrice = Double.parseDouble(txtMinPrice.getText());
            double maxFlightPrice = Double.parseDouble(txtMaxPrice.getText());

            Iterator<Flight> itList = filteredList.iterator();
            while (itList.hasNext()) {
                Flight flight = itList.next();
                if (flight.getFlightcharges() < minFlightPrice || flight.getFlightcharges() > maxFlightPrice) {
                    itList.remove();
                }
            }
        }

        if (drpdwnAirliner.getSelectedIndex() != 0) {
            String airliner = (String) (drpdwnAirliner.getSelectedIndex() != 0 ? drpdwnAirliner.getSelectedItem() : "");
            Iterator<Flight> itAirlinerList = filteredList.iterator();
            while (itAirlinerList.hasNext()) {
                Flight flight = itAirlinerList.next();
                if (!flight.getAirliner().getAirLinerName().equalsIgnoreCase(airliner)) {
                    itAirlinerList.remove();
                }
            }
        }

        if (chkMorning.isSelected() || chkAfternoon.isSelected() || chkEvening.isSelected() || chkNight.isSelected()) {
            ArrayList<Flight> filteredFlightList = new ArrayList<>();
            String morningTime = "";
            String eveningTime = "";
            String afternoonTime = "";
            String nightTime = "";
            if (chkMorning.isSelected()) {
                morningTime = "morning";
            }
            if (chkAfternoon.isSelected()) {
                afternoonTime = "afternoon";
            }
            if (chkEvening.isSelected()) {
                eveningTime = "evening";
            }
            if (chkNight.isSelected()) {
                nightTime = "night";
            }

            for (Flight flight : filteredList) {
                if (flight.getDeparture().equalsIgnoreCase(morningTime) || flight.getDeparture().equalsIgnoreCase(afternoonTime) || flight.getDeparture().equalsIgnoreCase(eveningTime) || flight.getDeparture().equalsIgnoreCase(nightTime)) {
                    filteredFlightList.add(flight);
                }
            }

            filteredList = filteredFlightList;
        }
        return filteredList;

    }

    private boolean validateSearchFilters() {
        String validationMsg = "";
        String source = txtSource.getText();
        String destination = txtDestination.getText();
        String dateOfTravel = txtDate.getText();
        String minPrice = txtMinPrice.getText();
        String maxPrice = txtMaxPrice.getText();

        if (source == null || source.equals("")) {
            validationMsg += "Source field can not be empty.\n";
        }
        if (destination == null || destination.equals("")) {
            validationMsg += "Destination field can not be empty.\n";
        }
        
        String format = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setLenient(false);
        Date travelDate = new Date();
        try {
            travelDate = sdf.parse(dateOfTravel);

        } catch (ParseException ex) {
            validationMsg += "Please enter date in correct format dd/mm/yyyy.\n";
            
        }

        /*if (dateOfTravel == null || dateOfTravel.equals("")) {
            validationMsg += "Date field can not be empty.\n";
        }*/

        if (!validationMsg.equals("")) {
            JOptionPane.showMessageDialog(null, "Please review the below errors : \n" + validationMsg);
            return false;
        } else {
             if ((minPrice == null || minPrice.equals("")) && (maxPrice != null && !maxPrice.equals(""))){
             JOptionPane.showMessageDialog(null, "Please enter appropriate price range.");
             return false;
             }else if  ((minPrice != null && !minPrice.equals("")) && (maxPrice == null || maxPrice.equals(""))){
             JOptionPane.showMessageDialog(null, "Please enter appropriate price range.");
             return false;
             } else if (minPrice != null && !minPrice.equals("") && maxPrice != null && !maxPrice.equals("")) {
                try {
                    double minFlightPrice = Double.parseDouble(minPrice);
                    double maxFlightPrice = Double.parseDouble(maxPrice);

                    if (minFlightPrice >= maxFlightPrice) {
                        JOptionPane.showMessageDialog(null, "Please enter appropriate price range.");
                        return false;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please enter price in correct format.");
                    return false;
                }
            }
        }
        return true;
    }

    private ArrayList<Airliner> populateAirlinerDirectory() {
        ArrayList<Airliner> airliner = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            Airliner a = new Airliner();
            a.setAirLinerName("Airliner_" + i);
            a.setNoOfFlights(i);

            airliner.add(a);
        }
        return airliner;
    }

    private ArrayList<Flight> populateFlightDirectory() {
        ArrayList<Flight> a = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Flight flight = new Flight();
            flight.setAirliner("Airliner_" + (i % 3));
            flight.setArrival("Arrival_" + i);
            flight.setDate("Date_" + (i % 2));

            flight.setDeparture((i < 3) ? "Morning" : (i < 6) ? "Afternoon" : (i < 8) ? "Evening" : "Night");

            flight.setDestination("Destination_" + (i % 2));
            flight.setFlightID("FlightNo_" + i);
            flight.setFlightcharges(((10 - i) * 100));
            flight.setHalts(i);
            flight.setSource("Source_" + (i % 2));

            a.add(flight);
        }
        return a;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHeader = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnSearchDeal = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFlightDetails = new javax.swing.JTable();
        btnBook = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtSource = new javax.swing.JTextField();
        txtDestination = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        chkMorning = new javax.swing.JCheckBox();
        chkAfternoon = new javax.swing.JCheckBox();
        chkEvening = new javax.swing.JCheckBox();
        chkNight = new javax.swing.JCheckBox();
        btnSearchFilter = new javax.swing.JButton();
        txtDate = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        drpdwnAirliner = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtMinPrice = new javax.swing.JTextField();
        btnBookingHistory = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtMaxPrice = new javax.swing.JTextField();
        btnClearSearch = new javax.swing.JButton();
        logoutJButton = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(900, 600));

        lblHeader.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setText("Welcome");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Search for the flights based on the below filters");

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));

        btnSearchDeal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSearchDeal.setText("SEARCH BEST DEALS");
        btnSearchDeal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchDealActionPerformed(evt);
            }
        });

        tblFlightDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Airliner ", "Flight No.", "Source", "Destination", "Date", "Time", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblFlightDetails);
        if (tblFlightDetails.getColumnModel().getColumnCount() > 0) {
            tblFlightDetails.getColumnModel().getColumn(0).setResizable(false);
            tblFlightDetails.getColumnModel().getColumn(1).setResizable(false);
            tblFlightDetails.getColumnModel().getColumn(2).setResizable(false);
            tblFlightDetails.getColumnModel().getColumn(3).setResizable(false);
            tblFlightDetails.getColumnModel().getColumn(4).setResizable(false);
            tblFlightDetails.getColumnModel().getColumn(5).setResizable(false);
            tblFlightDetails.getColumnModel().getColumn(6).setResizable(false);
        }

        btnBook.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBook.setText("Book Flight");
        btnBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookActionPerformed(evt);
            }
        });

        btnView.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnView.setText("View Details");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        jLabel2.setText("Date : ");

        jLabel3.setText("Source : ");

        jLabel4.setText("Destination :");

        jLabel5.setText("Time : ");

        chkMorning.setText("Morning");

        chkAfternoon.setText("Afternoon");

        chkEvening.setText("Evening");
        chkEvening.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkEveningActionPerformed(evt);
            }
        });

        chkNight.setText("Night");

        btnSearchFilter.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSearchFilter.setText("SEARCH BY FILTER");
        btnSearchFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchFilterActionPerformed(evt);
            }
        });

        jLabel6.setText("Airliner : ");

        drpdwnAirliner.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        drpdwnAirliner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drpdwnAirlinerActionPerformed(evt);
            }
        });

        jLabel7.setText("Price Range : ");

        btnBookingHistory.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnBookingHistory.setText("Booking History");
        btnBookingHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookingHistoryActionPerformed(evt);
            }
        });

        jLabel8.setText("to");

        btnClearSearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnClearSearch.setText("CLEAR SEARCH");
        btnClearSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearSearchActionPerformed(evt);
            }
        });

        logoutJButton.setText("Logout");
        logoutJButton.setEnabled(false);
        logoutJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutJButtonActionPerformed(evt);
            }
        });

        btnLogout.setText("Log out");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnBookingHistory)
                        .addGap(42, 42, 42)
                        .addComponent(btnView)
                        .addGap(40, 40, 40)
                        .addComponent(btnBook, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(132, 132, 132)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(161, 161, 161)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtSource, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(chkMorning)
                                                .addGap(18, 18, 18)
                                                .addComponent(chkAfternoon)
                                                .addGap(18, 18, 18)
                                                .addComponent(chkEvening)
                                                .addGap(18, 18, 18)
                                                .addComponent(chkNight))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(txtDate, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtDestination, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(drpdwnAirliner, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(287, 287, 287)
                                                .addComponent(btnClearSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMinPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(11, 11, 11)
                                        .addComponent(txtMaxPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(124, 124, 124)
                                .addComponent(btnSearchDeal)
                                .addGap(28, 28, 28)
                                .addComponent(btnSearchFilter)))
                        .addGap(0, 312, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnLogout)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(372, 372, 372)
                    .addComponent(logoutJButton, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                    .addGap(373, 373, 373)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogout))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSource, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDestination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(chkMorning)
                    .addComponent(chkAfternoon)
                    .addComponent(chkEvening)
                    .addComponent(chkNight))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(drpdwnAirliner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtMinPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtMaxPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearchDeal)
                    .addComponent(btnSearchFilter)
                    .addComponent(btnClearSearch))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBook, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnView)
                        .addComponent(btnBookingHistory)))
                .addGap(384, 384, 384))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(468, 468, 468)
                    .addComponent(logoutJButton)
                    .addContainerGap(509, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void chkEveningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkEveningActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkEveningActionPerformed

    private void btnSearchFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchFilterActionPerformed
        // TODO add your handling code here:
        //Validations
        boolean validationFlag = validateSearchFilters();

        if (!validationFlag) {
            return;
        }

//        //Eshanee Hack to eliminate flight creation
//        String source = "Source_" + txtSource.getText();
//        String destination = "Destination_" + txtDestination.getText();
//        String dateOfTravel = "Date_" + txtDate.getText();
//        ArrayList<Flight> filteredList = populateFlights(source, destination, dateOfTravel);

        ArrayList<Flight> filteredList = populateFlights(txtSource.getText(), txtDestination.getText(), txtDate.getText());

        DefaultTableModel dtm = (DefaultTableModel) tblFlightDetails.getModel();
        dtm.setRowCount(0);

        for (Flight flight : filteredList) {
            Object[] row = new Object[dtm.getColumnCount()];
            row[0] = flight;
            row[1] = flight.getFlightID();
            row[2] = flight.getSource();
            row[3] = flight.getDestination();
            row[4] = flight.getDate();
            row[5] = flight.getDeparture();
            row[6] = flight.getFlightcharges();

            dtm.addRow(row);
        }

    }//GEN-LAST:event_btnSearchFilterActionPerformed

    private void btnSearchDealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchDealActionPerformed
        // TODO add your handling code here:
        //Validations
        boolean validationFlag = validateSearchFilters();

        if (!validationFlag) {
            return;
        }

        ArrayList<Flight> filteredList = populateFlights(txtSource.getText(), txtDestination.getText(), txtDate.getText());

        //Sort function for the best price 
        Collections.sort(filteredList);

        DefaultTableModel dtm = (DefaultTableModel) tblFlightDetails.getModel();
        dtm.setRowCount(0);

        for (Flight flight : filteredList) {
            Object[] row = new Object[dtm.getColumnCount()];
            row[0] = flight;
            row[1] = flight.getFlightID();
            row[2] = flight.getSource();
            row[3] = flight.getDestination();
            row[4] = flight.getDate();
            row[5] = flight.getDeparture();
            row[6] = flight.getFlightcharges();
            dtm.addRow(row);
        }
    }//GEN-LAST:event_btnSearchDealActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblFlightDetails.getSelectedRow();

        if (selectedRow >= 0) {
            Flight flight = (Flight) tblFlightDetails.getValueAt(selectedRow, 0);
            CustomerViewScreen flightViewPanel = new CustomerViewScreen(this.rightPanel, flight);
            this.rightPanel.add("ViewFlightDetails", flightViewPanel);
            CardLayout layout = (CardLayout) this.rightPanel.getLayout();
            layout.next(rightPanel);

        } else {
            JOptionPane.showMessageDialog(null, "Please select a row for viewing the details.");
        }
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblFlightDetails.getSelectedRow();

        if (selectedRow >= 0) {
            Flight flight = (Flight) tblFlightDetails.getValueAt(selectedRow, 0);
            CustomerBookFlight flightBookPanel = new CustomerBookFlight(this.rightPanel, flight, customer, bookingDirectory);
            this.rightPanel.add("BookFlight", flightBookPanel);
            CardLayout layout = (CardLayout) this.rightPanel.getLayout();
            layout.next(rightPanel);

        } else {
            JOptionPane.showMessageDialog(null, "Please select a flight to proceed to booking.");
        }
    }//GEN-LAST:event_btnBookActionPerformed

    private void btnBookingHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookingHistoryActionPerformed
        // TODO add your handling code here:
        CustomerBookingHistory bookingHistoryPanel = new CustomerBookingHistory(this.rightPanel, flightDirectory, customer, bookingDirectory);
        this.rightPanel.add("BookingHistory", bookingHistoryPanel);
        CardLayout layout = (CardLayout) this.rightPanel.getLayout();
        layout.next(rightPanel);
    }//GEN-LAST:event_btnBookingHistoryActionPerformed

    private void btnClearSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearSearchActionPerformed
        // TODO add your handling code here:
        txtSource.setText("");
        txtDestination.setText("");
        txtDate.setText("");
        txtMinPrice.setText("");
        txtMaxPrice.setText("");
        drpdwnAirliner.setSelectedIndex(0);
        chkAfternoon.setSelected(false);
        chkMorning.setSelected(false);
        chkNight.setSelected(false);
        chkEvening.setSelected(false);

        DefaultTableModel dtm = (DefaultTableModel) tblFlightDetails.getModel();
        dtm.setRowCount(0);


    }//GEN-LAST:event_btnClearSearchActionPerformed

    private void drpdwnAirlinerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drpdwnAirlinerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_drpdwnAirlinerActionPerformed

    private void logoutJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutJButtonActionPerformed
    }//GEN-LAST:event_logoutJButtonActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        this.rightPanel.remove(this);
        CardLayout layout = (CardLayout) this.rightPanel.getLayout();

        Component[] comps = MainFrame.getFrames();
        for (Component comp : comps) {
            if (comp instanceof MainFrame) {
                MainFrame mainFrame = (MainFrame) comp;
                mainFrame.initialize();
            }
        }

        layout.previous(rightPanel);
    }//GEN-LAST:event_btnLogoutActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBook;
    private javax.swing.JButton btnBookingHistory;
    private javax.swing.JButton btnClearSearch;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnSearchDeal;
    private javax.swing.JButton btnSearchFilter;
    private javax.swing.JButton btnView;
    private javax.swing.JCheckBox chkAfternoon;
    private javax.swing.JCheckBox chkEvening;
    private javax.swing.JCheckBox chkMorning;
    private javax.swing.JCheckBox chkNight;
    private javax.swing.JComboBox<String> drpdwnAirliner;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JButton logoutJButton;
    private javax.swing.JTable tblFlightDetails;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtDestination;
    private javax.swing.JTextField txtMaxPrice;
    private javax.swing.JTextField txtMinPrice;
    private javax.swing.JTextField txtSource;
    // End of variables declaration//GEN-END:variables
}
