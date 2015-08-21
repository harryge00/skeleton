import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
 
public class Solution {
	public static void main(String[] args){
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("a", 10);
		map.put("b", 30);
		map.put("c", 50);
		map.put("d", 40);
		map.put("e", 20);
		System.out.println(map);
 
		TreeMap<String, Integer> sortedMap = SortByValue(map);  
		System.out.println(sortedMap);
	}
 
	public static TreeMap<String, Integer> SortByValue 
			(HashMap<String, Integer> map) {
		ValueComparator vc =  new ValueComparator(map);
		TreeMap<String,Integer> sortedMap = new TreeMap<String,Integer>(vc);
        System.out.println("Map is: "+map);
        System.out.println("sortedMap is: "+sortedMap);
		sortedMap.putAll(map);
		return sortedMap;
	}
}
 
class ValueComparator implements Comparator<String> {
 
    Map<String, Integer> map;
 
    public ValueComparator(Map<String, Integer> base) {
        this.map = base;
    }
 
    public int compare(String a, String b) {
        if (map.get(a) >= map.get(b)) {
            return -1;
        } else {
            return 1;
        } // returning 0 would merge keys 
    }
}
