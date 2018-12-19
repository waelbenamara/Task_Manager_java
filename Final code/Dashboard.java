import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class Dashboard {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dashboard window = new Dashboard();
					window.frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Dashboard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = (int)screenSize.getWidth();
		double height = (int)screenSize.getHeight();
		frame.setSize((int)width, (int)height);
		frame.getContentPane().setLayout(null);
		
	
		
		
		
		JButton button_4 = new JButton("About Us");
		button_4.setFont(new Font("Krungthep", Font.PLAIN, 22));
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(button_4, "This software Was Made By Kernel Panic", "About us", 3);
			}
		});
		button_4.setBounds(387, 661, 713, 39);
		
		frame.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("Exit");
		button_5.setFont(new Font("Krungthep", Font.PLAIN, 22));
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button_5.setBackground(Color.WHITE);
		button_5.setBounds(387, 712, 713, 39);
		frame.getContentPane().add(button_5);
		
		JButton button = new JButton("Schedule");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Schedulee s = new Schedulee();
				s.main(null);
			}
		});
		button.setFont(new Font("Krungthep", Font.PLAIN, 22));
		button.setBackground(Color.WHITE);
		button.setBounds(387, 49, 713, 125);
		frame.getContentPane().add(button);
		
		JButton btnCalendar = new JButton("Calendar");
		btnCalendar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CalendarDisplay d = new CalendarDisplay();
				d.main(null);
			}
		});
		btnCalendar.setFont(new Font("Krungthep", Font.PLAIN, 22));
		btnCalendar.setBackground(Color.WHITE);
		btnCalendar.setBounds(387, 207, 713, 125);
		frame.getContentPane().add(btnCalendar);
		
		JButton btnContacts = new JButton("Contacts");
		btnContacts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Contacts c = new Contacts();
				
				c.main(null);
			}
		});
		btnContacts.setFont(new Font("Krungthep", Font.PLAIN, 22));
		btnContacts.setBackground(Color.WHITE);
		btnContacts.setBounds(387, 344, 713, 125);
		frame.getContentPane().add(btnContacts);
		
		JButton btnToday = new JButton("Today");
		btnToday.setFont(new Font("Krungthep", Font.PLAIN, 22));
		btnToday.setBackground(Color.WHITE);
		btnToday.setBounds(387, 497, 713, 125);
		frame.getContentPane().add(btnToday);
	
	}
}
