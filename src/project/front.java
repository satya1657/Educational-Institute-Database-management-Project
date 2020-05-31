package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;



import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class front  implements ActionListener{
    //hello
	static JFrame f;
	private JTextField sid;
	private JTextField spas;
	private JTextField eid;
	private JTextField pass;
	private JComboBox type;
	private JButton logins,loginf,here;
	
	static Connection myconn;
	static Statement mystmt;
	static ResultSet myrs;	
	static  PreparedStatement pstmt;
    static boolean i=false; 
    
    front(){
		
    	
    	
	    f= new JFrame("INDIAN INSTITUTE OF INFORMATION TECHNOLOGY");
	    f.getContentPane().setBackground(new Color(204, 255, 204));
	    f.setSize(930,499);
	    
	    JLabel lblIndianInstituteOf = new JLabel("Indian Institute Of Information Technology Vadodara");
	    lblIndianInstituteOf.setVerticalAlignment(SwingConstants.TOP);
	    lblIndianInstituteOf.setHorizontalAlignment(SwingConstants.CENTER);
	    lblIndianInstituteOf.setFont(new Font("Verdana", Font.BOLD, 22));
	    
	    JLabel lblNewLabel = new JLabel("");
	    lblNewLabel.setForeground(Color.WHITE);
	    lblNewLabel.setIcon(new ImageIcon("C:\\Users\\SATYAPRAKASH\\Pictures\\IIITV logo3.png"));
	    
	    JPanel panel = new JPanel();
	    panel.setBackground(new Color(255, 255, 204));
	    panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
	    
	    JLabel lblNewLabel_1 = new JLabel("Student LogIn");
	    lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
	    
	    JLabel lblNewLabel_1_3 = new JLabel("Student ID");
	    lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
	    
	    JLabel lblNewLabel_1_4 = new JLabel("Password");
	    lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
	    
	    sid = new JTextField();
	    sid.setColumns(10);
	    
	    spas = new JTextField();
	    spas.setColumns(10);
	    
	     logins = new JButton("LogIn");
	    logins.addActionListener(this);
	    logins.setFont(new Font("Times New Roman", Font.BOLD, 12));
	    GroupLayout gl_panel = new GroupLayout(panel);
	    gl_panel.setHorizontalGroup(
	    	gl_panel.createParallelGroup(Alignment.TRAILING)
	    		.addGroup(gl_panel.createSequentialGroup()
	    			.addContainerGap(91, Short.MAX_VALUE)
	    			.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
	    			.addGap(75))
	    		.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
	    			.addContainerGap()
	    			.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
	    				.addComponent(lblNewLabel_1_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	    				.addComponent(lblNewLabel_1_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
	    			.addPreferredGap(ComponentPlacement.UNRELATED)
	    			.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
	    				.addComponent(sid, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
	    				.addComponent(spas, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
	    			.addContainerGap(28, Short.MAX_VALUE))
	    		.addGroup(gl_panel.createSequentialGroup()
	    			.addContainerGap(117, Short.MAX_VALUE)
	    			.addComponent(logins)
	    			.addGap(86))
	    );
	    gl_panel.setVerticalGroup(
	    	gl_panel.createParallelGroup(Alignment.LEADING)
	    		.addGroup(gl_panel.createSequentialGroup()
	    			.addComponent(lblNewLabel_1)
	    			.addGap(27)
	    			.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
	    				.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
	    				.addComponent(sid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	    			.addGap(18)
	    			.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
	    				.addComponent(lblNewLabel_1_4, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
	    				.addComponent(spas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	    			.addGap(51)
	    			.addComponent(logins)
	    			.addContainerGap(68, Short.MAX_VALUE))
	    );
	    panel.setLayout(gl_panel);
	    
	    JPanel panel_1 = new JPanel();
	    panel_1.setBackground(new Color(255, 255, 204));
	    panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
	    
	    JLabel lblNewLabel_1_1 = new JLabel("");
	    lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
	    
	    JLabel lblNewLabel_1_2 = new JLabel("Staff LogIn");
	    lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
	    
	    JLabel lblNewLabel_1_3_1 = new JLabel("Employee ID");
	    lblNewLabel_1_3_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
	    
	    JLabel lblNewLabel_1_4_1 = new JLabel("Password");
	    lblNewLabel_1_4_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
	    
	    JLabel lblNewLabel_1_4_1_1 = new JLabel("User Type");
	    lblNewLabel_1_4_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
	    
	    eid = new JTextField();
	    eid.setColumns(10);
	    
	    pass = new JTextField();
	    pass.setColumns(10);
	    
	    type = new JComboBox();
	    type.setModel(new DefaultComboBoxModel(new String[] {"select", "Admin", "Faculty", "Bus Manager", "Time Table Manager", "Hostel Management", "admission Secction", "Scholarship scection", "Course Manager", "Office management"}));
	    
	     loginf = new JButton("LogIn");
	    loginf.addActionListener(this);
	    loginf.setFont(new Font("Times New Roman", Font.BOLD, 12));
	    GroupLayout gl_panel_1 = new GroupLayout(panel_1);
	    gl_panel_1.setHorizontalGroup(
	    	gl_panel_1.createParallelGroup(Alignment.TRAILING)
	    		.addGroup(gl_panel_1.createSequentialGroup()
	    			.addContainerGap(94, Short.MAX_VALUE)
	    			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
	    				.addGroup(gl_panel_1.createSequentialGroup()
	    					.addGap(10)
	    					.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))
	    				.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
	    			.addGap(62))
	    		.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
	    			.addContainerGap()
	    			.addComponent(lblNewLabel_1_3_1, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
	    			.addPreferredGap(ComponentPlacement.RELATED)
	    			.addComponent(eid, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
	    			.addContainerGap(25, Short.MAX_VALUE))
	    		.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
	    			.addContainerGap()
	    			.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
	    				.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
	    					.addComponent(lblNewLabel_1_4_1_1, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
	    					.addPreferredGap(ComponentPlacement.UNRELATED)
	    					.addComponent(type, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	    				.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup()
	    					.addComponent(lblNewLabel_1_4_1, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
	    					.addPreferredGap(ComponentPlacement.RELATED)
	    					.addComponent(pass, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)))
	    			.addContainerGap(25, Short.MAX_VALUE))
	    		.addGroup(gl_panel_1.createSequentialGroup()
	    			.addContainerGap(121, Short.MAX_VALUE)
	    			.addComponent(loginf, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
	    			.addGap(65))
	    );
	    gl_panel_1.setVerticalGroup(
	    	gl_panel_1.createParallelGroup(Alignment.LEADING)
	    		.addGroup(gl_panel_1.createSequentialGroup()
	    			.addComponent(lblNewLabel_1_1)
	    			.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	    			.addComponent(lblNewLabel_1_2)
	    			.addGap(18)
	    			.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
	    				.addComponent(lblNewLabel_1_3_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
	    				.addComponent(eid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	    			.addGap(18)
	    			.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
	    				.addComponent(lblNewLabel_1_4_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
	    				.addComponent(pass, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	    			.addGap(18)
	    			.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
	    				.addComponent(lblNewLabel_1_4_1_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
	    				.addComponent(type, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	    			.addGap(41)
	    			.addComponent(loginf)
	    			.addGap(70))
	    );
	    panel_1.setLayout(gl_panel_1);
	    
	    JPanel panel_2 = new JPanel();
	    panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Notice", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
	    
	    JLabel lblNewLabel_3 = new JLabel("");
	    lblNewLabel_3.setBackground(new Color(255, 235, 205));
	    lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\SATYAPRAKASH\\Pictures\\project DBMS\\IIITV logo3.png"));
	    
	    JPanel panel_3_1 = new JPanel();
	    panel_3_1.setBackground(new Color(255, 255, 204));
	    panel_3_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
	    
	    JLabel lblNewLabel_4 = new JLabel("-> Students can login without sign up ");
	    
	    JLabel lblNewLabel_2 = new JLabel("->Student's password is their Jee Roll No");
	    lblNewLabel_2.setForeground(Color.BLACK);
	    GroupLayout gl_panel_3_1 = new GroupLayout(panel_3_1);
	    gl_panel_3_1.setHorizontalGroup(
	    	gl_panel_3_1.createParallelGroup(Alignment.LEADING)
	    		.addGroup(gl_panel_3_1.createSequentialGroup()
	    			.addContainerGap()
	    			.addGroup(gl_panel_3_1.createParallelGroup(Alignment.LEADING)
	    				.addComponent(lblNewLabel_4)
	    				.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE))
	    			.addContainerGap(19, Short.MAX_VALUE))
	    );
	    gl_panel_3_1.setVerticalGroup(
	    	gl_panel_3_1.createParallelGroup(Alignment.LEADING)
	    		.addGroup(gl_panel_3_1.createSequentialGroup()
	    			.addContainerGap()
	    			.addComponent(lblNewLabel_4)
	    			.addGap(18)
	    			.addComponent(lblNewLabel_2)
	    			.addContainerGap(69, Short.MAX_VALUE))
	    );
	    panel_3_1.setLayout(gl_panel_3_1);
	    
	    JPanel panel_3_1_1 = new JPanel();
	    panel_3_1_1.setBackground(new Color(255, 255, 204));
	    panel_3_1_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
	    
	    JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel(">For SignUp staff click ");
	    
	     here = new JButton("Here");
	     
	    here.setForeground(Color.BLUE);
	    here.setFont(new Font("Times New Roman", Font.BOLD, 12));
	    here.addActionListener(this);
	    
	    JLabel lblNewLabel_2_1_1_1 = new JLabel(">Staff can not LogIn without signUp");
	    GroupLayout gl_panel_3_1_1 = new GroupLayout(panel_3_1_1);
	    gl_panel_3_1_1.setHorizontalGroup(
	    	gl_panel_3_1_1.createParallelGroup(Alignment.LEADING)
	    		.addGroup(gl_panel_3_1_1.createSequentialGroup()
	    			.addContainerGap()
	    			.addGroup(gl_panel_3_1_1.createParallelGroup(Alignment.LEADING, false)
	    				.addComponent(lblNewLabel_2_1_1_1, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
	    				.addGroup(Alignment.TRAILING, gl_panel_3_1_1.createSequentialGroup()
	    					.addComponent(lblNewLabel_2_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
	    					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	    					.addComponent(here, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)))
	    			.addContainerGap(19, Short.MAX_VALUE))
	    );
	    gl_panel_3_1_1.setVerticalGroup(
	    	gl_panel_3_1_1.createParallelGroup(Alignment.LEADING)
	    		.addGroup(gl_panel_3_1_1.createSequentialGroup()
	    			.addContainerGap()
	    			.addComponent(lblNewLabel_2_1_1_1)
	    			.addGap(18)
	    			.addGroup(gl_panel_3_1_1.createParallelGroup(Alignment.BASELINE)
	    				.addComponent(lblNewLabel_2_1_1_1_1_1)
	    				.addComponent(here, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
	    			.addContainerGap(69, Short.MAX_VALUE))
	    );
	    panel_3_1_1.setLayout(gl_panel_3_1_1);
	    
	    JLabel lblNewLabel_5 = new JLabel("");
	    lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\SATYAPRAKASH\\Pictures\\project DBMS\\Welcome-250.png"));
	    GroupLayout groupLayout = new GroupLayout(f.getContentPane());
	    groupLayout.setHorizontalGroup(
	    	groupLayout.createParallelGroup(Alignment.TRAILING)
	    		.addGroup(groupLayout.createSequentialGroup()
	    			.addContainerGap(32, Short.MAX_VALUE)
	    			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	    				.addGroup(groupLayout.createSequentialGroup()
	    					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	    						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
	    						.addComponent(panel_3_1, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE))
	    					.addGap(30)
	    					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	    						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)
	    						.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE))
	    					.addPreferredGap(ComponentPlacement.RELATED)
	    					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
	    						.addComponent(panel_2, 0, 0, Short.MAX_VALUE)
	    						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	    					.addGap(18)
	    					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	    						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE)
	    						.addComponent(panel_3_1_1, GroupLayout.PREFERRED_SIZE, 274, GroupLayout.PREFERRED_SIZE))
	    					.addGap(26))
	    				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
	    					.addComponent(lblIndianInstituteOf, GroupLayout.PREFERRED_SIZE, 696, GroupLayout.PREFERRED_SIZE)
	    					.addGap(87))))
	    );
	    groupLayout.setVerticalGroup(
	    	groupLayout.createParallelGroup(Alignment.LEADING)
	    		.addGroup(groupLayout.createSequentialGroup()
	    			.addComponent(lblIndianInstituteOf)
	    			.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
	    				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
	    					.addPreferredGap(ComponentPlacement.RELATED)
	    					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
	    						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
	    							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
	    								.addComponent(panel_3_1, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
	    								.addComponent(panel_3_1_1, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
	    							.addGap(18)
	    							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
	    								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
	    								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)))
	    						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
	    							.addComponent(lblNewLabel)
	    							.addGap(18)
	    							.addComponent(panel_2, 0, 0, Short.MAX_VALUE))))
	    				.addGroup(groupLayout.createSequentialGroup()
	    					.addGap(39)
	    					.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
	    					.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
	    					.addComponent(lblNewLabel_3)))
	    			.addGap(38))
	    );
	    GroupLayout gl_panel_2 = new GroupLayout(panel_2);
	    gl_panel_2.setHorizontalGroup(
	    	gl_panel_2.createParallelGroup(Alignment.LEADING)
	    		.addGap(0, 249, Short.MAX_VALUE)
	    );
	    gl_panel_2.setVerticalGroup(
	    	gl_panel_2.createParallelGroup(Alignment.LEADING)
	    		.addGap(0, 360, Short.MAX_VALUE)
	    );
	    panel_2.setLayout(gl_panel_2);
	    f.getContentPane().setLayout(groupLayout);
	    f.setVisible(true); 
    }
	
	public void actionPerformed(ActionEvent e){ 
		
		if(e.getSource()==loginf) {
			      
			try {

				String id=(String)eid.getText();
				String pas=(String)pass.getText();
				String typ=(String)type.getSelectedItem();
				
	               i=false;
				   
				   myrs=mystmt.executeQuery("Select * from staff");
				   while(myrs.next()) {
					   String s1= myrs.getString("empid");
					   String s2= myrs.getString("pass");
					   String s3= myrs.getString("typ");
					   //System.out.println(s1+"  "+s2);
					   
					   if(   s1.equalsIgnoreCase(id)  &&   s2.equals(pas)  &&  s3.equalsIgnoreCase(typ)    )
						   i=true;
				   }
				  if(i) {
					  
				   JOptionPane.showMessageDialog(f,"username and password matched successfully ");
				   if(type.getSelectedIndex()==1) {
					    Admin ob=new Admin();
					    //f.dispose();
				   }
				   else if(type.getSelectedIndex()==2) {
					    Faculty fr=new Faculty(id);
					   // f.dispose();
				   }
				   else if(type.getSelectedIndex()==3) {
					    BusSchedule ob= new BusSchedule(); 
					  //  f.dispose();
				   }
				   else if(type.getSelectedIndex()==4) {
					    GoToTT ob=new GoToTT();
					  //  f.dispose();
				   }
				   else if(type.getSelectedIndex()==5) {
					    HostelManagement ob=new HostelManagement(); 
					  //  f.dispose();
				   }
				   else if(type.getSelectedIndex()==6) {
					     StudentReg srob=new StudentReg();
					  //  f.dispose();
				   }
				   else if(type.getSelectedIndex()==9) {
					    OfficeEmp fr=new OfficeEmp();
					  //  f.dispose();
				   }
				   else if(type.getSelectedIndex()==8) {
					    CourseManager ob=new CourseManager();
					  //  f.dispose();
				   }
				    
				  }  
				   else {
					    
					       JOptionPane.showMessageDialog(f,"username and password not matched");
				   }
			}  catch(Exception ex) {
				
				 // JOptionPane.showMessageDialog(null,"error2");
			}
			
		}
		if(e.getSource()==logins) {
			
			String pas=(String)spas.getText();
			String stid=(String)sid.getText();
			String sec=null,sem=null;
			try {
	               i=false;
				   
				   myrs=mystmt.executeQuery("Select * from Studentregistration where ID="+stid);
				   while(myrs.next()) {
					   String s2= myrs.getString("pass");
					    sec= myrs.getString("sec");
					    sem= myrs.getString("sem");
					   //System.out.println(s1+"  "+s2);
					   
					   if( s2.equalsIgnoreCase(pas)  )
						   i=true;
				   }
			if(i) {
			 new StudentHome(stid,sec,sem);}
		 else {
		       JOptionPane.showMessageDialog(f,"username and password not matched");
	        }
			}catch(Exception ex) {
	
					JOptionPane.showMessageDialog(null,"error!");
				}
		}
		if(e.getSource()==here) {
			new SignUp();
		  }
		
	   
	}
	public static void main(String[] args) {
		
		
		 new front();
		 try {
		     myconn=DriverManager.getConnection("jdbc:mysql://localhost:3306/result","root","Satya@1657");
		     mystmt=myconn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		     
	  }catch(Exception ex) {
		  JOptionPane.showMessageDialog(f,"There is some Error in connection with database");
	  }

	}
}
