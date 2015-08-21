import java.util.Set; /* java.util.Set needed only for challenge problem. */
import java.util.NoSuchElementException;
import java.util.Iterator;
/** A data structure that uses a linked list to store pairs of keys and values.
 *  Any key must appear at most once in the dictionary, but values may appear multiple
 *  times. Supports get(key), put(key, value), and contains(key) methods. The value
 *  associated to a key is the value in the last call to put with that key.
 *@author dapao
 *  For simplicity, you may assume that nobody ever inserts a null key or value
 *  into your map.
 */
public class ULLMap<K, V> implements Map61B<K, V>, Iterable<K> { //FIX ME
    /** Keys and values are stored in a linked list of Entry objects.
      * This variable stores the first pair in this linked list. You may
      * point this at a sentinel node, or use it as a the actual front item
      * of the linked list.
      */
    private Entry front;
    private int size;
    public ULLMap() {
        front=null;
        size=0;
    }
    public ULLMap(K key, V value){
        front=new Entry(key,value,null);
        size=0;
    }
    public Iterator <K> iterator(){
        return new ULLMapIter();
    }
    private class ULLMapIter implements Iterator <K>{
        //private int counter;
        private Entry elem;
        public ULLMapIter(){
            //counter=0;
            elem=front;
            /*if(elem!=null)
            {
                first=elem.key;
                second=elem.val;
            }
            else
            {
                first=null;second=null;
            }*/
        }
        public boolean hasNext(){
            return elem!=null;
        }
        public K next(){
            if(hasNext())
            {
                K nextKey=elem.key;
                elem=elem.next;
                //counter++;
                return nextKey;
            }
            return null;
        }
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }
    @Override
    public V get(K key) { //FIX ME
        if(front!=null)
        {
            Entry p=front.get(key);
            if(p!=null)
                return p.val;
        }
        throw new NoSuchElementException(); //FIX ME
    }

    @Override
    public void put(K key,V val) { //FIX ME
        if(front==null)
            front=new Entry(key,val,null);
        else
        {
            Entry p=front;
            Entry keyEntry=p.get(key);
            if(keyEntry!=null)
                keyEntry.val=val;
            else
                front=new Entry(key,val,front);

        }
        size++;
    }

    @Override
    public boolean containsKey(K key) { //FIX ME
        if(front!=null)
        {
            Entry p=front;
            p=front.get(key);
            return p!=null;
        }
        return false; //FIX ME
    }

    @Override
    public int size() {
        /*if(front==null)
            return 0; // FIX ME (you can add extra instance variables if you want)
        else
        {
            Entry p=front;
            int num=0;
            while(p!=null)
            {
                num++;
                p=p.next;
            }
            return num;
        }*/
        return size;
    }

    @Override
    public void clear() {
        size=0;
        front=null;
    }


    /** Represents one node in the linked list that stores the key-value pairs
     *  in the dictionary. */
    private class Entry {

        /** Stores KEY as the key in this key-value pair, VAL as the value, and
         *  NEXT as the next node in the linked list. */
        public Entry(K k,V v, Entry n) { //FIX ME
            key = k;
            val = v;
            next = n;
        }

        /** Returns the Entry in this linked list of key-value pairs whose key
         *  is equal to KEY, or null if no such Entry exists. */
        public Entry get(K k) { //FIX ME
            //FILL ME IN (using equals, not ==)
            Entry p=this;
            while(p!=null)
            {
                if(p.key==k)
                    return p;
                p=p.next;
            }
            return null;
        }

        /** Stores the key of the key-value pair of this node in the list. */
        private K key; //FIX ME
        /** Stores the value of the key-value pair of this node in the list. */
        private V val; //FIX ME
        /** Stores the next Entry in the linked list. */
        private Entry next;

    }

    /* Methods below are all challenge problems. Will not be graded in any way.
     * Autograder will not test these. */
    @Override
    public V remove(K key) { //FIX ME SO I COMPILE
        if(front!=null)
        {
            if(front.key==key)
            {
                V res=front.val;
                front=front.next;
                size--;
                return res;
            }
            else{
                Entry p=front,q=front.next;
                while(q!=null){
                    if(q.key==key)
                    {
                        size--;
                        p.next=q.next;
                        return q.val;
                    }
                    p=q;
                    q=q.next;
                }
            }
        }
        return null;
    }

    @Override
    public V remove(K key, V value) { //FIX ME SO I COMPILE
        if(front!=null)
        {
            if(front.key==key && front.val==value)
            {
                V res=front.val;
                front=front.next;
                size--;
                return res;
            }
            else{
                Entry p=front,q=front.next;
                while(q!=null){
                    if(q.key==key && q.val==value)
                    {
                        size--;
                        p.next=q.next;
                        return q.val;
                    }
                    p=q;
                    q=q.next;
                }
            }
        }
        return null;
    }

    @Override
    public Set<K> keySet() { //FIX ME SO I COMPILE
        throw new UnsupportedOperationException();
    }
    public static <TV,TK> ULLMap<TV,TK> invert(ULLMap<TK,TV> originMap)
    {
        ULLMap<TV,TK> invertedMap=new ULLMap<TV,TK>();
        for(TK key1:originMap)
        {
            invertedMap.put(originMap.get(key1),key1);
        }
        return invertedMap;
    }


}
