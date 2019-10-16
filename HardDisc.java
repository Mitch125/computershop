
public class HardDisc extends StockItem
{

    private int storage;

    public HardDisc(int itemPriceExVat, int initialQuantity, int sizeInGB)
    {
        super(itemPriceExVat, initialQuantity);
        storage = sizeInGB;
    }


    public String getStockType()
    {
        return "Hard Disc";
    }

    public String getDescription()
    {
        return (storage+"GB of space");
    }
}
