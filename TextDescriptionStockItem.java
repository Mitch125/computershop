public abstract class TextDescriptionStockItem extends StockItem
{
    private String itemDescription;

    public TextDescriptionStockItem(String givenItemDescription, int itemPriceExVat, int initialQuantity)
    {
        super(itemPriceExVat, initialQuantity);
        setDescription(givenItemDescription);
    }

    public String getDescription()
    {
        return itemDescription;
    }

    public void setDescription(String wantedDescription)
    {
       itemDescription = wantedDescription;
    }
    
}

