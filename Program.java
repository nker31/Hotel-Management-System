import java.util.*;

public class Program {
    static Scanner input = new Scanner(System.in);
    static Scanner input2 = new Scanner(System.in);
    static ArrayList<Customer> allCustomer = new ArrayList<Customer>();
    static ArrayList<Room> HOTELROOM = new ArrayList<Room>();
    static ArrayList<SuperiorRoom> SUPERIORROOM = new ArrayList<SuperiorRoom>();
    static ArrayList<SuiteRoom> SUITEROOM = new ArrayList<SuiteRoom>();
    static String[] inputData = new String[5];
    static Staff[] STAFFARRAY = new Staff[4];

    public static void main(String[] args) {

        boolean isWorking = true;
        // add staff object to STAFFARRAY
        STAFFARRAY[0] = new Staff("Phoomtep", "Pitakamnuay", "0960150773", "1218811725054", "staff1@email.com");
        STAFFARRAY[1] = new Staff("Nathat", "Kuanthanom", "0834706865", "1218811725055", "nkstaff@email.com");
        STAFFARRAY[2] = new Staff("Narongsak", "Jaroenpanyasak", "0960150773", "1640704035", "staff3@email.com");
        STAFFARRAY[3] = new Staff("Pansawut", "Pujaroen", "0968806203", "1630704458", "Pansawut.stf4@email.com");
        // add room to Array list
        SUITEROOM.add(new SuiteRoom(1, STAFFARRAY[0]));
        SUITEROOM.add(new SuiteRoom(2, STAFFARRAY[1]));
        SUITEROOM.add(new SuiteRoom(3, STAFFARRAY[2]));
        SUITEROOM.add(new SuiteRoom(4, STAFFARRAY[3]));
        SUPERIORROOM.add(new SuperiorRoom(5));
        SUPERIORROOM.add(new SuperiorRoom(6));

        // Main menu
        // Need to debug if we insert string to input the program will be error
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
                clearLine();
            } else if (ip == 4) {
                System.out.println(">>Exit");
                break;
            } else if (ip == 5) {
                showStaff();
            } else {
                System.out.println("Error please try again");
                clearLine();
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
        int selectType = selectType();
        System.out.println("=============================================");
        System.out.print("Select room for check-in: ");
        int inputSelect;
        char charInputSelect = input2.next().charAt(0);

        if (Character.isDigit(charInputSelect)) { // Check String error
            inputSelect = Character.getNumericValue(charInputSelect);

            if (selectType == 1) { // Select Supior
                // if index > SUPERIORROOM size then not found room
                if (inputSelect > SUPERIORROOM.size()) {
                    System.out.println("Room not found, Please select again");
                    clearLine();
                    checkIn();
                }
                // If room already have a customer
                if (SUPERIORROOM.get(inputSelect - 1).getRoomCustomer() != null) {
                    System.out.println("This room has been checked-in. Please select other room");
                    checkIn();
                }
                // If room not have customer, Let's Check-in
                else if (SUPERIORROOM.get(inputSelect - 1).getRoomCustomer() == null) {
                    enterData(); // this method call for insert customer data

                    System.out.print("Confirm check-in yes(y)/no(n): ");
                    String inputCF = input.nextLine();
                    if (inputCF.toUpperCase().equals("Y")) {

                        Customer cus = new Customer(inputData[0], inputData[1], inputData[2], inputData[3],
                                inputData[4]);
                        allCustomer.add(cus);
                        SUPERIORROOM.get(inputSelect - 1).checkIn(cus);
                        System.out.println("---- checked-in successfully ----");
                    } else if (inputCF.toUpperCase().equals("N")) {
                        checkIn();

                    } else {
                        System.out.println("---- Please insert only y and n ----");
                        checkIn();
                    }
                    System.out.println("=============================================");
                }
            }
            // Select suite
            else {
                // if index > SUPERIORROOM size then not found room
                if (inputSelect > SUITEROOM.size()) {
                    System.out.println("Room not found, Please select again");
                    clearLine();
                    checkIn();
                }
                // If room already have a customer
                if (SUITEROOM.get(inputSelect - 1).getRoomCustomer() != null) {
                    System.out.println("This room has been checked-in. Please select other room");
                    checkIn();
                }
                // If room not have customer, Let's Check-in
                else if (SUITEROOM.get(inputSelect - 1).getRoomCustomer() == null) {
                    enterData();

                    System.out.print("Confirm check-in yes(y)/no(n): ");
                    String inputCF = input.nextLine();
                    if (inputCF.toUpperCase().equals("Y")) {
                        Customer cus = new Customer(inputData[0], inputData[1], inputData[2], inputData[3],
                                inputData[4]);
                        allCustomer.add(cus);
                        SUITEROOM.get(inputSelect - 1).checkIn(cus);
                        System.out.println("---- checked-in successfully ----");
                    } else if (inputCF.toUpperCase().equals("N")) {
                        checkIn();

                    } else {
                        System.out.println("---- Please insert only y and n ----");
                        checkIn();
                    }
                    System.out.println("=============================================");
                }
            }

            clearLine();
        }
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
        boolean notfound = true;
        System.out.println(">> Check-out menu");
        showRoomInfo(); // show all room status
        System.out.print("Select room no. for check-out: ");
        int selectCheckOut = input2.nextInt(); // insert room number for check-out
        // find room no. in SUITEROOM array list
        for (SuiteRoom room : SUITEROOM) {
            // if found room no.
            if (room.getRoomNo() == selectCheckOut) {
                // if that room is booked, Let's check-out
                if (room.isStatus().equals("booked")) {
                    room.checkOut();
                    System.out.println("---- checked-out successfully ----");
                } else {
                    System.out.println("---- Cannot check-out, the room is not booked ----");
                }
                notfound = false;
            }
        }
        // find room no. in SUPERIOR array list
        for (SuperiorRoom room : SUPERIORROOM) {
            // if found room no.
            if (room.getRoomNo() == selectCheckOut) {
                // if that room is booked, Let's check-out
                if (room.isStatus().equals("booked")) {
                    room.checkOut();
                    System.out.println("---- checked-out successfully ----");

                } else {
                    System.out.println("---- Cannot check-out, the room is not booked ----");
                }
                notfound = false;

            }
        }
        // if not found that room no. in the hotel
        if (notfound) {
            System.out.println("---- checked-out failed, no room number in the hotel ----");
            checkOut();
        }
        clearLine();

    }

