import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner myObj1 = new Scanner(System.in);
        System.out.println("Please Input location: ");//Can be expanded on where information on each place is stored, at the moment
        String locationName = myObj1.nextLine();//it is just for "Lobitos"
        TourismAssistance tourismAssistance = new TourismAssistance(locationName);
        tourismAssistance.initialiseData();//Gets all the data from the txt files
        tourismAssistance.userChoice();//begins the program where the users inputs are taken in
    }
}