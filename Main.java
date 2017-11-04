import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by sedam on 04-Nov-17.
 */
public class Main {

    public static void main(String[] arg) {
        Hotel hotel = new Hotel("Captain Hook", "Neverland");
        Controller controller = hotel.getController();
        String fileName = "Intro.txt";

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            // Always close files.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
  
        int n = 1;
        Scanner reader = new Scanner(System.in);
        while(n !=0) {
            n = reader.nextInt();
            switch (n) {
                case 1:
                    reader.nextLine();
                    System.out.println("Enter room type");
                    String roomType = reader.nextLine();
                    System.out.println("Enter time interval d/m/y-d/m/y");
                    String timeInterval = reader.nextLine();
                    controller.check(roomType, timeInterval);
                    break;
                case 2:
                    reader.nextLine();
                    System.out.println("Enter room type");
                    String roomType1 = reader.nextLine();
                    System.out.println("Enter time interval d/m/y-d/m/y");
                    String timeInterval1 = reader.nextLine();
                    int reservationID = controller.makeReservation(roomType1, timeInterval1);
                    System.out.println("Your reservation ID is:" + reservationID);
                    break; 

                case 3: 
                    System.out.println("Enter your reservationID");
                    int reservationID1 = reader.nextInt();
                    controller.cancelReservation(reservationID1);
                    break;

                case 4: 
                    System.out.println("Enter your reservationID");
                    int reservationID2 = reader.nextInt();
                    ArrayList<Room> rooms = controller.getRooms(reservationID2);
                    System.out.println("Here's the list of available rooms:");
                    for(int i=0;i<rooms.size();i++)
                    {
                      System.out.println(rooms.get(i).getNumber());
                    }
                    break;

                case 5: 
                    if(controller.getRes() == null)
                    {
                       System.out.println("You have to ask for available rooms first, for that please enter 4.");
                       break;
                    }
                    System.out.println("Enter the room number:");
                    int number = reader.nextInt();
                    System.out.println("Enter your personal data");
                    String personalData = reader.nextLine();
                    controller.fixRoom(number, personalData);
                    break;

                case 6: 
                    System.out.println("Enter your room number");
                    int number1 = reader.nextInt();
                    controller.freeRoom(number1);
                    break;

            }
        }
        
        reader.close();
    }


}

