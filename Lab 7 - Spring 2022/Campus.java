/*
Julia Burnett
48354206
Lab 7 Spring 2022
*/
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Campus{
    /*Reference instance variable
        Change locations to an array list*/ 
    ArrayList<Location> buildings = new ArrayList<Location>();
    /*
    Campus Constructor needs to be edited to take a String. This
    will be the file name with the list of locations. It needs to read
    in the file and create campus locations. The file will be a line
    separated list. The first line of the file will list the number of
    locations in the file.
    */
    public Campus(String filename) {
        try {
            File file = new File(filename); 
            Scanner sc = new Scanner(file);
            int num = sc.nextInt();
            String firstLine = sc.nextLine();
            for(int i = 0; i < num; i++){
                firstLine = sc.nextLine();          
                buildings.add(new Location(firstLine, i));
            }
            
        } catch(FileNotFoundException e) {
        }
        //System.out.println(buildings.size());

    }

    /*Using x as an index number in the locations array, return 
    the Location object at that index # */
    public Location getStartLocation() {
        return buildings.get(0);
    }

    //Returns the Location object at index # 0
    public Location getLocation(int x){
        return buildings.get(x);

    }

    /*Returns a String containing the String representation of 
    all seven locations in the array (hint: use a loop to 
    build the String containing all Location objects in the 
    array)*/
    public String toString() {
    
        String w = "Campus: \n";
        for(int i = 0; i <= 6; i++){
            w = w + buildings.get(i).toString();
        }
        return w;
        
    }
}