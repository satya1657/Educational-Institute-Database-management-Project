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
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class managetable implements ActionListener {

	static JFrame f;
    static	JComboBox course,sec,sem;
    static JButton ct;
    static Connection myconn;
   	static Statement mystmt;
   	static ResultSet myrs;	
   	static  PreparedStatement pstmt;
   	static String tabnm;
   	private JButton back;
    
	public managetable(){
		  
		  try {
			     myconn=DriverManager.getConnection("jdbc:mysql://localhost:3306/result","root","Satya@1657");
			     mystmt=myconn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			     
		  }catch(Exception ex) {
			  JOptionPane.showMessageDialog(f,"There is some Error in connection with database");
		  }
		
	    f= new JFrame("Manage Tables");  
		f.setSize(623,473);
		
		JLabel lblNewLabel = new JLabel("Create Tables For Exam Marks ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblNewLabel_1 = new JLabel("Course Code");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1_1 = new JLabel("Section");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1_2 = new JLabel("Semester");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		 course = new JComboBox();
		course.setModel(new DefaultComboBoxModel(new String[] {"select", "MA114", "PH120", "EE110", "CS112", "HS112", "CS204", "HS202", "CS206", "CS208", "MA202", "CS202", "IT202", "IT306", "IT309", "IT307", "IT310", "CS306", "CS308", "CS309", "CS310", "PC401", "MA102"}));
		
		 sec = new JComboBox();
		sec.setModel(new DefaultComboBoxModel(new String[] {"select", "A", "B"}));
		
		 sem = new JComboBox();
		sem.setModel(new DefaultComboBoxModel(new String[] {"select", "1", "2", "3", "4", "5", "6", "7", "8"}));
		
	    ct = new JButton(" Create table");
		ct.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ct.addActionListener(this);
		
		back = new JButton("Back");
		back.addActionListener(this);
		GroupLayout groupLayout = new GroupLayout(f.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(154, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 332, GroupLayout.PREFERRED_SIZE)
					.addGap(121))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(171)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(sem, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
						.addComponent(sec, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)
						.addComponent(course, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(189, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(241)
					.addComponent(ct)
					.addContainerGap(257, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(back)
					.addContainerGap(508, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(back)
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(course, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(sec, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(sem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(49)
					.addComponent(ct)
					.addContainerGap(118, Short.MAX_VALUE))
		);
		f.getContentPane().setLayout(groupLayout);
	    f.setVisible(true); 
	}
	public void actionPerformed(ActionEvent e){ 
		if(e.getSource()==ct) {
			
			String cc=(String)course.getSelectedItem();
			String section=(String)sec.getSelectedItem();
			String semester=(String)sem.getSelectedItem();
			
			tabnm=cc+section+semester;
			String q1="CREATE TABLE "+tabnm+" LIKE temp;";
			//String q2="INSERT INTO "+tabnm+" SELECT * FROM temp;";
			try {
				
		    	 myconn.setAutoCommit(false);
				 mystmt.executeUpdate(q1);
				// mystmt.executeUpdate(q2);
				 myconn.commit();
				 JOptionPane.showMessageDialog(f,"Successfully created a table");
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(f,"Error! Table already exist");
			}
			
		}
		
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
//		new managetable();
//
//	}
}
