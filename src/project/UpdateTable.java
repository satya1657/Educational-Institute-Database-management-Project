package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class UpdateTable implements ActionListener {
	static JLabel cc,sec,sem;
	static JFrame f;
	private JTable table;
	private JTextField id;
	private JTextField marks;
	static DefaultTableModel model;
	static JButton add,search,ref;
	
	static Connection myconn;
	static Statement mystmt;
	static ResultSet myrs;	
	static  PreparedStatement pstmt;
    static	String tnm,forsec,forsem;
	static   JComboBox et; 
	private JButton back;
	/**
	 * @wbp.parser.entryPoint
	 */
	UpdateTable(String st1,String st2,String st3){
		  tnm=st1+st2+st3;
		  forsec=st2;
		  forsem=st3;
		  try {
			     myconn=DriverManager.getConnection("jdbc:mysql://localhost:3306/result","root","Satya@1657");
			     mystmt=myconn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			     
		  }catch(Exception ex) {
			  JOptionPane.showMessageDialog(f,"There is some Error in connection with database");
		  }
		 f= new JFrame("Update Marks");  
		 f.setSize(874,507);  
		    f.getContentPane().setLayout(null);  
		    
		    JScrollPane scrollPane = new JScrollPane();
		    scrollPane.setBounds(262, 102, 573, 243);
		    f.getContentPane().add(scrollPane);
		    model = new DefaultTableModel();
		    table = new JTable();
		    model=new DefaultTableModel(
		    	new Object[][] {
		    		{null, null, null, null, null},
		    	},
		    	new String[] {
		    		"Roll.No.", "Name", "Insem1", "Insem2", "End Sem"
		    	}
		    );
		    table.setModel(model);
		    scrollPane.setViewportView(table);
		    
		    JLabel lblUpdateMarks = new JLabel("Update Marks");
		    lblUpdateMarks.setFont(new Font("Tahoma", Font.BOLD, 20));
		    lblUpdateMarks.setBounds(355, 11, 173, 43);
		    f.getContentPane().add(lblUpdateMarks);
		    
		     et = new JComboBox();
		    
		    
		    
		    et.setModel(new DefaultComboBoxModel(new String[] {"select", "insem1", "insem2", "endsem"}));
		    et.setBounds(113, 244, 116, 22);
		    f.getContentPane().add(et);
		    
		    JLabel lblNewLabel = new JLabel("Exam");
		    lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		    lblNewLabel.setBounds(29, 246, 48, 14);
		    f.getContentPane().add(lblNewLabel);
		    
		    JLabel lblNewLabel_2 = new JLabel("Course Code");
		    lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		    lblNewLabel_2.setBounds(29, 75, 83, 19);
		    f.getContentPane().add(lblNewLabel_2);
		    
		     cc = new JLabel("____________");
		    cc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		    cc.setBounds(122, 75, 107, 19);
		    f.getContentPane().add(cc);
		    
		    JLabel lblNewLabel_2_2 = new JLabel("Roll No");
		    lblNewLabel_2_2.setBounds(535, 75, 48, 14);
		    f.getContentPane().add(lblNewLabel_2_2);
		    
		    id = new JTextField();
		    id.setFont(new Font("Tahoma", Font.PLAIN, 12));
		    id.setColumns(10);
		    id.setBounds(582, 70, 159, 21);
		    f.getContentPane().add(id);
		    
		     search = new JButton("Search");
		    search.setFont(new Font("Tahoma", Font.PLAIN, 12));
		    search.setBounds(751, 70, 84, 21);
		    search.addActionListener(this);
		    f.getContentPane().add(search);
		    
		    JLabel lblNewLabel_1_1 = new JLabel("Section");
		    lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		    lblNewLabel_1_1.setBounds(29, 105, 83, 19);
		    f.getContentPane().add(lblNewLabel_1_1);
		    
		    JLabel lblNewLabel_1_2 = new JLabel("Semester");
		    lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		    lblNewLabel_1_2.setBounds(29, 135, 83, 19);
		    f.getContentPane().add(lblNewLabel_1_2);
		    
		     sec = new JLabel("____________");
		    sec.setFont(new Font("Tahoma", Font.PLAIN, 15));
		    sec.setBounds(122, 105, 107, 19);
		    f.getContentPane().add(sec);
		    
		   sem = new JLabel("____________");
		    sem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		    sem.setBounds(122, 135, 107, 19);
		    f.getContentPane().add(sem);
		    sem.setText(st3);
		    sec.setText(st2);
		    cc.setText(st1);
		     add = new JButton("Add Marks");
		    add.setBounds(85, 354, 116, 23);
		    add.addActionListener(this);
		    f.getContentPane().add(add);
		    
		    JLabel lblMarks = new JLabel("Marks");
		    lblMarks.setFont(new Font("Tahoma", Font.PLAIN, 15));
		    lblMarks.setBounds(29, 288, 48, 14);
		    f.getContentPane().add(lblMarks);
		    
		    marks = new JTextField();
		    marks.setBounds(113, 287, 116, 20);
		    f.getContentPane().add(marks);
		    marks.setColumns(10);
		    
		     ref = new JButton("Refresh");
		    ref.setBounds(514, 356, 83, 23);
		    ref.addActionListener(this);
		    
		    f.getContentPane().add(ref);
		    
		    back = new JButton("Back");
		    back.setBounds(29, 31, 89, 23);
		    back.addActionListener(this);
		    f.getContentPane().add(back);
		    f.setVisible(true);
		    viewTable();
	}
	
	
	
	public void actionPerformed(ActionEvent e){ 
		 if(e.getSource()==add) {
			 
			 int rowind =table.getSelectedRow();
			 int colind=table.getSelectedColumn();
			 String str=(String)table.getValueAt(rowind, 0);
			 String extyp=(String)et.getSelectedItem();
			 String m=(String)marks.getText();
			 int no=Integer.parseInt(m);  
			 
             String q="UPDATE "+tnm+" set "+extyp+"= "+ no +" where roln='"+str+"';";
          //   System.out.println(q);
             try {
     			
    			 
    			    	 myconn.setAutoCommit(false);
    					 mystmt.executeUpdate(q);
    					 myconn.commit();
    					 JOptionPane.showMessageDialog(f,"Successfully updated");
    			 
    			 viewTable();
    			 }catch(Exception ex) {
    				 JOptionPane.showMessageDialog(f,"Error! ");
    			 }
    		
		 }
		 
		 if(e.getSource()==ref) {
			         
			 String q="insert into "+tnm+"(roln,nam) select ID,sname from studentRegistration where sec = '"+forsec+"' and sem ='"+forsem +"'  and ID not in(select roln from "+tnm+");";
			    try {
					
					
					    	 myconn.setAutoCommit(false);
							 mystmt.executeUpdate(q);
							 myconn.commit();
							 viewTable();
					 }catch(Exception ex) {
						 JOptionPane.showMessageDialog(f,"Error!  ");
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
		 
		 if(e.getSource()==search) {
			  
			 String st = (String)id.getText();
				
				
				model.setRowCount(0);
				try {   
				
					   myrs=mystmt.executeQuery("select * from "+tnm+" where roln="+st);
					   while(myrs.next()) {
						   String ID=myrs.getString("roln");
						    String Sname=myrs.getString("nam");
						    String is1=myrs.getString("insem1");
						    String is2=myrs.getString("insem2");
						    String es=myrs.getString("endsem");
							model.addRow(new Object[]{ID, Sname, is1,is2,es });	
					   }
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(f,"There is some Error in fetching data from database");
				}
		 }
	}
	
	 public static void viewTable() {
	    	model.setRowCount(0);
			try {   
					
				   myrs=mystmt.executeQuery("select * from "+tnm+";");
				   while(myrs.next()) {
					    String ID=myrs.getString("roln");
					    String Sname=myrs.getString("nam");
					    String is1=myrs.getString("insem1");
					    String is2=myrs.getString("insem2");
					    String es=myrs.getString("endsem");
						model.addRow(new Object[]{ID, Sname, is1,is2,es });				
				   }
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(f,"There is some Error in fetching data from database");
			}
	    }
	
	
//	public static void main(String[] args) {
//	
//		new UpdateTable("MA114","A","2");
//	}
}
