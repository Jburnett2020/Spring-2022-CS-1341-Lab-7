/*
Julia Burnett
48354206
Lab 7 Spring 2022
*/
import java.util.Scanner;
import java.io.File;  
import java.io.PrintWriter;
import java.util.ArrayList;

public class GraduationGame{
    /*Reference instance variables
    - players contains an arraylist of Player objects
    - theCampus contains a reference to a Campus object
    - Add a third reference instance variable named theShaker
    referencing one Shaker object

    */
    private static ArrayList<Player> players = new ArrayList<Player>();
    private static Campus theCampus;
    private static Scanner userinput = new Scanner(System.in);
    private static Shaker theShaker;
    

    
    public GraduationGame(){
        
        createPlayer();
        theShaker = new Shaker();
    }
    /*
    main method will be adjusted to pass the file provided from
    the command line arguments to the Campus class using the
    args parameter in the main method.
    */
    public static void main(String[] args){
        theCampus = new Campus(args[0]);
        GraduationGame theGame = new GraduationGame();
        theGame.playGame();
    }

    /*createPlayers()
    - Create Player array of size 2 and assign to players
    variable
    - Use java.util.Scanner to prompt for the two Player name
    Strings
    - Send getStartLocation to theCampus, which will return the
    Location object that is the starting point of the game
    - Create two Player objects using the name entered by the
    user and the Location object returned by theCampus. Pass
    both to the Player constructor
    - Put each of the newly created Player objects in the
    players array 

    createPlayers will be changed to use a loop that can support
    any number of players. After the first player is entered the
    program will prompt the user if they want to add another
    player. They will enter 1 for a new player and -1 to finish.
    
    needs to be changed to prompt the user for
    player difficulty level. They will enter a "A: for advanced or "B"
    for beginner. 
    */
    public void createPlayer(){
        int num = 1;
        while(true) {
        System.out.printf("Enter player %d's name: ", num);
        String playerOneName = userinput.nextLine();
        Location start = theCampus.getStartLocation();
        
        System.out.print("Is this a Advanced player or Beginner? (A/B)");
        String playerChoice = userinput.nextLine();
        if(playerChoice.equals("A")){
            players.add(new AdvancedPlayer(playerOneName, start));
        }
        else if(playerChoice.equals("B")){
            players.add(new BeginnerPlayer(playerOneName, start));
        }

        System.out.print("Would you like to add an additional player? 1 for yes, -1 for No:");
        String choice = userinput.nextLine();
        if(choice.equals("1")){
            num++;
            continue;
        }
        else if(choice.equals("-1")){
            break;
        }
        }
    }
    /*
    playGame() should add a call to createWinnerCertificate
    method in it at the appropriate place in the logic. It also will
    need to be adjusted on how it checks if the player is at the final
    location and the game needs to end. 
    */
    public void playGame(){
        boolean gameOver = false;
        while(gameOver == false){
            for(int i = 0 ; i < players.size(); i++){
                Player aPlayer = players.get(i);
                boolean advance = aPlayer.takeTurn(theShaker);
                if(advance == false){
                    System.out.printf("    %s is stuck\n",aPlayer.getName());
                } else {
                    //get player's current location number
                    int locNum = aPlayer.getLocationNumber();
                    //increment locNum to advance
                    locNum++;
                    if (locNum == 7){
                        gameOver = true;
                        System.out.printf("Game over! %s is the winner!\n",aPlayer.getName());
                        createWinnerCertificate(aPlayer);
                        break; //break out of playing for loop
                    } else {
                        Location newLoc = theCampus.getLocation(locNum);
                        aPlayer.setMyLocation(newLoc);
                        System.out.printf("   %s is now at %s\n", aPlayer.getName(),newLoc.getName());
                    }
                }// end else advance == false
            }// end for loop
        }//end while loop

    }//end playGame

    /* A method called createWinnerCertificate(Player player) will be
    created that outputs the winner Certificate to the file
    winnerCertificate.txt.
    */
    public void createWinnerCertificate(Player player){
        String filename = "winnerCertificate.txt";
        try{
        PrintWriter writer = new PrintWriter(filename);  
        writer.println("*************************************");
        writer.println("           CONGRATS!!!               ");
        writer.println(String.format("%s has won the game!!!", player.name));
        writer.println("*************************************");
        writer.close();
        }
        catch(Exception e){
            System.out.println("cant make file");
        }
    }

    /*
    toString()
    - Returns a String containing the String representation of
    both Player objects in the players array with their
    location
    */
    public String toString() {
        return "Graduation Game: \n" + players.get(0).toString() + players.get(1).toString();
    }
}