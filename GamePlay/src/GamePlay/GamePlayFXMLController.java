
package GamePlay;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import java.util.Random;


public class GamePlayFXMLController implements Initializable {
    
    private Label theLabel;
    @FXML
    private Label userSelection;
    @FXML
    private Button rockButton;
    @FXML
    private Button paperButton;
    @FXML
    private Button scissorsButton;
    @FXML
    private Button lizardButton;
    @FXML
    private Button spockButton;
    
    private Image[] images;
    @FXML
    private Label compChoice;
    @FXML
    private ImageView playerImage;
    @FXML
    private ImageView computerImage;
    @FXML
    private Label winner;
    @FXML
    private Label winnerReasonLabel;
    
    //Integer Array Used For Choice Comparision in Game
    private static final int choices[]={0,1,2,3,4};
    
    private int playerChoice;
    


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Initializing Images Used in Game
        images = new Image[5];
        images[0] = new Image("pngtree-monochrome-rock-clip-art-png-image_2689540.jpg");
        images[1] = new Image("paper.png");
        images[2] = new Image("scissors.png");
        images[3] = new Image("istockphoto-115344681-612x612.jpg");
        images[4] = new Image("spock.png");


    }    

 

    @FXML
    private void handleClick(ActionEvent event) {
        //Initialize Index Variable Used in Image Location
        int index = 0;
        
        //If User Clicks on Rock Button
        if(event.getSource() == rockButton){
            index = 0;
            userSelection.setText("ROCK");
        }
        //If User Clicks on Paper Button
        else if(event.getSource() == paperButton){
            index = 1;
        userSelection.setText("PAPER");
        }
         //If User Clicks on Scissors Button       
        else if(event.getSource() == scissorsButton){
            index = 2;
                  userSelection.setText("SCISSORS");

        }
         //If User Clicks on Lizard Button      
        else if(event.getSource() == lizardButton){
            index = 3;
                    userSelection.setText("LIZARD");

        }
        //If User Clicks on Spock Button         
        else if(event.getSource() == spockButton){
            index = 4;
                    userSelection.setText("SPOCK");
        }       
        //Set Player Image to Chosen Button
        playerImage.setImage(images[index]);
        //Player Choice Determined by Choice of Button
        playerChoice = choices[index];
        
        //Call to Get Computer Choice and Determine Game Winner
        gameWinner(playerChoice,computerChoice());
        
    }

//Method that Gets Computer's Choice to be used in determining winner and setting 
    //Image to that Choice
private int computerChoice(){
    //Random used to create random choice
    int comp = (int)(Math.random()*5);
    
    //Switch Statement to Set Text to Chosen Randomly Determined Choice
    switch(comp){
        case 0:
            compChoice.setText("ROCK");
            break;
        case 1:
            compChoice.setText("PAPER");
            break;            
        case 2:
            compChoice.setText("SCISSORS");
            break;            
        case 3:
            compChoice.setText("LIZARD");
            break;            
        case 4:
             compChoice.setText("SPOCK");
            break;           
    }
    
    //Set Image to choice based index
    computerImage.setImage(images[comp]);
    
    //Return choice to determine winner
    return comp;
}

