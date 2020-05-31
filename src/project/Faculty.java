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
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;

public class Faculty  implements ActionListener {

	static Connection myconn;
	static Statement mystmt;
	static ResultSet myrs;	
	static  PreparedStatement pstmt;
	static  JLabel facid;
	static JFrame f;
    static JButton marks,lgout,att;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_1_1;
    private JLabel lblNewLabel_1_2;
    private JComboBox sem;
    private JComboBox sec;
    private JComboBox course;
    static String frol;
   
     Faculty(String st){
		frol=st;
    	 try {
   		     myconn=DriverManager.getConnection("jdbc:mysql://localhost:3306/result","root","Satya@1657");
   		     mystmt=myconn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
   		     
   	  }catch(Exception ex) {
   		  JOptionPane.showMessageDialog(f,"There is some Error in connection wit database");
   	  }
    	 
	    f= new JFrame("Faculty "); 
	    
	    f.setSize(643,485);
	    
	    JLabel lblFacultyHome = new JLabel("Faculty Home");
	    lblFacultyHome.setFont(new Font("Tahoma", Font.BOLD, 20));
	    
	     marks = new JButton("Update Marks");
	    marks.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    marks.addActionListener(this);
	     lgout = new JButton("Logout");
	    lgout.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    lgout.addActionListener(this);
	    JLabel lblNewLabel = new JLabel("Welcome ");
	    lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    
	    facid = new JLabel("F1001");
	    facid.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    facid.setText(frol);
	     att = new JButton("Attendance");
	    att.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    att.addActionListener(this);
	    
	    lblNewLabel_2 = new JLabel("Course Code");
	    lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    
	    lblNewLabel_1_1 = new JLabel("Section");
	    lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    
	    lblNewLabel_1_2 = new JLabel("Semester");
	    lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
	    
	    sem = new JComboBox();
	    sem.setModel(new DefaultComboBoxModel(new String[] {"select", "1", "2", "3", "4", "5", "6", "7", "8"}));
	    
	    sec = new JComboBox();
	    sec.setModel(new DefaultComboBoxModel(new String[] {"select", "A", "B"}));
	    
	    course = new JComboBox();
	    course.setModel(new DefaultComboBoxModel(new String[] {"select", "MA114", "PH120", "EE110", "CS112", "HS112", "CS204", "HS202", "CS206", "CS208", "MA202", "CS202", "IT202", "IT306", "IT309", "IT307", "IT310", "CS306", "CS308", "CS309", "CS310", "PC401"}));
	    GroupLayout groupLayout = new GroupLayout(f.getContentPane());
	    groupLayout.setHorizontalGroup(
	    	groupLayout.createParallelGroup(Alignment.LEADING)
	    		.addGroup(groupLayout.createSequentialGroup()
	    			.addGap(23)
	    			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	    				.addGroup(groupLayout.createSequentialGroup()
	    					.addComponent(lblNewLabel)
	    					.addPreferredGap(ComponentPlacement.UNRELATED)
	    					.addComponent(facid, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
	    				.addComponent(att, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
	    			.addPreferredGap(ComponentPlacement.RELATED, 278, Short.MAX_VALUE)
	    			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	    				.addComponent(marks, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
	    				.addComponent(lgout, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
	    			.addGap(29))
	    		.addGroup(groupLayout.createSequentialGroup()
	    			.addContainerGap(240, Short.MAX_VALUE)
	    			.addComponent(lblFacultyHome, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
	    			.addGap(214))
	    		.addGroup(groupLayout.createSequentialGroup()
	    			.addGap(179)
	    			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	    				.addGroup(groupLayout.createSequentialGroup()
	    					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
	    					.addGap(28)
	    					.addComponent(course, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
	    				.addGroup(groupLayout.createSequentialGroup()
	    					.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
	    					.addGap(28)
	    					.addComponent(sec, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
	    				.addGroup(groupLayout.createSequentialGroup()
	    					.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
	    					.addGap(28)
	    					.addComponent(sem, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE)))
	    			.addContainerGap(201, Short.MAX_VALUE))
	    );
	    groupLayout.setVerticalGroup(
	    	groupLayout.createParallelGroup(Alignment.LEADING)
	    		.addGroup(groupLayout.createSequentialGroup()
	    			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	    				.addGroup(groupLayout.createSequentialGroup()
	    					.addGap(56)
	    					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
	    						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
	    							.addComponent(lblNewLabel)
	    							.addComponent(facid, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE))
	    						.addComponent(lgout, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
	    				.addGroup(groupLayout.createSequentialGroup()
	    					.addContainerGap()
	    					.addComponent(lblFacultyHome, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)))
	    			.addGap(64)
	    			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	    				.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
	    				.addGroup(groupLayout.createSequentialGroup()
	    					.addGap(1)
	    					.addComponent(course, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
	    			.addGap(26)
	    			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	    				.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
	    				.addGroup(groupLayout.createSequentialGroup()
	    					.addGap(1)
	    					.addComponent(sec, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
	    			.addGap(28)
	    			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	    				.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
	    				.addGroup(groupLayout.createSequentialGroup()
	    					.addGap(1)
	    					.addComponent(sem, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
	    			.addPreferredGap(ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
	    			.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
	    				.addGroup(groupLayout.createSequentialGroup()
	    					.addComponent(att, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
	    					.addGap(80))
	    				.addGroup(groupLayout.createSequentialGroup()
	    					.addComponent(marks)
	    					.addGap(89))))
	    );
	    f.getContentPane().setLayout(groupLayout);
	    f.setVisible(true);  
     } 
  public void actionPerformed(ActionEvent e){ 
    	    
	     if(e.getSource()==marks) {
	    	    String fid=facid.getText();
	    	    String cc=(String)course.getSelectedItem();
				String section=(String)sec.getSelectedItem();
				String semester=(String)sem.getSelectedItem();
				boolean flag=false;
				try {   
					
					   myrs=mystmt.executeQuery("select * from courseAssign where facID='"+ fid +"';");
					   while(myrs.next()) {
						   
						    String cnm=myrs.getString("coID");
						    String sec=myrs.getString("sec");
						    String sem=myrs.getString("sem");
						    String br=myrs.getString("branch");
						    
						     if(cc.equalsIgnoreCase(cnm) && section.equalsIgnoreCase(sec) && semester.equalsIgnoreCase(sem)) {
						    	  flag=true;
						    	  break;
						     }
									
					   }
					 if(flag) {
						         new UpdateTable(cc,section,semester);
						         
					 }
					 else {
						 JOptionPane.showMessageDialog(f,"Sorry you are not assign for this course");
					 }
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(f,"There is some Error in fetching data from database");
				}
				
	    	 
	     }
	 	if(e.getSource()==lgout) {
			 try {
	       			
    			 JDialog.setDefaultLookAndFeelDecorated(true);
    			    int response = JOptionPane.showConfirmDialog(null, "Do you want to LogOut?", "Confirm",
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
//		new Faculty("F1001");
//
//	}

}
