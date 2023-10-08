public class Driver_22033701{
    private String licenceNumber;
    private String licenceClass;
    private String firstName;
    private String lastName;
    private String address;
    private String suburb;
    private String postcode;
    private int demeritPoints;
    private String licenceStatus;

    public Driver_22033701(String licenceNumber, String licenceClass, String firstName, String lastName,
    String address, String suburb, String postcode, int demeritPoints, String licenceStatus){
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
    public int getDemeritPoints(){
        return demeritPoints;
    }
    public void setDemeritPoints(int demeritPoints){
        this.demeritPoints = demeritPoints;
    }
    public String getlicenceStatus(){
        return licenceStatus;
    }
    public void setLicenceStatus(String licenceStatus){
        this.licenceStatus = licenceStatus;
    }
    public String getlicenceNumber(){
        return licenceNumber;
    }
    public void setLicenceNumber(String licenceNumber){
        this.licenceNumber = licenceNumber;
    }
    public String getfirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getAddress(){
        return address;
    }

    @Override
    public String toString(){
        return "Licence Number: " + licenceNumber +
        ", Licence Class:  " + licenceClass +
        ", First Name: " + firstName +
        ", Last Name: " + lastName +
        ", Address: " + address +
        ", Suburb: " + suburb +
        ", Postcode: " + postcode +
        ", Demerit Points: " + demeritPoints +
        ", Lincence Status: " + licenceStatus;
    }
}