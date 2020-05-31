package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class BusTT implements ActionListener {

	
	static Connection myconn;
	static Statement mystmt;
	static ResultSet myrs;	
	static  PreparedStatement pstmt;
	static JFrame f;
	private JTable table;
	static DefaultTableModel model;
	private JButton back;
	private JLabel lblNewLabel;
     /**
      * @wbp.parser.entryPoint
      */
    BusTT(){
		
    	 try {
		     myconn=DriverManager.getConnection("jdbc:mysql://localhost:3306/result","root","Satya@1657");
		     mystmt=myconn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		
	  }catch(Exception ex) {
		  JOptionPane.showMessageDialog(f,"There is some Error in connection with database");
	  }
	    f= new JFrame("Course"); 
	    f.getContentPane().setBackground(new Color(204, 255, 204));
	    
	    f.setSize(590,451);
	    
	    JScrollPane scrollPane = new JScrollPane();
	    
	    back = new JButton("Back");
		 back.addActionListener(this);
	    lblNewLabel = new JLabel("Bus Time Table");
	    lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    GroupLayout groupLayout = new GroupLayout(f.getContentPane());
	    groupLayout.setHorizontalGroup(
	    	groupLayout.createParallelGroup(Alignment.LEADING)
	    		.addGroup(groupLayout.createSequentialGroup()
	    			.addContainerGap()
	    			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	    				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
	    				.addGroup(groupLayout.createSequentialGroup()
	    					.addComponent(back, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
	    					.addGap(139)
	    					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)))
	    			.addContainerGap())
	    );
	    groupLayout.setVerticalGroup(
	    	groupLayout.createParallelGroup(Alignment.LEADING)
	    		.addGroup(groupLayout.createSequentialGroup()
	    			.addGap(27)
	    			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
	    				.addComponent(back)
	    				.addComponent(lblNewLabel))
	    			.addPreferredGap(ComponentPlacement.UNRELATED)
	    			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
	    			.addContainerGap(158, Short.MAX_VALUE))
	    );
	    
	    table = new JTable();
	    table.setBackground(new Color(250, 235, 215));
	    model=new DefaultTableModel(
	    	new Object[][] {
	    		{null, null, null, null},
	    	},
	    	new String[] {
	    		"Day", "morning", "Evening1", "Evening2"
	    	}
	    );
	    table.setModel(model);
	    scrollPane.setViewportView(table);
	    f.getContentPane().setLayout(groupLayout);
	    f.setVisible(true);  
	    viewTable();
     }
 
     public static void viewTable() {
     	model.setRowCount(0);
 		try {   
 				
 			   myrs=mystmt.executeQuery("select * from bus ;");
 			   while(myrs.next()) {
 				    String day=myrs.getString("days");
 				    String m=myrs.getString("morn");
 				    String e1=myrs.getString("even1");
 				    String e2=myrs.getString("even2");
 					model.addRow(new Object[]{day, m, e1, e2 });				
 			   }
 		}catch(Exception ex) {
 			JOptionPane.showMessageDialog(f,"There is some Error in fetching data from database");
 		}
     }
 	
     
     public void actionPerformed(ActionEvent e){ 
    	  if(e.getSource()==back)
    	  {
    			
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
//           new BusTT();
//          // viewTable();
//	}

}
