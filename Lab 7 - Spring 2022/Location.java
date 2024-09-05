/*
Julia Burnett
48354206
Lab 7 Spring 2022
*/
public class Location{
    /*Simple instance variables
    - name contains a String with the location name
    - locationNumber has value 0,1,2,3,4,5 or 6 */
    private String name;
    private int locationNumber;

    /*Constructor
    - Two parameters contain the location name and number
    - Set name and locationNumber to the passed in values*/
    public Location(String n, int l){
        name = n;
        locationNumber = l;
    }

    //Getter for name attribute
    public void setName(String n){
        name = n;
    }
    //Setter for name attribute
    public String getName(){
        return name;
    }

    //Getter for locationNumber attribute
    public void setlocationNumber(int l){
        locationNumber = l;
    }

    //Setter for locationNumber attribute
    public int getlocationNumber(){
        return locationNumber;
    }

    /*toString()
    - Returns a String containing label Location # followed by locationNumber and name
    - Example: Location #0: Admissions
    */
    public String toString() {
        String locnum = "location #"+ locationNumber + ": " + name + "\n";
        return locnum;
    }
}