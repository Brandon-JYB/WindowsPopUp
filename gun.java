public abstract class gun {
    protected int totCham;
    protected int bullPos;

    public int getTotCham() { return totCham; }
    public abstract void load();
    public abstract boolean fire(int bullets);
    public abstract String getGunName();
    public abstract double rewardMult(int bullets);
}
