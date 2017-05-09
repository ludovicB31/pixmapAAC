package demoApp;

import java.io.File;
//import javaxt.io.File;

public class refresh extends pixmapProject {
	String path;
	public refresh(String s){
		 this.path=s;


		System.out.println("initialisation de l'actualisation des images du dossier");
	}
	
	public static  void actu(String chemin){
		File rep = new File(System.getProperty("user.dir")+"/"+"bib");
		  File[] listefichiers;

		  int i;
		  listefichiers=rep.listFiles();
		  for(i=0;i<listefichiers.length;i++){
		 
           String path=listefichiers[i].getPath();
           javaxt.io.File fi= new javaxt.io.File(path);
           iniDir(fi);
	

}}
}