package demoApp;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;

import com.esri.arcgisruntime.geometry.Point;
import com.esri.arcgisruntime.geometry.SpatialReference;
import com.esri.arcgisruntime.geometry.SpatialReferences;
import com.esri.arcgisruntime.symbology.PictureMarkerSymbol;
import com.oracle.tools.packager.IOUtils;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javaxt.io.Image;
public class NewImage extends pixmapProject {
	double lat;
	double longi;
	Image img;
	String nom;
	Point point;
	String path;
	PictureMarkerSymbol blueSymbol;
	
	
	
	public NewImage(javaxt.io.File imgg){
		Image imggg=imgg.getImage();
		double[] gps = imggg.getGPSCoordinate();
	   this.lat=gps[0];
	    this.longi=gps[1];
        this.img=imggg;
        javaxt.io.File fichier=imgg;
        this.nom=fichier.getName();
        SpatialReference wgs84 = SpatialReferences.getWgs84();
        this.point= new Point(this.lat, this.longi, wgs84);
        this.path=System.getProperty("user.dir")+"/"+"bib"+"/"+this.nom;
        this.blueSymbol = new PictureMarkerSymbol(path);
        
	}
	public void addliste(NewImage objImage){
		listechemin.add(objImage);
	}
	
	public static void ajouter(){
		
		JFileChooser choix = new JFileChooser();
		choix.setApproveButtonText("Ajouter");
		choix.setDialogTitle("Ajouter une image à la carte");

		int retour=choix.showOpenDialog(null);
		if(retour==JFileChooser.APPROVE_OPTION){
		   // un fichier a été choisi (sortie par OK)
		   // nom du fichier  choisi 
		   String Anom=choix.getSelectedFile().getName();
		   // chemin absolu du fichier choisi
		   String Apath=choix.getSelectedFile().getAbsolutePath();
		   System.out.println(Anom+Apath);
		   java.io.File entre= new java.io.File(Apath);
		   java.io.File sortie= new java.io.File(System.getProperty("user.dir")+"/"+"bib/"+Anom);
		   entre.renameTo(sortie)  ;
		   javaxt.io.File AAfichier= new javaxt.io.File(sortie);

		   NewImage aj=new NewImage(AAfichier);
		   aj.addliste(aj);
           aj.update(aj);		  
		}else {System.out.println("aucun fichier choisi");} ;// pas de fichier choisi
	}
	
	public static void supprimer(){
		JFileChooser choix = new JFileChooser(System.getProperty("user.dir")+"/"+"bib/");
		choix.setApproveButtonText("Supprimer");
		choix.setDialogTitle("Supprimer une image de la carte");

		//choix.setCurrentDirectory(System.getProperty("user.dir")+"/"+"bib/");

		int retour=choix.showOpenDialog(null);
		if(retour==JFileChooser.APPROVE_OPTION){
		   // un fichier a été choisi (sortie par OK)
		   // nom du fichier  choisi 
		   // chemin absolu du fichier choisi
		   String Apath=choix.getSelectedFile().getAbsolutePath();
		   java.io.File entre= new java.io.File(Apath);
		   entre.delete();
		   pixmapProject.updateDelete();
		     
		}else {System.out.println("aucun fichier choisi");
		   pixmapProject.updateDelete();
} ;// pas de fichier choisi
	}
	public static void on(){
		Application.launch(pixmapProject.class);

	}

	public static void main(String[] args) {
	
		
	}

}