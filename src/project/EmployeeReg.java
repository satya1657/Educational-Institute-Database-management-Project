package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import java.awt.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
public class EmployeeReg implements ActionListener {
      
	 static JFrame f;
	 private JTextField name;
	 private JTextField empid;
	 private JTextField jd;
	 private JTextField sid;
	 private JComboBox desig;
	 private JButton update,Add,search,edit,del,btnViewTable;
	 
	 static DefaultTableModel model;
	 
	 static Connection myconn;
		static Statement mystmt;
		static ResultSet myrs;	
		static  PreparedStatement pstmt;
		private JScrollPane scrollPane;
		private JTable table;
		private JButton back;
	 
	 EmployeeReg(){
		 
		 try {
  		     myconn=DriverManager.getConnection("jdbc:mysql://localhost:3306/result","root","Satya@1657");
  		     mystmt=myconn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
  		    
  	  }catch(Exception ex) {
  		  JOptionPane.showMessageDialog(f,"There is some Error in connection wit database");
  	  }
		 
		 
		  f=new JFrame("Employee Registration");
		  f.getContentPane().setBackground(new Color(153, 204, 204));
		  
		  f.setSize(929,500);
		  
		  JLabel lblEmployeeRegistration = new JLabel("Employee Registration");
		  lblEmployeeRegistration.setVerticalAlignment(SwingConstants.TOP);
		  lblEmployeeRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		  lblEmployeeRegistration.setFont(new Font("Verdana", Font.BOLD, 18));
		  
		  JPanel regpanel = new JPanel();
		  regpanel.setBackground(new Color(204, 204, 255));
		  regpanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		  
		  JLabel lblNewLabel_1_3 = new JLabel("Designation");
		  lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		  
		  desig = new JComboBox();
		  desig.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D"}));
		  desig.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		  
		  JLabel lblNewLabel_1_1 = new JLabel("Name");
		  lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		  
		  name = new JTextField();
		  name.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		  name.setColumns(10);
		  
		  JLabel lblNewLabel_1 = new JLabel("Employee ID");
		  lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		  
		  empid = new JTextField();
		  empid.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		  empid.setColumns(10);
		  
		  update = new JButton("UPDATE");
		  update.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		  update.addActionListener(this);
		  
		  Add = new JButton("ADD");
		  Add.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		  Add.addActionListener(this);
		  
		  JLabel lblNewLabel_1_1_1 = new JLabel("Joining Date");
		  lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		  
		  jd = new JTextField();
		  jd.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		  jd.setColumns(10);
		  GroupLayout gl_regpanel = new GroupLayout(regpanel);
		  gl_regpanel.setHorizontalGroup(
		  	gl_regpanel.createParallelGroup(Alignment.LEADING)
		  		.addGroup(gl_regpanel.createSequentialGroup()
		  			.addGap(20)
		  			.addComponent(update, GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
		  			.addGap(18)
		  			.addComponent(Add, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
		  			.addGap(35))
		  		.addGroup(gl_regpanel.createSequentialGroup()
		  			.addGroup(gl_regpanel.createParallelGroup(Alignment.TRAILING)
		  				.addGroup(gl_regpanel.createSequentialGroup()
		  					.addContainerGap()
		  					.addGroup(gl_regpanel.createParallelGroup(Alignment.LEADING, false)
		  						.addGroup(gl_regpanel.createSequentialGroup()
		  							.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
		  							.addPreferredGap(ComponentPlacement.RELATED)
		  							.addComponent(desig, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		  						.addGroup(gl_regpanel.createSequentialGroup()
		  							.addGroup(gl_regpanel.createParallelGroup(Alignment.LEADING, false)
		  								.addComponent(lblNewLabel_1_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		  								.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
		  							.addPreferredGap(ComponentPlacement.RELATED)
		  							.addGroup(gl_regpanel.createParallelGroup(Alignment.TRAILING, false)
		  								.addGroup(gl_regpanel.createSequentialGroup()
		  									.addComponent(name)
		  									.addPreferredGap(ComponentPlacement.RELATED))
		  								.addComponent(empid, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)))))
		  				.addGroup(Alignment.LEADING, gl_regpanel.createSequentialGroup()
		  					.addContainerGap()
		  					.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
		  					.addPreferredGap(ComponentPlacement.RELATED)
		  					.addComponent(jd, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)))
		  			.addContainerGap(32, Short.MAX_VALUE))
		  );
		  gl_regpanel.setVerticalGroup(
		  	gl_regpanel.createParallelGroup(Alignment.LEADING)
		  		.addGroup(gl_regpanel.createSequentialGroup()
		  			.addGap(37)
		  			.addGroup(gl_regpanel.createParallelGroup(Alignment.BASELINE)
		  				.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
		  				.addComponent(empid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		  			.addGap(18)
		  			.addGroup(gl_regpanel.createParallelGroup(Alignment.BASELINE)
		  				.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
		  				.addComponent(name, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
		  			.addGap(18)
		  			.addGroup(gl_regpanel.createParallelGroup(Alignment.BASELINE)
		  				.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
		  				.addComponent(jd, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
		  			.addGap(16)
		  			.addGroup(gl_regpanel.createParallelGroup(Alignment.BASELINE)
		  				.addComponent(lblNewLabel_1_3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
		  				.addComponent(desig, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
		  			.addGap(44)
		  			.addGroup(gl_regpanel.createParallelGroup(Alignment.BASELINE)
		  				.addComponent(update, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
		  				.addComponent(Add))
		  			.addContainerGap(24, Short.MAX_VALUE))
		  );
		  regpanel.setLayout(gl_regpanel);
		  
		  JLabel lblNewLabel_2 = new JLabel("Employee ID");
		  
		  sid = new JTextField();
		  sid.setFont(new Font("Tahoma", Font.PLAIN, 12));
		  sid.setColumns(10);
		  
		  search = new JButton("Search");
		  search.setFont(new Font("Tahoma", Font.PLAIN, 12));
		  search.addActionListener(this);
		  JLabel lblNewLabel = new JLabel("For Edit OR Delete please Select from Table\r\n");
		  lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		  
		  JPanel tablepanel = new JPanel();
		  tablepanel.setBackground(new Color(204, 204, 255));
		  tablepanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		  
		  
		  model = new DefaultTableModel();
		 	  
		  scrollPane = new JScrollPane();
		   
		  GroupLayout gl_tablepanel = new GroupLayout(tablepanel);
		  gl_tablepanel.setHorizontalGroup(
		  	gl_tablepanel.createParallelGroup(Alignment.TRAILING)
		  		.addGroup(Alignment.LEADING, gl_tablepanel.createSequentialGroup()
		  			.addContainerGap()
		  			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
		  			.addContainerGap())
		  );
		  gl_tablepanel.setVerticalGroup(
		  	gl_tablepanel.createParallelGroup(Alignment.TRAILING)
		  		.addGroup(Alignment.LEADING, gl_tablepanel.createSequentialGroup()
		  			.addContainerGap()
		  			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)
		  			.addContainerGap(22, Short.MAX_VALUE))
		  );
		  
		  table = new JTable();
		  table.setBackground(new Color(255, 255, 204));
		  model=new DefaultTableModel(
		  	new Object[][] {
		  		{null, null, null, null},
		  	},
		  	new String[] {
		  		"EmployeeID", "Name", "Joining Date", "Designation"
		  	}
		  );
		  table.setModel(model);
		  scrollPane.setViewportView(table);
		  tablepanel.setLayout(gl_tablepanel);
		  
		  edit = new JButton("EDIT");
		  edit.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		  edit.addActionListener(this);
		  
		  del = new JButton("DELETE");
		  del.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		  del.addActionListener(this);
		  
		  btnViewTable = new JButton("VIEW FULL TABLE");
		  btnViewTable.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		  btnViewTable.addActionListener(this);
		  
		  back = new JButton("Back");
		  back.addActionListener(this);
		  GroupLayout groupLayout = new GroupLayout(f.getContentPane());
		  groupLayout.setHorizontalGroup(
		  	groupLayout.createParallelGroup(Alignment.LEADING)
		  		.addGroup(groupLayout.createSequentialGroup()
		  			.addContainerGap()
		  			.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
		  				.addGroup(groupLayout.createSequentialGroup()
		  					.addComponent(lblEmployeeRegistration, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
		  					.addGap(328))
		  				.addGroup(groupLayout.createSequentialGroup()
		  					.addComponent(regpanel, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
		  					.addGap(18)
		  					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
		  						.addGroup(groupLayout.createSequentialGroup()
		  							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
		  							.addPreferredGap(ComponentPlacement.UNRELATED)
		  							.addComponent(edit, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
		  							.addGap(18)
		  							.addComponent(del, GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
		  							.addGap(18)
		  							.addComponent(btnViewTable, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
		  						.addComponent(tablepanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		  					.addContainerGap())
		  				.addGroup(groupLayout.createSequentialGroup()
		  					.addComponent(back)
		  					.addPreferredGap(ComponentPlacement.RELATED, 525, Short.MAX_VALUE)
		  					.addComponent(lblNewLabel_2)
		  					.addPreferredGap(ComponentPlacement.UNRELATED)
		  					.addComponent(sid, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
		  					.addPreferredGap(ComponentPlacement.RELATED)
		  					.addComponent(search, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
		  					.addContainerGap())))
		  );
		  groupLayout.setVerticalGroup(
		  	groupLayout.createParallelGroup(Alignment.LEADING)
		  		.addGroup(groupLayout.createSequentialGroup()
		  			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
		  				.addGroup(groupLayout.createSequentialGroup()
		  					.addContainerGap()
		  					.addComponent(lblEmployeeRegistration, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
		  					.addGap(12)
		  					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
		  						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
		  							.addComponent(sid, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
		  							.addComponent(lblNewLabel_2))
		  						.addComponent(search, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
		  					.addPreferredGap(ComponentPlacement.RELATED)
		  					.addComponent(tablepanel, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE)
		  					.addPreferredGap(ComponentPlacement.UNRELATED)
		  					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
		  						.addGroup(groupLayout.createSequentialGroup()
		  							.addGap(8)
		  							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE))
		  						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
		  							.addComponent(btnViewTable, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
		  							.addComponent(del, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
		  							.addComponent(edit, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))))
		  				.addGroup(groupLayout.createSequentialGroup()
		  					.addGap(35)
		  					.addComponent(back)
		  					.addGap(18)
		  					.addComponent(regpanel, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE)))
		  			.addContainerGap(15, Short.MAX_VALUE))
		  );
		  f.getContentPane().setLayout(groupLayout);
		    f.setVisible(true);
		    viewTable();
	 }
     
	 public static void viewTable() {
	    	model.setRowCount(0);
			try {   
					
				   myrs=mystmt.executeQuery("select * from EmpReg;");
				   while(myrs.next()) {
					    String ID=myrs.getString("empID");
					    String name=myrs.getString("Ename");
					    String joindate=myrs.getString("jod");
					    String level=myrs.getString("lev");
						model.addRow(new Object[]{ID, name, joindate, level  });				
				   }
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(f,"There is some Error in fetching data from database");
			}
	    }
	 
	public void actionPerformed(ActionEvent e){
		
		if(e.getSource()==Add) {
			 
			String ID=(String)empid.getText();
			String ename=(String)name.getText();
			String jondate=(String)jd.getText();
			String level=(String)desig.getSelectedItem();
		try {
			 //mystmt=myconn.createStatement();
			 myconn.setAutoCommit(false);
			
		     pstmt=myconn.prepareStatement("insert into EmpReg values(?,?,?,?)");
			 pstmt.setString(1, ID);
			 pstmt.setString(2, ename);
			 pstmt.setString(3, jondate);
			 pstmt.setString(4, level);
			 
			 
			 pstmt.executeUpdate();
			 myconn.commit();
			 JOptionPane.showMessageDialog(f,"Added Successfully");
	
//			 empid.setText("");
//			 name.setText("");
//			 jd.setText("");
			 
			 viewTable();
			 
		}catch(Exception ex) {
				JOptionPane.showMessageDialog(f,"There is some Error to write data into Database");
			}
     	}
		
		if(e.getSource()==del) {
			 
			 int rowind =table.getSelectedRow();
			 int colind=table.getSelectedColumn();
			// System.out.println(colind);
			 // System.out.println(str);
			 String str =(String)table.getValueAt(rowind, 0);
			 if(str.isEmpty())
				 JOptionPane.showMessageDialog(f,"Select Any element of row which you want to delete");
			 String sql="delete from EmpReg where empID='"+str+"';";
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
			 
			int rowno =table.getSelectedRow();
			
			String id=(String)table.getValueAt(rowno, 0);
			String nm=(String)table.getValueAt(rowno, 1);
			String date=(String)table.getValueAt(rowno, 2);
			//String s=(String)table.getValueAt(rowno, 3);
			
			
			 empid.setText(id);
			 name.setText(nm);
			 jd.setText(date);
			
			 
			 String sql="delete from EmpReg where empID='"+id+"';";
		try {
			    	 myconn.setAutoCommit(false);
					 mystmt.executeUpdate(sql);
					 myconn.commit();
		}catch(Exception ex) {
			 JOptionPane.showMessageDialog(f,"Error!");
		 }
			 
		}
		
		
if(e.getSource()==search) {
			String st = (String)sid.getText();
			
			model.setRowCount(0);
			try {   
				   //mystmt=myconn.createStatement();
				   myrs=mystmt.executeQuery("select * from EmpReg where empID='"+st+"' ;");
				  // System.out.println(st);
				   while(myrs.next()) {
					    String id=myrs.getString("empID");
					    String ename=myrs.getString("Ename");
					    String date=myrs.getString("jod");
					    String des=myrs.getString("lev");
					    
					 //  System.out.println(ename);
					   
						model.addRow(new Object[]{id, ename, date, des });				
				   }  
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(f,"There is some Error in fetching data from database");
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

if(e.getSource()==update) {
	 
	String ID=(String)empid.getText();
	String ename=(String)name.getText();
	String date=(String)jd.getText();
	String lev=(String)desig.getSelectedItem();
try {
	 //mystmt=myconn.createStatement();
	 myconn.setAutoCommit(false);
	
     pstmt=myconn.prepareStatement("insert into EmpReg values(?,?,?,?)");
	 pstmt.setString(1, ID);
	 pstmt.setString(2, ename);
	 pstmt.setString(3, date);
	 pstmt.setString(4, lev);
	 
	 
	 pstmt.executeUpdate();
	 myconn.commit();
	 JOptionPane.showMessageDialog(f,"Updated Successfully");

	 empid.setText("");
	 name.setText("");
	 jd.setText("");
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
//           new EmployeeReg();
//           try {
//  		     myconn=DriverManager.getConnection("jdbc:mysql://localhost:3306/result","root","Satya@1657");
//  		     mystmt=myconn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
//  		     viewTable();
//  	  }catch(Exception ex) {
//  		  JOptionPane.showMessageDialog(f,"There is some Error in connection wit database");
//  	  }
//           
//           
//	}
}
