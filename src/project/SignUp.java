package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
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
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;

public class SignUp implements ActionListener {

	 static Connection myconn;
		static Statement mystmt;
		static ResultSet myrs;	
		static  PreparedStatement pstmt;
	
	static JFrame f;
	private JTextField empID;
	private JTextField nam;
	private JTextField pas;
	private JComboBox ut;
    private JButton signup;
     /**
      * @wbp.parser.entryPoint
      */
     SignUp(){
    	 
    	 try {
		     myconn=DriverManager.getConnection("jdbc:mysql://localhost:3306/result","root","Satya@1657");
		     mystmt=myconn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		     
	  }catch(Exception ex) {
		  JOptionPane.showMessageDialog(f,"There is some Error in connection with database");
	  }
    	 
	    f= new JFrame("Sign Up"); 
	    f.getContentPane().setForeground(new Color(255, 255, 255));
	    f.getContentPane().setBackground(new Color(240, 255, 240));
	    
	    f.setSize(546,382);
	    
	    JLabel lblNewLabel = new JLabel("Sign Up");
	    lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	    
	    JLabel lblNewLabel_1 = new JLabel("Employe ID");
	    lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    
	    empID = new JTextField();
	    empID.setColumns(10);
	    
	    JLabel lblNewLabel_1_1 = new JLabel("Name");
	    lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    
	    JLabel lblNewLabel_1_2 = new JLabel("Password");
	    lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    
	    JLabel lblNewLabel_1_3 = new JLabel("User Type");
	    lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	    
	    nam = new JTextField();
	    nam.setColumns(10);
	    
	    pas = new JTextField();
	    pas.setColumns(10);
	    
	    signup = new JButton("SignUp");
	    signup.addActionListener(this);
	     ut = new JComboBox();
	    ut.setModel(new DefaultComboBoxModel(new String[] {"select", "Admin", "Faculty", "Bus Manager", "Time Table Manager", "Hostel Management", "admission Secction", "Scholarship scection", "Course Manager", "Office management"}));
	    GroupLayout groupLayout = new GroupLayout(f.getContentPane());
	    groupLayout.setHorizontalGroup(
	    	groupLayout.createParallelGroup(Alignment.TRAILING)
	    		.addGroup(groupLayout.createSequentialGroup()
	    			.addContainerGap(156, Short.MAX_VALUE)
	    			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
	    				.addGroup(groupLayout.createSequentialGroup()
	    					.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
	    					.addPreferredGap(ComponentPlacement.UNRELATED)
	    					.addComponent(pas, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE))
	    				.addGroup(groupLayout.createSequentialGroup()
	    					.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
	    					.addPreferredGap(ComponentPlacement.UNRELATED)
	    					.addComponent(nam, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE))
	    				.addGroup(groupLayout.createSequentialGroup()
	    					.addComponent(lblNewLabel_1)
	    					.addPreferredGap(ComponentPlacement.UNRELATED)
	    					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	    						.addComponent(lblNewLabel)
	    						.addComponent(empID, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)))
	    				.addGroup(groupLayout.createSequentialGroup()
	    					.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
	    					.addPreferredGap(ComponentPlacement.UNRELATED)
	    					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	    						.addComponent(signup)
	    						.addComponent(ut, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
	    			.addGap(144))
	    );
	    groupLayout.setVerticalGroup(
	    	groupLayout.createParallelGroup(Alignment.LEADING)
	    		.addGroup(groupLayout.createSequentialGroup()
	    			.addGap(25)
	    			.addComponent(lblNewLabel)
	    			.addGap(53)
	    			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
	    				.addComponent(empID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	    				.addComponent(lblNewLabel_1))
	    			.addPreferredGap(ComponentPlacement.UNRELATED)
	    			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
	    				.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
	    				.addComponent(nam, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	    			.addPreferredGap(ComponentPlacement.UNRELATED)
	    			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
	    				.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
	    				.addComponent(pas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	    			.addPreferredGap(ComponentPlacement.UNRELATED)
	    			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
	    				.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
	    				.addComponent(ut, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	    			.addGap(46)
	    			.addComponent(signup)
	    			.addContainerGap(152, Short.MAX_VALUE))
	    );
	    f.getContentPane().setLayout(groupLayout);
	    f.setVisible(true);  
     }
     
     public void actionPerformed(ActionEvent e){ 
    	   if(e.getSource()==signup) {
    		   String id=(String)empID.getText();
    		   String nm=(String)nam.getText();
    		   String pass=(String)pas.getText();
    		   String typ=(String)ut.getSelectedItem();
    		   System.out.println(id+ "  "+nm+"  "+pass+" "+typ);
    		   
    		try {   
    			 myconn.setAutoCommit(false);
    		  pstmt=myconn.prepareStatement("insert into staff values(?,?,?,?)");
				 pstmt.setString(1, id);
				 pstmt.setString(2, nm);
				 pstmt.setString(3, pass);
				 pstmt.setString(4, typ);
				 pstmt.executeUpdate();
				 myconn.commit();
				 
				 JOptionPane.showMessageDialog(f,"Successfully sign Up Now You can logIn");
				 f.dispose();
    		}catch(Exception ex) {
    			JOptionPane.showMessageDialog(f,"Unsuccessful to sign up");
    		}
    	   }
     }


//	public static void main(String[] args) {
//		
//          new SignUp();
//	}

}
