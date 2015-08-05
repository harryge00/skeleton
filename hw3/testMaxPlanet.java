import org.junit.Test;
import static org.junit.Assert.*;

public class testMaxPlanet {
	@Test
	public void testLargestPlanet(){
		Planet planet1 = new Planet(0, 0, 0, 0, 5, null, 10);
		Planet planet2 = new Planet(0, 0, 0, 0, 4, null, 11);
		Planet planet3 = new Planet(0, 0, 0, 0, 6, null, 19);
		Planet planet4 = new Planet(0, 0, 0, 0, 9, null, 13);
		Planet[] planets = new Planet[]{planet1, planet2,planet3,planet4};
		MassComparator mc=new MassComparator() ;
		RadiusComparator rc=new RadiusComparator ();
		assertEquals(MaxPlanet.maxPlanet(planets,mc),planet4);
		assertEquals(MaxPlanet.maxPlanet(planets,rc),planet3);

		
	}
	public static void main(String[] args){
		jh61b.junit.textui.runClasses(testMaxPlanet.class);		
	}
}
