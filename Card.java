public class Card
{
    String name;
    int value;
    Card(String n, int v)
    {
        name = n;
        value = v;
    }

    public int getValue(){
        return this.value;
    }
}
