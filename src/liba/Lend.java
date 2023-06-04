/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liba;
import java.util.Date;
import java.text.ParseException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;


public class Lend extends javax.swing.JFrame {
 private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox txtbook;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtname;
    private com.toedter.calendar.JDateChooser txtrdate;
    private com.toedter.calendar.JDateChooser txttdate;
    
    public Lend() {
        initComponents();
        Connect();
        
        Book();
       
        table_update();
    }
     Connection con;
    PreparedStatement pst;
     ResultSet rs;
    
public class BookItem {
    int id;
    String name;

    public BookItem(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return name;
    }
}

      
      

   
   

   
   
   
   
   
   
    
    

    
    
     public void Connect()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
              con = DriverManager.getConnection("jdbc:mysql://localhost/slibrary","root","");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Publisher.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Publisher.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        
    }
    
       
    
        private void Book()
    {

        try {
          
            pst = con.prepareStatement("select * from book");
            ResultSet rs = pst.executeQuery();
            txtbook.removeAllItems();
            
            while(rs.next())
            {                
                txtbook.addItem(new BookItem(rs.getInt(1),rs.getString(2)) );    
            }             
        }  catch (SQLException ex) {
            Logger.getLogger(Lend.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    
  
    
    
     private void table_update()
    {
       
            int c;
            try {
               
                 pst = con.prepareStatement("SELECT l.id,m.id,b.bname,l.issuedate,l.returndate FROM lend l JOIN member m ON l.memberid = m.id JOIN book b ON b.id = l.bookid ");
                 ResultSet rs = pst.executeQuery();
                 
                 ResultSetMetaData rsd = rs.getMetaData();
                 c = rsd.getColumnCount();
                 
                 DefaultTableModel d = (DefaultTableModel)jTable1.getModel();
                 d.setRowCount(0);
                                 
                 while(rs.next())
                 {
                     Vector v2 = new Vector(); 
                     for(int i=1; i<=c; i++)
                     {
                         v2.add(rs.getString("l.id"));
                         v2.add(rs.getString("m.id"));
                            v2.add(rs.getString("b.bname"));
                         v2.add(rs.getString("l.issuedate"));  
                         v2.add(rs.getString("l.returndate"));
                         
                     }             
                     d.addRow(v2);
                     
                 }
        } catch (SQLException ex) {
            Logger.getLogger(author.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtbook = new javax.swing.JComboBox();
        txtid = new javax.swing.JTextField();
        txtname = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txttdate = new com.toedter.calendar.JDateChooser();
        txtrdate = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Book", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jLabel9.setText("Member ID");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Member ID", "Book", "Issue Date", "Return Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel11.setText("Book");

        jLabel13.setText("Date");

        jLabel14.setText("Return");

        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });
        txtid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtidKeyPressed(evt);
            }
        });

        jLabel10.setText("Member Name");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10))
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtid)
                    .addComponent(txtname)
                    .addComponent(txtbook, 0, 285, Short.MAX_VALUE)
                    .addComponent(txttdate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtrdate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addGap(31, 31, 31))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtbook)
                        .addGap(28, 28, 28)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(txttdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14)
                    .addComponent(txtrdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(296, 296, 296))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Issue Book");

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Cancel");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(463, 463, 463)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {

            String id = txtid.getText();

            try {
                pst = con.prepareStatement("select * from member where id=?");
                pst.setString(1, id);
                ResultSet rs = pst.executeQuery();
                  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
             Date currentDate = new Date();
            String date = dateFormat.format(currentDate);
             txttdate.setDate(currentDate);


                if(rs.next()==false)
                {
                    JOptionPane.showMessageDialog(this,"Member ID not Found");
                }
                else
                {
                    String productname = rs.getString("name");

                    txtname.setText(productname.trim());

                }
            } catch (SQLException ex) {
                Logger.getLogger(Lend.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }//GEN-LAST:event_txtidKeyPressed

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtidActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
     
    DefaultTableModel d1 = (DefaultTableModel) jTable1.getModel();
    int selectIndex = jTable1.getSelectedRow();

    txtid.setText(d1.getValueAt(selectIndex, 1).toString());
    String idStr = txtid.getText();
    int id = Integer.parseInt(idStr); // Parse the string to an integer
    try {
        pst = con.prepareStatement("SELECT * FROM member WHERE id = ?");
        pst.setInt(1, id); // Set the integer value to the prepared statement
        ResultSet rs = pst.executeQuery();
        if (rs.next()) {
            String productname = rs.getString("name");
            txtname.setText(productname);
        }
    } catch (SQLException ex) {
        Logger.getLogger(Lend.class.getName()).log(Level.SEVERE, null, ex);
    }

    
    
    String selectedCategory = d1.getValueAt(selectIndex, 2).toString();
for (int i = 0; i < txtbook.getItemCount(); i++) {
    if (txtbook.getItemAt(i).toString().equals(selectedCategory)) {
        txtbook.setSelectedIndex(i);
        break;
    }
}

String dateStr = d1.getValueAt(selectIndex, 3).toString(); // assuming date is in the fifth column
SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); // the format of your date string
try {
    Date date = format.parse(dateStr);
    txttdate.setDate(date); // set the date to the JCalendar field
} catch (ParseException ex) {
    Logger.getLogger(Lend.class.getName()).log(Level.SEVERE, null, ex);
}

