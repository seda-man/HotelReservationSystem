import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
                    System.out.println("Enter room type");
                    String roomType = reader.nextLine();
                    System.out.println("Enter time interval d/m/y-d/m/y");
                    String timeInterval = reader.nextLine();
                    controller.check(roomType, timeInterval);
                    break;
                case 2: controller.makeReservation();

                case 3: controller.cancelReservation();

                case 4: controller.getRooms();

                case 5: controller.fixRoom();

                case 6: controller.freeRoom();
            }
        }
    }


}

