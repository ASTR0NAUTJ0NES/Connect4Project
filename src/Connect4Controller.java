/**
 * 'connect4GUI.fxml' Controller Class
 * 
 * @author Andrew P. Albanese
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class Connect4Controller {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="dragBoardAnchorPane"
    private AnchorPane dragBoardAnchorPane; // Value injected by FXMLLoader
    
    @FXML // fx:id="fileMenuButton"
    private Menu fileMenuButton; // Value injected by FXMLLoader

    @FXML // fx:id="blackPiece"
    private ImageView blackPiece; // Value injected by FXMLLoader

    @FXML // fx:id="connect4Logo"
    private ImageView connect4Logo; // Value injected by FXMLLoader

    @FXML // fx:id="boardAnchorPane"
    private AnchorPane boardAnchorPane; // Value injected by FXMLLoader

    @FXML // fx:id="pieceGridPane"
    private GridPane pieceGridPane; // Value injected by FXMLLoader

    @FXML // fx:id="piecePlacerGridPane"
    private GridPane piecePlacerGridPane; // Value injected by FXMLLoader

    @FXML // fx:id="redPiece"
    private ImageView redPiece; // Value injected by FXMLLoader

    @FXML // fx:id="boardGridPane"
    private GridPane boardGridPane; // Value injected by FXMLLoader
    
    private final double ORG_RED_PIECE_X = 18;
    private final double ORG_RED_PIECE_Y = 502;
    private final double ORG_BLACK_PIECE_X = 531;
    private final double ORG_BLACK_PIECE_Y = 502;
    private boolean redTurn = true;
    private int[][] scoreArray = new int[6][7];
    private int[] landingRowList;
    
    @FXML
    void setBlackOnDragDetected(MouseEvent event) {

    }

    @FXML
    void setBlackOnDragDropped(DragEvent event) {

    }

    @FXML
    void setOnAction(ActionEvent event) {
    	Platform.exit();
    }

    @FXML
    void setOnDragDropped(DragEvent event) {

    }

    @FXML
    void setRedOnDragDetected(MouseEvent event) {
    	
    }

    @FXML
    void setRedOnDragDropped(DragEvent event) {

    }
    
    @FXML
    void setRedOnMouseClicked(MouseEvent event) {

    }
    
    @FXML
    void setBlackOnMouseClicked(MouseEvent event) {

    }
    
    public void dropPiece() {
 		/*
 		 * Row0 - 208-262
 		 * Row1 - 263-317
 		 * Row2 - 318-372
 		 * Row3 - 373-427
 		 * Row4 - 428-482
 		 * Row5 - 483-537
 		 * Board Range vert - 208-537
 		 */
    	 
 	}

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize(Scene scene) {
        assert fileMenuButton != null : "fx:id=\"fileMenuButton\" was not injected: check your FXML file 'connect4GUI.fxml'.";
        assert dragBoardAnchorPane != null : "fx:id=\"dragBoardAnchorPane\" was not injected: check your FXML file 'connect4GUI.fxml'.";
        assert blackPiece != null : "fx:id=\"blackPiece\" was not injected: check your FXML file 'connect4GUI.fxml'.";
        assert connect4Logo != null : "fx:id=\"connect4Logo\" was not injected: check your FXML file 'connect4GUI.fxml'.";
        assert boardAnchorPane != null : "fx:id=\"boardAnchorPane\" was not injected: check your FXML file 'connect4GUI.fxml'.";
        assert pieceGridPane != null : "fx:id=\"pieceGridPane\" was not injected: check your FXML file 'connect4GUI.fxml'.";
        assert piecePlacerGridPane != null : "fx:id=\"piecePlacerGridPane\" was not injected: check your FXML file 'connect4GUI.fxml'.";
        assert redPiece != null : "fx:id=\"redPiece\" was not injected: check your FXML file 'connect4GUI.fxml'.";
        assert boardGridPane != null : "fx:id=\"boardGridPane\" was not injected: check your FXML file 'connect4GUI.fxml'.";
        
        redPiece.setOnMousePressed(new EventHandler <MouseEvent>()
        {
        	public void handle(MouseEvent event)
            {
        		if(!redTurn) return;
        		blackPiece.setOpacity(0);
            	redPiece.setMouseTransparent(true);
            	Glow glow = new Glow();  
                glow.setLevel(1.0);
                redPiece.setEffect(glow);
                redPiece.setCursor(Cursor.CLOSED_HAND);
            	System.out.println("Event on Source: mouse pressed");
        	    event.setDragDetect(true);
        	}	  
        });
        
     	redPiece.setOnMouseReleased(new EventHandler <MouseEvent>()
        {
	        public void handle(MouseEvent event)
	        {
	        	if(!redTurn) return;
				/*
				 * Col0 - 108-162
				 * Col1 - 163-217
				 * Col2 - 218-272
				 * Col3 - 273-327
				 * Col4 - 328-382
				 * Col5 - 383-437
				 * Col6 - 438-492
				 * Board Range - 108-492
				 */
				redPiece.setMouseTransparent(false);
				DropShadow dropShadow = new DropShadow();
				dropShadow.setRadius(20.0);
				dropShadow.setHeight(40.0);
				dropShadow.setWidth(40.0);
				redPiece.setEffect(dropShadow);
				double locX = event.getSceneX();
				double locY = event.getSceneY();
				double dropY = 148;
				
				
				if(locX>=108 && locX<=492) {
					if(locY<135 || locY>208) {
						redPiece.setLayoutX(ORG_RED_PIECE_X);
						redPiece.setLayoutY(ORG_RED_PIECE_Y); 
						return;						
					}
					redPiece.setLayoutY(dropY);					
				} else {
					redPiece.setLayoutX(ORG_RED_PIECE_X);
					redPiece.setLayoutY(ORG_RED_PIECE_Y); 
					return;
				}
				
				int column = 0;
				
				if(locX>=108 && locX<=162) {
					column = 0;
					redPiece.setLayoutX(108);
				} else if(locX>=163 && locX<=217) {
					column = 1;
					redPiece.setLayoutX(163);
				} else if(locX>=218 && locX<=272) {
					column = 2;
					redPiece.setLayoutX(218);
				} else if(locX>=273 && locX<=327) {
					column = 3;
					redPiece.setLayoutX(273);
				} else if(locX>=328 && locX<=382) {
					column = 4;
					redPiece.setLayoutX(328);
				} else if(locX>=383 && locX<=437) {
					column = 5;
					redPiece.setLayoutX(383);
				} else if(locX>=438 && locX<=492) {
					column = 6;
					redPiece.setLayoutX(438);
				}
				
				System.out.println("Event on Source: mouse released");
				redPiece.setOpacity(0);
				ImageView redDropPiece = new ImageView();
				Image redPieceImg = new Image("4row_red.png");
				redDropPiece.setImage(redPieceImg);
				ObservableList<Node> nodes = dragBoardAnchorPane.getChildren();//.add(redDropPiece);
				//redDropPiece.setLayoutX(redPiece.getLayoutX());
				//redDropPiece.setLayoutY(redPiece.getLayoutY());
				//int row = landingRowList[column];
				//redDropPiece.setLayoutY(208 + (row * 54));
				//landingRowList[column]--;
				//scoreArray[row][column]=1;
				redPiece.setLayoutX(ORG_RED_PIECE_X);
				redPiece.setLayoutY(ORG_RED_PIECE_Y);
				blackPiece.setOpacity(100);
				redTurn = false;
	        }
        });
     	
     	redPiece.setOnMouseDragged(new EventHandler <MouseEvent>()
     	 {
     		 public void handle(MouseEvent event)
             {
     			 if(!redTurn) return;
     			 System.out.println("Event on Source: mouse dragged");
     			 redPiece.setLayoutX(event.getSceneX()-30);
     			 redPiece.setLayoutY(event.getSceneY()-30);
     	         event.setDragDetect(false);
             }
         });
     	
     	blackPiece.setOnMousePressed(new EventHandler <MouseEvent>()
        {
        	public void handle(MouseEvent event)
        	{
        		if(redTurn) return;
        		redPiece.setOpacity(0);
            	blackPiece.setMouseTransparent(true);
            	Glow glow = new Glow();  
                glow.setLevel(1.0);
                blackPiece.setEffect(glow);
                blackPiece.setCursor(Cursor.CLOSED_HAND);
            	System.out.println("Event on Source: mouse pressed");
        	    event.setDragDetect(true);
        	}	  
        });
        
     	blackPiece.setOnMouseReleased(new EventHandler <MouseEvent>()
        {
	        public void handle(MouseEvent event)
	        {
	        	if(redTurn) return;
				/*
				 * Col0 - 108-162
				 * Col1 - 163-217
				 * Col2 - 218-272
				 * Col3 - 273-327
				 * Col4 - 328-382
				 * Col5 - 383-437
				 * Col6 - 438-492
				 * Board Range - 108-492
				 */
				blackPiece.setMouseTransparent(false);
				DropShadow dropShadow = new DropShadow();
				dropShadow.setRadius(20.0);
				dropShadow.setHeight(40.0);
				dropShadow.setWidth(40.0);
				blackPiece.setEffect(dropShadow);
				double locX = event.getSceneX();
				double locY = event.getSceneY();
				double dropY = 148;
				
				
				if(locX>=108 && locX<=492) {
					if(locY<135 || locY>208) {
						blackPiece.setLayoutX(ORG_BLACK_PIECE_X);
						blackPiece.setLayoutY(ORG_BLACK_PIECE_Y); 
						return;						
					}
					blackPiece.setLayoutY(dropY);					
				} else {
					blackPiece.setLayoutX(ORG_BLACK_PIECE_X);
					blackPiece.setLayoutY(ORG_BLACK_PIECE_Y); 
					return;
				}
				
				if(locX>=108 && locX<=162) {
					blackPiece.setLayoutX(108);
				} else if(locX>=163 && locX<=217) {
					blackPiece.setLayoutX(163);
				} else if(locX>=218 && locX<=272) {
					blackPiece.setLayoutX(218);
				} else if(locX>=273 && locX<=327) {
					blackPiece.setLayoutX(273);
				} else if(locX>=328 && locX<=382) {
					blackPiece.setLayoutX(328);
				} else if(locX>=383 && locX<=437) {
					blackPiece.setLayoutX(383);
				} else if(locX>=438 && locX<=492) {
					blackPiece.setLayoutX(438);
				}
				
				System.out.println("Event on Source: mouse released");
				blackPiece.setOpacity(0);
				blackPiece.setLayoutX(ORG_BLACK_PIECE_X);
				blackPiece.setLayoutY(ORG_BLACK_PIECE_Y);
				redPiece.setOpacity(100);
				redTurn = true;
	        }
        });
     	
     	blackPiece.setOnMouseDragged(new EventHandler <MouseEvent>()
     	 {
     		 public void handle(MouseEvent event)
             {
     			 if(redTurn) return;
     			 System.out.println("Event on Source: mouse dragged");
     			 blackPiece.setLayoutX(event.getSceneX()-30);
     			 blackPiece.setLayoutY(event.getSceneY()-30);
     	         event.setDragDetect(false);
             }
         });
     	
     	for(int row = 0; row < scoreArray.length; row++) {
     		for(int col = 0; col < scoreArray[row].length; col++) {
     			scoreArray[row][col] = 0;
     		}
     	}
     	landingRowList = new int[] {5,5,5,5,5,5,5};
    }
}
