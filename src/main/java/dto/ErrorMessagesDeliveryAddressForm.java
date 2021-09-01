package dto;

public class ErrorMessagesDeliveryAddressForm {
    private String fieldName;
    private String errorMsg;

    public ErrorMessagesDeliveryAddressForm(String fieldName, String errorMsg) {
        this.fieldName = fieldName;
        this.errorMsg = errorMsg;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}