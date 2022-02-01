package haiquanid;

import java.io.Serializable;
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    private String productId;
    private String productName;
    private String description;
    private double unitPrice;
    private int quality;
    private String dateimport;
    private String original;
    private Double tax;

	private String dateExport;
	private String country;
	private String transportation;

//	variables for Export UI
	public String getDateExport() {
		return dateExport;
	}
	public void setDateExport(String dateExport) {
		this.dateExport = dateExport;
	}

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public String getTransportation() {
		return transportation;
	}
	public void setTransportation(String transportation) {
		this.transportation = transportation;
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public String getProductId() 
    {
        return productId;
    }
    public void setProductId(String productId) 
    {
        this.productId = productId;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public String getProductName() 
    {
        return productName;
    }
    public void setProductName(String productName) 
    {
        this.productName = productName;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public String getDescription() 
    {
        return description;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public double getUnitPrice() 
    {
        return unitPrice;
    }
    public void setUnitPrice(double unitPrice) 
    {
        this.unitPrice = unitPrice;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public int getQuality() 
    {
        return quality;
    }
    public void setQuality(int quality) {
        this.quality = quality;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String getDateImport()
    {
        return dateimport;
    }
    public void setDateImport(String dateimport) {
        this.dateimport = dateimport;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String getOriginal()
    {
        return original;
    }
    public void setOriginal(String original) {
        this.original = original;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Double getTax()
    {
        return tax;
    }
    public void setTax(Double tax)
    {               
        this.tax = tax;
    }
    public Double CalTax()
    {
        return unitPrice*quality*getTax();
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public Product(String productId, String productName, String description, double unitPrice, int quality, String dateimport, String original, Double tax) 
    {
        super();
        this.productId = productId;
        this.productName = productName;
        this.description = description;
        this.unitPrice = unitPrice;
        this.quality = quality;
        this.dateimport = dateimport;
        this.original = original;
        this.tax = tax;
    }

    public Product() {
        super();
    }

}