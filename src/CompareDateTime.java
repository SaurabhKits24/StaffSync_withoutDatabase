import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class CompareDateTime {

public static void main(String[] args) {
    String fileName = "datetime.dat";
    File file = new File(fileName);
    String storedDateTimeStr;

    // Check if file exists
    if (file.exists()) {
        // File exists, read date and time from the file
        try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            storedDateTimeStr = dis.readUTF();
            System.out.println("Date and time read from file: " + storedDateTimeStr);

            // Compare stored date and time with current date and time
            Date storedDateTime = parseDateTime(storedDateTimeStr);

            if (isExpired(storedDateTime)) {
                System.out.println("Free trial expired. Press Enter to update trial period...");
                waitForEnterKeyPress(); // Wait for user to press Enter
                updateFileWithCurrentDateTime(file); // Update file with current date and time
            } else {
                System.out.println("Free trial still going on.");
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    } else {
        // File does not exist, create it and store current date and time
        
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {
            Date currentDateTime = new Date();
            String formattedDateTime = formatDateTime(currentDateTime);
            dos.writeUTF(formattedDateTime);
            System.out.println("File created with current date and time: " + formattedDateTime);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
public static boolean isExpired(Date storedDateTime) {
    // Calculate expiration date as 6 months from storedDateTime
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(storedDateTime);
    calendar.add(Calendar.MONTH, 6); // Add 6 months

    Date expirationDate = calendar.getTime();
    Date currentDate = new Date();

    // Compare current date with expiration date
    return currentDate.after(expirationDate);
}

public static Date parseDateTime(String dateTimeStr) throws ParseException {
    SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
    return dateFormat.parse(dateTimeStr);
}

public static String formatDateTime(Date dateTime) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
    return dateFormat.format(dateTime);
}

    public static void waitForEnterKeyPress() { System.out.println("Press Enter to continue...");
        try {
            System.in.read(); // This will wait for the user to press Enter
        } catch (IOException e) {
            e.printStackTrace();
        }  }

    public static void updateFileWithCurrentDateTime(File file) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {
            Date currentDateTime = new Date();
            String formattedDateTime = formatDateTime(currentDateTime);
            dos.writeUTF(formattedDateTime);
            System.out.println("File updated with current date and time: " + formattedDateTime);
        } catch (IOException e) {
            e.printStackTrace();
        }    }

}
