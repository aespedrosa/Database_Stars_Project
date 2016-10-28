import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;


public class Main extends JFrame  {
	
		private Box isto;
		private int a;
		private JButton submitButton;
		private JTextField xField;
		private JTextField yField;
		static final String USERNAME= "coisitos"; // SUBSTITUIR conforme o mySQL do localhost;
		 static final String PASSWORD= "coisitos"; //SUBSTITUIR conforme o mySQL do localhost;
		
	   public Main() 
	   {   
		   super( "GBD Space 1.0" );
		   a=3;
		     
	   try
		   {
			   String workingdirectory = System.getProperty("user.dir");
		   setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(workingdirectory+ "/espaco.PNG")))));
		   }
		   catch(IOException e)
		   {
			   System.out.print("Erro imagem de fundo");	
		   }
		   setSize(720,470);
		   setVisible(true);
		   setLayout(new FlowLayout());
		   
		   JTabbedPane tabbedPane=new JTabbedPane();
		   submitButton = new JButton("OK");
		   JPanel myPanel = new JPanel();
		   xField = new JTextField("username",5);
		   xField.setOpaque(false);
		   yField = new JTextField("password",5);
		   yField.setOpaque(false);
		   isto = Box.createVerticalBox(); 
		   JLabel user =new JLabel("USERNAME:");
		   user.setForeground(Color.white);
		   isto.add(user);
		   isto.add(xField);
		   isto.add(Box.createHorizontalStrut(15)); 
		   JLabel pass= new JLabel("PASWORD:");
		   pass.setForeground(Color.white);
		   isto.add(pass);
		   isto.add(yField); 
		   isto.add(submitButton);
		   isto.setOpaque(false);
		   isto.setBorder(BorderFactory.createEmptyBorder(150,150,150,150));
		   tabbedPane.add("LOGIN",isto);
		   tabbedPane.setOpaque(false);
		  
		   add(isto);
		   ouvido ol= new ouvido();
		   submitButton.addActionListener(ol);
		   
		   
		   
	   }

	   private class ouvido implements ActionListener{
		   public void actionPerformed(ActionEvent event){
			a=a-1;
		   if(event.getSource()==submitButton){
			   if(xField.getText().equals(USERNAME) && yField.getText().equals(PASSWORD)&& (a>0) )
    		   {
				   JOptionPane.showMessageDialog(null, "Sucesso no Login.", "InfoBox", JOptionPane.WARNING_MESSAGE);
     			   new Interface(USERNAME, PASSWORD); 
     			   setVisible(false); 
     			   dispose(); 
     			  
    		   }
     		   else if(a<0){
     			   setVisible(false); 
     			   dispose(); 
     			  JOptionPane.showMessageDialog(null, "Insucesso no Login. Esgotou as tentativas.", "InfoBox", JOptionPane.WARNING_MESSAGE);
       			 
     		   }
     			  
     		   else{
			   JOptionPane.showMessageDialog(null, "Insucesso no Login. Tente de novo.", "InfoBox", JOptionPane.WARNING_MESSAGE);
		   } 
		   }
	   }
	   

}
	   public static void main( String args[] ) 
	   {
	      new Main();     
	   } 
	   
}


