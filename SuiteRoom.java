public class SuiteRoom extends Room {

    private Staff staff;

    public SuiteRoom(int roomNo) {
        super(roomNo, "suite room");
    }

    public SuiteRoom(int roomNo, Staff staff) {
        super(roomNo, "Queen size", "suite room");
        this.staff = staff;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}