/*
Julia Burnett
48354206
Lab 7 Spring 2022
*/
import java.util.Scanner;

public class Player{
    /*Reference instance variable
    - myLocation contains a reference to a Location
    object passed into the constructor */
    protected Location mylocation;
    /*Simple instance variable
    - name contains a String with the Player name */
    protected String name;

    /*Constructor
    - Two parameters contain the player name and location
    - Set name and myLocation to the passed in values */
    public Player(String name, Location mylocation){
        this.name = name;
        this.mylocation = mylocation;
    }
    /*setName(int)
    setter for name attribute */
    public void setName(String n) {
        this.name = n;

    }

    /*getName()
    Getter for name attribute */
    public String getName() {
        return name;
    }

    /*setMyLocation(Location)
    setter for myLocation attribute */
    public void setMyLocation(Location mylocation){
        this.mylocation = mylocation;
    }

    /*getMyLocation()
    Getter for myLocation attribute */
    public Location getMyLocation() {
        return mylocation;
    }

    public int getLocationNumber() {
        return mylocation.getlocationNumber();
    }

    /*
    toString()
    - Returns a String containing the player name and
    current
    - Example: Pat is at Location #0: Admissions

    takeTurn() – In Lab 6 you were provided the code for the takeTurn
    method. Inside that method there is logic that determines whether
    or not the player had a successful roll. For this lab you need to pull
    that logic out of takeTurn and put it in a new method named
    isSuccessful, which returns a boolean. You will then call isSuccesful
    from the location in takeTurn where that code previously existed.
    This change is required to be able to override isSuccessful in the
    two new subclasses. 
    */

    public boolean takeTurn(Shaker theShaker){

        Scanner input = new Scanner(System.in);
        System.out.printf("%s's turn at %s. \n", name, mylocation.getName());
        System.out.print("    Press Enter to shake the dice...");
        input.nextLine();
        
        theShaker.shake();
        System.out.println("   " + theShaker);
        return isSuccessful(theShaker);
    }// end takeTurn

    /*
    • isSuccessful - takes the total rolled value and the shaker. In the
    player class it will return true. This will be overridden by the
    subclasses. 
    */
    public boolean isSuccessful(Shaker theShaker){
        if(theShaker.isEven() == true){
            System.out.println("    Sum is even!");
            return true;
        }else{
            return false;
        }
        
    }

    public String toString() {
        return name + " is at " + mylocation;
    }

}