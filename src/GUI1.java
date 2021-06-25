import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class GUI1 extends JFrame implements ChangeListener {

    private List<JSlider> sliderList;
    private List<JLabel> sliderLabels;

    private JPanel square1;
    private JPanel squareInside;
    private JPanel square2;
    private JPanel smallerSquare;
    private JLabel label;
    private JPanel textPanel;

    public GUI1() {
        this.setTitle("GUI projekt 2 - zadanie 1");
        this.setResizable(false);
        this.setSize(500, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        ImageIcon img = new ImageIcon("data/color_wheel.png");
        this.setIconImage(img.getImage());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.getContentPane().add(mainPanel);
        int valueMin = 0;
        int valueMax = 255;
        int valueInit = 127;
        sliderList = Arrays.asList(
                new JSlider(JSlider.VERTICAL, valueMin, valueMax, valueInit),
                new JSlider(JSlider.VERTICAL, valueMin, valueMax, valueInit),
                new JSlider(JSlider.VERTICAL, valueMin, valueMax, valueInit),
                new JSlider(JSlider.VERTICAL, valueMin, valueMax, valueInit),
                new JSlider(JSlider.VERTICAL, valueMin, valueMax, valueInit),
                new JSlider(JSlider.VERTICAL, valueMin, valueMax, valueInit)
        );

        JPanel slidersPanel = new JPanel();
        slidersPanel.setLayout(new GridBagLayout());
        GridBagConstraints b = new GridBagConstraints();
        slidersPanel.setBorder(BorderFactory.createEmptyBorder(10, 5, 5, 20));

        textPanel = new JPanel();
        textPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        label = new JLabel("GUI - Projekt II, zadanie 1, s22154");
        textPanel.setBackground(Color.GRAY);
        textPanel.setOpaque(true);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        textPanel.add(label);
        c.gridx = 1;
        c.gridy = -2;
        mainPanel.add(textPanel, c);

        square1 = new JPanel();
        square1.setLayout(new BorderLayout());
        square1.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        square1.setBackground(Color.GRAY);
        square1.setOpaque(true);

        squareInside = new JPanel();
        squareInside.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        squareInside.setBackground(Color.GRAY);
        squareInside.setOpaque(true);
        square1.add(squareInside, BorderLayout.CENTER);

        square2 = new JPanel();
        square2.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        square2.setBackground(Color.GRAY);
        square2.setOpaque(true);

        smallerSquare = new JPanel();
        smallerSquare.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        smallerSquare.setBackground(Color.GREEN);
        smallerSquare.setOpaque(true);
        square2.add(smallerSquare, BorderLayout.PAGE_START);
        square2.add(smallerSquare, BorderLayout.LINE_END);


        c.gridx = 0;
        c.gridy = 0;
        mainPanel.add(square1, c);
        c.gridy = -1;
        mainPanel.add(square2, c);

        sliderLabels = Arrays.asList(
                new JLabel(),
                new JLabel(),
                new JLabel(),
                new JLabel(),
                new JLabel(),
                new JLabel()
        );
        for (int i = 0; i < sliderList.size(); i++){
            sliderList.get(i).setMajorTickSpacing(85);
            sliderList.get(i).setMinorTickSpacing(17);
            sliderList.get(i).setPaintTicks(true);
            sliderList.get(i).setPaintLabels(true);
            if (i == 0 || i == 3)
                sliderLabels.get(i).setText("R: " + sliderList.get(i).getValue());
            else if (i == 1 || i == 4)
                sliderLabels.get(i).setText("G: " + sliderList.get(i).getValue());
            else
                sliderLabels.get(i).setText("B: " + sliderList.get(i).getValue());
            sliderList.get(i).addChangeListener(this);
            b.gridx = i;
            b.gridy = 0;
            slidersPanel.add(sliderList.get(i), b);
            b.gridx = i;
            b.gridy = -1;
            slidersPanel.add(sliderLabels.get(i), b);
        }
        c.gridx = 1;
        c.gridy = 0;
        mainPanel.add(slidersPanel, c);

        this.repaint();
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        for (int i = 0; i < sliderLabels.size(); i++){
            if (i == 0 || i == 3)
                sliderLabels.get(i).setText("R: " + sliderList.get(i).getValue());
            else if (i == 1 || i == 4)
                sliderLabels.get(i).setText("G: " + sliderList.get(i).getValue());
            else
                sliderLabels.get(i).setText("B: " + sliderList.get(i).getValue());
        }
        int r1 = sliderList.get(0).getValue();
        int g1 = sliderList.get(1).getValue();
        int b1 = sliderList.get(2).getValue();
        int r2 = sliderList.get(3).getValue();
        int g2 = sliderList.get(4).getValue();
        int b2 = sliderList.get(5).getValue();
        square1.setBackground(new Color(r1, g1, b1));
        label.setForeground(new Color(r1, g1, b1));
        squareInside.setBackground(new Color(r2, g2, b2));
        textPanel.setBackground(new Color(r2, g2, b2));
        square2.setBackground(new Color(r2, g2, b2));
        smallerSquare.setBackground(new Color(r1, g1, b1));
    }
}