String dateStr2 = d1.getValueAt(selectIndex, 4).toString(); // assuming date is in the sixth column
SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd"); // the format of your date string
try {
    Date date2 = format2.parse(dateStr2);
    txtrdate.setDate(date2); // set the date to the JCalendar field
} catch (ParseException ex) {
    Logger.getLogger(Lend.class.getName()).log(Level.SEVERE, null, ex);
}

 
    
   




   

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
    int selectIndex = jTable1.getSelectedRow();
        int id = Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());

        int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to Delete the Record","Warning",JOptionPane.YES_NO_OPTION);

        if(dialogResult == JOptionPane.YES_OPTION)
        {

            try {
                pst = con.prepareStatement("delete from lend where id =?");
                pst.setInt(1, id);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null,"record Deletedd");
                table_update();
                txtname.setText("");
            txtbook.setSelectedIndex(-1);
            
            txttdate.setDate(null); 
            txtrdate.setDate(null); 
        
            txtname.requestFocus();
            txtname.requestFocus();
            } catch (SQLException ex) {
                Logger.getLogger(author.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    // TODO add your handling code here:
    DefaultTableModel d1 = (DefaultTableModel)jTable1.getModel();
    int selectIndex = jTable1.getSelectedRow();
    int id = Integer.parseInt(d1.getValueAt(selectIndex, 0).toString());
    String idm = txtid.getText();
    BookItem book = (BookItem) txtbook.getSelectedItem();
    String txttdateStr = "";
    String txtrdateStr = "";
    try {
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format2 = new SimpleDateFormat("MM/dd/yyyy");

        Date date = txttdate.getDate(); 
        txttdateStr = format1.format(date);

        Date dater = txtrdate.getDate(); 
        txtrdateStr = format1.format(dater);

        PreparedStatement pst = con.prepareStatement("update lend set memberid=?, bookid=?, issuedate=?, returndate=? where id= ?");
        pst.setString(1, idm);
        pst.setInt(2, book.getId());
        pst.setString(3, txttdateStr);
        pst.setString(4, txtrdateStr);
        pst.setInt(5, id);
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null, "Record updated successfully");
        table_update();
        txtid.setText("");
        txtname.setText("");
        txtbook.setSelectedIndex(0); // Set the selected book to the first item in the list
        txttdate.setDate(null);
        txtrdate.setDate(null);
    } catch (SQLException ex) {
        Logger.getLogger(Lend.class.getName()).log(Level.SEVERE, null, ex);
    } 






    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                                        
    // TODO add your handling code here:
    String idm = txtid.getText();
    int id = Integer.parseInt(idm);
     try {
         pst = con.prepareStatement("SELECT id FROM lend WHERE memberid = ?");
     } catch (SQLException ex) {
         Logger.getLogger(Lend.class.getName()).log(Level.SEVERE, null, ex);
     }
     try {
         pst.setInt(1, id);
     } catch (SQLException ex) {
         Logger.getLogger(Lend.class.getName()).log(Level.SEVERE, null, ex);
     }
     
    ResultSet rs = null;
    try {
        rs = pst.executeQuery();
        ResultSetMetaData rsd = rs.getMetaData();
        int c = rsd.getColumnCount();
        if (rs.next()) {
            JOptionPane.showMessageDialog(null, "This member already has a book.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            BookItem book = (BookItem) txtbook.getSelectedItem();

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date currentDate = new Date();
            String date = dateFormat.format(currentDate);
             

            SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
            Date otherDate = txtrdate.getDate(); 
            String date1 = dateFormat1.format(otherDate);
            if (currentDate.compareTo(otherDate) > 0) {
                JOptionPane.showMessageDialog(null, "Return date is in the past.", "Error", JOptionPane.ERROR_MESSAGE);
                 
            } else { 

                try {
                    pst = con.prepareStatement("INSERT INTO lend (memberid, bookid, issuedate, returndate) VALUES (?, ?, ?, ?)");
                    pst.setString(1, idm);
                    pst.setInt(2, book.id);
                    pst.setString(3, date);
                    pst.setString(4, date1);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Book ISSUED");
                    table_update();
                    txtid.setText("");
                    txtbook.setSelectedIndex(-1);
                    txtname.requestFocus();
                    table_update();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error executing query: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    Logger.getLogger(Lend.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error retrieving data from database: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        Logger.getLogger(Lend.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(Lend.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }


    

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
          this.setVisible(false) ; }
    }//GEN-LAST:event_jButton4ActionPerformed

    
    /*
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox txtbook;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtname;
    private com.toedter.calendar.JDateChooser txtrdate;
    private com.toedter.calendar.JDateChooser txttdate;
    // End of variables declaration//GEN-END:variables
}
*/