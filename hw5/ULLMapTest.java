import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Iterator;

/** ULLMapTest. You should write additional tests.
 *  @author Josh Hug
 */

public class ULLMapTest {
    @Test
    public void testBasic() {
        ULLMap<String, String> um = new ULLMap<String, String>();
        um.put("Gracias", "Dios Basado");
        assertEquals(um.get("Gracias"), "Dios Basado");
        um.put("ABCD"," how are you?");
        assertEquals(um.get("ABCD")," how are you?");
        um.put("","Dios Basado");
        assertEquals(um.get(""),"Dios Basado");
        assertEquals(um.size(),3);
        assertEquals(um.containsKey("ABCD"),true);
        um.put("ABCD","EFGH");
        assertEquals(um.get("ABCD"),"EFGH");
        um.clear();
        assertEquals(um.size(),0);
        assertEquals(um.containsKey("ABCD"),false);
    }


    @Test
    public void testIterator() {
        ULLMap<Integer, String> um = new ULLMap<Integer, String>();
        um.put(5, "zero");
        um.put(9, "one");
        um.put(23, "two");
        Iterator<Integer> umi = um.iterator();
        System.out.println(umi.next());
        /*for(Iterator<Integer,String> it=um.iterator();it.hasNext();it=it.next()){
            System.out.println(it.first+" is "+it.second);

        }*/
        for(int x: um){
            System.out.println(x+" is "+um.get(x));
        }
    }


    /** Runs tests. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(ULLMapTest.class);
    }
}
