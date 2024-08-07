import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//ISD-12 Zhylyk Anna
public class CalculatorFrame extends JFrame{
    JButton butCalc, butClear, butExit;
    JTextField textFieldres1, textFieldres2, textField1, textField2, textField3;
    double num1, num2, num3, root1, root2;
    Font font = new Font("Tahoma",Font.BOLD,17);
    public CalculatorFrame(){
        this.setTitle("Square root calculator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,230);
        this.setResizable(false);

        //Add panels
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();

        //Panel characteristics
        panel1.setBackground(new Color(167, 211, 227, 255));
        panel2.setBackground(new Color(138, 73, 197, 255));
        panel3.setBackground(new Color(138, 73, 197, 255));
        panel4.setBackground(new Color(138, 73, 197, 255));
        panel5.setBackground(new Color(138, 73, 197, 255));


        //Panel position
        this.add(panel1, BorderLayout.CENTER);
        this.add(panel2, BorderLayout.SOUTH);
        this.add(panel3, BorderLayout.WEST);
        this.add(panel4, BorderLayout.EAST);
        this.add(panel5, BorderLayout.NORTH);

        //Add text
        JLabel label1 = new JLabel();
        label1.setText(" X^2 + ");
        label1.setFont(font);

        JLabel label2 = new JLabel();
        label2.setText(" X + ");
        label2.setFont(font);

        JLabel label3 = new JLabel();
        label3.setText(" = 0 ");
        label3.setFont(font);

        JLabel label4 = new JLabel();
        label4.setText(" Root 1 : ");
        label4.setFont(font);

        JLabel label5 = new JLabel();
        label5.setText(" Root 2 : ");
        label5.setFont(font);

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

        textFieldres1 = new JTextField();
        textFieldres1.setFocusable(false);
        textFieldres1.setPreferredSize(new Dimension(80,30));
        textFieldres1.setFont(font);
        textFieldres1.setForeground(new Color(12, 28, 65));

        textFieldres2= new JTextField();
        textFieldres2.setFocusable(false);
        textFieldres2.setPreferredSize(new Dimension(80,30));
        textFieldres2.setFont(font);
        textFieldres2.setForeground(new Color(12, 28, 65));

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
        panel1.add(Box.createRigidArea(new Dimension(10,10)));
        panel1.add(textField1);
        panel1.add(label1);
        panel1.add(textField2);
        panel1.add(label2);
        panel1.add(textField3);
        panel1.add(label3);
        panel1.add(Box.createRigidArea(new Dimension(50,50)));
        panel1.add(label4);
        panel1.add(textFieldres1);
        panel1.add(label5);
        panel1.add(textFieldres2);
        panel1.add(Box.createRigidArea(new Dimension(50,50)));
        panel1.add(butCalc);
        panel1.add(butClear);
        panel1.add(Box.createRigidArea(new Dimension(80,80)));
        panel1.add(butExit);

        //View all
        this.setVisible(true);
    }
    //Add button interaction
    public class CalculateBut implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                num1 = Double.parseDouble(textField1.getText());
                num2 = Double.parseDouble(textField2.getText());
                num3 = Double.parseDouble(textField3.getText());

                double ds = (num2 * num2) - (4 * num1 * num3);

                root1 = (-num2 + Math.sqrt(ds)) / (2 * num1);
                root2 = (-num2 - Math.sqrt(ds)) / (2 * num1);
            }catch (NumberFormatException error){
                JOptionPane.showMessageDialog(CalculatorFrame.this, "Cannot use this symbols, please enter all numbers.", "Invalid symbol", JOptionPane.ERROR_MESSAGE);
            }
            textField1.setEditable(false);
            textField2.setEditable(false);
            textField3.setEditable(false);

            textFieldres1.setText(String.valueOf(root1));
            textFieldres2.setText(String.valueOf(root2));
        }
    }
    public class ClearBut implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            textFieldres1.setText("");
            textFieldres2.setText("");
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
