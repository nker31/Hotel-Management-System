import java.util.*;

public class Program {
    static Scanner input = new Scanner(System.in);
    static Scanner input2 = new Scanner(System.in);
    static ArrayList<Customer> allCustomer = new ArrayList<Customer>();
    static ArrayList<Room> HOTELROOM = new ArrayList<Room>();
    static String[] inputData = new String[5];

    public static void main(String[] args) {

        boolean isWorking = true;
        HOTELROOM.add(new SuiteRoom(1));
        HOTELROOM.add(new SuiteRoom(2));
        HOTELROOM.add(new SuiteRoom(3));
        HOTELROOM.add(new SuiteRoom(4));
        HOTELROOM.add(new SuiteRoom(5));

        // for (Room room : HOTELROOM) {
        // System.out.println("Room no." + room.getRoomNo() + " status " +
        // room.isStatus());
        // }
        while (isWorking) {
            showMenu();
            System.out.print("Enter :");
            String selectMenu = input.nextLine();
            int ip = Integer.parseInt(selectMenu);
            if (ip == 1) {
                checkIn();
            } else if (ip == 2) {
                checkOut();
            } else if (ip == 3) {
                showRoomInfo();
            } else if (ip == 4) {
                System.out.println(">>Exit");
                break;
            } else {
                System.out.println("Error please try again");
            }
        }
        System.out.println("End program...");
    }

    private static void showMenu() {
        System.out.println("============ Hotel Management System ========");
        System.out.println("1.check-in");
        System.out.println("2.check-out");
        System.out.println("3.check room remaining");
        System.out.println("4.exit");
        System.out.println("=============================================");

    }

    private static void checkIn() {
        System.out.println(">> Check-in menu");
        showRoomInfo();
        System.out.println("=============================================");
        System.out.print("Select room for check-in: ");
        int inputSelect = input2.nextInt();

        if (HOTELROOM.get(inputSelect - 1).getRoomCustomer() != null) {
            System.out.println("This room has been checked-in. Please select other room");
            checkIn();
        } else if (HOTELROOM.get(inputSelect - 1).getRoomCustomer() == null) {
            enterData();
            System.out.print("Confirm check-in yes(y)/no(n): ");
            String inputCF = input.nextLine();
            if (inputCF.toUpperCase().equals("Y")) {
                Customer cus = new Customer(inputData[0], inputData[1], inputData[2], inputData[3], inputData[4]);
                allCustomer.add(cus);
                HOTELROOM.get(inputSelect - 1).checkIn(cus);
                System.out.println("---- checked-in successfully ----");
            } else if (inputCF.toUpperCase().equals("N")) {
                checkIn();

            }

        }
        System.out.println("=============================================");
    }

    public static void enterData() {
        System.out.println("=============================================");
        System.out.print("Enter customer name: ");
        String inputName = input.nextLine();
        System.out.print("Enter customer lastname: ");
        String inputLname = input.nextLine();
        System.out.print("Enter customer phone number: ");
        String inputPhone = input.nextLine();
        System.out.print("Enter customer ID: ");
        String inputID = input.nextLine();
        System.out.print("Enter customer email: ");
        String inputEmail = input.nextLine();
        inputData[0] = inputName;
        inputData[1] = inputLname;
        inputData[2] = inputPhone;
        inputData[3] = inputID;
        inputData[4] = inputEmail;

    }

    private static void checkOut() {
        System.out.println(">> Check-out menu");
        showRoomInfo();
        System.out.print("Select room for check-out: ");
        int selectCheckOut = input2.nextInt();
        HOTELROOM.get(selectCheckOut - 1).checkOut();
        System.out.println("---- checked-out successfully ----");

    }

    private static void showRoomInfo() {
        showRoomRemaining();
        for (int i = 0; i < HOTELROOM.size(); i++) {
            if (HOTELROOM.get(i).isStatus().equals("booked")) {// ไม่ว่าง
                System.out.println("Room. " + HOTELROOM.get(i).getRoomNo() + ", type: " + HOTELROOM.get(i).getRoomType()
                        + ", status booked" + " Customer: " + HOTELROOM.get(i).getRoomCustomer().getCustomerName() + " "
                        + HOTELROOM.get(i).getRoomCustomer().getCustomerLastName());
            } else if (HOTELROOM.get(i).isStatus().equals("empty")) { // ว่าง
                System.out.println("Room. " + HOTELROOM.get(i).getRoomNo() + ", type: " + HOTELROOM.get(i).getRoomType()
                        + ", status empty");
            } else {
                System.out.println("I'm working but condition is not true");
            }
        }

    }

    private static void showRoomRemaining() {
        int roomRemain = 0;
        for (Room room : HOTELROOM) {
            if (room.isStatus().equals("empty"))
                roomRemain++;

        }
        System.out.println("=============================================");
        System.out.println(roomRemain + " room remaining   " + (HOTELROOM.size() - roomRemain) + " room booked");
    }

}