package creatures;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashMap;
import java.awt.Color;
import huglife.Direction;
import huglife.Action;
import huglife.Occupant;
import huglife.Impassible;
import huglife.Empty;

/** Tests the clorus class
 *  @authr Harryge
 */

public class TestClorus {

    @Test
    public void testBasics() {
        Clorus p = new Clorus(2.0);
        assertEquals(2.0, p.energy(), 0.01);
        assertEquals(new Color(34, 0, 231), p.color());
       /* p.move();
        assertEquals(1.85, p.energy(), 0.01);
        p.move();
        assertEquals(1.70, p.energy(), 0.01);
        p.stay();
        assertEquals(1.90, p.energy(), 0.01);
        p.stay();
        assertEquals(2.00, p.energy(), 0.01);*/
    }

    @Test
    public void testReplicate() {
        Clorus p=new Clorus(1.5);
        Clorus offspring=p.replicate();
        assertEquals(offspring.energy(),0.75,0.005);
        assertEquals(p.energy(),0.75,0.005);
        assertNotSame(p,offspring);
    }

    @Test
    public void testChoose() {
        Clorus cls = new Clorus(1.2);
        HashMap<Direction, Occupant> surrounded = new HashMap<Direction, Occupant>();
        surrounded.put(Direction.TOP, new Plip());
        surrounded.put(Direction.BOTTOM, new Plip());
        surrounded.put(Direction.LEFT, new Plip());
        surrounded.put(Direction.RIGHT, new Plip());

        Action actual = cls.chooseAction(surrounded);
        Action expected = new Action(Action.ActionType.STAY);

        assertEquals(expected, actual);

        surrounded.put(Direction.BOTTOM, new Empty());
        surrounded.put(Direction.LEFT, new Empty());
        surrounded.put(Direction.RIGHT, new Empty());
        Action actual2 = cls.chooseAction(surrounded);
        Action expected2 = new Action(Action.ActionType.ATTACK,Direction.TOP);
        assertEquals(expected2, actual2);

    }

    public static void main(String[] args) {
        System.exit(jh61b.junit.textui.runClasses(TestClorus.class));
    }
}
