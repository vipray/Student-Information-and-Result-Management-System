import java.awt.*;  
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;  
  
public class MyGridLayout extends JFrame{   
 JButton[] Viewbtn =new JButton[100];
 int count=0;
MyGridLayout(ResultSet rs){
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
	setLayout(new GridLayout(count,3));  
    //setting grid layout of 3 rows and 3 columns  
  
    setSize(300,300);  
  
      
    /* JLabel b1=new JLabel("1");  
    JLabel b2=new JLabel("2");  
    JLabel b3=new JLabel("3");  
    JLabel b4=new JLabel("4");  
    JLabel b5=new JLabel("5");  
        JLabel b6=new JLabel("6");  
        JLabel b7=new JLabel("7");  
    JLabel b8=new JLabel("8");  
        JLabel b9=new JLabel("9");  
          
    add(b1);add(b2);add(b3);*/
    /*add(b4);add(b5);  
    add(b6);add(b7);add(b8);add(b9);*/
    
    
    try {
		int i=0;
		while(rs.next()){
				Viewbtn[i]=new JButton("View");
				
				 add(new JLabel(rs.getString("sssmid")));
				 add(new JLabel(rs.getString("name")));
				 add(Viewbtn[i]);
				
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