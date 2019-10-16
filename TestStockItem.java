public class TestStockItem
{
    public static void main(String[] args)
    {
        // Construct items into existence
        StockItem[] items = 
        {
            new MouseMat("Plain blue cloth, foam backed",499,10),
            new Book("No1 Catalogue",10,10),
            new Book("Fuel",700,10),
            new Book("Madness",500,10),
            new CPU(7000,25),
            new Keyboard(1600,30),
            new HardDisc(4000,20)
        };

        // Print out the creation of all the items
        for (StockItem item:items)
        {
            createItem(item);
        }

        increaseStock(items[0],32);
        decreaseStock(items[0],7);
        changePrice(items[0],399);
     
    }
    
    private static void createItem(StockItem product)
    {
        System.out.printf("Creating '%s', %d in stock @ %d.%n",
                            product.getStockType(), product.getQuantityInStock(), 
                            product.getPriceExVat());
        System.out.printf("%s%n%n",product);
    }

    private static void increaseStock(StockItem product, int addedQuantity)
    {
        System.out.printf("Obtain %d more '%s's %n",addedQuantity,product.getStockType());
        product.increaseStock(addedQuantity);
        System.out.printf("%s%n%n",product);
    }

    private static void decreaseStock(StockItem product, int quantity)
    {
        System.out.printf("Sell %d '%s's %n",quantity, product.getStockType());
        product.sellStock(quantity);
        System.out.printf("%s%n%n",product);
    }

    public static void changePrice(StockItem product, int newPriceExVat)
    {
        System.out.printf("Change price of '%s' to %d %n",product.getStockType(), 
                            newPriceExVat);
        product.setPriceExVat(newPriceExVat);
        System.out.printf("%s%n%n",product);
    }
}
