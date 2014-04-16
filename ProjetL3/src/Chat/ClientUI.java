package Chat;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.rmi.*;

public class ClientUI extends JFrame implements ActionListener
	{
	private JTextField txtA,txtB,txtKQ;
	private JButton btnClear,btnExit;
	private JButton btnCalcSend;
	public ClientUI(){
	JPanel pCen=new JPanel(new GridLayout(4,1));
	JPanel p1=new JPanel();JPanel p2=new JPanel();
	JPanel p3=new JPanel();JPanel p4=new JPanel();
	pCen.add(p1);pCen.add(p2);pCen.add(p3);pCen.add(p4);
	getContentPane().add(pCen);
	//==========================================
	p1.add(new JLabel("Message envoye"));p1.add(txtA=new JTextField(15));
	p3.add(new JLabel("Message recu: :"));p3.add(txtKQ=new JTextField(15));
	txtKQ.setEditable(false);
	p4.add(btnCalcSend=new JButton("send"));btnCalcSend.addActionListener(this);
	p4.add(btnClear=new JButton("Clear"));btnClear.addActionListener(this);
	p4.add(btnExit=new JButton("Exit"));btnExit.addActionListener(this);
	setResizable(false);
	setSize(350,200);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLocation(300,200);
}
	
public void actionPerformed(ActionEvent e) {
Object o=e.getSource();
if(o.equals(btnExit)){
System.exit(1);
}
else
{
if(txtA.getText().trim().equals("")){
JOptionPane.showMessageDialog(null,"Text Fields cannot be null",
"Error",JOptionPane.ERROR_MESSAGE);
return;
}

if(o.equals(btnCalcSend)){
try {
ChatInterface obj=null;

obj=(ChatInterface)Naming.lookup("rmi://localhost:1099/chat");
String a=txtA.getText();
String s=obj.chat(a);
txtKQ.setText(""+s);
}catch (Exception ex) {
ex.printStackTrace();
}
}

else if(o.equals(btnClear)){
txtA.setText("");
txtB.setText("");
txtKQ.setText("");
}
}
}
public static void main(String[]args){
System.setProperty("java.security.policy", "client.policy");
ClientUI cc=new ClientUI();
cc.setVisible(true);
}

}
