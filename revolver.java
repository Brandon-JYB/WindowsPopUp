import java.util.Random;

public class revolver extends gun { 
    public revolver() { 
        totCham = 6;
    }

    @Override
    public void load() { 
        bullPos = new Random().nextInt(totCham);
        System.out.println("Revolver loaded.");
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
        return "Revolver";
    }

    @Override
    public double rewardMult(int bullets) { 
        return 1.5 * bullets;
    }
}
