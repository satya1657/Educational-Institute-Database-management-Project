package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Color;

public class timetableStu implements ActionListener {

	
	static String clas;
	static JFrame f;
	private JTable table;
	static DefaultTableModel model;
	static Connection myconn;
	static Statement mystmt;
	static ResultSet myrs;	
	static  PreparedStatement pstmt;
	private JButton back;
     /**
      * @wbp.parser.entryPoint
      */
     timetableStu(String st){
    	 
		clas=st;
		 try {
		     myconn=DriverManager.getConnection("jdbc:mysql://localhost:3306/result","root","Satya@1657");
		     mystmt=myconn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		
	  }catch(Exception ex) {
		  JOptionPane.showMessageDialog(f,"There is some Error in connection with database");
	  }
	    f= new JFrame(clas+"time table"); 
	    f.getContentPane().setBackground(new Color(255, 248, 220));
	    f.setSize(768,500);
	    
	    JLabel lblNewLabel = new JLabel("Time Table");
	    lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    
	    JScrollPane scrollPane = new JScrollPane();
	    
	    back = new JButton("Back");
	    back.addActionListener(this);
	    GroupLayout groupLayout = new GroupLayout(f.getContentPane());
	    groupLayout.setHorizontalGroup(
	    	groupLayout.createParallelGroup(Alignment.LEADING)
	    		.addGroup(groupLayout.createSequentialGroup()
	    			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	    				.addGroup(groupLayout.createSequentialGroup()
	    					.addGap(329)
	    					.addComponent(lblNewLabel))
	    				.addGroup(groupLayout.createSequentialGroup()
	    					.addGap(29)
	    					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	    						.addComponent(back, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
	    						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 686, GroupLayout.PREFERRED_SIZE))))
	    			.addContainerGap(37, Short.MAX_VALUE))
	    );
	    groupLayout.setVerticalGroup(
	    	groupLayout.createParallelGroup(Alignment.LEADING)
	    		.addGroup(groupLayout.createSequentialGroup()
	    			.addGap(22)
	    			.addComponent(lblNewLabel)
	    			.addGap(24)
	    			.addComponent(back)
	    			.addGap(32)
	    			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
	    			.addContainerGap(162, Short.MAX_VALUE))
	    );
	    
	    table = new JTable();
	    table.setBackground(new Color(250, 235, 215));
	    model=new DefaultTableModel(
	    	new Object[][] {
	    		{null, null, null, null},
	    	},
	    	new String[] {
	    		"Day", "9-1:30(AM)", "11:45-12:15(PM)", "1-4:30(PM)"
	    	}
	    );
	    table.setModel(model);
	    table.getColumnModel().getColumn(2).setPreferredWidth(94);
	    scrollPane.setViewportView(table);
	    f.getContentPane().setLayout(groupLayout);
	    f.setVisible(true);  
	    viewTable();
     }
     
     public static void viewTable() {
     	model.setRowCount(0);
 		try {   
 				
 			   myrs=mystmt.executeQuery("select * from "+clas+" ;");
 			   while(myrs.next()) {
 				    String brnch=myrs.getString("branch");
 				    String sec=myrs.getString("section");
 				    String day=myrs.getString("days");
 				    String fs=myrs.getString("fstsft");
 				    String ss=myrs.getString("sndsft");
 				    String al=myrs.getString("aftrlnch1");
 					model.addRow(new Object[]{ day, fs, ss, al });				
 			   }
 		}catch(Exception ex) {
 			JOptionPane.showMessageDialog(f,"There is some Error in fetching data from database");
 		}
     }
     
     public void actionPerformed(ActionEvent e){ 
    	 if(e.getSource()==back) {
			 try {
	       			
    			 JDialog.setDefaultLookAndFeelDecorated(true);
    			    int response = JOptionPane.showConfirmDialog(null, "Do you want to Go Back?", "Confirm",
    			        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    			    if (response == JOptionPane.NO_OPTION) {
    			    } else if (response == JOptionPane.YES_OPTION) {
    			    	f.dispose();
    			  	// JOptionPane.showMessageDialog(f,"Successfully deleted");
    			    } else if (response == JOptionPane.CLOSED_OPTION) {
    					
    			         
    			    }
    			 }catch(Exception ex) {
    				 JOptionPane.showMessageDialog(f,"Error! ");
    			 }
		}
     }

//	public static void main(String[] args) {
//	
//       new timetableStu("BTech2");
//	}

}
