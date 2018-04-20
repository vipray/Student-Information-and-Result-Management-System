import javax.swing.*;



import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

class LoginView extends JFrame{
	static DBConnection db;
	JButton loginBtn;
	JTextArea usertf;
	JTextArea passtf;

	public LoginView(){

		setSize(600,600);

		Container cp=getContentPane();
		cp.setBackground(Color.cyan);
		cp.setLayout(new FlowLayout());

		JLabel userl = new JLabel("Username");
		cp.add(userl);

		usertf = new JTextArea(1,45);
		cp.add(usertf);

		JLabel passl = new JLabel("Password");
		cp.add(passl);

		passtf = new JTextArea(1,45);
		cp.add(passtf);
		

		Listener o = new Listener(this);

		loginBtn = new JButton("Login");
		loginBtn.addActionListener(o);
		cp.add(loginBtn);
		

		setVisible(true);
	}

	
	public static void main(String args[]){
		
		new LoginView();
		new DBConnection();
	}

}

class Listener extends DBConnection implements ActionListener{

	LoginView lv;
	//Listener sunn;
	DBConnection db;
	Listener(LoginView lv){
			this.lv = lv;
			 
	}

	public void actionPerformed(ActionEvent e){

		if( e.getSource() == lv.loginBtn ){
			String u=lv.usertf.getText();
			String p=lv.passtf.getText();
			String q= "SELECT * FROM admin WHERE username='"+u+"' AND password='"+p+"'";
			System.out.print(q);
			//String id = "";
			//ResultSet rs;
			try {
				rs=s.executeQuery(q);
				System.out.println("DATA: \n");
				
				while(rs.next()){
					new Dashboard();
					lv.setVisible(false);
					break;
				}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//return false;
			
		
			/*boolean aaya=DBConnection.db.login(lv.usertf.getText(),lv.passtf.getText());
			if(aaya){
				new Dashboard();
				lv.setVisible(false);
			}*/
			
			
		}

	}


}