package dto;

public class DeliveryAddressForm {
    private String fullName;
    private String addressLine1;
    private String addressLine2;
    private String townCity;
    private String postcode;
    private String countryState;

    public DeliveryAddressForm(String fullName, String addressLine1, String addressLine2, String townCity, String countryState, String postcode) {
        this.fullName = fullName;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.townCity = townCity;
        this.countryState = countryState;
        this.postcode = postcode;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public void setTownCity(String townCity) {
        this.townCity = townCity;
    }

    public void setCountryState(String countryState) {
        this.countryState = countryState;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }


    public String getFullName() {
        return fullName;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getTownCity() {
        return townCity;
    }

    public String getCountryState() {
        return countryState;
    }

    public String getPostcode() {
        return postcode;
    }
}