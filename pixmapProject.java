package demoApp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javaxt.io.File;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import com.esri.arcgisruntime.mapping.Basemap;
import com.esri.arcgisruntime.mapping.Viewpoint;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.io.FilenameFilter;




import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.esri.arcgisruntime.geometry.Point;
import com.esri.arcgisruntime.geometry.SpatialReference;
import com.esri.arcgisruntime.geometry.SpatialReferences;
import com.esri.arcgisruntime.mapping.ArcGISMap;
import com.esri.arcgisruntime.mapping.view.Graphic;
import com.esri.arcgisruntime.mapping.view.GraphicsOverlay;
import com.esri.arcgisruntime.mapping.view.MapView;
import com.esri.arcgisruntime.symbology.PictureMarkerSymbol;
import com.esri.arcgisruntime.symbology.SimpleMarkerSymbol;


public class pixmapProject extends Application {
	private ArcGISMap map;
    private MapView mapView;
    private GraphicsOverlay graphicsOverlay = new GraphicsOverlay();
    public static ArrayList<NewImage> listechemin =new ArrayList();


  @Override
  public void start(Stage stage) throws Exception {
	  
	//create a border pane
	  Stage st=new Stage();
	    BorderPane  borderPane = new BorderPane();
	    Scene scene = new Scene(borderPane);
         st.setTitle("Paneau de Commande PixMap");

	    //size the stage and add a title
	    stage.setTitle("PixMap vos photos gÃ©olocalisÃ©es");
	    stage.setWidth(1000);
	    stage.setHeight(550);
	    stage.setScene(scene);
	    HBox hbox = new HBox();
	    // set padding gere les marge entre element (The top,right,bottom,left padding)
	    hbox.setPadding(new Insets(50, 15, 50, 80));
	    hbox.setSpacing(10);
	    hbox.setStyle("-fx-background-color: #336699;");

	    
	    Label addLabel = new Label("Vous pouvez Ajouter une image à la carte ou en supprimer une:");
	    Label Warning =new Label("Attention: Selectionner une image à la fois !");
	    Warning.setTextFill(Color.BROWN);
	    Button add= new Button("Ajouter une image");
	    Button supp=new Button("Supprimer une image");
	    
	    hbox.getChildren().addAll(add,supp);
	   
	   
	    supp.setOnAction((event) -> {
	    	listechemin.clear();

	    	NewImage.supprimer();
	    	stage.close();
	    	 for(int i=0;i<listechemin.size();i++){
	 	    	placePictureMarkerSymbol(listechemin.get(i).blueSymbol, listechemin.get(i).point);
	 	    	
	 	    }
	    	 System.out.println(listechemin);
	    	 stage.show();

	    	});
	    add.setOnAction((event) -> {
	    	NewImage.ajouter();
	    	stage.close();
	    	 for(int i=0;i<listechemin.size();i++){
	 	    	placePictureMarkerSymbol(listechemin.get(i).blueSymbol, listechemin.get(i).point);
	 	    }
	    	 stage.show();

	    	});
	    StackPane root = new StackPane();
	     root.setAlignment(addLabel, Pos.TOP_CENTER);
	     root.setAlignment(Warning, Pos.BOTTOM_CENTER);

	        root.getChildren().add(hbox);

        root.getChildren().add(addLabel);
        root.getChildren().add(Warning);


       // root.getChildren().add(add);
        //root.getChildren().add(supp);

        Scene command=new Scene(root,500,100);
        st.setScene(command);
	    stage.show();
	    st.show();
	  //create an ArcGISMap that defines the layers of data to view 
	    map = new ArcGISMap();
	    

	    //make the basemap for streets
	    map.setBasemap(Basemap.createNationalGeographic());

	    //create the MapView JavaFX control and assign its map
	    mapView = new MapView();
	    mapView.setMap(map);

	    //add the MapView 
	    borderPane.setCenter(mapView);
	  //add the overlay to the map view
	    for(int i=0;i<listechemin.size();i++){
	    	placePictureMarkerSymbol(listechemin.get(i).blueSymbol, listechemin.get(i).point);
	    }

	   mapView.getGraphicsOverlays().add(graphicsOverlay);
	   SpatialReference wgs84 = SpatialReferences.getWgs84();
	    //print image
		stage.setOnCloseRequest(e -> Platform.exit());

	    
  }
  private void placePictureMarkerSymbol(PictureMarkerSymbol markerSymbol, Point graphicPoint) {

	    // set size of the image
	    markerSymbol.setHeight(100);
	    markerSymbol.setWidth(100);

	    // load symbol asynchronously
	    markerSymbol.loadAsync();

	    // add to the graphic overlay once done loading
	    markerSymbol.addDoneLoadingListener(() -> {
	      Graphic symbolGraphic = new Graphic(graphicPoint, markerSymbol);
	      graphicsOverlay.getGraphics().add(symbolGraphic);
	    });
	    
  }
 public static void iniDir(javaxt.io.File fichier){
	 NewImage ni= new NewImage(fichier);
	 ni.addliste(ni);
	 
	 
 }
 public void update (NewImage ajout) {
	 //System.exit(1);
	 //placePictureMarkerSymbol(ajout.blueSymbol,ajout.point);

	 refresh initialize =new refresh(System.getProperty("user.dir")+"/"+"bib");
	 refresh.actu(initialize.path);
      Stage restart=new Stage();
      pixmapProject res=new pixmapProject();
	//Application.launch();
	 


	
 }
 public static void updateDelete (){
	 //System.exit(1);
	 //placePictureMarkerSymbol(ajout.blueSymbol,ajout.point);
	 System.out.println("je suis la");
	 
	 refresh initialize =new refresh(System.getProperty("user.dir")+"/"+"bib");
	 refresh.actu(initialize.path);
	 Stage restart=new Stage();
     pixmapProject res=new pixmapProject();

	 //Application.launch();

	
 }

 public void stop() throws Exception {

	    if (mapView != null) {
	      mapView.dispose();
	    }
	  }
	  
  
 
  
  
  
  public static void main(String[] args) {
	
	  refresh initialize =new refresh(System.getProperty("user.dir")+"/"+"bib");
		 refresh.actu(initialize.path);

	         
	  Application.launch(args);
		
	 
	
  }}