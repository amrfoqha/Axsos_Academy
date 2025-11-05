import java.util.ArrayList;
import java.util.Collections;

public class Museum {
        public static void main(String[] args){
            Painting p1=new Painting("oil","paint1","amr","whiteColor");
            Painting p2=new Painting("wood","paint2","ameer","brawnColor");
            Painting p3=new Painting("iron","paint3","ahmad","greyColor");

            Sculpture s1=new Sculpture("wood","title1","yousef","handmade");
            Sculpture s2=new Sculpture("oliveWood","title2","khalid","imported");
            ArrayList<Art> museum = new ArrayList<Art> ();
            museum.add(p1);
            museum.add(p2);
            museum.add(p3);
            museum.add(s1);
            museum.add(s2);
            Collections.shuffle(museum);
            for(Art el:museum){
                el.viewArt();
            }


       }
}
