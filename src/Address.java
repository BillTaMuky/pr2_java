public class Address {
    String city;
    String street;
    int buildingNumber;
    int apartmentNumber;

    public Address(String city, String street, int buildingNumber, int apartmentNumber) {
        this.city = city;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.apartmentNumber = apartmentNumber;
    }

    @Override
    public String toString() {
        return city + ", " + street + " " + buildingNumber + ", apt. " + apartmentNumber;
    }
}

