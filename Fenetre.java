package demoApp;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame{
	
	public Fenetre(){
		super();
 
		build();//On initialise notre fenêtre
	}
 
	private void build(){
		setTitle("PixMap Command "); //On donne un titre à l'application
		setSize(330,300); //On donne une taille à notre fenêtre
		setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
		setResizable(false); //On interdit la redimensionnement de la fenêtre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de se fermer lors du clic sur la croix

 
	}
	
	public static void main(String[] args){
		Fenetre fenetre = new Fenetre();
		fenetre.setVisible(true);//On la rend visible
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
 
		JButton bouton = new JButton("Ajouter une image à la carte");
		panel.add(bouton);
		bouton.addActionListener(new ActionListener() { 
	          public void actionPerformed(ActionEvent args) {
	        	  
	        refresh initializeS =new refresh(System.getProperty("user.dir")+"/"+"bib");

	            NewImage.ajouter();
	          }
	        }); 
 
		JButton bouton2 = new JButton("supprimer une image");
		panel.add(bouton2);
		bouton2.addActionListener(new ActionListener() { 
	          public void actionPerformed(ActionEvent args) {
	  	        refresh initializeSS =new refresh(System.getProperty("user.dir")+"/"+"bib");

	            NewImage.supprimer();
	          }
	        }); 
		fenetre.add(panel);
		
	}
	
}