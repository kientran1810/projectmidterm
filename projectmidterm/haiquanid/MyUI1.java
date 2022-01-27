package haiquanid;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MyUI1 extends JFrame{

    public MyUI1()

    {

        setTitle("Import&Export Tool");

        doAddSomeControl();

    }

    public void doAddSomeControl()

    {

        JPanel pn=new JPanel();

        JLabel lbl1=new JLabel("Hello I'm Import. And you?");

        JTextField txt1=new JTextField(15);

        JButton btn1=new JButton("Next");
        pn.add(lbl1);

        pn.add(txt1);

        pn.add(btn1);
        btn1.addActionListener(new btn1Listener());

        Container con=getContentPane();

        con.add(pn);

        setSize(300, 200);

        setLocationRelativeTo(null);

    }
    private class btn1Listener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            new IMPORT();
        }
    }

}