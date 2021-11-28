public class SuperiorRoom extends Room {

    private boolean kitchen;

    public SuperiorRoom(int roomNo) {
        super(roomNo, "King size", "superior room");

    }

    public boolean isKitchen() {
        return kitchen;
    }

    public void setKitchen(boolean kitchen) {
        this.kitchen = kitchen;
    }
}