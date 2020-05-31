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
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;

public class FacultyDetails implements ActionListener {

	static JFrame f;
	private JTextField fnm;
	private JTextField fid;
	private JTextField sub;
	private JTextField srno;
	static DefaultTableModel model;
	 private JButton Add,update,edit,del,search,btnViewTable,rf;
	
	static Connection myconn;
	static Statement mystmt;
	static ResultSet myrs;	
	static  PreparedStatement pstmt;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton back;
	
	FacultyDetails(){
		 try {
		     myconn=DriverManager.getConnection("jdbc:mysql://localhost:3306/result","root","Satya@1657");
		     mystmt=myconn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		     
	  }catch(Exception ex) {
		  JOptionPane.showMessageDialog(f,"There is some Error in connection wit database");
	  }
		 f=new JFrame("Faculty Details");
		 f.getContentPane().setBackground(new Color(255, 228, 196));
		    f.setSize(897,512);
		    
		    JLabel lblFacultydetails = new JLabel("FacultyDetails");
		    lblFacultydetails.setVerticalAlignment(SwingConstants.TOP);
		    lblFacultydetails.setHorizontalAlignment(SwingConstants.CENTER);
		    lblFacultydetails.setFont(new Font("Verdana", Font.BOLD, 18));
		    
		    JPanel regpanel = new JPanel();
		    regpanel.setBackground(new Color(255, 250, 240));
		    regpanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		    
		    JLabel lblNewLabel_1_2 = new JLabel("Subject");
		    lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		    
		    JLabel lblNewLabel_1_1 = new JLabel("Name");
		    lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		    
		    fnm = new JTextField();
		    fnm.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		    fnm.setColumns(10);
		    
		    JLabel lblNewLabel_1 = new JLabel("Faculty ID");
		    lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		    
		    fid = new JTextField();
		    fid.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		    fid.setColumns(10);
		    
		     update = new JButton("UPDATE");
		    update.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		    update.addActionListener(this);
		    
		    Add = new JButton("ADD");
		    Add.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		    Add.addActionListener(this);
		    
		    sub = new JTextField();
		    sub.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		    sub.setColumns(10);
		    GroupLayout gl_regpanel = new GroupLayout(regpanel);
		    gl_regpanel.setHorizontalGroup(
		    	gl_regpanel.createParallelGroup(Alignment.LEADING)
		    		.addGap(0, 272, Short.MAX_VALUE)
		    		.addGroup(gl_regpanel.createSequentialGroup()
		    			.addContainerGap()
		    			.addGroup(gl_regpanel.createParallelGroup(Alignment.LEADING)
		    				.addGroup(gl_regpanel.createSequentialGroup()
		    					.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
		    					.addPreferredGap(ComponentPlacement.RELATED)
		    					.addComponent(sub, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))
		    				.addGroup(gl_regpanel.createParallelGroup(Alignment.LEADING, false)
		    					.addGroup(gl_regpanel.createSequentialGroup()
		    						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
		    						.addPreferredGap(ComponentPlacement.RELATED)
		    						.addComponent(fnm))
		    					.addGroup(gl_regpanel.createSequentialGroup()
		    						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
		    						.addPreferredGap(ComponentPlacement.RELATED)
		    						.addComponent(fid, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE))))
		    			.addGap(30))
		    		.addGroup(gl_regpanel.createSequentialGroup()
		    			.addGap(20)
		    			.addComponent(update, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
		    			.addGap(18)
		    			.addComponent(Add, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
		    			.addGap(35))
		    );
		    gl_regpanel.setVerticalGroup(
		    	gl_regpanel.createParallelGroup(Alignment.LEADING)
		    		.addGap(0, 291, Short.MAX_VALUE)
		    		.addGroup(gl_regpanel.createSequentialGroup()
		    			.addGap(37)
		    			.addGroup(gl_regpanel.createParallelGroup(Alignment.BASELINE)
		    				.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
		    				.addComponent(fid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		    			.addGap(18)
		    			.addGroup(gl_regpanel.createParallelGroup(Alignment.BASELINE)
		    				.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
		    				.addComponent(fnm, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
		    			.addGap(18)
		    			.addGroup(gl_regpanel.createParallelGroup(Alignment.BASELINE)
		    				.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
		    				.addComponent(sub, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
		    			.addGap(82)
		    			.addGroup(gl_regpanel.createParallelGroup(Alignment.BASELINE)
		    				.addComponent(update, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
		    				.addComponent(Add))
		    			.addContainerGap(23, Short.MAX_VALUE))
		    );
		    regpanel.setLayout(gl_regpanel);
		    
		    JLabel lblNewLabel = new JLabel("For Edit OR Delete please Select from Table\r\n");
		    lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		    
		    JPanel tablepanel = new JPanel();
		    tablepanel.setBackground(new Color(255, 250, 240));
		    tablepanel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		    
		    
		    model = new DefaultTableModel();
			  String data[][]= {
		     	 		{"201851112", "karan ", "2", "CSE"},
		     	 		{"201851113", "kamal ", "2", "IT"},
		     	 		{"201851114", "mamta", "3", "IT"},
		     	 		{"201851114", "kapil ", "3", "CSE"}};
			  
			  String head[]={"FacultyID", "name", "subject"};   //888

			  model.setColumnIdentifiers(head);
		    
		    scrollPane = new JScrollPane();
		    
		    rf = new JButton("Refrsh");
		    rf.setFont(new Font("Times New Roman", Font.PLAIN, 14));
            rf.addActionListener(this);
		    
//		    table = new JTable();
//		    table.setSurrendersFocusOnKeystroke(true);
//		    table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
//		    table.setFillsViewportHeight(true);
//		    table.setColumnSelectionAllowed(true);
//		    table.setCellSelectionEnabled(true);
//		    table.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
//		    table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		    GroupLayout gl_tablepanel = new GroupLayout(tablepanel);
		    gl_tablepanel.setHorizontalGroup(
		    	gl_tablepanel.createParallelGroup(Alignment.LEADING)
		    		.addGroup(gl_tablepanel.createSequentialGroup()
		    			.addContainerGap()
		    			.addGroup(gl_tablepanel.createParallelGroup(Alignment.LEADING)
		    				.addGroup(gl_tablepanel.createSequentialGroup()
		    					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
		    					.addContainerGap())
		    				.addGroup(Alignment.TRAILING, gl_tablepanel.createSequentialGroup()
		    					.addComponent(rf, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
		    					.addGap(212))))
		    );
		    gl_tablepanel.setVerticalGroup(
		    	gl_tablepanel.createParallelGroup(Alignment.LEADING)
		    		.addGroup(gl_tablepanel.createSequentialGroup()
		    			.addContainerGap()
		    			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)
		    			.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
		    			.addComponent(rf, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
		    			.addContainerGap())
		    );
		    
		    table = new JTable();
		    table.setBackground(new Color(255, 250, 205));
		    model=new DefaultTableModel(
		    	new Object[][] {
		    		{null, null, null},
		    	},
		    	new String[] {
		    		"Facilty ID", "Name", "Subject"
		    	}
		    );
		    table.setModel(model);
		    scrollPane.setViewportView(table);
		    tablepanel.setLayout(gl_tablepanel);
		    
		    JLabel lblNewLabel_2 = new JLabel("Faculty ID");
		    
		    srno = new JTextField();
		    srno.setFont(new Font("Tahoma", Font.PLAIN, 12));
		    srno.setColumns(10);
		    
		    search = new JButton("Search");
		    search.setFont(new Font("Tahoma", Font.PLAIN, 12));
		    search.addActionListener(this);
		    
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
		    	groupLayout.createParallelGroup(Alignment.TRAILING)
		    		.addGroup(groupLayout.createSequentialGroup()
		    			.addContainerGap()
		    			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
		    				.addComponent(regpanel, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
		    				.addComponent(back))
		    			.addPreferredGap(ComponentPlacement.UNRELATED)
		    			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
		    				.addComponent(lblFacultydetails, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
		    				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
		    					.addGroup(groupLayout.createSequentialGroup()
		    						.addGap(4)
		    						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
		    						.addPreferredGap(ComponentPlacement.UNRELATED)
		    						.addComponent(edit, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
		    						.addPreferredGap(ComponentPlacement.UNRELATED)
		    						.addComponent(del, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
		    						.addPreferredGap(ComponentPlacement.UNRELATED)
		    						.addComponent(btnViewTable, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		    					.addGroup(groupLayout.createSequentialGroup()
		    						.addGap(259)
		    						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
		    						.addPreferredGap(ComponentPlacement.RELATED)
		    						.addComponent(srno, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
		    						.addPreferredGap(ComponentPlacement.RELATED)
		    						.addComponent(search, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		    					.addComponent(tablepanel, GroupLayout.PREFERRED_SIZE, 568, GroupLayout.PREFERRED_SIZE)))
		    			.addContainerGap(21, Short.MAX_VALUE))
		    );
		    groupLayout.setVerticalGroup(
		    	groupLayout.createParallelGroup(Alignment.LEADING)
		    		.addGroup(groupLayout.createSequentialGroup()
		    			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
		    				.addGroup(groupLayout.createSequentialGroup()
		    					.addGap(44)
		    					.addComponent(back)
		    					.addPreferredGap(ComponentPlacement.RELATED)
		    					.addComponent(regpanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		    				.addGroup(groupLayout.createSequentialGroup()
		    					.addContainerGap()
		    					.addComponent(lblFacultydetails, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
		    					.addGap(8)
		    					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
		    						.addComponent(lblNewLabel_2)
		    						.addComponent(srno, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
		    						.addComponent(search, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
		    					.addPreferredGap(ComponentPlacement.RELATED)
		    					.addComponent(tablepanel, GroupLayout.PREFERRED_SIZE, 356, GroupLayout.PREFERRED_SIZE)))
		    			.addPreferredGap(ComponentPlacement.UNRELATED)
		    			.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
		    				.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 12, GroupLayout.PREFERRED_SIZE)
		    				.addComponent(edit, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
		    				.addComponent(del, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
		    				.addComponent(btnViewTable, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
		    );
		    f.getContentPane().setLayout(groupLayout);
		    f.setVisible(true);  
		    viewTable();
	}
	 
	 public static void viewTable() {
	    	model.setRowCount(0);
			try {   
					
				   myrs=mystmt.executeQuery("select * from faculty;");
				   while(myrs.next()) {
					    String ID=myrs.getString("fID");
					    String fnm=myrs.getString("fname");
					    String sub=myrs.getString("sub");
					    
						model.addRow(new Object[]{ID, fnm, sub});				
				   }
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(f,"There is some Error in fetching data from database");
			}
	    }
	
	public void actionPerformed(ActionEvent e){ 
		
		if(e.getSource()==Add) {
			 
			String ID=(String)fid.getText();
			String fname=(String)fnm.getText();
			String subject=(String)sub.getText();
		try {
			 myconn.setAutoCommit(false);
			
		     pstmt=myconn.prepareStatement("insert into faculty values(?,?,?)");
			 pstmt.setString(1, ID);
			 pstmt.setString(2, fname);
			 pstmt.setString(3, subject);
			 
			 
			 pstmt.executeUpdate();
			 myconn.commit();
			 JOptionPane.showMessageDialog(f,"Added Successfully");
	
			 fid.setText("");
			 fnm.setText("");
			 sub.setText("");
			 
			 viewTable();
		}catch(Exception ex) {
				JOptionPane.showMessageDialog(f,"There is some Error to write data into Database");
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
		
		if(e.getSource()==del) {
			 
			 int rowind =table.getSelectedRow();
			 int colind=table.getSelectedColumn();
			 String str =(String)table.getValueAt(rowind, 0);
			 if(str.isEmpty())
				 JOptionPane.showMessageDialog(f,"Select Any element of row which you want to delete");
			 String sql="delete from faculty where fid='"+str+"';";
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
			String s=(String)table.getValueAt(rowno, 2);
			
			 fid.setText(id);
			 fnm.setText(nm);
			 sub.setText(s);
			
			 
			 String sql="delete from faculty where fid='"+id+"';";
		try {
			
			    	 myconn.setAutoCommit(false);
					 mystmt.executeUpdate(sql);
					 myconn.commit();
		}catch(Exception ex) {
			 JOptionPane.showMessageDialog(f,"Error!");
		 }
			 
		}
		
		if(e.getSource()==update) {
			 
			String ID=(String)fid.getText();
			String fname=(String)fnm.getText();
			String subject=(String)sub.getText();
		try {
			 myconn.setAutoCommit(false);
			
		     pstmt=myconn.prepareStatement("insert into faculty values(?,?,?)");
			 pstmt.setString(1, ID);
			 pstmt.setString(2, fname);
			 pstmt.setString(3, subject);
			 
			 
			 pstmt.executeUpdate();
			 myconn.commit();
			 JOptionPane.showMessageDialog(f,"updated Successfully");
	
			 fid.setText("");
			 fnm.setText("");
			 sub.setText("");
			 
			 viewTable();
		}catch(Exception ex) {
				JOptionPane.showMessageDialog(f,"There is some Error to write data into Database");
			}
		}
		
if(e.getSource()==search) {
			
            
			String st = (String)srno.getText();
			
			
			model.setRowCount(0);
			try {   
			
				   myrs=mystmt.executeQuery("select * from faculty where fID="+st);
				   while(myrs.next()) {
					    String ID=myrs.getString("fID");
					    String fname=myrs.getString("fname");
					    String s=myrs.getString("sub");
						model.addRow(new Object[]{ID, fname,s });				
				   }
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(f,"There is some Error in fetching data from database");
			}
			
		}
	
		if(e.getSource()==btnViewTable) {
	
				viewTable();
				}
		
		if(e.getSource()==rf) {
			  
			    String q="insert into faculty(fid,fname) select empID , Ename from EmpReg where lev ='B' and empID not in(select fid from faculty);";
			    try {
					
					
					    	 myconn.setAutoCommit(false);
							 mystmt.executeUpdate(q);
							 myconn.commit();
							 viewTable();
					 }catch(Exception ex) {
						 JOptionPane.showMessageDialog(f,"Error!  ");
					 }
		}
		
	}
	 
//	public static void main(String[] args) {
//		new FacultyDetails();
//
//		 try {
//		     myconn=DriverManager.getConnection("jdbc:mysql://localhost:3306/result","root","Satya@1657");
//		     mystmt=myconn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
//		     viewTable();
//	  }catch(Exception ex) {
//		  JOptionPane.showMessageDialog(f,"There is some Error in connection wit database");
//	  }
//	}
}

