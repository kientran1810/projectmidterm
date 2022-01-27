package haiquanid;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MyUI2 extends JFrame{


    public MyUI2()

    {

        setTitle("Import&Export Tool");

        doAddSomeControl();

    }

    public void doAddSomeControl()

    {

        JPanel pn=new JPanel();

        JLabel lbl1=new JLabel("Hi, I'm Export. And you?");

        JTextField txt1=new JTextField(15);

        JButton btn=new JButton("Next");
        pn.add(lbl1);

        pn.add(txt1);

        pn.add(btn);
        btn.addActionListener(new MyUI2.btnListener());

        Container con=getContentPane();

        con.add(pn);

        setSize(300, 200);

        setLocationRelativeTo(null);

    }
    private class btnListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            new IMPORT();
        }
}
}