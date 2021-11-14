class Customer {
    // data member
    private String customerName;
    private String customerLastname;
    private String phoneNumber;
    private String idNumber;
    private String email;

    // Constructor
    public Customer(String name, String lastname, String phone, String id, String email) {
        this.customerName = name;
        this.customerLastname = lastname;
        this.phoneNumber = phone;
        this.idNumber = id;
        this.email = email;
    }

    // method
    public void setCustomerName(String name) {
        this.customerName = name;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerLastName(String lastname) {
        this.customerLastname = lastname;
    }

    public String getCustomerLastName() {
        return this.customerLastname;

    }

    public void setPhoneNum(String phone) {
        this.phoneNumber = phone;
    }

    public String getPhoneNum() {
        return this.phoneNumber;
    }

    public void setIdNumber(String id) {
        this.idNumber = id;
    }

    public String getIdNumber() {
        return this.idNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

}