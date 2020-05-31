package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Admin implements ActionListener {

	
	static JButton bus,tt,hostel,stureg,empreg,corsenroll,corseass,corsedet,lgout;
	static JFrame f;

     Admin(){
		
	    f= new JFrame("Admin"); 
	    f.setBackground(new Color(0, 0, 0));
	    f.getContentPane().setBackground(new Color(245, 245, 220));
	    
	    f.setSize(921,499);
	    
	    JLabel lblAdminHome = new JLabel("Admin Home");
	    lblAdminHome.setFont(new Font("Times New Roman", Font.BOLD, 30));
	    
	     bus = new JButton("");
	    bus.setIcon(new ImageIcon("C:\\Users\\SATYAPRAKASH\\Pictures\\project DBMS\\bus 100px.png"));
	    bus.setFont(new Font("Times New Roman", Font.BOLD, 15));
	    bus.addActionListener(this);
	    
	    JLabel lblNewLabel = new JLabel("Bus Schedule");
	    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
	    
	    tt = new JButton("");
	    tt.setIcon(new ImageIcon("C:\\Users\\SATYAPRAKASH\\Pictures\\project DBMS\\timetable.png"));
	    tt.addActionListener(this);
	    JLabel lblTimeTable = new JLabel("Time Table");
	    lblTimeTable.setFont(new Font("Tahoma", Font.BOLD, 11));
	    
	     hostel = new JButton("");
	    hostel.setIcon(new ImageIcon("C:\\Users\\SATYAPRAKASH\\Pictures\\project DBMS\\hostel100.jpg"));
	    hostel.addActionListener(this);
	    JLabel lblHostel = new JLabel("Hostel");
	    lblHostel.setFont(new Font("Tahoma", Font.BOLD, 11));
	    
	     stureg = new JButton("");
	    stureg.setIcon(new ImageIcon("C:\\Users\\SATYAPRAKASH\\Pictures\\project DBMS\\Studentreg100.png"));
	    stureg.addActionListener(this);
	    JLabel lblStudentRegistration = new JLabel("");
	    
	    JLabel lblRegistration = new JLabel("Registration");
	    lblRegistration.setFont(new Font("Tahoma", Font.BOLD, 11));
	    
	     empreg = new JButton("");
	    empreg.setIcon(new ImageIcon("C:\\Users\\SATYAPRAKASH\\Pictures\\project DBMS\\empreg100.jpg"));
	    empreg.addActionListener(this);
	    JLabel lblEmployeeReg = new JLabel("Employee Reg");
	    lblEmployeeReg.setFont(new Font("Tahoma", Font.BOLD, 11));
	    
	     corsenroll = new JButton("");
	    corsenroll.setIcon(new ImageIcon("C:\\Users\\SATYAPRAKASH\\Pictures\\project DBMS\\courseenroll.png"));
	    corsenroll.addActionListener(this);
	    JLabel lblCourseEnroll = new JLabel("Course Enroll");
	    lblCourseEnroll.setFont(new Font("Tahoma", Font.BOLD, 11));
	    
	     corseass = new JButton("");
	    corseass.setIcon(new ImageIcon("C:\\Users\\SATYAPRAKASH\\Pictures\\project DBMS\\courseassgn.jpg"));
	    corseass.addActionListener(this);
	     corsedet = new JButton("");
	     
	    corsedet.setIcon(new ImageIcon("C:\\Users\\SATYAPRAKASH\\Pictures\\project DBMS\\courseDetails100.png"));
	    corsedet.addActionListener(this);
	    JLabel lblCourseAssign = new JLabel("Course Assign");
	    lblCourseAssign.setFont(new Font("Tahoma", Font.BOLD, 11));
	    
	    JLabel lblCourseDetails = new JLabel("Course Details");
	    lblCourseDetails.setFont(new Font("Tahoma", Font.BOLD, 11));
	    
	     lgout = new JButton("LogOut");
	     lgout.addActionListener(this);
	    GroupLayout groupLayout = new GroupLayout(f.getContentPane());
	    groupLayout.setHorizontalGroup(
	    	groupLayout.createParallelGroup(Alignment.LEADING)
	    		.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
	    			.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
	    				.addGroup(groupLayout.createSequentialGroup()
	    					.addGap(358)
	    					.addComponent(lblAdminHome, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
	    					.addPreferredGap(ComponentPlacement.RELATED, 220, Short.MAX_VALUE)
	    					.addComponent(lgout))
	    				.addGroup(groupLayout.createSequentialGroup()
	    					.addGap(32)
	    					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
	    						.addComponent(lblTimeTable, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
	    						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
	    							.addComponent(tt, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	    							.addGroup(groupLayout.createSequentialGroup()
	    								.addGap(33)
	    								.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	    							.addComponent(bus, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)))
	    					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	    						.addGroup(groupLayout.createSequentialGroup()
	    							.addGap(137)
	    							.addComponent(lblHostel, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
	    						.addGroup(groupLayout.createSequentialGroup()
	    							.addGap(89)
	    							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
	    								.addComponent(stureg, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	    								.addComponent(hostel, GroupLayout.PREFERRED_SIZE, 125, Short.MAX_VALUE)))
	    						.addGroup(groupLayout.createSequentialGroup()
	    							.addGap(107)
	    							.addComponent(lblStudentRegistration, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
	    						.addGroup(groupLayout.createSequentialGroup()
	    							.addGap(126)
	    							.addComponent(lblRegistration, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)))
	    					.addGap(125)
	    					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
	    						.addComponent(lblCourseEnroll, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
	    						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
	    							.addGroup(groupLayout.createSequentialGroup()
	    								.addGap(6)
	    								.addComponent(empreg, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
	    							.addGroup(groupLayout.createSequentialGroup()
	    								.addPreferredGap(ComponentPlacement.RELATED)
	    								.addComponent(corsenroll, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
	    						.addComponent(lblEmployeeReg, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
	    					.addGap(84)
	    					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
	    						.addComponent(corseass, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
	    						.addComponent(corsedet, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
	    						.addComponent(lblCourseAssign, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
	    						.addComponent(lblCourseDetails, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))))
	    			.addGap(53))
	    );
	    groupLayout.setVerticalGroup(
	    	groupLayout.createParallelGroup(Alignment.LEADING)
	    		.addGroup(groupLayout.createSequentialGroup()
	    			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	    				.addGroup(groupLayout.createSequentialGroup()
	    					.addContainerGap()
	    					.addComponent(lblAdminHome, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
	    				.addGroup(groupLayout.createSequentialGroup()
	    					.addGap(35)
	    					.addComponent(lgout)))
	    			.addGap(36)
	    			.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
	    				.addComponent(corseass, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	    				.addComponent(empreg, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	    				.addComponent(hostel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	    				.addComponent(bus, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
	    			.addPreferredGap(ComponentPlacement.RELATED)
	    			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
	    				.addComponent(lblNewLabel)
	    				.addComponent(lblHostel)
	    				.addComponent(lblCourseAssign)
	    				.addComponent(lblEmployeeReg))
	    			.addGap(70)
	    			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
	    				.addComponent(corsedet, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	    				.addComponent(corsenroll, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	    				.addComponent(stureg, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	    				.addComponent(tt, GroupLayout.PREFERRED_SIZE, 105, Short.MAX_VALUE))
	    			.addPreferredGap(ComponentPlacement.RELATED)
	    			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
	    				.addComponent(lblTimeTable)
	    				.addComponent(lblStudentRegistration)
	    				.addComponent(lblRegistration)
	    				.addComponent(lblCourseEnroll)
	    				.addComponent(lblCourseDetails))
	    			.addContainerGap(27, Short.MAX_VALUE))
	    );
	    f.getContentPane().setLayout(groupLayout);
	    f.setVisible(true);  
     }
     
     public void actionPerformed(ActionEvent e){ 
    	  if(e.getSource()==bus) {
    		  new BusSchedule();
    	  }
    	  if(e.getSource()==tt) {
    		  new GoToTT();
    	  }
    	  if(e.getSource()==hostel) {
    		  new HostelManagement();
    	  }
    	  if(e.getSource()==stureg) {
    		  new StudentReg();
    	  }
    	  if(e.getSource()==empreg) {
    		  new EmployeeReg();
    	  }
    	  if(e.getSource()==corsenroll) {
    		  new CourseEnroll();
    	  }
    	  if(e.getSource()==corseass) {
    		  new CourseAssign();
    	  }
    	  if(e.getSource()==corsedet) {
    		  new coursedetails();
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
//            new Admin();
//	}
}
