package Chat;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class Client extends JFrame implements ActionListener{

	private JPanel contentPane;
    private JButton btnNewButton = new JButton("Lancer Server");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client frame = new Client();
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
	public Client() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		btnNewButton.setBounds(26, 89, 166, 62);
		btnNewButton.addActionListener(this);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Chat");
		btnNewButton_1.setBounds(256, 89, 135, 62);
		contentPane.add(btnNewButton_1);
	}

	public void actionPerformed(ActionEvent e) {
		Object o=e.getSource();
		
		if(o.equals(btnNewButton)){
			try {
				ServerUI obj=null;
				obj.main(null);
			}catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

}
