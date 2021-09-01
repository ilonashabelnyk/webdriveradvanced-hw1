package dto;

public class CreditCardDetails {
    private String creditCardField;
    private String creditCardValue;

    public CreditCardDetails(String creditCardField, String creditCardValue) {
        this.creditCardField = creditCardField;
        this.creditCardValue = creditCardValue;
    }

    public String getCreditCardField() {
        return creditCardField;
    }

    public void setCreditCardField(String creditCardField) {
        this.creditCardField = creditCardField;
    }

    public String getCreditCardValue() {
        return creditCardValue;
    }

    public void setCreditCardValue(String creditCardValue) {
        this.creditCardValue = creditCardValue;
    }
}