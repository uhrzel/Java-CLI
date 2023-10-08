// Driver.java
public class Driver_22033701 {
    private String licenceNumber;
    private String licenceClass;
    private String firstName;
    private String lastName;
    private String address;
    private String suburb;
    private String postcode;
    private int demeritPoints;
    private String licenceStatus;

    // Constructors
    public Driver_22033701(String licenceNumber, String licenceClass, String firstName, String lastName,
                  String address, String suburb, String postcode, int demeritPoints, String licenceStatus) {
        this.licenceNumber = licenceNumber;
        this.licenceClass = licenceClass;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.suburb = suburb;
        this.postcode = postcode;
        this.demeritPoints = demeritPoints;
        this.licenceStatus = licenceStatus;
    }

    @Override
    public String toString() {
        return "Licence Number: " + licenceNumber +
                ", Licence Class: " + licenceClass +
                ", First Name: " + firstName +
                ", Last Name: " + lastName +
                ", Address: " + address +
                ", Suburb: " + suburb +
                ", Postcode: " + postcode +
                ", Demerit Points: " + demeritPoints +
                ", Licence Status: " + licenceStatus;
    }

    // Other methods go here
}
