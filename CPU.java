
public final class CPU extends StockItem
{
    public CPU(int itemPriceExVat, int initialQuantity)
    {
        super(itemPriceExVat, initialQuantity);
    }


    public String getStockType()
    {
        return "CPU";
    }

    public String getDescription()
    {
        return "Really Fast";
    }
}
