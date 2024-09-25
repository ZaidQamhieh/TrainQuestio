import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Driver {
    static Train t = new Train();
    public static void main(String[] args) {
        while (true) {
            printMenu();
            Scanner op = new Scanner(System.in);
            int option = op.nextInt();
            int seat = 0;
            Scanner input = new Scanner(System.in);
            switch (option) {
                case 1:
                    readFromFile();
                    continue;
                case 2:
                    System.out.println("Please Enter The Seat You Want To Reserve And The name");
                    seat = input.nextInt();
                    String name = input.next();
                    reserveANewEmptySeat(seat, name);
                    continue;
                case 3:
                    System.out.println("Please Enter The Seat You Want To Empty");
                    seat = input.nextInt();
                    deleteAReservedSeat(seat);
                    continue;
                case 4:
                    deleteAllReservedSeats();
                    continue;
                case 5:
                    updatePassengerFile();
                    continue;
                case 6:
                    t.printAllSeats();
                    continue;
                case 7:
                    break;
            }
            break;
        }
    }
    public static void readFromFile() {
        File file = new File("C:\\Users\\zqmhy\\IdeaProjects\\reLearning\\src\\passengers");
        if (file.exists()) {
            try {
                Scanner scanner = new Scanner(file);
                int seatNumber = 0;
                String name = null;
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    String parts[] = line.trim().split(":");
                    try {
                        seatNumber = Integer.parseInt(parts[0]);
                        name = parts[1];
                    } catch (Exception e) {
                    }
                    if (Seat.isValid(seatNumber)) {
                        if (t.reserveSeat(seatNumber, name)) {
                            System.out.println(seatNumber+ "Reserved Successfully");
                        } else {
                            System.out.println(seatNumber+" Is either Reserved Seat Or Don't Exist");
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            System.out.println("Ouch Error In File");
        }
    }
    public static void reserveANewEmptySeat(int seatNumber, String name) {
        if (t.reserveSeat(seatNumber, name)) {
            System.out.println("Seat Reserved Successfully");
        }else {
            System.out.println("The Seat Isn't Empty");
        }
    }
    public static void deleteAReservedSeat(int seatNumber) {
        if (t.deleteNonEmpty(seatNumber)){
            System.out.println("Seat Deleted Successfully");
        }else{
            System.out.println("The Seat Is Already Empty");
        }
    }public static void deleteAllReservedSeats() {
        t.deleteSeats();
    }
    public static void updatePassengerFile(){
        File file = new File("C:\\Users\\zqmhy\\IdeaProjects\\reLearning\\src\\passengers");
        if (file.exists()) {
            try(PrintWriter p = new PrintWriter(file)) {
                for (int i = 0; i < 88; i++) {
                    if (t.getSeats()[i].getPassengerName() != null) {
                    p.println(t.getSeats()[i].toString()+"\t");}
                }
            }catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    public static void printMenu() {
        System.out.println("Please Pick Your Option: ");
        System.out.println("1) Read From File");
        System.out.println("2) Reserve A New Empty Seat");
        System.out.println("3) Delete A Reserved Seat");
        System.out.println("4) Delete All Reserved Seats");
        System.out.println("5) Update Passenger File");
        System.out.println("6) Print All On Screen");
        System.out.println("7) Quit");
    }
}
