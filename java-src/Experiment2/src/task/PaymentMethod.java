package task;

public interface PaymentMethod {
  public void spend(int amount);
  public boolean hasFunds(int amount);
}
