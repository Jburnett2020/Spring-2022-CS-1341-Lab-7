/*
Julia Burnett
48354206
Lab 7 Spring 2022
*/
import java.util.Random;

public class Die{
    private int value;
    Random random = new Random();
    //Initialize value to 1
    public Die() {
        value = 1;
    }
    //Getter for value attribute
    public int getValue(){
        return value;
    }
    //Setter for value attribute
    public void setValue(int v){
        value = v;
    }
    //Using java.util.Random, assign a random number in the range of 1..6 in the attribute value
    public int roll(){
        value = random.nextInt(6)+1;
        return value;
    }
    //Returns a String containing label Die followed by the contents of the value attribute, Example: Die 5
    public String toString() {
		String die = "Die " + String.valueOf(value);
        return die;
	}
}