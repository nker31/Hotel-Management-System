import java.util.List;

public class Room {

    protected int roomNo;
    protected String roomType;
    protected String bedType;
    protected Customer customer;
    protected String status = "empty";

    public Room(int roomNo, String roomType) {
        this.roomNo = roomNo;
        this.roomType = roomType;
    }

    public Room(int roomNo, String bedType, String roomType) {
        this.roomNo = roomNo;
        this.bedType = bedType;
        this.roomType = roomType;
    }

    public void checkIn(Customer customer) {
        this.status = "booked";
        this.customer = customer;
    }

    public Customer getRoomCustomer() {
        return this.customer;
    }

    public void checkOut() {
        this.customer = null;
        this.status = "empty";
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    public String isStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
