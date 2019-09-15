import edu.duke.URLResource;
public class Part4 {
public void findYouTube()
{
    URLResource ur = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
    for (String s : ur.words()) {
        String slower= s.toLowerCase();
        int startIndex = slower.indexOf("youtube.com");
        if(startIndex == -1)
        {
            System.out.println("nothing");
        }
        else
        {
            int endIndex = s.indexOf("\"",startIndex+11);
            int newStartIndex = s.lastIndexOf("\"" , startIndex);
            String link = s.substring(newStartIndex,endIndex+1);
            System.out.println(link);
        }
    }
}
}
