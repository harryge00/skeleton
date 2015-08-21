import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Iterator;

/** ULLMapTest. You should write additional tests.
 *  @author Josh Hug
 */

public class ULLMapTest2 {
  @Test
    public void testBasic() {
        ULLMap<String, String> um = new ULLMap<String, String>();
        um.put("Gracias", "Dios Basado");
        assertEquals(um.get("Gracias"), "Dios Basado");
    }

   @Test
   public void testRemove(){
        ULLMap<String, String> um = new ULLMap<String, String>();
        assertEquals(null, um.remove("Returns null"));

        um.put("Gracias", "Dios Basado");
        assertEquals(um.get("Gracias"), "Dios Basado");

        um.remove("Gracias", "Incorrect Value");
        assertEquals(1, um.size());
        um.remove("Gracias");
        assertEquals(0, um.size());
   }
public void testInvert(){
        ULLMap<Integer, String> um = new ULLMap<Integer, String>();
        um.put(0, "zero");
        um.put(1, "one");
        um.put(0, "two");

        Map61B<String, Integer> result = ULLMap.invert(um);
        assertEquals(2, result.size(), 1e11);
        assertEquals(0, result.get("two"), 1e11);
        assertEquals(1, result.get("one"), 1e11);
}
    /*
    //@Test
    public void testIterator() {
        ULLMap<Integer, String> um = new ULLMap<Integer, String>();
        um.put(0, "zero");
        um.put(1, "one");
        um.put(2, "two");
        Iterator<Integer> umi = um.iterator();
        System.out.println(umi.next());
    }
    
    //@Test
        }*/
    @Test
    public void testBasic2() {
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


    /*@Test
    public void testIterator() {
        ULLMap<Integer, String> um = new ULLMap<Integer, String>();
        um.put(0, "zero");
        um.put(1, "one");
        um.put(2, "two");
        Iterator<Integer> umi = um.iterator();
        System.out.println(umi.next());
    }*/


    /** Runs tests. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(ULLMapTest2.class);
    }
}
