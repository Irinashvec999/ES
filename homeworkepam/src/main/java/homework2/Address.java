package homework2;

public class Address {
    private String city;
    private int code;

    public Address() {
    }

    public Address(String city, int code) {
        this.city = city;
        this.code = code;
    }

    public String getCity() {
        return this.city;
    }

     void setCity(String city) {
        this.city = city;
    }

    public int getCode() {
        return code;
    }

     void setCode(int code) {
        this.code = code;
    }
}

