// A client that uses the synthesizer package to replicate a plucked guitar string sound
import synthesizer.GuitarString;
public class GuitarHero{
      public static void main(String[] args) {

          // create two guitar strings, for concert A and C
          double CONCERT_A = 440.0;
            String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
            synthesizer.GuitarString []strings=new synthesizer.GuitarString[37];
            for(int i=0;i<strings.length;i++)
            {
                strings[i]=new synthesizer.GuitarString(CONCERT_A*Math.pow(2,(i-24)/12));
            }

            double sample=0;
            synthesizer.GuitarString oldstr=strings[0];
          while (true) {

              // check if the user has typed a key; if so, process it
              if (StdDraw.hasNextKeyTyped()) {
                  char key = StdDraw.nextKeyTyped();
                  int i=keyboard.indexOf(key);
                  if(i>-1)
                  {
                       System.out.print(key+" ");
                       strings[i].pluck();
                      sample = oldstr.sample()+strings[i].sample();
                      strings[i].tic();
                      oldstr=strings[i];
                  }
              }
                      StdAudio.play(sample);
                      oldstr.tic();
              // compute the superposition of samples

              // play the sample on standard audio
              // note: this is just playing the double value YOUR GuitarString
              //       class is generating.
          }
       }
  }

