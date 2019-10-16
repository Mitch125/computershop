public class ShoppingBasket
{

    private StockItem[] cart= new StockItem[7];
    private int[] quantityInCart= new int[7];
    private int nextEmptyIndex;

    public ShoppingBasket()
    {
        StockItem[] cart = new StockItem[7];
        nextEmptyIndex = 0;
    }


    public void add(StockItem wantedItem, int numberWanted)
    {
        cart[nextEmptyIndex] = wantedItem;
        quantityInCart[nextEmptyIndex] = numberWanted;
        // System.out.println(cart[nextEmptyIndex]);
        nextEmptyIndex++;
    }

    public String checkout()
    {
        String output = "";
        for (int index =0; index < cart.length; index++)
        {

            if (cart[index].sellStock(quantityInCart[index]))
            {
                output += ("Purchased "+quantityInCart[index]+ " of " + 
                cart[index] +"\n");
                // cart[index] = null;
                quantityInCart[index] = 0;
               
            }
            else
            {
                noOfRemainingItems++;
                output+=("Not purchased "+quantityInCart[index]+ " of " 
                    + cart[index]+ "\n");
            }

        }


        
        if (noOfRemainingItems>0)
            {
                cart = leftOverItems(cart,quantityInCart,noOfRemainingItems);
                quantityInCart = resizeQuantityArray(quantityInCart,noOfRemainingItems);
            }
        return output;
    }

    private StockItem[] leftOverItems(StockItem[] cartItems, int[] quantities, int noOfRemainingItems)
    {
        
        StockItem[] newCartItems = new StockItem[noOfRemainingItems];
        for (int index=0; index<cartItems.length;index++)
        {
            int cartItemNo=0;
            if (quantities[index] != 0)
            {
                newCartItems[cartItemNo]= cartItems[index];
                cartItemNo++;
            }
        }
        return newCartItems;
    }       


    private int[] resizeQuantityArray(int[] quantities, int noOfRemainingItems)
    {
        int[] newQuantities = new int[noOfRemainingItems];
        for (int index=0; index<quantities.length;index++)
        {
            int cartItemNo=0;
            if (quantities[index] != 0)
            {
                newQuantities[cartItemNo]=quantities[index];
                cartItemNo++;
            }
        }
        return newQuantities;
    }

    public String toString()
    {
        String cartdeets=("Shopping Basket:\n");
        for (int index =0; index < 7; index++)
            cartdeets+= (""+ quantityInCart[index] + " of " + cart[index] +"\n");
        return (cartdeets);
    }
}
