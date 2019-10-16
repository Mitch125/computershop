
public final class ReliableHardDisc extends HardDisc
{
    private int yearsGuaranteed;

    public ReliableHardDisc(int itemPriceExVat, int initialQuantity, int sizeInGB, int lifespan)
    {
        super(itemPriceExVat, initialQuantity, sizeInGB);
        yearsGuaranteed = lifespan;
    }


    public String getStockType()
    {
        return "Hard Disc";
    }

    public String getDescription()
    {
        return (super.getDescription()+", guaranteed " +
            yearsGuaranteed+" years");
    }
}
