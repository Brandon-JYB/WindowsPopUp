import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GuiRoulette {

    private player player;
    private gun currentGun;
    private JFrame frame;
    private JLabel messageLabel;
    private JTextField betField, bulletField;
    private JComboBox<String> gunSelector;

    public GuiRoulette() {
        player = new player("Player", 1000.0);
        frame = new JFrame("Riskless Roulette");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(6, 1));

        messageLabel = new JLabel("Balance: ₱" + player.getBal(), JLabel.CENTER);
        frame.add(messageLabel);

        String[] guns = {"Desert Eagle", "Revolver", "Pepperbox Pistol", "Double Barrel Shotgun"};
        gunSelector = new JComboBox<>(guns);
        frame.add(gunSelector);

        betField = new JTextField("Enter bet");
        frame.add(betField);

        bulletField = new JTextField("Enter bullets");
        frame.add(bulletField);

        JButton fireButton = new JButton("Pull Trigger");
        frame.add(fireButton);

        fireButton.addActionListener(e -> playRound());

        frame.setVisible(true);
    }

    private void playRound() {
        int gunChoice = gunSelector.getSelectedIndex() + 1;

        switch (gunChoice) {
            case 1: currentGun = new desertEagle(); break;
            case 2: currentGun = new revolver(); break;
            case 3: currentGun = new pepperBox(); break;
            case 4: currentGun = new doubleBarrel(); break;
        }

        double bet;
        int bullets;
        try {
            bet = Double.parseDouble(betField.getText());
            bullets = Integer.parseInt(bulletField.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid number input!");
            return;
        }

        if (bet > player.getBal() || bet <= 0) {
            JOptionPane.showMessageDialog(frame, "Invalid bet amount!");
            return;
        }
        if (bullets <= 0 || bullets > currentGun.getTotCham()) {
            JOptionPane.showMessageDialog(frame, "Invalid bullet count!");
            return;
        }

        currentGun.load();

        if (gunChoice == 1 || currentGun.fire(bullets)) {
            messageLabel.setText("Bang! You died.");
            player.subtractBalance(player.getBal());
            player.setAlive(false);
        } else {
            double winnings = bet * currentGun.rewardMult(bullets);
            player.addBalance(winnings);
            messageLabel.setText("Click! You live. Winnings: ₱" + winnings + " | Balance: ₱" + player.getBal());
        }

        if (player.getBal() <= 0) {
            messageLabel.setText("You ran out of money. Game over!");
        }
    }

    public static void main(String[] args) {
        new GuiRoulette();
    }
}
