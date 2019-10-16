
public final class MouseMat extends TextDescriptionStockItem
{

    public MouseMat(String description, int itemPriceExVat, int initialQuantity)
    {
        super(description, itemPriceExVat, initialQuantity);
    }


    public String getStockType()
    {
        return "Mouse Mat";
    }

    // public String getDescription()
    // {
    //     return "Plain blue cloth, foam backed";
    // }


}
