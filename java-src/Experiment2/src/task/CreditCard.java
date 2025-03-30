package task;

public class CreditCard implements PaymentMethod {
    public CreditCard() {}

    @Override
    public void spend(int amount) {}

    @Override
    public boolean hasFunds(int amount) {
        return true;
    }
}
