
public final class Keyboard extends StockItem
{
    public Keyboard(int itemPriceExVat, int initialQuantity)
    {
        super(itemPriceExVat, initialQuantity);
    }


    public String getStockType()
    {
        return "Keyboard";
    }

    public String getDescription()
    {
        return "Cream, non-click";
    }
}
