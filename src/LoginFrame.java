
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField userTf;
	private JPasswordField passF;
	private JLabel passL;
	private JLabel userL; 
	private JButton btnLogin;
	
	private EntityManagment em;
	private Account account;
	private User user;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		
		
		

	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		
		em=new EntityManagment();
		user=new User();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		userTf = new JTextField();
		userTf.setBounds(165, 86, 172, 20);
		contentPane.add(userTf);
		userTf.setColumns(10);
		
		passF = new JPasswordField();
		passF.setBounds(165, 117, 172, 20);
		contentPane.add(passF);
		
	    userL = new JLabel("username\r\n:");
		userL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		userL.setBounds(50, 84, 94, 20);
		contentPane.add(userL);
		
		passL = new JLabel("password");
		passL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passL.setBounds(50, 120, 94, 20);
		contentPane.add(passL);
		
		btnLogin = new JButton("login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.setPassword(String.valueOf(passF.getPassword()));
				user.setUsername(userTf.getText());
				if(em.userExist(user))
				{
				   account=em.loadAccount(user.getUsername());
					account.setUser(user);
				
					PaintFrame pf=new PaintFrame(account);
					pf.setVisible(true);
					dispose();
				}
				
			}
		});
		btnLogin.setBounds(314, 198, 89, 23);
		contentPane.add(btnLogin);
	}
}
