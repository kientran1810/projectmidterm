package haiquanid;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class MainManagerUI extends JFrame {
    private static final long serialVersionUID = 1L;
    private static JList lstCate;
    private JTable tblProduct;
    private DefaultTableModel dtmProduct;
    private JButton btnCateRemove,btnCateNew,btnCateUpdate,btnNew,btnSave,btnRemove;
    private JTextField txtId,txtName,txtUnitprice,txtQuality, txtDE, txtOG, txtTax;
    private JTextArea txtDescription;
    private static JComboBox cboCateList;
    JMenuBar menubar;
    JMenu mnuFile;
    JMenuItem mnuFileOpenDataFromDisk,mnuFileWritetodisk,mnuFileExit;
    public static ListCategory listData;
    public static Category selectedCate;

    public MainManagerUI(String title)
    {
        super(title);
        listData=new ListCategory();
    }

    public void doShow()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1450, 850);
        addControl();
        setLocationRelativeTo(null);
        setVisible(true);
    }

// T???o menubar cho ph??p ng?????i d??ng l??u v?? m??? c??c file ch???a th??ng tin h??ng h??a nh???p kh???u
    public void addMenu()
    {
        menubar=new JMenuBar();
        mnuFile=new JMenu("File");
        mnuFileWritetodisk=new JMenuItem("Save Data ");
        mnuFileOpenDataFromDisk=new JMenuItem("Open Data ");
        mnuFileExit =new JMenuItem("Exit");

        menubar.add(mnuFile);
        mnuFile.add(mnuFileWritetodisk);
        mnuFile.add(mnuFileOpenDataFromDisk);
        mnuFile.addSeparator();
        mnuFile.add(mnuFileExit);
        setJMenuBar(menubar);
    }

    public void addControl()
    {
// th??m manubar
        addMenu();

// T???o b???ng v?? ti??u ????? cho b???ng
        JPanel pnBorder=new JPanel();
        pnBorder.setLayout(new BorderLayout());
        JPanel pnNorth=new JPanel();
        JLabel lblTitle=new JLabel("HO???T ?????NG NH???P KH???U");
        Font ftTitle=new Font("Futura", Font.BOLD, 28);
        lblTitle.setFont(ftTitle);
        lblTitle.setForeground(new Color(0,51,102));
        pnNorth.add(lblTitle);
        pnBorder.add(pnNorth,BorderLayout.NORTH);

// T???o b???ng cho ph??p ng?????i d??ng th??m nh??m h??ng h??a
        JPanel pnListCate=new JPanel();
        JPanel pnListProduct=new JPanel();
        JSplitPane slitPane=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnListCate, pnListProduct);
        pnBorder.add(slitPane,BorderLayout.CENTER);
        pnListCate.setLayout(new BorderLayout());
        lstCate=new JList();
        TitledBorder cateborder=new TitledBorder(BorderFactory.createLineBorder(Color.RED), "Lo???i H??ng H??a");
        lstCate.setBorder(cateborder);
        pnListCate.setPreferredSize(new Dimension(300, 0));
        pnListCate.add(lstCate,BorderLayout.CENTER);
        JPanel pnListCateSouth=new JPanel();
        btnCateNew =new JButton("New");
        pnListCateSouth.add(btnCateNew);
        btnCateUpdate =new JButton("Update");
        pnListCateSouth.add(btnCateUpdate);
        btnCateRemove =new JButton("Remove");
        pnListCateSouth.add(btnCateRemove);
        pnListCate.add(pnListCateSouth,BorderLayout.SOUTH);
        pnListProduct.setLayout(new BorderLayout());

// ?????t t??n v?? t???o b???ng ch??? th??ng tin chi ti???t c??c lo???i h??ng h??a
        JPanel pnProductTitle=new JPanel();
        JLabel lblProductTitle=new JLabel("Th??ng tin chi ti???t");
        pnProductTitle.add(lblProductTitle);
        pnListProduct.add(pnProductTitle,BorderLayout.NORTH);

        JPanel pnProductTable=new JPanel();
        pnProductTable.setLayout(new BorderLayout());
        pnListProduct.add(pnProductTable,BorderLayout.CENTER);

        dtmProduct =new DefaultTableModel();
        dtmProduct.addColumn("M?? s??? h??ng ");
        dtmProduct.addColumn("T??n h??ng h??a");
        dtmProduct.addColumn("????n gi??");
        dtmProduct.addColumn("S??? l?????ng");
        dtmProduct.addColumn("Ng??y nh???p ");
        dtmProduct.addColumn("Xu???t x???");
        dtmProduct.addColumn("Thu??? nh???p kh???u");
        dtmProduct.addColumn("M?? t???");

        tblProduct=new JTable(dtmProduct);
        JScrollPane sctblproduct=new JScrollPane(tblProduct );
        pnProductTable.add(sctblproduct,BorderLayout.CENTER);

