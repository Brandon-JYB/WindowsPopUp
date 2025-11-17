import java.util.Random;

public class pepperBox extends gun { // Pepperbox Pistol
    public pepperBox() { 
        totCham = 4; // total chambers
    }

    @Override
    public void load() { 
        bullPos = new Random().nextInt(totCham);
        System.out.println("Pepperbox loaded.");
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
        return "Pepperbox Pistol";
    }

    @Override
    public double rewardMult(int bullets) { 
        return 2.5 * bullets;
    }
}