    private static int selectType() {
        System.out.println("==== Select room type ====");
        System.out.println("1. Superior Room");
        System.out.println("2. Suite Room");
        System.out.print("Press number for select room (1 or 2) : ");
        int selectedType = input2.nextInt();
        if (selectedType == 1) {
            showSelectedRoomInfo(1); // Select superior room
        } else if (selectedType == 2) {
            showSelectedRoomInfo(2);// Select suite room
        } else {
            System.out.println("Error please select type again");
            checkIn();
        }
        return selectedType;

    }

    private static void showSelectedRoomInfo(int selectedType) {

        if (selectedType == 1) {
            for (int i = 0; i < SUPERIORROOM.size(); i++) {
                if (SUPERIORROOM.get(i).isStatus().equals("booked")) {// ไม่ว่าง
                    System.out.println(

                            (i + 1) + ". " + "Room no. " + SUPERIORROOM.get(i).getRoomNo() + ", type: "
                                    + SUPERIORROOM.get(i).getRoomType()
                                    + ", status booked" + " Customer: "
                                    + SUPERIORROOM.get(i).getRoomCustomer().getCustomerName() + " "
                                    + SUPERIORROOM.get(i).getRoomCustomer().getCustomerLastName());
                } else if (SUPERIORROOM.get(i).isStatus().equals("empty")) { // ว่าง
                    System.out.println(
                            (i + 1) + ". " + "Room no. " + SUPERIORROOM.get(i).getRoomNo() + ", type: "
                                    + SUPERIORROOM.get(i).getRoomType()
                                    + ", status empty");
                } else {
                    System.out.println("I'm working but condition is not true");
                }
            }

        } else {

            // Show Suite room
            for (int i = 0; i < SUITEROOM.size(); i++) {
                // Check room status empty or booked
                if (SUITEROOM.get(i).isStatus().equals("booked")) {// ไม่ว่าง
                    System.out.println(
                            (i + 1) + ". " + "Room no. " + SUITEROOM.get(i).getRoomNo() + ", type: "
                                    + SUITEROOM.get(i).getRoomType()
                                    + ", status booked" + " Customer: "
                                    + SUITEROOM.get(i).getRoomCustomer().getCustomerName() + " "
                                    + SUITEROOM.get(i).getRoomCustomer().getCustomerLastName() + " Staff: "
                                    + SUITEROOM.get(i).getStaff().getStaffName());
                } else if (SUITEROOM.get(i).isStatus().equals("empty")) { // ว่าง
                    System.out.println(
                            (i + 1) + ". " + "Room no. " + SUITEROOM.get(i).getRoomNo() + ", type: "
                                    + SUITEROOM.get(i).getRoomType()
                                    + ", status empty" + " Staff: " + SUITEROOM.get(i).getStaff().getStaffName());
                } else {
                    System.out.println("I'm working but condition is not true");
                }
            }
        }
    }

