public class Card
{
    private String name;
    private int value;
    Card(String n, int v)
    {
        name = n;
        value = v;
    }

    public int getValue(){
        return this.value;
    }
    public String getName()
    {
      return this.name;
    }
    public String toString()
    {
      return this.name;
    }
}
