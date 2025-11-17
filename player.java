public class player {      // ← class declaration starts here
    private String name;
    private boolean isAlive = true;
    private double balance;

    // constructor
    public player(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() { return name; }
    public boolean isAlive() { return isAlive; }
    public void setAlive(boolean status) { isAlive = status; }
    public double getBal() { return balance; }
    public void addBalance(double amount) { balance += amount; }
    public void subtractBalance(double amount) { balance -= amount; }
}  // ← class ends here
