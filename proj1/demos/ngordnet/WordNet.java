//import ngordnet.*; //lazy is OK?
package ngordnet;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.algs4.DirectedDFS;
import java.util.List;import java.util.ArrayList;
import java.util.Set;import java.util.TreeSet;
public class WordNet {
    public Digraph g;
    private ULLMap<String,Integer> str2Int;//not sure if it can be useful
    private String[] words;
    /** Creates a WordNet using files form SYNSETFILENAME and HYPONYMFILENAME */
    public WordNet(String synsetFilename, String hyponymFilename)
    {
        str2Int=new ULLMap<String,Integer>();
        In synset=new In(synsetFilename);
        List<String> lines=new ArrayList<String>();
        for(int i=0;synset.hasNextLine();i++){
            String[] lineText=synset.readLine().split(",");
            lines.add(lineText[1]);
        }
        words=new String[lines.size()];
        words=lines.toArray(words);
        g=new Digraph(lines.size());
        In hyponymFile=new In(hyponymFilename);
        for(int i=0;hyponymFile.hasNextLine();i++){
            String[] lineInt=hyponymFile.readLine().split(",");
            for(int j=1;j<lineInt.length;j++){
                g.addEdge(Integer.parseInt(lineInt[0]),Integer.parseInt(lineInt[j]));
            }
        }
    }

    /* Returns true if NOUN is a word in some synset. */
    public boolean isNoun(String noun)
    {
        for(int i=0;i<words.length;i++)
        {
            if(words[i].indexOf(noun)>=0)
                return true;
        }
        return false;
    }
    /* Returns the set of all nouns. */
    public Set<String> nouns()
    {
        TreeSet<String> result=new TreeSet<String>();
        for(int i=0;i<words.length;i++){
            result.add(words[i]);
        }
        return result;
    }

    /** Returns the set of all hyponyms of WORD as well as all synonyms of
      * WORD. If WORD belongs to multiple synsets, return all hyponyms of
      * all of these synsets. See http://goo.gl/EGLoys for an example.
      * Do not include hyponyms of synonyms.
      */
    public Set<String> hyponyms(String word){
        TreeSet<String> result=new TreeSet<String>();
        for(int i=0;i<words.length;i++)
        {
            if(words[i].indexOf(word)>=0)
            {
                DirectedDFS dfdp=new DirectedDFS(g,i);
                for(int j=0;j<g.V();j++){
                    if(dfdp.marked(j)){
                       // System.out.println(i+","+j+" "+words[j]);
                        for(String str:words[j].split(" "))
                            result.add(str);
                    }
                }
            }
        }
        return result;
    }
}