//Method to Determine Winner 
private void gameWinner(int player, int computer){
    //Switch statement based on Player's choice to determine winner
    //and set winner image and text accordingly 
    switch(player){
//Nested Switch based on Computer's choice
        //Player has PAPER
        case 1:
            switch(computer){
                //Computer has PAPER
                case 1:
                    winner.setText("TIE");
                    winnerReasonLabel.setText("You Both Chose PAPER!");
                    break;
                 //Computer has SCISSORS                   
                case 2:
                    winner.setText("COMPUTER");
                    winnerReasonLabel.setText("SCISSORS Cuts PAPER!");                  
                    break;    
                 //Computer has LIZARD
                case 3:
                    winner.setText("COMPUTER");
                    winnerReasonLabel.setText("LIZARD Eats PAPER!");                    
                    break;   
                 //Computer has SPOCK
                case 4:
                    winner.setText("PLAYER");
                    winnerReasonLabel.setText("PAPER Disproves SPOCK!");                             
                    break;  
                 //Computer has ROCK
                default:
                    winner.setText("PLAYER");
                    winnerReasonLabel.setText("PAPER Covers ROCK!");                     
                    break;                   
            }
                      break;
        //Player has SCISSORS          
        case 2:
            switch(computer){
                   //Computer has PAPER
                case 1:
                    winner.setText("PLAYER");
                      winnerReasonLabel.setText("SCISSORS cuts PAPER!");                                    
                      break;                  
                //Computer has SCISSORS 
                case 2:
                    winner.setText("TIE");
                    winnerReasonLabel.setText("You Both Chose SCISSORS!");
                     break;              
 
                 //Computer has LIZARD              
                case 3:
                    winner.setText("PLAYER");
                    winnerReasonLabel.setText("SCISSORS Decapitates LIZARD!");                  
                     break;      
                  //Computer has SPOCK             
                case 4:
                    winner.setText("COMPUTER");
                    winnerReasonLabel.setText("SPOCK Smashes SCISSORS!");                  
                     break;                   
                 //Computer has  ROCK             
                default: 
                     winner.setText("COMPUTER");
                    winnerReasonLabel.setText("ROCK Crushes SCISSORS!");                   
                     break;
            }
                      break;
         //Player has LIZARD           
        case 3:
           switch(computer){
                 //Computer has   PAPER            
               case 1:
                    winner.setText("PLAYER");
                    winnerReasonLabel.setText("LIZARD Eats PAPER!");                  
                    break;                   
                  //Computer has SCISSORS             
                case 2:
                    winner.setText("COMPUTER");
                    winnerReasonLabel.setText("SCISSORS Decapitates LIZARD!");                    
                    break;               
                  //Computer has LIZARD             
                case 3:
                    winner.setText("TIE");
                    winnerReasonLabel.setText("You Both Chose Lizard!");
                     break;
                  //Computer has SPOCK            
                case 4:
                    winner.setText("PLAYER");
                    winnerReasonLabel.setText("LIZARD Poisons SPOCK!");                  
                    break;                   
                 //Computer has ROCK              
                default: 
                    winner.setText("COMPUTER");
                    winnerReasonLabel.setText("ROCK Crushes LIZARD!");                    
                    break;
                        }
            break;
         //Player has SPOCK                       
        case 4:
          switch(computer){
                 //Computer has PAPER              
              case 1:
                    winner.setText("COMPUTER");
                    winnerReasonLabel.setText("PAPER Disproves SPOCK!");                    
                     break;                   
                 //Computer has SCISSORS              
                case 2:
                    winner.setText("PLAYER");
                    winnerReasonLabel.setText("SPOCK Smashes SCISSORS!");                  
                    break;               
                  //Computer has LIZARD            
                case 3:
                       winner.setText("COMPUTER");
                    winnerReasonLabel.setText("LIZARD Poisons SPOCK!");                 
                    break;                    
                   //Computer has SPOCK             
                case 4:
                    winner.setText("TIE");
                    winnerReasonLabel.setText("You Both Chose SPOCK!"); 
                     break;
                 //Computer has ROCK
                default: 
                    winner.setText("PLAYER");
                    winnerReasonLabel.setText("SPOCK Vaporizes ROCK!");                  
                    break;

                        }
          break;
          //Player has ROCK                      
        default:
            switch(computer){
                  //Computer has PAPER
                case 1:
                     winner.setText("COMPUTER");
                    winnerReasonLabel.setText("PAPER Covers ROCK!");                   
                      break;  
                 //Computer has  SCISSORS 
                case 2:
                    winner.setText("PLAYER");
                    winnerReasonLabel.setText("ROCK Crushes SCISSORS!");                  
                    break; 
                 //Computer has LIZARD
                case 3:
                    winner.setText("PLAYER");
                    winnerReasonLabel.setText("ROCK Crushes LIZARD!");                  
                    break; 
                 //Computer has SPOCK
                case 4:
                     winner.setText("COMPUTER");
                    winnerReasonLabel.setText("SPOCK Vaporizes ROCK!");                   
                     break;   
                 //Computer has  ROCK  
                default: 
                    winner.setText("TIE");
                    winnerReasonLabel.setText("You Both Chose ROCK!");
                     break;
            }
             break;
    }
    
    
    
 

    }
}
    

