import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//ISD-12 Zhylyk Anna
public class GeometrProgressionFrame extends JFrame{
    JButton butCalc, butClear, butExit;
    JTextField textField1, textField2, textField3;
    JTextArea resultArea;
    double n, x, k, result;
    Font font = new Font("Tahoma",Font.BOLD,17);

    public GeometrProgressionFrame() {
        this.setTitle("Geometric progression calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(620, 520);
        this.setLayout(null);
        this.setResizable(false);

        //Add panels
        JPanel panelLeft = new JPanel();
        panelLeft.setBackground(new Color(167, 211, 227, 255));
        panelLeft.setBounds(0,0,300,600);
        this.add(panelLeft);

        JPanel panelRight = new JPanel();
        panelRight.setBackground(new Color(167, 211, 227, 255));
        panelRight.setBounds(280,0,330,600);
        this.add(panelRight);

        //Add text
        JLabel label1 = new JLabel();
        label1.setText(" First Number: ");
        label1.setFont(font);

        JLabel label2 = new JLabel();
        label2.setText(" Common Ratio: ");
        label2.setFont(font);

        JLabel label3 = new JLabel();
        label3.setText(" Number of Terms: ");
        label3.setFont(font);

        //Add text field
        textField1 = new JTextField();
        textField1.setFocusable(true);
        textField1.setPreferredSize(new Dimension(80,30));
        textField1.setFont(font);
        textField1.setForeground(new Color(12, 28, 65));

        textField2 = new JTextField();
        textField2.setFocusable(true);
        textField2.setPreferredSize(new Dimension(80,30));
        textField2.setFont(font);
        textField2.setForeground(new Color(12, 28, 65));

        textField3 = new JTextField();
        textField3.setFocusable(true);
        textField3.setPreferredSize(new Dimension(80,30));
        textField3.setFont(font);
        textField3.setForeground(new Color(12, 28, 65));

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setPreferredSize(new Dimension(300,400));
        resultArea.setFont(font);
        resultArea.setForeground(new Color(12, 28, 65));
        resultArea.setBounds(800,10000,300,400);

        //Add button
        butCalc = new JButton("Calculate");
        butCalc.setFocusable(false);
        butCalc.setPreferredSize(new Dimension(130,30));
        butCalc.setFont(font);
        butCalc.setForeground(new Color(12, 28, 65));

        butClear = new JButton("Clear");
        butClear.setFocusable(false);
        butClear.setPreferredSize(new Dimension(80,30));
        butClear.setFont(font);
        butClear.setForeground(new Color(12, 28, 65));

        butExit = new JButton("Exit");
        butExit.setFocusable(false);
        butExit.setPreferredSize(new Dimension(80,30));
        butExit.setFont(font);
        butExit.setForeground(new Color(12, 28, 65));

        // Add button listener
        butCalc.addActionListener(new CalculateBut());
        butClear.addActionListener(new ClearBut());
        butExit.addActionListener(new ExitBut());

        //View components
        panelLeft.add(Box.createRigidArea(new Dimension(0,100)));
        panelLeft.add(label1);
        panelLeft.add(textField1);
        panelLeft.add(label2);
        panelLeft.add(textField2);
        panelLeft.add(label3);
        panelLeft.add(textField3);
        panelLeft.add(Box.createRigidArea(new Dimension(10,100)));
        panelLeft.add(butCalc);
        panelLeft.add(Box.createRigidArea(new Dimension(100,0)));
        panelLeft.add(butClear);
        panelLeft.add(Box.createRigidArea(new Dimension(150,100)));
        panelLeft.add(butExit);
        panelLeft.add(Box.createRigidArea(new Dimension(0,100)));
        panelRight.add(Box.createRigidArea(new Dimension(100,30)));
        panelRight.add(resultArea);

        //View all
        this.setVisible(true);
    }
    public class CalculateBut implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double firstNumber = Double.parseDouble(textField1.getText());
                double commonRatio = Double.parseDouble(textField2.getText());
                int numberOfTerms = Integer.parseInt(textField3.getText());

                resultArea.setText("n\tX\n");
                for (int i = 1; i <= numberOfTerms; i++) {
                    int term = (int) (Math.pow(commonRatio, firstNumber));
                    resultArea.append((int)firstNumber + "\t" + term + "\n");
                    firstNumber ++;
                }
            } catch (NumberFormatException error) {
                JOptionPane.showMessageDialog(GeometrProgressionFrame.this,
                        "Invalid input. Please enter valid numbers.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            textField1.setEditable(false);
            textField2.setEditable(false);
            textField3.setEditable(false);
        }
    }
    public class ClearBut implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            resultArea.setText("");
            textField1.setText("");
            textField2.setText("");
            textField3.setText("");

            textField1.setEditable(true);
            textField2.setEditable(true);
            textField3.setEditable(true);
        }
    }
    public class ExitBut implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
}
