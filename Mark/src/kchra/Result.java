import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;


public class Result extends JFrame {

	JButton[] Viewbtn =new JButton[100];
	 int count=0;
	Result(ResultSet rs){
		try {
			//counting of number of rows in rs
			rs.last(); 
			count=rs.getRow();
			rs.beforeFirst();
			//System.out.println(count);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JPanel cp= new JPanel();
		//setting grid layout of 3 rows and 3 columns
		cp.setLayout(new GridLayout(count+1,3));
		add(new JScrollPane(cp));
		//cp.add(s);
	
		
	  
	    setSize(1600,900);  
	  
	    ListenerView o = new ListenerView(this);

	     JLabel b1=new JLabel("SSSMID");  
	    JLabel b2=new JLabel("NAME");  
	    JLabel b3=new JLabel("VIEW PROFILE");  
	    /*JLabel b4=new JLabel("4");  
	    JLabel b5=new JLabel("5");  
	        JLabel b6=new JLabel("6");  
	        JLabel b7=new JLabel("7");  
	    JLabel b8=new JLabel("8");  
	        JLabel b9=new JLabel("9");  
	      */    
	    b1.setFont(new Font("Courier", Font.BOLD,42));
	    b2.setFont(new Font("Courier", Font.BOLD,42));
	    b3.setFont(new Font("Courier", Font.BOLD,42));
	    cp.add(b1);cp.add(b2);cp.add(b3);
	    /*add(b4);add(b5);  
	    add(b6);add(b7);add(b8);add(b9);*/
	    
	    
	    try {
			int i=0;
			while(rs.next()){
					Viewbtn[i]=new JButton("View");
					
					Viewbtn[i].setActionCommand(rs.getString("id"));
					Viewbtn[i].addActionListener(o);
					 cp.add(new JLabel(rs.getString("sssmid")));
					 cp.add(new JLabel(rs.getString("name")));
					 cp.add(Viewbtn[i]);
					
			        //jt.getColumn("SALARY").setCellEditor(new ButtonEditor(new JCheckBox()));
	                //dtm.addRow(new Object[]{rs.getString("aadhar"),rs.getString("sssmid"),Viewbtn[i]});
	                i++;
			System.out.println(rs.getString("name"));
			}
			//addNumtf.setText(rs.getString("name"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    
	    
	    
	    
	    
	    
	    
	  
	      setVisible(true);  
	}  
	 


}

class ListenerView extends DBConnection implements ActionListener{

	Result as;

	ListenerView(Result as){
			this.as = as;
	}

	public void actionPerformed(ActionEvent e1){

			System.out.println(e1.getActionCommand());
			new ViewFull(e1.getActionCommand());
			
	}


}