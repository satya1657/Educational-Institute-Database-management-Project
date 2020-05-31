package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.LayoutStyle.ComponentPlacement;

public class CourseManager implements ActionListener {

	static JFrame f;
	static  JButton en,ass,det,btnLogout;
	private JButton ct;
	private JButton fd;
	CourseManager(){
		f=new JFrame("Course Manager");
		 f.setSize(543,482);
		 
		 JLabel lblCourseManager = new JLabel("Course Manager");
		 lblCourseManager.setVerticalAlignment(SwingConstants.TOP);
		 lblCourseManager.setHorizontalAlignment(SwingConstants.CENTER);
		 lblCourseManager.setFont(new Font("Verdana", Font.BOLD, 18));
		 
		  en = new JButton("Course Enroll");
		 en.setFont(new Font("Tahoma", Font.BOLD, 15));
		 en.addActionListener(this);
		 
		  ass = new JButton("Course Assign");
		 ass.setFont(new Font("Tahoma", Font.BOLD, 15));
		 ass.addActionListener(this);
		 
		  det = new JButton("Course Details");
		 det.setFont(new Font("Tahoma", Font.BOLD, 15));
		 det.addActionListener(this);
		 
		  btnLogout = new JButton("LogOut");
		 btnLogout.setFont(new Font("Tahoma", Font.BOLD, 15));
		 btnLogout.addActionListener(this);
		 
		 ct = new JButton("Create Tables");
		 ct.setFont(new Font("Tahoma", Font.BOLD, 15));
		 ct.addActionListener(this);
		 
		 fd = new JButton("Faculty Details");
		 fd.setFont(new Font("Tahoma", Font.BOLD, 15));
		 fd.addActionListener(this);
		 GroupLayout groupLayout = new GroupLayout(f.getContentPane());
		 groupLayout.setHorizontalGroup(
		 	groupLayout.createParallelGroup(Alignment.LEADING)
		 		.addGroup(groupLayout.createSequentialGroup()
		 			.addContainerGap(162, Short.MAX_VALUE)
		 			.addComponent(lblCourseManager, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
		 			.addGap(114))
		 		.addGroup(groupLayout.createSequentialGroup()
		 			.addContainerGap(382, Short.MAX_VALUE)
		 			.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
		 			.addContainerGap())
		 		.addGroup(groupLayout.createSequentialGroup()
		 			.addGap(128)
		 			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
		 				.addGroup(groupLayout.createSequentialGroup()
		 					.addComponent(fd, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)
		 					.addContainerGap())
		 				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
		 					.addGroup(groupLayout.createSequentialGroup()
		 						.addComponent(ct, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)
		 						.addContainerGap())
		 					.addGroup(groupLayout.createSequentialGroup()
		 						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
		 							.addComponent(det, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
		 							.addComponent(ass, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
		 							.addComponent(en, GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE))
		 						.addGap(88)))))
		 );
		 groupLayout.setVerticalGroup(
		 	groupLayout.createParallelGroup(Alignment.LEADING)
		 		.addGroup(groupLayout.createSequentialGroup()
		 			.addContainerGap()
		 			.addComponent(lblCourseManager, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
		 			.addGap(18)
		 			.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
		 			.addGap(96)
		 			.addComponent(en)
		 			.addGap(18)
		 			.addComponent(ass, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
		 			.addGap(18)
		 			.addComponent(det, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
		 			.addGap(18)
		 			.addComponent(ct, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
		 			.addGap(18)
		 			.addComponent(fd, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
		 			.addContainerGap(61, Short.MAX_VALUE))
		 );
		 f.getContentPane().setLayout(groupLayout);
		    f.setVisible(true);  
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==en) {
			   CourseEnroll ob=new CourseEnroll();
		    }
        if(e.getSource()==ass) {
			   CourseAssign ob=new CourseAssign();
		    }
         if(e.getSource()==det) {
	              coursedetails ob=new coursedetails(); 
             }
         if(e.getSource()==ct) {
             managetable ob=new managetable(); 
        }
         if(e.getSource()==fd) {
             FacultyDetails ob=new FacultyDetails(); 
        }
         if(e.getSource()==btnLogout) {
        	    
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
//          new CourseManager();
//	}
}
