package haiquanid;

import javax.swing.*;

public class IMPORT extends JFrame {
  public IMPORT(){
    setSize(300, 400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    MainManagerUI openFile = new MainManagerUI("HE THONG QUAN NHAP KHAU");
    openFile.doShow();
  }

}