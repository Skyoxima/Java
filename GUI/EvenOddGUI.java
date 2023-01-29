//~ A simple Java Swing program to make a GUI-List-Odd-Even filterer.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class EveOddUI extends JFrame implements ActionListener {
  Container c;
  JPanel mainPanel, inputPanel, buttonPanel;
  JLabel inputLabel;
  JTextField inputTxt, outputTxt;
  JButton eves, odds;
  
  public EveOddUI() {
    this.setTitle("Even Odd List Filterer");
    c = getContentPane();
    mainPanel = new JPanel();
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

    inputPanel = new JPanel(new FlowLayout());
    inputLabel = new JLabel("List of Numbers: ");
    inputTxt = new JTextField();
    inputTxt.setColumns(12);

    inputPanel.add(inputLabel);
    inputPanel.add(inputTxt);
    mainPanel.add(inputPanel);

    outputTxt = new JTextField();
    outputTxt.setColumns(12);
    mainPanel.add(outputTxt);

    buttonPanel = new JPanel();
    buttonPanel.setLayout(new FlowLayout());
    eves = new JButton("Eve Nos.");
    odds = new JButton("Odd Nos.");
    buttonPanel.add(eves);
    buttonPanel.add(odds);
    mainPanel.add(buttonPanel);
    c.add(mainPanel);

    eves.addActionListener(this);
    odds.addActionListener(this);
  }

  public void actionPerformed(ActionEvent ae) {
    String[] inputStringArr = inputTxt.getText().split(" ");
    String opString = "";

    if(ae.getSource() == eves) {
      for(int i = 0; i < inputStringArr.length; i++) {
        if(Integer.parseInt(inputStringArr[i]) % 2 == 0)
          opString += (inputStringArr[i] + " ");
      }
      outputTxt.setText(opString);
    } else if(ae.getSource() == odds) {
      for(int i = 0; i < inputStringArr.length; i++) {
        if(Integer.parseInt(inputStringArr[i]) % 2 != 0)
          opString += (inputStringArr[i] + " ");
      }
      outputTxt.setText(opString);
    }
  }
}


class EvenOddGUI {
  public static void main(String[] args) {
    EveOddUI e = new EveOddUI();
    e.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    e.setBounds(100, 100, 400, 300);
    e.setVisible(true);
  }
}
