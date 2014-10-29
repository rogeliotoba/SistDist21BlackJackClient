package sistDist.blackjack;

public class Card
{
    private String value;
    private String type;

    public Card(String value, String type)
    {
        this.value = value;
        this.type = type;
    }
    
    public Card()
    {
    }

    public String getValue()
    {
        return value != null ? value : "";
    }

    public void setValue(String value)
    {
        this.value = value;
    }

    public String getType()
    {
        return type != null ? type : "";
    }

    public void setType(String type)
    {
        this.type = type;
    }
}
