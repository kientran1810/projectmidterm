package haiquanid;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JRadioButton exportRadioButton;
    private JRadioButton importRadioButton;
    private JButton logInButton;
    private JLabel Username;
    private JPanel pn;
    private JLabel Password;

    public MainMenu() {
        setContentPane(pn);
        // Set the window title.
        setTitle("Import&Export Tool");


        // Specify what happens when the close button is clicked.
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Build the panel and add it to the frame.
        setSize(400, 300);

        // Display the window.
        setVisible(true);
        logInButton.addActionListener(new LoginListener());
    }
    /**
     The buildPanel method adds a label, text field, and a button to a panel.
     */
    private class LoginListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e){
            if(importRadioButton.isSelected()){
                setVisible(false);
               MyUI1 nhapkhau= new MyUI1();
               nhapkhau.setVisible(true);
            }
            else if(exportRadioButton.isSelected()){
                setVisible(false);
                MyUI2 xuatkhau= new MyUI2();
                xuatkhau.setVisible(true);
            }
        }
    }

}

