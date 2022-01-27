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

// Tạo menubar cho phép người dùng lưu và mở các file chứa thông tin hàng hóa nhập khẩu
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
// thêm manubar
        addMenu();

// Tạo bảng và tiêu đề cho bảng
        JPanel pnBorder=new JPanel();
        pnBorder.setLayout(new BorderLayout());
        JPanel pnNorth=new JPanel();
        JLabel lblTitle=new JLabel("HOẠT ĐỘNG NHẬP KHẨU");
        Font ftTitle=new Font("Futura", Font.BOLD, 28);
        lblTitle.setFont(ftTitle);
        lblTitle.setForeground(new Color(0,51,102));
        pnNorth.add(lblTitle);
        pnBorder.add(pnNorth,BorderLayout.NORTH);

// Tạo bảng cho phép người dùng thêm nhóm hàng hóa
        JPanel pnListCate=new JPanel();
        JPanel pnListProduct=new JPanel();
        JSplitPane slitPane=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnListCate, pnListProduct);
        pnBorder.add(slitPane,BorderLayout.CENTER);
        pnListCate.setLayout(new BorderLayout());
        lstCate=new JList();
        TitledBorder cateborder=new TitledBorder(BorderFactory.createLineBorder(Color.RED), "Loại Hàng Hóa");
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

// Đặt tên và tạo bảng chứ thông tin chi tiết các loại hàng hóa
        JPanel pnProductTitle=new JPanel();
        JLabel lblProductTitle=new JLabel("Thông tin chi tiết");
        pnProductTitle.add(lblProductTitle);
        pnListProduct.add(pnProductTitle,BorderLayout.NORTH);

        JPanel pnProductTable=new JPanel();
        pnProductTable.setLayout(new BorderLayout());
        pnListProduct.add(pnProductTable,BorderLayout.CENTER);

        dtmProduct =new DefaultTableModel();
        dtmProduct.addColumn("Mã số hàng ");
        dtmProduct.addColumn("Tên hàng hóa");
        dtmProduct.addColumn("Đơn giá");
        dtmProduct.addColumn("Số lượng");
        dtmProduct.addColumn("Ngày nhập ");
        dtmProduct.addColumn("Xuất xứ");
        dtmProduct.addColumn("Thuế nhập khẩu");
        dtmProduct.addColumn("Mô tả");

        tblProduct=new JTable(dtmProduct);
        JScrollPane sctblproduct=new JScrollPane(tblProduct );
        pnProductTable.add(sctblproduct,BorderLayout.CENTER);

// Tạo bảng cho người dùng nhập dữ liệu hàng hóa theo từng loại hàng
        JPanel pnProductDetail=new JPanel();
        pnListProduct.add(pnProductDetail,BorderLayout.SOUTH);
        pnProductDetail.setLayout(new BoxLayout(pnProductDetail, BoxLayout.Y_AXIS ));

        JPanel pnCateList = new JPanel();
        JLabel lblCateId = new JLabel("Loại hàng :");
        cboCateList = new JComboBox();
        pnCateList.add(lblCateId);
        pnCateList.add(cboCateList);
        pnProductDetail.add(pnCateList);
        cboCateList.setEditable(false);

        JPanel pnProductId = new JPanel();
        JLabel lblProId = new JLabel("Mã số hàng :");
        txtId=new JTextField(20);
        pnProductId.add(lblProId);
        pnProductId.add(txtId);
        pnProductDetail.add(pnProductId);

        JPanel pnProductName = new JPanel();
        JLabel lblProName=new JLabel("Tên hàng hóa :");
        txtName=new JTextField(20);
        pnProductName.add(lblProName);
        pnProductName.add(txtName);
        pnProductDetail.add(pnProductName);

        JPanel pnProductUnitPrice = new JPanel();
        JLabel lblUnitPrice=new JLabel("Đơn giá :");
        txtUnitprice=new JTextField(20);
        pnProductUnitPrice.add(lblUnitPrice);
        pnProductUnitPrice.add(txtUnitprice);
        pnProductDetail.add(pnProductUnitPrice);

        JPanel pnQuality = new JPanel();
        JLabel lblQuality=new JLabel("Số lượng :");
        txtQuality = new JTextField(20);
        pnQuality.add(lblQuality);
        pnQuality.add(txtQuality);
        pnProductDetail.add(pnQuality);

        JPanel pnDateImport = new JPanel();
        JLabel lblDE = new JLabel("Ngày nhập :");
        txtDE = new JTextField(20);
        pnDateImport.add(lblDE);
        pnDateImport.add(txtDE);
        pnProductDetail.add(pnDateImport);
    
        JPanel pnOriginal = new JPanel();
        JLabel lblOG = new JLabel("Xuất xứ :");
        txtOG = new JTextField(20);
        pnOriginal.add(lblOG);
        pnOriginal.add(txtOG);
        pnProductDetail.add(pnOriginal);

        JPanel pnTax = new JPanel();
        JLabel lblTax = new JLabel("Hệ Số Thuế(%):");
        txtTax = new JTextField(20);
        pnTax.add(lblTax);
        pnTax.add(txtTax);
        pnProductDetail.add(pnTax);

        JPanel pnProductDescription = new JPanel();
        JLabel lblDescription=new JLabel("Mô tả :");
        txtDescription=new JTextArea(3, 20);
        JScrollPane scare = new JScrollPane(txtDescription);
        pnProductDescription.add(lblDescription);
        pnProductDescription.add(scare);
        pnProductDetail.add(pnProductDescription);

// Tạo 3 phím chức năng
        JPanel pnButton = new JPanel();
        btnNew=new JButton("New");
        btnSave=new JButton("Save");
        btnRemove=new JButton("Remove");
        pnButton.add(btnNew);
        pnButton.add(btnSave);
        pnButton.add(btnRemove);
        pnProductDetail.add(pnButton);

// Set up các text feild thẳng hàng
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