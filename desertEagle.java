import java.util.Random;

public class desertEagle extends gun {
    public desertEagle() {  
        totCham = 9;
    }

    @Override
    public void load() { 
        bullPos = 0;
        System.out.println("Desert Eagle loaded.");
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
        return "Desert Eagle";
    }

    @Override
    public double rewardMult(int bullets) { 
        return 5.0;
    }
}
