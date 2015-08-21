import org.junit.Test;
import java.util.AbstractList;
import java.lang.RuntimeException;
public class ArrayList61B<E> extends AbstractList<E>{
    private E[] items;
    private int size;
    public ArrayList61B(int initialCapacity)
    {
        if(initialCapacity<1)
            throw new IllegalArgumentException("Capacity must >=1");
        items=(E[]) new Object[initialCapacity];
        size=0;
    }
    public ArrayList61B()
    {
        items=(E[]) new Object[1];
        size=0;
    }
    @Override
    public E get(int i)
    {
        if(i<0||i>=size)
            throw new IllegalArgumentException();
        return items[i];
    }
    @Override
    public boolean add(E item)
    {
        if(items.length<=size)
        {
            E[] newItems=(E[]) new Object[(int)items.length+1];
            for(int i=0;i<items.length;i++)
            {
                newItems[i]=items[i];
            }
            items=newItems;
        }
        items[size++]=item;
        return true;
    }
    public int size()
    {
        return size;
        //return the size;
    }

}