    private static void showRoomInfo() {
        System.out.println("=============== Show All Room===============");

        showRoomRemaining();

        // Show SuiteRoom
        for (int i = 0; i < SUITEROOM.size(); i++) {
            if (SUITEROOM.get(i).isStatus().equals("booked")) {// ไม่ว่าง
                System.out.println("Room. " + SUITEROOM.get(i).getRoomNo() + ", type: " + SUITEROOM.get(i).getRoomType()
                        + ", status booked" + " customer: " + SUITEROOM.get(i).getRoomCustomer().getCustomerName() + " "
                        + SUITEROOM.get(i).getRoomCustomer().getCustomerLastName());
            } else if (SUITEROOM.get(i).isStatus().equals("empty")) { // ว่าง
                System.out.println("Room. " + SUITEROOM.get(i).getRoomNo() + ", type: " + SUITEROOM.get(i).getRoomType()
                        + ", status empty");
            } else {
                System.out.println("I'm working but condition is not true");
            }
        }

        // Show SuperiorRoom
        for (int i = 0; i < SUPERIORROOM.size(); i++) {
            if (SUPERIORROOM.get(i).isStatus().equals("booked")) {// ไม่ว่าง
                System.out.println(
                        "Room. " + SUPERIORROOM.get(i).getRoomNo() + ", type: " + SUPERIORROOM.get(i).getRoomType()
                                + ", status booked" + " customer: "
                                + SUPERIORROOM.get(i).getRoomCustomer().getCustomerName() + " "
                                + SUPERIORROOM.get(i).getRoomCustomer().getCustomerLastName());
            } else if (SUPERIORROOM.get(i).isStatus().equals("empty")) { // ว่าง
                System.out.println(
                        "Room. " + SUPERIORROOM.get(i).getRoomNo() + ", type: " + SUPERIORROOM.get(i).getRoomType()
                                + ", status empty");
            } else {
                System.out.println("I'm working but condition is not true");
            }
        }

    }

    private static void showRoomRemaining() {
        int roomRemain = 0;
        int totalRoom = SUITEROOM.size() + SUPERIORROOM.size();
        for (SuiteRoom room : SUITEROOM) {
            if (room.isStatus().equals("empty"))
                roomRemain++;

        }
        for (SuperiorRoom room : SUPERIORROOM) {
            if (room.isStatus().equals("empty"))
                roomRemain++;

        }
        System.out.println("Total room : " + totalRoom + " | " + roomRemain + " room remaining   "
                + (totalRoom - roomRemain) + " room booked");
        System.out.println("=============================================");
    }

    private static void showStaff() {
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("name            lastname           phone num.           email");
        System.out.println("--------------------------------------------------------------------------------");
        // name12 lname 15
        for (Staff staff : STAFFARRAY) {
            System.out.format("%-12s\t%-19s%-13s\t%-15s\n", staff.getStaffName(), staff.getStaffLastName(),
                    staff.getPhoneNumber(), staff.getemail());
        }
        System.out.println("--------------------------------------------------------------------------------");
        clearLine();
    }

    private static void clearLine() {
        System.out.println("-----> Please any key to continue <-----");
        input.nextLine();
        for (int i = 0; i < 15; i++) {
            System.out.println("");
        }
    }

}