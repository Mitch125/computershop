
public final class Book extends TextDescriptionStockItem
{
    public Book(String itemDescription, int itemPriceExVat, int initialQuantity)
    {
        super(itemDescription, itemPriceExVat, initialQuantity);
    }


    public String getStockType()
    {
        return "Book";
    }

    // public String getDescription()
    // {
    //     return "List of all items and prices";
    // }

    public double getVatRate()
    {
        return 0;
    }
}
