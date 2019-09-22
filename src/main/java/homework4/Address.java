package homework4;

public class Address {
    private String street;
    private int houseNumber;
    private String town;


    public Address( int houseNumber, String street, String town) {
        this.street = street;
        this.houseNumber = houseNumber;
        this.town = town;
    }

    public String getStreet() {
        return street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public String getTown() {
        return town;
    }

    public Address(){}
}
