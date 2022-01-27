package haiquanid;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame{
    private JLabel tenGD;
    private JComboBox chonTinh;
    private JLabel dienMaHaiQuan;
    private JTextField dienMa;
    private JButton dangNhap;
    private JButton thoat;
    private JPanel giaoDienChinh;

    public Main() {
        setContentPane(giaoDienChinh);
        setTitle("Cục Hải Quan");
        setSize(300,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        dangNhap.addActionListener(new DangNhapListener());
        thoat.addActionListener(new ThoatListener());
    }
    private class DangNhapListener implements ActionListener {
        @Override
            public void actionPerformed(ActionEvent e) {
            setVisible(false);
                String id = dienMa.getText();
                String selectedValue = (String) chonTinh.getSelectedItem();
                if (!id.contentEquals("C27F") && selectedValue == "Thanh Hóa") {
                    JOptionPane.showMessageDialog(null, "Mã không hợp lệ","Invalid!",JOptionPane.ERROR_MESSAGE);
                }
                else if (!id.contentEquals("A01B") && selectedValue == "Hà Nội") {
                    JOptionPane.showMessageDialog(null, "Mã không hợp lệ","Invalid!",JOptionPane.ERROR_MESSAGE);
                }
                else if (!id.contentEquals("B29B") && selectedValue == "Nghệ An") {
                    JOptionPane.showMessageDialog(null, "Mã không hợp lệ","Invalid!",JOptionPane.ERROR_MESSAGE);
                }
                else if (!id.contentEquals("A02B") && selectedValue == "Hồ Chí Minh") {
                    JOptionPane.showMessageDialog(null, "Mã không hợp lệ","Invalid!",JOptionPane.ERROR_MESSAGE);
                }else{
                    new MainMenu();
                }
            }

    }


    private class ThoatListener implements ActionListener {
        @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }

    }


    public static void main(String[] args) {
        new Main();
    }
}
