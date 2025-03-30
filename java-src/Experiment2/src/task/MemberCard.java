package task;

public class MemberCard implements PaymentMethod {
    public int balance;

    public MemberCard() {}

    @Override
    public void spend(int amount) {
        if (hasFunds(amount)) {
            balance -= amount;
        } else {
            throw new RuntimeException("Insufficient funds on member card.");
        }
    }

    @Override
    public boolean hasFunds(int amount) {
        return balance >= amount;
    }  

    public void addToBalance(int amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            throw new RuntimeException("Cannot add negative amount to member card.");
        }
    }
}
