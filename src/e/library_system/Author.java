/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e.library_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dell
 */
public class Author extends javax.swing.JFrame {

    /**
     * Creates new form Author
     */
    public Author() {
        initComponents();
    }

      private static final String username ="root"; 
   private static final String password ="Campmake96"; 
   private static final String dataconnect ="jdbc:mysql://localhost:3306/e-library_system"; 
   
    Connection connect = null;
    PreparedStatement pst =null;
    ResultSet rs = null;
    DefaultTableModel de;
     int q ,i ,id ;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    public void updateDB() 
    {
    try
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connect =DriverManager.getConnection(dataconnect ,username ,password);
        pst =connect.prepareStatement("Select * from author");
        rs = pst.executeQuery();
        java.sql.ResultSetMetaData stdata = rs.getMetaData();
         q = stdata.getColumnCount();
         
         
          DefaultTableModel RecordTable =(DefaultTableModel)jTable1.getModel();
         RecordTable.setRowCount(0);
        while(rs.next())
        {
        Vector columbaData = new Vector();
        
      
        for(i =1;i <=q ;i++)
        {
        columbaData.add(rs.getString("idauthor"));
        columbaData.add(rs.getString("Name"));
        columbaData.add(rs.getString("Address"));
        columbaData.add(rs.getString("Phone"));
        
        
        
        }

        RecordTable.addRow(columbaData);
        
        }
        
        
    }  catch (Exception ex) {
           JOptionPane.showMessageDialog(null, "error");
       }
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        NameAuthor = new javax.swing.JTextField();
        AddressAuthor = new javax.swing.JTextField();
        PhoneAuthor = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        AddAuth = new javax.swing.JButton();
        UpdateAuth = new javax.swing.JButton();
        DeleteAuth = new javax.swing.JButton();
        CancelAuth = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Author");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Name :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Address :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Phone :");

        jTable1.setBackground(new java.awt.Color(204, 204, 204));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Address", "Phone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        AddAuth.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        AddAuth.setText("Add");
        AddAuth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddAuthActionPerformed(evt);
            }
        });

        UpdateAuth.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        UpdateAuth.setText("Update");
        UpdateAuth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateAuthActionPerformed(evt);
            }
        });

        DeleteAuth.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        DeleteAuth.setText("Delete");
        DeleteAuth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteAuthActionPerformed(evt);
            }
        });

        CancelAuth.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        CancelAuth.setText("Cancel");
        CancelAuth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelAuthActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2))
                            .addGap(29, 29, 29)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(NameAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(AddressAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(PhoneAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(37, 37, 37)
                            .addComponent(AddAuth)
                            .addGap(54, 54, 54)
                            .addComponent(UpdateAuth)
                            .addGap(48, 48, 48)
                            .addComponent(DeleteAuth)
                            .addGap(77, 77, 77)
                            .addComponent(CancelAuth))))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(NameAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(AddressAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(PhoneAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddAuth)
                    .addComponent(UpdateAuth)
                    .addComponent(DeleteAuth)
                    .addComponent(CancelAuth))
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel RecordTable = (DefaultTableModel)jTable1.getModel();
        int SelcetedRow = jTable1.getSelectedRow();

        NameAuthor.setText(RecordTable.getValueAt(jTable1.getSelectedRow(), 1).toString());
        AddressAuthor.setText(RecordTable.getValueAt(jTable1.getSelectedRow(), 2).toString());
        PhoneAuthor.setText(RecordTable.getValueAt(jTable1.getSelectedRow(), 3).toString());
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void UpdateAuthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateAuthActionPerformed
           try
        {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connect = DriverManager.getConnection(dataconnect ,username ,password);
        de =(DefaultTableModel)jTable1.getModel();
        int selected =jTable1.getSelectedRow();
        id =Integer.parseInt(de.getValueAt(selected, 0).toString());
        pst = connect.prepareStatement("update author set   Name = ?, Address =?, Phone=? where idauthor =? ");
      
        
        
            
            pst.setString(1, NameAuthor.getText());
            pst.setString(2, AddressAuthor.getText());
            pst.setString(3, PhoneAuthor.getText());
            pst.setInt(4, id);
            
            

        pst.executeUpdate();
        updateDB();
        JOptionPane.showMessageDialog(this, "Successfully updated");
        
        }
           catch(Exception as)
           {
               System.out.println(as);
           JOptionPane.showMessageDialog(null, "Erooor");
           }
 
                                        
    }//GEN-LAST:event_UpdateAuthActionPerformed

    private void CancelAuthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelAuthActionPerformed
        setVisible(false);
        Menu m = new Menu();
        m.setVisible(true);
    }//GEN-LAST:event_CancelAuthActionPerformed

    private void AddAuthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddAuthActionPerformed
            try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect =DriverManager.getConnection(dataconnect ,username ,password);
            pst =connect.prepareStatement("insert into author ( Name, Address, Phone) value(?,?,?)");

          
            
            
            
            //Storing
            pst.setString(1, NameAuthor.getText());
            pst.setString(2,AddressAuthor.getText());
            pst.setString(3, PhoneAuthor.getText());
            
            
            
            
            pst.executeUpdate();

            
           JOptionPane.showMessageDialog(null, "The Author has sucessfully added");
           updateDB();
            
           
            
            
            
        }catch(Exception ex)
        {
            System.out.println(ex);
            
        }
                                         

    }//GEN-LAST:event_AddAuthActionPerformed

    private void DeleteAuthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteAuthActionPerformed
        de =(DefaultTableModel)jTable1.getModel();
        int selected =jTable1.getSelectedRow();
        id =Integer.parseInt(de.getValueAt(selected, 0).toString());
       
        
        try{
        pst =connect.prepareStatement("Delete from  author   where idauthor =?");
        pst.setInt(1, id);
        //int rowsAffected = stmt.executeUpdate(deleteQuery);
        pst.executeUpdate();
        updateDB();
        JOptionPane.showMessageDialog(null,"Record deleted");
        
        
            NameAuthor.setText("");
            AddressAuthor.setText("");
            PhoneAuthor.setText("");
            
        
           // pst.executeQuery();
            
        
        }
        catch(Exception a){
        JOptionPane.showMessageDialog(null, a);
            System.out.println(a);
        }
    }//GEN-LAST:event_DeleteAuthActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Author.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Author.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Author.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Author.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Author().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddAuth;
    private javax.swing.JTextField AddressAuthor;
    private javax.swing.JButton CancelAuth;
    private javax.swing.JButton DeleteAuth;
    private javax.swing.JTextField NameAuthor;
    private javax.swing.JTextField PhoneAuthor;
    private javax.swing.JButton UpdateAuth;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
