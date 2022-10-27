import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class YummyPizza_Roster extends javax.swing.JFrame {


    public YummyPizza_Roster() {
        initComponents();
        Connect();
        Fetch();
        LoadEmployeeIds();
        LoadRosterIndexes();
    }
Connection con;
PreparedStatement pst;
ResultSet rs;


//Define connection to MySQL Database
public void Connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/rostermanagement","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(YummyPizza_Roster.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(YummyPizza_Roster.class.getName()).log(Level.SEVERE, null, ex);
        }
}

//Load all the Ids of listed employees in Employee Code dropdown to perform employee search
public void LoadEmployeeIds(){
    
        try {
            pst=con.prepareStatement("SELECT EmpId from employees");
            rs=pst.executeQuery();
            empCode.removeAllItems();
            empCode.addItem("Select Employee ID");
            while(rs.next()){
                empCode.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(YummyPizza_Roster.class.getName()).log(Level.SEVERE, null, ex);
        }
}

//Fetch and Display the roster details in a table
public void Fetch(){
    try {
            int q;
            pst = con.prepareStatement("SELECT * FROM roster");
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            q = rss.getColumnCount();
            
            DefaultTableModel df = (DefaultTableModel)jTable1.getModel();
            df.setRowCount(0);
            while(rs.next()){
            Vector v2 = new Vector();
            for (int a=1;a<=1;a++){
                v2.add(rs.getString("Id"));
                v2.add(rs.getString("EmpId"));
                v2.add(rs.getString("EmpName"));
                v2.add(rs.getString("Date"));
                v2.add(rs.getString("Shift_Start"));
                v2.add(rs.getString("Shift_End"));
                v2.add(rs.getString("Role"));
            }
            df.addRow(v2);
        }
        } catch (SQLException ex) {
            Logger.getLogger(YummyPizza_Roster.class.getName()).log(Level.SEVERE, null, ex);
        }
}


//Load all the Indexes in Roster table in a dropdown to perform search, update and delete using the roster id
public void LoadRosterIndexes(){
    
        try {
            pst=con.prepareStatement("SELECT Id from roster");
            rs=pst.executeQuery();
            rosterIndex.removeAllItems();
            rosterIndex.addItem("Select Roster Index");
            while(rs.next()){
                rosterIndex.addItem(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(YummyPizza_Roster.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        empCode = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        empName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        empRole = new javax.swing.JTextField();
        start = new com.github.lgooddatepicker.components.TimePicker();
        end = new com.github.lgooddatepicker.components.TimePicker();
        searchEmployee = new javax.swing.JButton();
        add = new javax.swing.JButton();
        rosterIndex = new javax.swing.JComboBox<>();
        searchIndex = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        shiftDate = new com.github.lgooddatepicker.components.DatePicker();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Yummy Pizza Roster");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 51));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("Employee Code");
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        empCode.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        empCode.setBackground(new java.awt.Color(204, 204, 204));
        empCode.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        empCode.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel3.setText("Employee Name");
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        empName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        empName.setBackground(new java.awt.Color(204, 204, 204));
        empName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setText("Shift Date");
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel5.setText("Shift Start");
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel6.setText("Shift End");
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jLabel8.setText("Role");
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        empRole.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        empRole.setBackground(new java.awt.Color(204, 204, 204));
        empRole.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        start.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        start.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        end.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        end.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        searchEmployee.setText("Search ");
        searchEmployee.setBackground(new java.awt.Color(204, 204, 255));
        searchEmployee.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        searchEmployee.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        searchEmployee.setForeground(new java.awt.Color(0, 102, 51));
        searchEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchEmployeeActionPerformed(evt);
            }
        });

        add.setText("Add");
        add.setBackground(new java.awt.Color(204, 204, 255));
        add.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        add.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        add.setForeground(new java.awt.Color(0, 102, 102));
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        rosterIndex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        rosterIndex.setBackground(new java.awt.Color(204, 204, 204));
        rosterIndex.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        rosterIndex.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        searchIndex.setText("Search");
        searchIndex.setBackground(new java.awt.Color(204, 204, 255));
        searchIndex.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        searchIndex.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        searchIndex.setForeground(new java.awt.Color(0, 102, 102));
        searchIndex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchIndexActionPerformed(evt);
            }
        });

        update.setText("Update");
        update.setBackground(new java.awt.Color(204, 204, 255));
        update.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        update.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        update.setForeground(new java.awt.Color(0, 102, 102));
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        delete.setText("Delete");
        delete.setBackground(new java.awt.Color(204, 204, 255));
        delete.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        delete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        delete.setForeground(new java.awt.Color(0, 102, 102));
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        shiftDate.setBackground(new java.awt.Color(204, 204, 204));
        shiftDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        shiftDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel7.setText("Add/Edit/Remove Roster Details for selected Employee:");
        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 102));

        jLabel9.setText("Search for Employee to Add:");
        jLabel9.setFont(new java.awt.Font("Segoe UI", 3, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(empName)
                            .addComponent(empRole)
                            .addComponent(empCode, 0, 186, Short.MAX_VALUE))
                        .addGap(103, 103, 103))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(shiftDate, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(87, 87, 87)
                                .addComponent(jLabel5))
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(96, 96, 96)
                                .addComponent(rosterIndex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(searchIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(71, 71, 71))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(end, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(49, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(617, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(empCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchEmployee))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(empName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(empRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(shiftDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(end, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delete)
                    .addComponent(add)
                    .addComponent(rosterIndex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchIndex)
                    .addComponent(update))
                .addGap(334, 334, 334))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(jLabel9)
                    .addContainerGap(649, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 707, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 273, Short.MAX_VALUE)
        );

        jTable1.setBorder(new javax.swing.border.MatteBorder(null));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Roster Id", "Emp Code", "Emp Name", "Date", "Shift Start", "Shift End", "Role"
            }
        ));
        jTable1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(316, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(320, 320, 320)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(166, 166, 166)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1169, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
//Search employee by employee code on click of Search button
    private void searchEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchEmployeeActionPerformed
       try {
           String selected_item =empCode.getSelectedItem().toString();
            pst = con.prepareStatement("SELECT EmpName,Role FROM employees WHERE EmpId=?");
            pst.setString(1, selected_item);
            rs=pst.executeQuery();
            
            if(rs.next()==true){
                empName.setText(rs.getString(1));
                empRole.setText(rs.getString(2));
                empName.setEditable(false);
                empRole.setEditable(false);

            }
            else{
                JOptionPane.showMessageDialog(this,"No record found");
            }
        } catch (SQLException ex) {
            Logger.getLogger(YummyPizza_Roster.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_searchEmployeeActionPerformed

// Add employee and shift details in the roster table
    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed

           try {
            
            String eName = empName.getText();
            String eRole = empRole.getText();

            String sDate = shiftDate.getText();
            String eCode = empCode.getSelectedItem().toString();
            String shiftStart = start.getText();
            String shiftEnd = end.getText();
            
            
            pst=con.prepareStatement("INSERT INTO roster (EmpId,EmpName,Date,Shift_Start,Shift_End,Role)VALUES(?,?,?,?,?,?)");
            pst.setString(1,eCode);
            pst.setString(2,eName);
            pst.setString(3,sDate);
            pst.setString(4,shiftStart);
            pst.setString(5,shiftEnd);
            pst.setString(6,eRole);
            
            int k = pst.executeUpdate();
            
            if(k==1){
                JOptionPane.showMessageDialog(this,"Record Added");
                empName.setText("");
                empRole.setText("");
                shiftDate.setText("");
                start.setText("");
                end.setText("");
                Fetch();
                LoadEmployeeIds();
                LoadRosterIndexes();
            }
            else{
                JOptionPane.showMessageDialog(this,"Record Failed to save");
            }
        } catch (SQLException ex) {
            Logger.getLogger(YummyPizza_Roster.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addActionPerformed

    
//Search roster of a particular employee using unique roster index on click of Search button
    private void searchIndexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchIndexActionPerformed
        try {
           String selected_item =rosterIndex.getSelectedItem().toString();
            pst = con.prepareStatement("SELECT * FROM roster WHERE Id=?");
            pst.setString(1, selected_item);
            rs=pst.executeQuery();
            
            if(rs.next()==true){
                empName.setText(rs.getString(3));
                shiftDate.setText(rs.getString(4));
                start.setText(rs.getString(5));
                end.setText(rs.getString(6));
                empRole.setText(rs.getString(7));
                empName.setEditable(false);
                empRole.setEditable(false);

            }
            else{
                JOptionPane.showMessageDialog(this,"No record found");
            }
        } catch (SQLException ex) {
            Logger.getLogger(YummyPizza_Roster.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchIndexActionPerformed

//Update the roster of particular employee using roster index
    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
try {

            String sDate = (shiftDate.getText());
            String shiftStart = start.getText();
            String shiftEnd = end.getText();
            String rid=rosterIndex.getSelectedItem().toString();
            
            pst = con.prepareStatement("UPDATE roster SET Date=?,Shift_Start=?,Shift_End=? WHERE Id=?");
            pst.setString(1,sDate);
            pst.setString(2,shiftStart);
            pst.setString(3,shiftEnd);
            pst.setString(4,rid);
            
            int k = pst.executeUpdate();
            if(k==1){
                JOptionPane.showMessageDialog(this,"Record successfully updated");
                empName.setText("");
                empRole.setText("");
                shiftDate.setText("");
                start.setText("");
                end.setText("");
                Fetch();
                LoadEmployeeIds();
                LoadRosterIndexes();
            }
            else{
                JOptionPane.showMessageDialog(this,"Failed to update record");
            }
        } catch (SQLException ex) {
            Logger.getLogger(YummyPizza_Roster.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }//GEN-LAST:event_updateActionPerformed

    
//Delete the roster of particular employee using roster index
    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
try {
                      
            String rid = rosterIndex.getSelectedItem().toString();
            pst = con.prepareStatement("DELETE FROM roster WHERE Id=?");
            pst.setString(1, rid);
            
            int k = pst.executeUpdate();
            if(k==1){
                 JOptionPane.showMessageDialog(this,"Record has been deleted successfully");
                empName.setText("");
                empRole.setText("");
                shiftDate.setText("");
                start.setText("");
                end.setText("");
                Fetch();
                LoadEmployeeIds();
                LoadRosterIndexes();
            }else{
                JOptionPane.showMessageDialog(this,"Record failed to delete");
            }
        } catch (SQLException ex) {
            Logger.getLogger(YummyPizza_Roster.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }//GEN-LAST:event_deleteActionPerformed


    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(YummyPizza_Roster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(YummyPizza_Roster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(YummyPizza_Roster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(YummyPizza_Roster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);  //Don't allow unauthorized user to access roster page without logging in
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton delete;
    private javax.swing.JComboBox<String> empCode;
    private javax.swing.JTextField empName;
    private javax.swing.JTextField empRole;
    private com.github.lgooddatepicker.components.TimePicker end;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> rosterIndex;
    private javax.swing.JButton searchEmployee;
    private javax.swing.JButton searchIndex;
    private com.github.lgooddatepicker.components.DatePicker shiftDate;
    private com.github.lgooddatepicker.components.TimePicker start;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