// T???o b???ng cho ng?????i d??ng nh???p d??? li???u h??ng h??a theo t???ng lo???i h??ng
        JPanel pnProductDetail=new JPanel();
        pnListProduct.add(pnProductDetail,BorderLayout.SOUTH);
        pnProductDetail.setLayout(new BoxLayout(pnProductDetail, BoxLayout.Y_AXIS ));

        JPanel pnCateList = new JPanel();
        JLabel lblCateId = new JLabel("Lo???i h??ng :");
        cboCateList = new JComboBox();
        pnCateList.add(lblCateId);
        pnCateList.add(cboCateList);
        pnProductDetail.add(pnCateList);
        cboCateList.setEditable(false);

        JPanel pnProductId = new JPanel();
        JLabel lblProId = new JLabel("M?? s??? h??ng :");
        txtId=new JTextField(20);
        pnProductId.add(lblProId);
        pnProductId.add(txtId);
        pnProductDetail.add(pnProductId);

        JPanel pnProductName = new JPanel();
        JLabel lblProName=new JLabel("T??n h??ng h??a :");
        txtName=new JTextField(20);
        pnProductName.add(lblProName);
        pnProductName.add(txtName);
        pnProductDetail.add(pnProductName);

        JPanel pnProductUnitPrice = new JPanel();
        JLabel lblUnitPrice=new JLabel("????n gi?? :");
        txtUnitprice=new JTextField(20);
        pnProductUnitPrice.add(lblUnitPrice);
        pnProductUnitPrice.add(txtUnitprice);
        pnProductDetail.add(pnProductUnitPrice);

        JPanel pnQuality = new JPanel();
        JLabel lblQuality=new JLabel("S??? l?????ng :");
        txtQuality = new JTextField(20);
        pnQuality.add(lblQuality);
        pnQuality.add(txtQuality);
        pnProductDetail.add(pnQuality);

        JPanel pnDateImport = new JPanel();
        JLabel lblDE = new JLabel("Ng??y nh???p :");
        txtDE = new JTextField(20);
        pnDateImport.add(lblDE);
        pnDateImport.add(txtDE);
        pnProductDetail.add(pnDateImport);
    
        JPanel pnOriginal = new JPanel();
        JLabel lblOG = new JLabel("Xu???t x??? :");
        txtOG = new JTextField(20);
        pnOriginal.add(lblOG);
        pnOriginal.add(txtOG);
        pnProductDetail.add(pnOriginal);

        JPanel pnTax = new JPanel();
        JLabel lblTax = new JLabel("H??? S??? Thu???(%):");
        txtTax = new JTextField(20);
        pnTax.add(lblTax);
        pnTax.add(txtTax);
        pnProductDetail.add(pnTax);

        JPanel pnProductDescription = new JPanel();
        JLabel lblDescription=new JLabel("M?? t??? :");
        txtDescription=new JTextArea(3, 20);
        JScrollPane scare = new JScrollPane(txtDescription);
        pnProductDescription.add(lblDescription);
        pnProductDescription.add(scare);
        pnProductDetail.add(pnProductDescription);

// T???o 3 ph??m ch???c n??ng
        JPanel pnButton = new JPanel();
        btnNew=new JButton("New");
        btnSave=new JButton("Save");
        btnRemove=new JButton("Remove");
        pnButton.add(btnNew);
        pnButton.add(btnSave);
        pnButton.add(btnRemove);
        pnProductDetail.add(pnButton);

