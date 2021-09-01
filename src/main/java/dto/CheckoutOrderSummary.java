package dto;

public class CheckoutOrderSummary {
    private String subTotal;
    private String delivery;
    private String vat;
    private String total;

    public CheckoutOrderSummary(String subTotal, String delivery, String vat, String total) {
        this.subTotal = subTotal;
        this.delivery = delivery;
        this.vat = vat;
        this.total = total;
    }

    public String getDelivery() {
        return delivery;
    }

    public String getTotal() {
        return total;
    }

    public String getSubTotal() {
        return subTotal;
    }

    public String getVat() {
        return vat;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }
}