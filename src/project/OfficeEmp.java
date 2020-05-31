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

public class OfficeEmp implements ActionListener {

	
	
	static JFrame f;
    static JButton rege;
    private JButton btnLogout;
     OfficeEmp(){
		
	    f= new JFrame("Office Employee"); 
	    
	    f.setSize(500,500);
	    
	    JLabel lblIiitvOffice = new JLabel("IIITV Office ");
	    lblIiitvOffice.setVerticalAlignment(SwingConstants.TOP);
	    lblIiitvOffice.setHorizontalAlignment(SwingConstants.CENTER);
	    lblIiitvOffice.setFont(new Font("Verdana", Font.BOLD, 18));
	    
	    rege = new JButton("Register Employee");
	    rege.setFont(new Font("Tahoma", Font.BOLD, 15));
	    rege.addActionListener(this);
	    
	    btnLogout = new JButton("LogOut");
	    btnLogout.setFont(new Font("Tahoma", Font.BOLD, 15));
	    btnLogout.addActionListener(this);
	    GroupLayout groupLayout = new GroupLayout(f.getContentPane());
	    groupLayout.setHorizontalGroup(
	    	groupLayout.createParallelGroup(Alignment.TRAILING)
	    		.addGroup(groupLayout.createSequentialGroup()
	    			.addGap(114)
	    			.addComponent(lblIiitvOffice, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
	    			.addContainerGap(119, Short.MAX_VALUE))
	    		.addGroup(groupLayout.createSequentialGroup()
	    			.addContainerGap(106, Short.MAX_VALUE)
	    			.addComponent(rege, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)
	    			.addGap(67))
	    		.addGroup(groupLayout.createSequentialGroup()
	    			.addContainerGap(331, Short.MAX_VALUE)
	    			.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
	    			.addGap(18))
	    );
	    groupLayout.setVerticalGroup(
	    	groupLayout.createParallelGroup(Alignment.LEADING)
	    		.addGroup(groupLayout.createSequentialGroup()
	    			.addContainerGap()
	    			.addComponent(lblIiitvOffice, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
	    			.addPreferredGap(ComponentPlacement.RELATED)
	    			.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
	    			.addGap(79)
	    			.addComponent(rege, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
	    			.addContainerGap(288, Short.MAX_VALUE))
	    );
	    f.getContentPane().setLayout(groupLayout);
	    f.setVisible(true);  
     } 
  public void actionPerformed(ActionEvent e){ 
    	 if(e.getSource()==rege) {
    		 EmployeeReg ob=new EmployeeReg();
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
//		new OfficeEmp();
//
//	}

}
