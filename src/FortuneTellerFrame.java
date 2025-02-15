import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {

    JPanel mainPnl, titlePnl, displayPnl, buttonPnl;
    JButton fortuneBtn, exitBtn;
    ImageIcon icon;
    JLabel titleLbl;
    JTextArea fortuneTA;
    JScrollPane scrollPanel;

    public FortuneTellerFrame() {

        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());
        createTitlePanel();
        createDisplayPanel();
        createButtonPanel();

        add(mainPnl);
        setTitle("Fortune Teller");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void createTitlePanel () {
        titlePnl = new JPanel();
        icon = new ImageIcon("src/FortuneTeller.jpg");
        titleLbl = new JLabel(icon);
        titleLbl.setText("Fortune Teller");
        titleLbl.setFont(new Font("Serif", Font.BOLD, 20));
        titlePnl.add(titleLbl);
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);
        titleLbl.setVerticalTextPosition(JLabel.BOTTOM);
        mainPnl.add(titlePnl, BorderLayout.NORTH);
    }

    public void createDisplayPanel() {

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        displayPnl = new JPanel();
        fortuneTA = new JTextArea(10, 25);

        fortuneTA.setEditable(false);
        scrollPanel = new JScrollPane(fortuneTA);
        fortuneTA.setFont(new Font("Sans-Serif", Font.PLAIN, 12));
        fortuneTA.setSize(screenWidth / 4, screenHeight / 2);
        displayPnl.add(scrollPanel);
        mainPnl.add(displayPnl, BorderLayout.CENTER);
    }

    public void createButtonPanel() {


        Random rand = new Random();

        buttonPnl = new JPanel();
        buttonPnl.setLayout(new GridLayout (1, 2));

        exitBtn = new JButton("Exit");
        exitBtn.setFont(new Font("Sans-Serif", Font.PLAIN, 16));
        fortuneBtn = new JButton("Get a new Fortune");
        fortuneBtn.setFont(new Font("Sans-Serif", Font.PLAIN, 16));

        fortuneBtn.addActionListener((ActionEvent ae) -> {
            String currentFortune = "";
            String newFortune = "";

            do {

                newFortune = getFortune(rand.nextInt(0, 12));
            } while (currentFortune == newFortune);
            currentFortune = newFortune;
            fortuneTA.append(currentFortune + "\n");
        });
        exitBtn.addActionListener((ActionEvent ae) -> System.exit(0));

        buttonPnl.add(fortuneBtn);
        buttonPnl.add(exitBtn);

        mainPnl.add(buttonPnl, BorderLayout.SOUTH);
    }

    public String getFortune(int fortuneIndex) {

        String[] fortunes = new String[12];
        fortunes[0] = "Do you wanna have a bad time?";
        fortunes[1] = "You are really not going to like what happens next.";
        fortunes[2] = "It's a beautiful day outside.";
        fortunes[3] = "I'm going to Grillby's. Papyrus, do you want anything.";
        fortunes[4] = "The british are coming.";
        fortunes[5] = "Los ingleses estan viniendo.";
        fortunes[6] = "Les britanniques arrivent.";
        fortunes[7] = "The calamity is here.";
        fortunes[8] = "La calamidad está aquí.";
        fortunes[9] = "災難がここにある.";
        fortunes[10] = "You will have a good day today.";
        fortunes[11] = "Good things will happen.";

        return fortunes[fortuneIndex];
    }
}