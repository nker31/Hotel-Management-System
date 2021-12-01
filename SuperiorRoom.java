public class SuperiorRoom extends Room {

    private String kitchen;

    public SuperiorRoom(int roomNo, String kitchenStyle) {
        super(roomNo, "King size", "superior room");
        this.kitchen = kitchenStyle;
    }

    public String getKitchenStyle() {
        return kitchen;
    }

}