// Set up c??c text feild th???ng h??ng
        cboCateList.setPreferredSize(txtId.getPreferredSize());
        lblCateId.setPreferredSize(lblProName.getPreferredSize());
        lblDescription.setPreferredSize(lblProName.getPreferredSize());
        lblDE.setPreferredSize(lblProName.getPreferredSize());
        lblQuality.setPreferredSize(lblProName.getPreferredSize());
        lblUnitPrice.setPreferredSize(lblProName.getPreferredSize());
        lblProId.setPreferredSize(lblProName.getPreferredSize());
        lblTax.setPreferredSize(lblProName.getPreferredSize());
        lblOG.setPreferredSize(lblProName.getPreferredSize());


        Container con = getContentPane();
        con.add(pnBorder);
        btnCateNew.addActionListener(new processButtonEvent());
        btnNew.addActionListener(new processButtonEvent());
        btnSave.addActionListener(new processButtonEvent());
        btnRemove.addActionListener(new processButtonEvent());
        cboCateList.addActionListener(new processButtonEvent());
        mnuFileWritetodisk.addActionListener(new processButtonEvent());
        mnuFileOpenDataFromDisk.addActionListener(new processButtonEvent());
        lstCate.addListSelectionListener(new ListSelectionListener() 
        {
            public void valueChanged(ListSelectionEvent arg0) 
            {
                selectedCate=(Category) lstCate.getSelectedValue();
                showListProductIntoTable();
            }
        });
    }

    private void showListProductIntoTable()
    {
        dtmProduct.setRowCount(0);
        for(Product p: selectedCate.getListPro())
        {
            Vector<String> vec = new Vector<String>();
            vec.add(p.getProductId());
            vec.add(p.getProductName());
            vec.add(p.getUnitPrice()+"");
            vec.add(p.getQuality()+"");
            vec.add(p.getDateImport());
            vec.add(p.getOriginal());
            vec.add(p.CalTax()+"");
            vec.add(p.getDescription());
            dtmProduct.addRow(vec);
        }
    }

    public static void updateCateList()
    {
        lstCate.removeAll();
        lstCate.setListData(listData.getList().toArray());
        lstCate.updateUI();
        cboCateList.removeAllItems();
        for(Category cate : listData.getList())
        {
            cboCateList.addItem(cate);
        }
    }

    private void doCreateNewCate()
    {
        CategoryManagerUI cateUI = new CategoryManagerUI("Cate information");
        cateUI.doShow();
    }

    private void doSaveProduct()
    {
        if(selectedCate != null)
        {
            Product p = new Product();
            p.setProductId(txtId.getText());
            p.setProductName(txtName.getText());
            p.setQuality(Integer.parseInt(txtQuality.getText()));
            p.setUnitPrice(Double.parseDouble(txtUnitprice.getText()));
            p.setDateImport(txtDE.getText());
            p.setOriginal(txtOG.getText());
            p.setTax(Double.parseDouble(txtTax.getText()));
            p.setDescription(txtDescription.getText());
            selectedCate.addProduct(p);
        }
    }

    private void doComboboxSelected()
    {
        selectedCate = (Category) cboCateList.getSelectedItem();
    }

    private void doWriteDataToDisk()
    {
        JFileChooser fc=new JFileChooser(".");
        if(fc.showSaveDialog(null)==JFileChooser.APPROVE_OPTION)
        {
        MyProcessFile.saveData(listData, fc.getSelectedFile().getAbsolutePath());
        }
    }

    private void doReadDataFromDisk()
    {
        JFileChooser fc=new JFileChooser(".");
        if(fc.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
        {
            listData=(ListCategory)      
            MyProcessFile.openData(fc.getSelectedFile().getAbsolutePath());
            updateCateList();
        }
    }

    private class processButtonEvent implements ActionListener
    {
        public void actionPerformed(ActionEvent e) 
        {
            Object o=e.getSource();
            if(o.equals(btnCateNew))
            {
                doCreateNewCate();
            }
            else if(o.equals(btnNew))
            {
                txtDescription.setText("");
                txtId.setText("");
                txtName.setText("");
                txtUnitprice.setText("");
                txtQuality.setText("");
                txtDE.setText("");
                txtOG.setText("");
                txtTax.setText("");
                txtId.requestFocus();
            }
            else if(o.equals(btnSave))
            {
                doSaveProduct();
            }
            else if(o.equals(cboCateList))
            {
                doComboboxSelected();
            }
            else if(o.equals(mnuFileWritetodisk))
            {
                doWriteDataToDisk();
            }
            else if(o.equals(mnuFileOpenDataFromDisk))
            {
                doReadDataFromDisk();
            }
        }
    }
}