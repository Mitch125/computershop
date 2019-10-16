public class StockItemPurchaseRequest
{

private StockItem item;
private int quantity;

    public StockItemPurchaseRequest(StockItem requestedItem, int requestedQuantity)
    {
        item = requestedItem;
        quantity = requestedQuantity;
    }

    public StockItem getItem()
    {
        return item;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void sellAll()
    {
        quantity = 0;
    }

    public String toString()
    {
        return (quantity+ " of "+ item);
    }


}
