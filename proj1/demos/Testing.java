import java.util.*;
public class Testing {
    public static void main(String[] args) {
        HashMap<String,Double> map = new HashMap<String,Double>();
        ValueComparator bvc = new ValueComparator(map);
        TreeMap sorted_map = new TreeMap(bvc);

        map.put("A", 99.5);
        map.put("B", 67.4);
        map.put("C", 67.4);
        map.put("D", 67.3);

        System.out.println("unsorted map: " + map);
        sorted_map.putAll(map);
        System.out.println("results: " + sorted_map);
    }
}

class ValueComparator implements Comparator {
    Map<String,Double> base;

    public ValueComparator(Map base) {
        this.base = base;
    }

    // Note: this comparator imposes orderings that are inconsistent with
    // equals.
	@Override
    public int compare(String a, String b) {
        if (base.get(a)>= base.get(b)) {
            return -1;
        } else {
            return 1;
        } // returning 0 would merge keys
    }
}
