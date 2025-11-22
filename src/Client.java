public class Client {
    private String AFM;
    private String first_name;
    private String last_name;
    private String phone;
    private String email;
    public Client(String AFM, String first_name, String last_name, String phone, String email) {
        this.AFM = AFM;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone = phone;
        this.email = email;
    }
    public String getAFM() {
        return AFM;
    }
    public String getFirst_name() {
        return first_name;
    }
    public String getLast_name() {
        return last_name;
    }
    public String getPhone() {
        return phone;
    }
    public String getEmail() {
        return email;
    }
}
