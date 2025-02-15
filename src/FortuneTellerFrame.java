import javax.swing.*;
import java.awt.*;

public class FortuneTellerFrame extends JFrame {

    JPanel mainPnl, titlePnl, displayPnl, buttonPnl;
    JButton fortuneBtn, exitBtn;
    ImageIcon icon;
    JLabel titlelbl;
    JTextArea textArea;
    JScrollPane scrollPane;

    public FortuneTellerFrame() {

        mainPnl = new JPanel();
        mainPnl.setLayout(new BorderLayout());
        createTitlePanel();

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
        titlelbl = new JLabel(icon);
        titlelbl.setText("Fortune Teller");
        titlePnl.add(titlelbl);
        titlelbl.setHorizontalTextPosition(JLabel.CENTER);
        titlelbl.setVerticalTextPosition(JLabel.BOTTOM);
        mainPnl.add(titlePnl, BorderLayout.NORTH);
    }
    public void createDisplayPanel() {

        textArea = new JTextArea();
    }

    public void createButtonPanel() {

        exitBtn = new JButton("Exit");
        fortuneBtn = new JButton("Get a new Fortune");
        mainPnl.add(exitBtn, BorderLayout.SOUTH);
        mainPnl.add(fortuneBtn, BorderLayout.SOUTH);
    }

}