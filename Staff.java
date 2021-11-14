public class Staff {

    // data member
    private String staffName;
    private String staffLastName;
    private String phoneNumber;
    private String idNumber;
    private String email;

    // Constructor
    public Staff(String name, String lastName, String phonenumber, String id, String email) {
        this.staffName = name;
        this.staffLastName = lastName;
        this.phoneNumber = phonenumber;
        this.idNumber = id;
        this.email = email;

    }

    // method setStaffName
    public void setStaffName(String name) {
        this.staffName = name;

    }

    // method getStaffName
    public String getStaffName() {
        return this.staffName;

    }

    // method setStaffLastName
    public void setStaffLastName(String lastname) {
        this.staffLastName = lastname;

    }

    // method getStaffLastName
    public String getStaffLastName() {
        return this.staffLastName;

    }

    // method setphoneNumber
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;

    }

    // method getphoneNumber
    public String getPhoneNumber() {
        return this.phoneNumber;

    }

    // method setidNumber
    public void setid(String id) {
        this.idNumber = id;

    }

    // method getidNumber
    public String getid() {
        return this.idNumber;

    }

    // method setemail
    public void setemail(String email) {
        this.email = email;

    }

    // method getemail
    public String getemail() {
        return this.email;

    }

}
