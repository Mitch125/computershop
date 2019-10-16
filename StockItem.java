// Representation of a item in stock
public abstract class StockItem
{
    private static int noOfStockItemsCreated = 0;
    private final int stockCode;
    // public final String itemDescription;

    private int priceExVat;
    private int quantity;
    private double vatRate;

    // Constructor

    public StockItem(int itemPriceExVat, int initialQuantity)
    {
        noOfStockItemsCreated++;
        stockCode = noOfStockItemsCreated;
        priceExVat = itemPriceExVat;
        quantity = initialQuantity;
        vatRate = 20.0;
    }

    public int getStockCode()
    {
        return stockCode;
    }

    public abstract String getStockType();

    public abstract String getDescription();


    public int getQuantityInStock()
    {
        return quantity;
    }

    public void increaseStock(int quantityIncreaseAmount)
    {
        try
        {
            if (quantityIncreaseAmount < 1) 
                throw new IllegalArgumentException
                ("Illegal value to increase stock quantity by: " + quantityIncreaseAmount);
            quantity += quantityIncreaseAmount;
        }
        catch (IllegalArgumentException exception)
        {
            System.out.println("Stock increase must be a whole positive number!");
            System.out.println("Exception message was: ‘"
                               + exception.getMessage() + "’");
            System.err.println(exception);
        } // catch

    }

    public boolean sellStock(int quantityDecreaseAmount)
    {
        try
        {
                if (quantityDecreaseAmount < 1) 
                    throw new IllegalArgumentException
                    ("Illegal value to decrease stock quantity by: " + quantityDecreaseAmount);
                if (quantity >= quantityDecreaseAmount)
                {
                    quantity -= quantityDecreaseAmount;
                    return true;
                }
                
            }
         catch (IllegalArgumentException exception)
        {
            System.out.println("Stock decrease must be a whole positive number!");
            System.out.println("Exception message was: ‘"
                               + exception.getMessage() + "’");
            System.err.println(exception);
        } // catch
        return false;
    }

    public void setPriceExVat(int newPriceExVat)
    {
        priceExVat = newPriceExVat;
    }

    public int getPriceExVat()
    {
        return priceExVat;
    }

    public double getVatRate()
    {
        return vatRate;
    }

    public int getPriceIncVat()
    {
        double salePrice = ((priceExVat)*(1+getVatRate()/100));
        int salePriceRounded = (int) Math.round(salePrice);
        return salePriceRounded;
    }

    public String toString()
    {
        return ("SC" + getStockCode() +": " + getStockType() + ", " + 
            getDescription() + " ("+ getQuantityInStock() + " @ " +
            getPriceExVat() + "p/" + getPriceIncVat() + "p)");
    }
}
