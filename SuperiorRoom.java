public class SuperiorRoom extends Room {

    private boolean kitchen;

    public SuperiorRoom(int roomNo) {
        super(roomNo, "superior room");

    }

    public SuperiorRoom(int roomNo, String bedType) {
        super(roomNo, bedType, "superior room");

    }

    public boolean isKitchen() {
        return kitchen;
    }

    public void setKitchen(boolean kitchen) {
        this.kitchen = kitchen;
    }
}
