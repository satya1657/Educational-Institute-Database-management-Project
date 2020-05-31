package project;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import java.awt.ScrollPane;
import java.awt.Scrollbar;
import java.util.*;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
public class StudentReg implements ActionListener {

	static JFrame f;
	private JTextField id;
	private JTextField name;
    private JButton Add,edit,del,search;
    
    static DefaultTableModel model;
    
    static Connection myconn;
	static Statement mystmt;
	static ResultSet myrs;	
	static  PreparedStatement pstmt;
	private JTextField rlno;
	private JButton btnViewTable;
	private JButton update;
    private JComboBox br,sem,sec;
    private JScrollPane scrollPane;
    private JTable STable;
    private JLabel lblNewLabel_3;
    private JTextField jee;
    private JButton back;
    
    StudentReg(){
          
    	 try {
		     myconn=DriverManager.getConnection("jdbc:mysql://localhost:3306/result","root","Satya@1657");
		     mystmt=myconn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		     
		   
		    
	  }catch(Exception ex) {
		  JOptionPane.showMessageDialog(f,"There is some Error in connection with database");
	  }

    	
    	f= new JFrame("Student Registration"); 
    	f.getContentPane().setBackground(new Color(176, 224, 230));
    	 f.setSize(930,510);
    	 
    	 JLabel topic = new JLabel("Student Registration");
    	 topic.setVerticalAlignment(SwingConstants.TOP);
    	 topic.setHorizontalAlignment(SwingConstants.CENTER);
    	 topic.setFont(new Font("Verdana", Font.BOLD, 18));
    	 
    	 JPanel regpanel = new JPanel();
    	 regpanel.setBackground(new Color(255, 245, 238));
    	 regpanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
    	 
    	 JLabel lblNewLabel_1 = new JLabel("Roll No.");
    	 lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
    	 
    	 id = new JTextField();
    	 id.setFont(new Font("Times New Roman", Font.PLAIN, 16));
    	 id.setColumns(10);
    	 
    	 JLabel lblNewLabel_1_1 = new JLabel("Name");
    	 lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
    	 
    	 JLabel lblNewLabel_1_2 = new JLabel("Branch");
    	 lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
    	 
    	 JLabel lblNewLabel_1_3 = new JLabel("Semester");
    	 lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
    	 
    	 name = new JTextField();
    	 name.setFont(new Font("Times New Roman", Font.PLAIN, 16));
    	 name.setColumns(10);
    	 
    	 Add = new JButton("ADD");
    	 Add.setFont(new Font("Times New Roman", Font.PLAIN, 14));
    	 Add.addActionListener(this);
    	 
    	 update = new JButton("UPDATE");
    	 update.setFont(new Font("Times New Roman", Font.PLAIN, 14));
    	 update.addActionListener(this);
    	 
    	 br = new JComboBox();
    	 br.setFont(new Font("Times New Roman", Font.PLAIN, 12));
    	 br.setModel(new DefaultComboBoxModel(new String[] {"CSE", "IT"}));
    	 
    	 sem = new JComboBox();
    	 sem.setFont(new Font("Times New Roman", Font.PLAIN, 12));
    	 sem.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8"}));
    	 
    	 lblNewLabel_3 = new JLabel("JEE Roll");
    	 lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
    	 
    	 jee = new JTextField();
    	 jee.setFont(new Font("Times New Roman", Font.PLAIN, 16));
    	 jee.setColumns(10);
    	 
    	 JLabel lblNewLabel_3_1 = new JLabel("Section");
    	 lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
    	 
    	  sec = new JComboBox();
    	 sec.setModel(new DefaultComboBoxModel(new String[] {"A", "B"}));
    	 sec.setFont(new Font("Times New Roman", Font.PLAIN, 12));
    	 GroupLayout gl_regpanel = new GroupLayout(regpanel);
    	 gl_regpanel.setHorizontalGroup(
    	 	gl_regpanel.createParallelGroup(Alignment.LEADING)
    	 		.addGroup(gl_regpanel.createSequentialGroup()
    	 			.addContainerGap()
    	 			.addGroup(gl_regpanel.createParallelGroup(Alignment.LEADING)
    	 				.addGroup(gl_regpanel.createSequentialGroup()
    	 					.addGroup(gl_regpanel.createParallelGroup(Alignment.LEADING)
    	 						.addGroup(gl_regpanel.createSequentialGroup()
    	 							.addGroup(gl_regpanel.createParallelGroup(Alignment.LEADING)
    	 								.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
    	 								.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
    	 							.addPreferredGap(ComponentPlacement.RELATED)
    	 							.addGroup(gl_regpanel.createParallelGroup(Alignment.LEADING)
    	 								.addComponent(sem, 0, 151, Short.MAX_VALUE)
    	 								.addComponent(br, 0, 151, Short.MAX_VALUE)))
    	 						.addGroup(gl_regpanel.createParallelGroup(Alignment.LEADING, false)
    	 							.addGroup(gl_regpanel.createSequentialGroup()
    	 								.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
    	 								.addPreferredGap(ComponentPlacement.RELATED)
    	 								.addComponent(name))
    	 							.addGroup(gl_regpanel.createSequentialGroup()
    	 								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
    	 								.addPreferredGap(ComponentPlacement.RELATED)
    	 								.addComponent(id, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)))
    	 						.addGroup(gl_regpanel.createSequentialGroup()
    	 							.addComponent(update, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
    	 							.addGap(33)
    	 							.addComponent(Add, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
    	 						.addGroup(gl_regpanel.createSequentialGroup()
    	 							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
    	 							.addPreferredGap(ComponentPlacement.RELATED)
    	 							.addComponent(jee, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)))
    	 					.addGap(30))
    	 				.addGroup(gl_regpanel.createSequentialGroup()
    	 					.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
    	 					.addPreferredGap(ComponentPlacement.RELATED)
    	 					.addComponent(sec, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
    	 					.addContainerGap(30, Short.MAX_VALUE))))
    	 );
    	 gl_regpanel.setVerticalGroup(
    	 	gl_regpanel.createParallelGroup(Alignment.LEADING)
    	 		.addGroup(gl_regpanel.createSequentialGroup()
    	 			.addGap(37)
    	 			.addGroup(gl_regpanel.createParallelGroup(Alignment.BASELINE)
    	 				.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
    	 				.addComponent(id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
    	 			.addGap(18)
    	 			.addGroup(gl_regpanel.createParallelGroup(Alignment.BASELINE)
    	 				.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
    	 				.addComponent(name, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
    	 			.addGap(18)
    	 			.addGroup(gl_regpanel.createParallelGroup(Alignment.BASELINE)
    	 				.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
    	 				.addComponent(br, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
    	 			.addGap(18)
    	 			.addGroup(gl_regpanel.createParallelGroup(Alignment.BASELINE)
    	 				.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
    	 				.addComponent(sem, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
    	 			.addGap(18)
    	 			.addGroup(gl_regpanel.createParallelGroup(Alignment.BASELINE)
    	 				.addComponent(jee, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
    	 				.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
    	 			.addPreferredGap(ComponentPlacement.UNRELATED)
    	 			.addGroup(gl_regpanel.createParallelGroup(Alignment.BASELINE)
    	 				.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
    	 				.addComponent(sec, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
    	 			.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
    	 			.addGroup(gl_regpanel.createParallelGroup(Alignment.BASELINE)
    	 				.addComponent(update, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
    	 				.addComponent(Add))
    	 			.addContainerGap())
    	 );
    	 regpanel.setLayout(gl_regpanel);
    	 
    	 JPanel tablepanel = new JPanel();
    	 tablepanel.setBackground(new Color(255, 245, 238));
    	 tablepanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
    	
    	 
    	
    	 
    	 scrollPane = new JScrollPane();
    	 
    	 GroupLayout gl_tablepanel = new GroupLayout(tablepanel);
    	 gl_tablepanel.setHorizontalGroup(
    	 	gl_tablepanel.createParallelGroup(Alignment.LEADING)
    	 		.addGroup(gl_tablepanel.createSequentialGroup()
    	 			.addContainerGap()
    	 			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
    	 			.addContainerGap())
    	 );
    	 gl_tablepanel.setVerticalGroup(
    	 	gl_tablepanel.createParallelGroup(Alignment.LEADING)
    	 		.addGroup(Alignment.TRAILING, gl_tablepanel.createSequentialGroup()
    	 			.addContainerGap(28, Short.MAX_VALUE)
    	 			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)
    	 			.addContainerGap())
    	 );
    	 
    	 STable = new JTable();
    	 STable.setBackground(new Color(250, 250, 210));
    	 STable.setColumnSelectionAllowed(true);
		 STable.setCellSelectionEnabled(true);
		 model = new DefaultTableModel(
		    	 	new Object[][] {
		    	 		
		    	 		{null, null, null, null},
		    	 	},
		    	 	new String[] {
		    	 		"Roll No", "Name", "Branch", "Semester"
		    	 	}
		    	 );
		 
    	 STable.setModel(model);
    	
    	// STable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    	 scrollPane.setViewportView(STable);
    	 tablepanel.setLayout(gl_tablepanel);
    	 
    	 rlno = new JTextField();
    	 rlno.setFont(new Font("Tahoma", Font.PLAIN, 12));
    	 rlno.setColumns(10);
    	 
    	 search = new JButton("Search");
    	 search.setFont(new Font("Tahoma", Font.PLAIN, 12));
    	 search.addActionListener(this);
    	 
    	 JLabel lblNewLabel_2 = new JLabel("Roll No");
    	 
    	 btnViewTable = new JButton("VIEW FULL TABLE");
    	 btnViewTable.setFont(new Font("Times New Roman", Font.PLAIN, 14));
    	 btnViewTable.addActionListener(this);
    	 
    	 edit = new JButton("EDIT");
    	 edit.setFont(new Font("Times New Roman", Font.PLAIN, 14));
    	 edit.addActionListener(this);
    	 
    	  del = new JButton("DELETE");
    	  del.setFont(new Font("Times New Roman", Font.PLAIN, 14));
    	  del.addActionListener(this);
    	 
    	 JLabel lblNewLabel = new JLabel("For Edit OR Delete please Select from Table\r\n");
    	 lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 10));
    	 
    	 back = new JButton("Logout");
    	 back.addActionListener(this);
    	 GroupLayout groupLayout = new GroupLayout(f.getContentPane());
    	 groupLayout.setHorizontalGroup(
    	 	groupLayout.createParallelGroup(Alignment.TRAILING)
    	 		.addGroup(groupLayout.createSequentialGroup()
    	 			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
    	 				.addGroup(groupLayout.createSequentialGroup()
    	 					.addGap(328)
    	 					.addComponent(topic, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE))
    	 				.addGroup(groupLayout.createSequentialGroup()
    	 					.addContainerGap()
    	 					.addComponent(regpanel, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
    	 					.addGap(18)
    	 					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
    	 						.addComponent(lblNewLabel)
    	 						.addComponent(tablepanel, GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE))))
    	 			.addContainerGap())
    	 		.addGroup(groupLayout.createSequentialGroup()
    	 			.addContainerGap()
    	 			.addComponent(back)
    	 			.addPreferredGap(ComponentPlacement.RELATED, 489, Short.MAX_VALUE)
    	 			.addComponent(lblNewLabel_2)
    	 			.addPreferredGap(ComponentPlacement.RELATED)
    	 			.addComponent(rlno, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
    	 			.addPreferredGap(ComponentPlacement.RELATED)
    	 			.addComponent(search)
    	 			.addGap(53))
    	 		.addGroup(groupLayout.createSequentialGroup()
    	 			.addContainerGap(502, Short.MAX_VALUE)
    	 			.addComponent(edit, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
    	 			.addGap(18)
    	 			.addComponent(del)
    	 			.addGap(18)
    	 			.addComponent(btnViewTable)
    	 			.addGap(47))
    	 );
    	 groupLayout.setVerticalGroup(
    	 	groupLayout.createParallelGroup(Alignment.LEADING)
    	 		.addGroup(groupLayout.createSequentialGroup()
    	 			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
    	 				.addGroup(groupLayout.createSequentialGroup()
    	 					.addGap(31)
    	 					.addComponent(back)
    	 					.addPreferredGap(ComponentPlacement.UNRELATED)
    	 					.addComponent(regpanel, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE))
    	 				.addGroup(groupLayout.createSequentialGroup()
    	 					.addGap(4)
    	 					.addComponent(topic, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
    	 					.addGap(9)
    	 					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
    	 						.addComponent(search, 0, 0, Short.MAX_VALUE)
    	 						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
    	 							.addComponent(rlno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
    	 							.addComponent(lblNewLabel_2)))
    	 					.addGap(8)
    	 					.addComponent(tablepanel, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE)))
    	 			.addPreferredGap(ComponentPlacement.UNRELATED)
    	 			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
    	 				.addComponent(btnViewTable, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
    	 				.addComponent(del)
    	 				.addComponent(edit)
    	 				.addComponent(lblNewLabel))
    	 			.addContainerGap(14, Short.MAX_VALUE))
    	 );
    	 f.getContentPane().setLayout(groupLayout);
 	    f.setVisible(true);
 	   viewTable();
    }
     
    
    
    public static void viewTable() {
    	model.setRowCount(0);
		try {   
				
			   myrs=mystmt.executeQuery("select * from StudentRegistration;");
			   while(myrs.next()) {
				    String ID=myrs.getString("ID");
				    String Sname=myrs.getString("Sname");
				    String semester=myrs.getString("sem");
				    String brnch=myrs.getString("branch");
					model.addRow(new Object[]{ID, Sname, brnch,semester });				
			   }
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(f,"There is some Error in fetching data from database");
		}
    }
	
	public void actionPerformed(ActionEvent e){ 
		
		if(e.getSource()==back) {
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
		
		if(e.getSource()==Add) {
			
			String jeerolno=(String)jee.getText(); 
			String ID=(String)id.getText();
			String Sname=(String)name.getText();
			String brnch=(String)br.getSelectedItem();
			String semester=(String)sem.getSelectedItem();
			String section=(String)sec.getSelectedItem();
				
			
		try {
			
		
			
			 myconn.setAutoCommit(false);
		     pstmt=myconn.prepareStatement("insert into StudentRegistration values(?,?,?,?,?,?)");
			 pstmt.setString(1, ID);
			 pstmt.setString(2, Sname);
			 pstmt.setString(3, brnch);
			 pstmt.setString(4, semester);
			 pstmt.setString(5, section);
			 pstmt.setString(6, jeerolno);
			 
			 pstmt.executeUpdate();
			 myconn.commit();
			 JOptionPane.showMessageDialog(f,"Added Successfully");
	
			// id.setText("");
			// name.setText("");
			
			 viewTable();
		}catch(Exception ex) {
				JOptionPane.showMessageDialog(f,"There is some Error to write data into Database");
			}
		}
		
		if(e.getSource()==del) {
			 
			 int rowind =STable.getSelectedRow();
			 int colind=STable.getSelectedColumn();
			// System.out.println(colind);
			 // System.out.println(str);
			 String str =(String)STable.getValueAt(rowind, 0);
			 if(str.isEmpty())
				 JOptionPane.showMessageDialog(f,"Select Any element of row which you want to delete");
			 String sql="delete from StudentRegistration where ID='"+str+"';";
		try {
			
			 JDialog.setDefaultLookAndFeelDecorated(true);
			    int response = JOptionPane.showConfirmDialog(null, "Do you want to delete?", "Confirm",
			        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			    if (response == JOptionPane.NO_OPTION) {
			    } else if (response == JOptionPane.YES_OPTION) {
			    	 myconn.setAutoCommit(false);
					 mystmt.executeUpdate(sql);
					 myconn.commit();
					 JOptionPane.showMessageDialog(f,"Successfully deleted");
			    } else if (response == JOptionPane.CLOSED_OPTION) {
					
			         
			    }
			 viewTable();
			 }catch(Exception ex) {
				 JOptionPane.showMessageDialog(f,"Error! You have selected wrong column probably");
			 }
		
		
		}
		
		if(e.getSource()==edit) {
			 
			int rowno =STable.getSelectedRow();
			
			String rno=(String)STable.getValueAt(rowno, 0);
			String nm=(String)STable.getValueAt(rowno, 1);
			String brnch=(String)STable.getValueAt(rowno, 2);
			String s=(String)STable.getValueAt(rowno, 3);
			
			 id.setText(rno);
			 name.setText(nm);
			
			
			 
			 String sql="delete from StudentRegistration where ID='"+rno+"';";
		try {
			
			    	 myconn.setAutoCommit(false);
					 mystmt.executeUpdate(sql);
					 myconn.commit();
		}catch(Exception ex) {
			 JOptionPane.showMessageDialog(f,"Error!");
		 }
			 
		}
		
		if(e.getSource()==search) {
			
            
			String st = (String)rlno.getText();
			
			
			model.setRowCount(0);
			try {   
			
				   myrs=mystmt.executeQuery("select * from StudentRegistration where ID="+st);
				   while(myrs.next()) {
					    String ID=myrs.getString("ID");
					    String Sname=myrs.getString("Sname");
					    String semester=myrs.getString("sem");
					    String brnch=myrs.getString("branch");
						model.addRow(new Object[]{ID, Sname,semester, brnch });				
				   }
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(f,"There is some Error in fetching data from database");
			}
			
		}
		
		if(e.getSource()==update) {
			 
			String ID=(String)id.getText();
			String Sname=(String)name.getText();
			String brnch=(String)br.getSelectedItem();
			String semester=(String)sem.getSelectedItem();
			String section=(String)sec.getSelectedItem();
			String jeerolno=(String)jee.getText(); 
		try {
			
			 myconn.setAutoCommit(false);
			
		     pstmt=myconn.prepareStatement("insert into studentRegistration values(?,?,?,?,?,?)");
			 pstmt.setString(1, ID);
			 pstmt.setString(2, Sname);
			 pstmt.setString(3, brnch);
			 pstmt.setString(4, semester);
			 pstmt.setString(5, section);
			 pstmt.setString(6, jeerolno);
			 pstmt.executeUpdate();
			 myconn.commit();
			 JOptionPane.showMessageDialog(f,"Updated Successfully");
	
			 id.setText("");
			 name.setText("");
			 
			 viewTable();
		}catch(Exception ex) {
				JOptionPane.showMessageDialog(f,"There is some Error to write data into Database");
			}
			
		}
		
		if(e.getSource()==btnViewTable) {
			
			 viewTable();
		}
		
	}
	
	
//	public static void main(String[] args) {
//	
//		new StudentReg();
//		
//	  try {
//		     myconn=DriverManager.getConnection("jdbc:mysql://localhost:3306/result","root","Satya@1657");
//		     mystmt=myconn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
//		     
//		   
//		     viewTable();
//	  }catch(Exception ex) {
//		  JOptionPane.showMessageDialog(f,"There is some Error in connection with database");
//	  }
//
//	}
}
