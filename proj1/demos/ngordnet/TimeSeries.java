//no package?
package ngordnet;
import java.util.*;
/*
import java.util.TreeMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.Collection;
import java.util.NavigableSet;
import java.util.Map;
*/
import java.lang.IllegalArgumentException;
public class TimeSeries<T extends Number> extends TreeMap<Integer, T> {    
    /** Constructs a new empty TimeSeries. */
    public TimeSeries(){
        super(); //Niubility!
    }

    /** Returns the years in which this time series is valid. Doesn't really
      * need to be a NavigableSet. This is a private method and you don't have 
      * to implement it if you don't want to. */
    private NavigableSet<Integer> validYears(int startYear, int endYear)
    {
        TreeSet<Integer> years=new TreeSet<Integer> ();
        return years;
    }

    /** Creates a copy of TS, but only between STARTYEAR and ENDYEAR. 
     * inclusive of both end points. */
    public TimeSeries(TimeSeries<T> ts, int startYear, int endYear)
    {
        for(Integer yearNumber:ts.keySet())
        {
            if(yearNumber<=endYear && yearNumber>=startYear)
            {
                super.put(yearNumber,ts.get(yearNumber));
            }
        }
    }
    /** Creates a copy of TS. */
    public TimeSeries(TimeSeries<T> ts){
        for(Integer yearNumber:ts.keySet())
        {
                super.put(yearNumber,ts.get(yearNumber));
        }
    }

    /** Returns the quotient of this time series divided by the relevant value in ts.
      * If ts is missing a key in this time series, return an IllegalArgumentException. */
    public TimeSeries<Double> dividedBy(TimeSeries<? extends Number> ts)
    {
        TimeSeries<Double> tsDouble=new TimeSeries<Double>();
        for(Map.Entry<Integer,? extends Number> entry : ts.entrySet())
        {
            //if(entry.getKey()==null)
              //  throw new IllegalArgumentException();
            Integer year=entry.getKey();
            Number divisor=entry.getValue();
            if(super.get(year)==null)
                throw new IllegalArgumentException();
            Number divident=super.get(year);
            double quotient=divident.doubleValue()/divisor.doubleValue();
            tsDouble.put(year,quotient);
        }
        return tsDouble;
    }

    /** Returns the sum of this time series with the given ts. The result is a 
      * a Double time series (for simplicity). */
    public TimeSeries<Double> plus(TimeSeries<? extends Number> ts)
    {
        TimeSeries<Double> sumSeries=new TimeSeries<Double>();
        for(Map.Entry<Integer,? extends Number> entry : ts.entrySet())
        {
            Integer year = entry.getKey();
            if(super.get(year)==null)
            {
                sumSeries.put(year,entry.getValue().doubleValue());
                continue;
            }
            Number val1=entry.getValue();
            Number val2=super.get(year);
            double sum=val1.doubleValue()+val2.doubleValue();
            sumSeries.put(year,sum);
        }
        return sumSeries;
    }

    /** Returns all years for this time series (in any order). */
    public Collection<Number> years(){
        List<Number> l=new ArrayList<Number>();
        for(Integer key: super.keySet())
        {
            l.add(key);
        }
        return l;
    }

    /** Returns all data for this time series. 
      * Must be in the same order as years(). */
    public Collection<Number> data(){
        List<Number> l=new ArrayList<Number>();
        for(Integer key: super.keySet())
        {
            l.add(super.get(key));
        }
        return l;
    }
}
