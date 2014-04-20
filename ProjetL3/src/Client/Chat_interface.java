
package Client;

import java.awt.EventQueue;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

import java.awt.TextArea;

import javax.swing.JButton;
import javax.swing.JScrollPane;

import Server.server;


/**
 *
 */
public class Chat_interface extends JFrame{
	
	private JComboBox list_user;
    private JLabel lb_user_online;
    private JLabel select_user;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JTextArea user_online;
    private JTextArea chat_area;
    private JTextField message;
    
    static Chat_interface frame;
    static ClientObj clientObj;
    static server server;
    static String host;
    static String nickname;
    
    /** Créer une nouvelle interface */
    
    public Chat_interface() {
       
        lb_user_online = new JLabel();
        user_online = new JTextArea();
        list_user = new JComboBox();
        select_user = new JLabel();
        message = new JTextField();
        chat_area = new JTextArea();
        jPanel1 = new JPanel();
        jScrollPane1 = new JScrollPane();
        jScrollPane2 = new JScrollPane();
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lb_user_online.setFont(new java.awt.Font("Tahoma", 1, 14));
        lb_user_online.setText("Utilisateur en ligne");

        jScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        user_online.setBackground(new java.awt.Color(240, 240, 240));
        user_online.setColumns(20);
        user_online.setRows(5);
        jScrollPane1.setViewportView(user_online);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lb_user_online, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_user_online, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
        );

        list_user.setModel(new DefaultComboBoxModel(new String[] {"Tous utilisateurs"}));
        select_user.setFont(new java.awt.Font("Tahoma", 1, 14));
        select_user.setText("Utilisateur");

        message.setText("Bonjour a tous...");
        message.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                messageKeyReleased(evt);
            }
        });

        jScrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        chat_area.setBackground(new java.awt.Color(240, 240, 240));
        chat_area.setColumns(20);
        chat_area.setEditable(false);
        chat_area.setLineWrap(true);
        chat_area.setRows(5);
        jScrollPane2.setViewportView(chat_area);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(select_user, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(list_user, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                            .addComponent(message, GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(list_user, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(select_user, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(message, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
        );

      pack();
    }

	/** Utiliser le bouton ENTER pour envoyer un message */
    
    private void messageKeyReleased(KeyEvent evt) {
	    if (evt.getKeyCode() == KeyEvent.VK_ENTER && !message.getText().equals(""))  {
	  	    try {
	                server.MsgToServer(message.getText(), nickname, list_user.getSelectedItem().toString());
	                message.setText("");
	        } catch (RemoteException e) {
	                e.printStackTrace();
	        }
	    }
	}

	
    /** Fermer la fenêtre chat pour disconnecter à serveur*/
    
    private void formWindowClosing(WindowEvent evt) {
	     try {
	            if(server!=null)
	            {
	                server.LogoutToServer(clientObj, nickname);
	            }
	        } catch (RemoteException ex) {
	            Logger.getLogger(Chat_interface.class.getName()).log(Level.SEVERE, null, ex);
	        }
	}

    
    /**
     * 
     */
    private void Utilisateur_a_utilisateur(MouseEvent evt) { //
        // TODO add your handling code here:
        if(evt.getClickCount() == 2){
            String index = user_online.getSelectedText();
            JOptionPane.showInputDialog(index);
            
        }
    }
    
    public static void main(String args[]) {

        /** Créer et afficher l'interface */
    	
        EventQueue.invokeLater(new Runnable() {

        public void run() {
        	try {
				
        		frame = new Chat_interface();
        		
        		Point p = new Point((Toolkit.getDefaultToolkit().getScreenSize().width-frame.getSize().width)/2, (Toolkit.getDefaultToolkit().getScreenSize().height-frame.getSize().height)/2);
				frame.setLocation(p); 
				frame.setVisible(true);
		          
				clientObj = new ClientObj();                                        
                host = JOptionPane.showInputDialog("Entrer le nom du serveur chat","localhost");
                server = (server)Naming.lookup("//" + host + "/Server");
                                    
                boolean flag = true;
                while(flag)
                {
                    nickname = JOptionPane.showInputDialog("Entrer votre surnom ");
                    if(nickname==null)
                    {
                        JOptionPane.showConfirmDialog(frame, "Il faut entre votre surnom.", " ", JOptionPane.CLOSED_OPTION);
                    }
                    else if(!nickname.equalsIgnoreCase(""))
                    {
                            if(server.RegisterToServer(clientObj, nickname))
                            {
                            	frame.setTitle("User : " + nickname);
                                flag = false;                            
                            }
                            else
                            {
                                JOptionPane.showConfirmDialog(frame, " Ce surnom a déja utilisé ", "Nick Name", JOptionPane.CLOSED_OPTION);
                            }
                    }
                }
                
            }
            catch (NotBoundException ex)
            {
                JOptionPane.showConfirmDialog(frame, "Serveur ne pas réponde", "Serveur Connecte", JOptionPane.CLOSED_OPTION);
            }
            catch (MalformedURLException ex)
            {
                JOptionPane.showConfirmDialog(frame, "Serveur ne pas réponde", "Serveur Connecte", JOptionPane.CLOSED_OPTION);
            }
            catch (RemoteException ex)
            {
                JOptionPane.showConfirmDialog(frame, "Serveur ne pas réponde", "Serveur Connecte", JOptionPane.CLOSED_OPTION);
            }
        }
    });
    }
    
    /** Afficher le message d'utilisateur  	*/
    
    public static void _MsgArrived(String msg, String FromUser) {     
        frame.NewMsg(msg, FromUser);
    }
    
    public void NewMsg(String msg, String FromUser) {
        chat_area.append(FromUser +" : "+ msg + "\n");
    }
    
    
    /**	Mettre à jour la liste de utilisateur en ligne	*/
    
    public static void _UpdateUserList(List<String> ClientsName)    {
        frame.NewUser(ClientsName);
    }
    
    public void NewUser(List<String> ClientsName)    {       
        user_online.setText("");
        String selectedUser = list_user.getSelectedItem().toString();
        list_user.removeAllItems();
        list_user.addItem("Tous utilisateurs");
        
        for(String UserName : ClientsName) {
            if(UserName.length()>15) {
                UserName = UserName.substring(0,15)+"..";
            }
            
            user_online.append(" "+UserName + "\n");
            list_user.addItem(UserName);            
        }
        
        list_user.setSelectedItem(selectedUser);
    }
     
    
  
}
