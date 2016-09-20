package airlinesystem.model.valueobject.enums;

public enum Payment 
{
    CARD (0),
    BANKTRANSFER (1),
    PAYPAL (2);
    
    private int paymentType;
    
    Payment (int paymentType)
    {
        this.paymentType = paymentType;
    }
    
    public int getPaymentType()
    {
        return this.paymentType;
    }
    
    public void setPaymentType(int paymentType)
    {
        this.paymentType = paymentType;
    }
}
