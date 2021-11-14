public class SuiteRoom extends Room {

    private Staff staff;

    public SuiteRoom(int roomNo) {
        super(roomNo, "suite room");
    }

    public SuiteRoom(int roomNo, String bedType) {
        super(roomNo, bedType, "suite room");
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }
}
