/*
Julia Burnett
48354206
Lab 7 Spring 2022
*/
public class AdvancedPlayer extends Player{
    /*
    Inherits the Player class
    */
    public AdvancedPlayer (String name, Location mylocation){
        super( name,mylocation);

    }
    /*isSuccessful receives the Shaker object. It determines if the roll
    as even and greater than 6. If so, it will print Sum is even and
    greater than 6! and return true. Otherwise it will return false. */
    public boolean isSuccessful(Shaker theShaker){
        if(theShaker.isEven() && theShaker.isGreaterThanSix()){
            System.out.println("    Sum is even and greater than 6!");
            return true;
        }else{
            return false;
        }
    }
    /*
    toString will return the player name, location and that it is an
    advanced player.
    */
    public String toString() {
        return super.toString();
    }
}