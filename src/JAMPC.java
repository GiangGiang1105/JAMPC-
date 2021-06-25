import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.Selector;
import java.util.Date;
import java.util.StringTokenizer;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.*;

public class JAMPC extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel port_apache;
	private JTextArea textArea;
	
	static boolean verbose = true; 
	static final File WEB_ROOT = new File(".");
	static final String DEFAULT_FILE = "index.html";
	static final String FILE_NOT_FOUND = "404.html";
	static final String METHOD_NOT_SUPPORTED = "not_supported.html";
	private static Socket connect; 
	public static ServerSocket serverSocket;
	public static JavaHTTPServer myServer;
	public static Server server;
    static int PORT_DEFAULT=8000;
    static int PORT;
    
    
    private static JLabel lblNewLabel; 
    private static JPanel panel;
    private static JPanel panel_1;
    private static JPanel panel_2;
    private static JPanel panel_3;
    private static JPanel panel_4;
    private static JPanel panel_5;
    private static JLabel label;
    private static JLabel label_1; 
    private static JButton admin_apache;
    private static JButton admin_php;
    private static JButton admin_c;
    private static JButton admin_mysql;
    private static JLabel action;
    private static GroupLayout gl_panel_5;
    private static JButton start_apache;
    private static  JButton btnPHP; 
    private static JButton btnC; 
    private static JButton btnMysql;
    private  static GroupLayout gl_panel_4; 
    private static JLabel port;
    private static GroupLayout gl_panel_3;
    private static JLabel lblNewLabel_6;
    private static JLabel lbl_apache;
    private static JLabel lbl_php;
    private static JLabel lbl_c;
    private static JLabel lbl_mysql; 
    private static GroupLayout gl_panel_2;
    private static JLabel lblNewLabel_1; 
    private static JLabel lblNewLabel_2;
    private static JLabel lblNewLabel_3;
    private static JLabel lblNewLabel_4;
    private static JLabel lblNewLabel_5; 
    private static GroupLayout gl_panel_1; 
    private static GroupLayout gl_panel;
    private static String bName;
    private static String message; 
    private JTextField textChangeport;

	
	/*
	 * public boolean boolean_start_php = false; public boolean boolean_start_c =
	 * false; public boolean boolean_start_mysql = false;
	 */

	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		 EventQueue.invokeLater(new Runnable() { 
			 public void run() {
				 try { 
					 JAMPC frame = new JAMPC(); 
					 frame.setVisible(true);
					 
				 } catch (Exception e) {
					 e.printStackTrace(); 
					 } 
				 }
			 });
		 
		 
		 		
			
				
				
		 
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public JAMPC() throws IOException {
		setTitle("JAMPC++");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 546);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lblNewLabel = new JLabel("JAMPC++ Control Panel ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		panel = new JPanel();
		
		panel_1 = new JPanel();
		
		panel_2 = new JPanel();
		
		panel_3 = new JPanel();
		
		panel_4 = new JPanel();
		
		panel_5 = new JPanel();
		
		label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\GIANG_GIANG\\eclipse-workspace\\JAMPC++\\logo\\C++.png"));
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\GIANG_GIANG\\eclipse-workspace\\JAMPC++\\logo\\php.png"));
		
		JLabel lblChangePort = new JLabel("Change port ");
		
		textChangeport = new JTextField();
		
		
		 textChangeport.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent ke) {
	            String value = textChangeport.getText();
	            int l = value.length();
	            if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode()== KeyEvent.VK_BACK_SPACE) {
	               textChangeport.setEditable(true);
	               label.setText("");
	            } else {
	               textChangeport.setEditable(false);
	               label.setText("* Enter only numeric digits(0-9)");
	            }
	         }
	      });
		
		
		
		textChangeport.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(8)
							.addComponent(label)
							.addGap(51)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(label_1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblChangePort, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(panel_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 77, Short.MAX_VALUE))
							.addGap(29)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(textChangeport, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.UNRELATED))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_1)
							.addGap(7))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(panel_4, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(panel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblChangePort)
						.addComponent(textChangeport, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
					.addGap(28))
		);
		
		admin_apache = new JButton("Admin");
		admin_apache.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 ProcessBuilder compile = new ProcessBuilder("cmd", "/C", "start chrome  \"http://localhost:8000/Apache/admin.html\"");
	             try {
	            	 Process process = compile.start();
					process.waitFor();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		admin_php = new JButton("Admin");
		admin_php.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProcessBuilder compile = new ProcessBuilder("cmd", "/C", "start chrome \"http://localhost:8000/source_php/test.php\"");
	             try {
	            	 Process process = compile.start();
					process.waitFor();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		admin_c = new JButton("Admin");
		admin_c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProcessBuilder compile = new ProcessBuilder("cmd", "/C", "start chrome  \"http://localhost:8000/source_C/admin.cpp\"");
	             try {
	            	 Process process = compile.start();
					process.waitFor();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		admin_mysql = new JButton("Admin");
		admin_mysql.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addComponent(admin_apache)
						.addComponent(admin_php)
						.addComponent(admin_c)
						.addComponent(admin_mysql))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGap(32)
					.addComponent(admin_apache)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(admin_php)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(admin_c)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(admin_mysql)
					.addContainerGap(13, Short.MAX_VALUE))
		);
		panel_5.setLayout(gl_panel_5);
		
		action = new JLabel("Actions");
		action.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		start_apache = new JButton("Start");
		start_apache.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bName = start_apache.getLabel();
				port();
				startApache();
				
			}
		});
		
		btnPHP = new JButton("Stop");
		btnPHP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {}});
		
		btnC = new JButton("Stop");
		
		btnMysql = new JButton("Start");
		
		
		
		gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(btnPHP, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
						.addComponent(action, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
						.addComponent(start_apache, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnC, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
						.addComponent(btnMysql, GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addComponent(action, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(start_apache)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnPHP)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnC)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnMysql)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_4.setLayout(gl_panel_4);
		
		port = new JLabel("Port(s)");
		port.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		port_apache = new JLabel();
		port_apache.setText(String.valueOf(PORT_DEFAULT));
		gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(14)
							.addComponent(port))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addContainerGap()
							.addComponent(port_apache, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(11, Short.MAX_VALUE))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(5)
					.addComponent(port)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(port_apache, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(89, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		
		lblNewLabel_6 = new JLabel("Status");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		lbl_apache = new JLabel("");
		
		lbl_php = new JLabel("");
		
		lbl_c = new JLabel("");
		
		lbl_mysql = new JLabel("");
		gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_6)
								.addComponent(lbl_apache)
								.addComponent(lbl_php)
								.addComponent(lbl_c)))
						.addComponent(lbl_mysql))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(lblNewLabel_6)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lbl_apache)
					.addGap(29)
					.addComponent(lbl_php)
					.addGap(18)
					.addComponent(lbl_c)
					.addGap(18)
					.addComponent(lbl_mysql)
					.addContainerGap(30, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		lblNewLabel_1 = new JLabel("Module");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		lblNewLabel_2 = new JLabel("Apache ");
		
		lblNewLabel_3 = new JLabel("PHP");
		
		lblNewLabel_4 = new JLabel("C++");
		
		lblNewLabel_5 = new JLabel("MySQL");
		gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(25)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_3)
								.addComponent(lblNewLabel_4)
								.addComponent(lblNewLabel_5)
								.addComponent(lblNewLabel_2)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_1)))
					.addContainerGap(15, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(5)
					.addComponent(lblNewLabel_1)
					.addGap(18)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
					.addComponent(lblNewLabel_3)
					.addGap(18)
					.addComponent(lblNewLabel_4)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_5)
					.addGap(19))
		);
		panel_1.setLayout(gl_panel_1);
		
		 textArea = new JTextArea();
		gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(20, Short.MAX_VALUE)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
	private void startApache(){
		java.util.Date date=new java.util.Date();  
		if (bName.equals("Start")) {
			start(date);
		}
		else if (bName.equals("Stop")) {
			stop(date);
		}
		port_apache.setText(String.valueOf(PORT));
	}
	private void start(java.util.Date date) {
		try {
			serverSocket = new ServerSocket(PORT);
	 		System.out.println("Server started. \n Listening for connections on Port : "+ PORT+".../n");
	 		message = "JAMPC++ started on port " + PORT +"in time: "+date+"\n JAMPC++ Running... ";	
	 		server = new Server(serverSocket);
	 		server.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		start_apache.setLabel("Stop");
		textArea.setText(message);
	}
	private void stop(java.util.Date date) {
		try {
			//myServer.wait();
			serverSocket.close();	
			message = "JAMPC++ stopped in time: "+date+"\nYou can't work with it..."+"\n You must be start localhost"+"\n Thank for you...";
			server.stop();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		start_apache.setLabel("Start");
		textArea.setText(message);
	}
	private void port() {
		if (!textChangeport.getText().trim().toString().equals("")) {
			PORT_DEFAULT = Integer.parseInt(textChangeport.getText().toString().trim());
			System.out.println(textChangeport.getText().toString().trim());
			PORT = PORT_DEFAULT;
		}
		else {
			PORT = PORT_DEFAULT;
		}
	}

}

class Server extends Thread{
	ServerSocket serverSocket;
	JavaHTTPServer myServer;
	public Server(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}
	@Override
	public void run() {
		try {
			while(true) {		
				myServer = new JavaHTTPServer(serverSocket.accept());
				System.out.println("Connect opened. ("+ new Date()+")");
				myServer.start();	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

 


