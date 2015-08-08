package creatures;
import huglife.Creature;
import huglife.Direction;
import huglife.Action;
import huglife.Occupant;
import huglife.HugLifeUtils;
import java.awt.Color;
import java.util.Map;
import java.util.List;

/** An implementation of a motile predator
 *  @author  HarryGe
 */
public class Clorus extends Creature {
    /** red color. */
    private int r;
    /** green color. */
    private int g;
    /** blue color. */
    private int b;

    /** creates plip with energy equal to E. */
    public Clorus(double e) {
        super("clorus");
        r = 0;
        g = 0;
        b = 0;
        energy = e;
    }

    /** creates a plip with energy equal to 1. */
    public Clorus() {
        this(1);
    }

    public Color color() {
        r=34;b=231;
        g =0;
        return color(r, g, b);
    }

    public void attack(Creature c) {
        energy+=c.energy();
    }

    /** Plips should lose 0.15 units of energy when moving. If you want to
     *  to avoid the magic number warning, you'll need to make a
     *  private static final variable. This is not required for this lab.
     */
    public void move() {
        energy-=0.03;
    }


    /** Plips gain 0.2 energy when staying due to photosynthesis. */
    public void stay() {
        energy-=0.01;
    }

    /** Plips and their offspring each get 50% of the energy, with none
     *  lost to the process. Now that's efficiency! Returns a baby
     *  Plip.
     */
    public Clorus replicate() {
        energy*=0.50;
        return new Clorus(energy);
    }

    /** Cloruses should obey exactly the following behavioral rules:
         If there are no empty squares the Clorus will STAY (even if there are Plips nearby they could attack).
         Otherwise, if any Plips are seen, the Clorus will ATTACK one of them randomly.
        Otherwise, if the Clorus has energy greater than or equal to one, it will REPLICATE to a random empty square.
        Otherwise, the Clorus will MOVE.
     */
    public Action chooseAction(Map<Direction, Occupant> neighbors) {
        List<Direction> empties = getNeighborsOfType(neighbors, "empty");
        List<Direction> neighborPlips = getNeighborsOfType(neighbors, "plip");
        if(empties.size()==0)
            return new Action(Action.ActionType.STAY);
        else if(neighborPlips.size()>0)
        {
            Direction moveDir = HugLifeUtils.randomEntry(neighborPlips);
            return new Action(Action.ActionType.ATTACK,moveDir);
        }
        else if(energy>=1.0)
        {
            Direction moveDir = HugLifeUtils.randomEntry(empties);
            return new Action(Action.ActionType.REPLICATE,moveDir);
        }
        else
        {
                 Direction moveDir = HugLifeUtils.randomEntry(empties);
                return new Action(Action.ActionType.MOVE, moveDir);
        }

    }
}
