/*
Julia Burnett
48354206
Lab 7 Spring 2022
*/
public class Shaker{
    //Send roll to each Die in the array
    Die[] dieArray;
    public Shaker(){
        dieArray = new Die[2];
        dieArray[0] = new Die();
        dieArray[1] = new Die();
    }
    //Send roll to each Die in the array
    public void shake(){
        dieArray[0].roll();
        dieArray[1].roll();
    }
    /*Returns true if the sum of both Die objects 
    is even, otherwise returns false */
    public boolean isEven(){
        if ((dieArray[0].getValue() + dieArray[1].getValue()) % 2 == 0){
            return true;
        } else{
            return false;
        }
    }

    /*
    isGreaterThanSix() is a method that looks at the dice to
    see if their value is greater than 6. Will return true if it is
    false otherwise. 
    */
    public boolean isGreaterThanSix(){
        if(dieArray[0].getValue() + dieArray[1].getValue() > 6 ){
            return true;
        } else {
        return false;
        }
    }

    /*Returns a String containing the values of 
    both dice in the array
    Example: Shaker with Die 6 Die 4*/
    public String toString() {
        String shaker = "Shaker with Die " + String.valueOf(dieArray[0].getValue()) + " Die " + String.valueOf(dieArray[1].getValue());
        return shaker;
	}
}