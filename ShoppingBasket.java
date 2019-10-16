public class ShoppingBasket
{
    private int nextEmptyIndex;
    private StockItemPurchaseRequest[] cart;
    private boolean checkedout;

    public ShoppingBasket()
    {
    }

    // Increase cart array size by 1 and add purchase request to last index 
    public void add(StockItem wantedItem, int numberWanted)
    {
        StockItemPurchaseRequest[] biggerCart =
            new StockItemPurchaseRequest[nextEmptyIndex + 1];
        for (int index = 0; index < nextEmptyIndex; index++)
            biggerCart[index] = cart[index];
        cart = biggerCart;
        cart[nextEmptyIndex] = 
            new StockItemPurchaseRequest(wantedItem, numberWanted);
        nextEmptyIndex++;
    }

    private int unsuccesfulPurchases;
    private StockItemPurchaseRequest[] cartPostCheckout;

    // 
    public String checkout()
    {
        checkedout = true;
        unsuccesfulPurchases = 0;
        int costSoFarExVat = 0;
        int costSoFarIncVat = 0;
        String output = "Checkout Report:\n";
        // If cart item * quantity available to buy, reduce stock quantity by amount
        // and add the costs to the running totals.
        for (StockItemPurchaseRequest item : cart)
        {
            if (item.getItem().sellStock(item.getQuantity()))
            {

                output += ("Purchased " + item.getQuantity() + " of " +
                           item.getItem() + "\n");
                costSoFarExVat += item.getItem().getPriceExVat() * item.getQuantity();
                costSoFarIncVat += item.getItem().getPriceIncVat() * item.getQuantity();
                item.sellAll();
            }
            else
            {
                output += ("Not purchased " + item.getQuantity() + " of " +
                           item.getItem() + "\n");
                unsuccesfulPurchases++;
            }
        }
        if (unsuccesfulPurchases > 0)
            cartPostCheckout = resizeAfterCheckout(unsuccesfulPurchases, cart);

        output += ("Total price ex vat: " + costSoFarExVat + "p\nTotal price inc vat "
                   + costSoFarIncVat) + "p\n";
        return output;
    }

    // Resize cart so that it only contains items with a quantity > 0
    private StockItemPurchaseRequest[] resizeAfterCheckout(int remainingItems, StockItemPurchaseRequest[] leftovers)
    {
        int index = 0;
        StockItemPurchaseRequest[] newArraySize = new StockItemPurchaseRequest[remainingItems];
        for (StockItemPurchaseRequest leftover : leftovers)
        {
            if (leftover.getQuantity() != 0)
            {
                newArraySize[index] = leftover;
                index++;
            }
        }
        return newArraySize;
    }

    public String toString()
    {
        String stringOut = ("Shopping Basket:\n");

        if (!checkedout || (checkedout && unsuccesfulPurchases > 0))
        {
            if (checkedout)
                cart = cartPostCheckout;
            for (StockItemPurchaseRequest item : cart)
            {
                stringOut += (item.getQuantity() + " of " +
                              item.getItem() + "\n");
            }
        }
        else
            stringOut += ("Empty\n");

        return stringOut;
    }
}
