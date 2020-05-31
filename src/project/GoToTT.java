package project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;

public class GoToTT implements ActionListener {

	static JFrame f;
    static JComboBox sem,course;
    static JButton go,lgout;
    static String com;
    /**
     * @wbp.parser.entryPoint
     */
    GoToTT(){
    	f= new JFrame("Move To Time Table");  
    	f.getContentPane().setBackground(new Color(135, 206, 235));
    	f.setSize(444,289);
    	
    	JLabel lblNewLabel = new JLabel("Log In To Access Time Table");
    	lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
    	lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
    	
    	JLabel lblNewLabel_1 = new JLabel("Course");
    	lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
    	
    	JLabel lblNewLabel_1_1 = new JLabel("Semester");
    	lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
    	
    	JLabel lblNewLabel_1_2 = new JLabel("Time Table You want to Access");
    	lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.ITALIC, 14));
    	
    	 go = new JButton("GO");
    	go.setFont(new Font("Times New Roman", Font.BOLD, 14));
    	 go.addActionListener(this);
        course = new JComboBox();
    	course.setModel(new DefaultComboBoxModel(new String[] {"BTech", "MTech"}));
    	
        sem = new JComboBox();
    	sem.setModel(new DefaultComboBoxModel(new String[] {"2", "4", "6"}));
    	
    	 lgout = new JButton("LogOut");
    	 lgout.addActionListener(this);
    	GroupLayout groupLayout = new GroupLayout(f.getContentPane());
    	groupLayout.setHorizontalGroup(
    		groupLayout.createParallelGroup(Alignment.TRAILING)
    			.addGroup(groupLayout.createSequentialGroup()
    				.addGap(38)
    				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
    					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
    					.addComponent(lblNewLabel_1_1))
    				.addGap(18)
    				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
    					.addComponent(course, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    					.addComponent(sem, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
    				.addPreferredGap(ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
    				.addComponent(go, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
    				.addGap(64))
    			.addGroup(groupLayout.createSequentialGroup()
    				.addContainerGap(128, Short.MAX_VALUE)
    				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
    					.addComponent(lblNewLabel_1_2)
    					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE))
    				.addGap(113))
    			.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
    				.addContainerGap()
    				.addComponent(lgout)
    				.addContainerGap(329, Short.MAX_VALUE))
    	);
    	groupLayout.setVerticalGroup(
    		groupLayout.createParallelGroup(Alignment.LEADING)
    			.addGroup(groupLayout.createSequentialGroup()
    				.addContainerGap()
    				.addComponent(lblNewLabel)
    				.addGap(7)
    				.addComponent(lgout)
    				.addGap(8)
    				.addComponent(lblNewLabel_1_2, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
    				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
    					.addGroup(groupLayout.createSequentialGroup()
    						.addGap(29)
    						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
    							.addComponent(lblNewLabel_1)
    							.addComponent(course, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
    						.addGap(26)
    						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
    							.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
    							.addComponent(sem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
    					.addGroup(groupLayout.createSequentialGroup()
    						.addGap(46)
    						.addComponent(go)))
    				.addContainerGap(72, Short.MAX_VALUE))
    	);
    	f.getContentPane().setLayout(groupLayout);
	    f.setVisible(true); 	
    }
    
    public void actionPerformed(ActionEvent e){ 
    	  if(e.getSource()==go) {
    		  
    		  String s=(String)sem.getSelectedItem();   //s=semester
    		  String c=(String)course.getSelectedItem(); // c=course 
    		  
    		  com=c+s;
    		  new TimeTable(com);
    		  //System.out.println(com);
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
//		 new GoToTT();
//	}
}
