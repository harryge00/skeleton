package ngordnet;
import java.util.*;
public class YearlyRecord {
    /** Creates a new empty YearlyRecord. */
    Map<String,Integer> countMap;
    public YearlyRecord()
    {
        countMap=new HashMap<String,Integer>();
    }
    /** Creates a YearlyRecord using the given data. */
    public YearlyRecord(HashMap<String, Integer> otherCountMap)
    {
        countMap=otherCountMap;
    }
    /** Returns the number of times WORD appeared in this year. */
    public int count(String word) 
    {
        return countMap.get(word);
    }
    /** Records that WORD occurred COUNT times in this year. */
    public void put(String word, int count) 
    {
        countMap.put(word,count);
    }
    /** Returns the number of words recorded this year. */
    public int size()
    {
        return countMap.size();
    }
    private class ValueComparator implements Comparator<String> {
        Map<String,Integer> map;
        public ValueComparator(Map<String,Integer> base){
            map=base;
        }
        public int compare (String a, String b){
            if(map.get(a)>=map.get(b)) {
                return 1;
            }
            else {
                return -1;
            }
        }
    }
    /** Returns all words in ascending order of count. */
    public Collection<String> words() {
        ValueComparator vc=new ValueComparator(countMap);
        TreeMap<String,Integer> sortedMap=new TreeMap<String,Integer> (vc);
        sortedMap.putAll(countMap);
        return sortedMap.keySet();
    }

    /** Returns all counts in ascending order of count. */
    public Collection<Number> counts() 
    {
        ValueComparator vc=new ValueComparator(countMap);
        TreeMap<String, Integer> sortedMap=new TreeMap<String, Integer> (vc);
        sortedMap.putAll(countMap);
        List<Number> result=new ArrayList<Number>();
        for(Integer val : sortedMap.values()) {
            result.add(val);
        }
        return result;
    }
    /** Returns rank of WORD. Most common word is rank 1
      * If two words have the same rank, break ties arbitrarily. 
      * No two words should have the same rank.
      */
    public int rank(String word) {
        ValueComparator vc=new ValueComparator(countMap);
        TreeMap<String,Integer> sortedMap=new TreeMap<String,Integer> (vc);
        sortedMap.putAll(countMap);
        int i=0;
        for(String str : sortedMap.keySet())
        {
            if(str==word)
                return sortedMap.size()-i;
            i++;
        }
        return -1;
    }
} 
