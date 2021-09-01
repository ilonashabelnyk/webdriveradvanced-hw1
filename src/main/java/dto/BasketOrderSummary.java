package dto;

public class BasketOrderSummary {
    private String delivery;
    private String total;


    public BasketOrderSummary(String delivery, String total) {
        this.delivery = delivery;
        this.total = total;
    }

    public String getDelivery() {
        return delivery;
    }

    public String getTotal() {
        return total;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}