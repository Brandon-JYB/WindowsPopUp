import java.util.Random;

public class doubleBarrel extends gun {  // <- class declaration must be here
    public doubleBarrel() {  // constructor
        totCham = 2;
    }

    @Override
    public void load() {
        bullPos = new Random().nextInt(totCham);
        System.out.println("\nDouble Barrel Shotgun loaded.");
    }

    @Override
    public boolean fire(int bullets) {
        Random rand = new Random();
        boolean[] chamber = new boolean[totCham];
        int bulletsChambed = 0;

        while (bulletsChambed < bullets) {
            int pos = rand.nextInt(totCham);
            if (!chamber[pos]) {
                chamber[pos] = true;
                bulletsChambed++;
            }
        }

        int firePos = rand.nextInt(totCham);
        return chamber[firePos];
    }

    @Override
    public String getGunName() {
        return "Double Barrel Shotgun";
    }

    @Override
    public double rewardMult(int bullets) {
        return 3.5 * bullets;
    }
}
