public class TestShoppingBasket
{
    public static void main(String[] args)
    {
        StockItem[] stockItems =
        {
            /* 0 */ new MouseMat("Plain blue cloth, foam backed", 150, 10),
            /* 1 */ new MouseMat("Pink vinyl with fluffy trim", 350, 10),
            /* 2 */ new Book("List of all items and prices", 150, 10),
            /* 3 */ new Book("Build a gaming monster", 1799, 0),
            /* 4 */ new CPU(1500, 10),
            /* 5 */ new HardDisc(5500, 10, 250),
            /* 6 */ new Keyboard(200, 10),
                    new ReliableHardDisc(7000, 8, 220, 10)
        };
        System.out.println("Stock before purchase:");
        for (StockItem stockItem : stockItems)
            System.out.println(stockItem);
        System.out.println();
        ShoppingBasket shoppingBasket = new ShoppingBasket();
        shoppingBasket.add(stockItems[0], 2);
        shoppingBasket.add(stockItems[2], 1);
        shoppingBasket.add(stockItems[4], 8);
        shoppingBasket.add(stockItems[5], 9);
        shoppingBasket.add(stockItems[4], 3);
        shoppingBasket.add(stockItems[6], 8);
        shoppingBasket.add(stockItems[3], 1);
        System.out.println("Shopping basket filled up:");
        System.out.println(shoppingBasket);
        System.out.println();
        System.out.println("Performing Checkout:");
        System.out.println(shoppingBasket.checkout());
        System.out.println();
        System.out.println("Shopping basket after checkout:");
        System.out.println(shoppingBasket);
        System.out.println();
        System.out.println("Stock after checkout:");
        for (StockItem stockItem : stockItems)
            System.out.println(stockItem);
    } // main
} // class TestShoppingBasket
