import edu.duke.*;

public class PerimeterRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }
    public int getNumPoints (Shape s) {
    // Start with n = 0
    int n =0;
    for (Point pt : s.getPoints()){
        n++;
    }
    return n;
    }
    public double getAverageLength(Shape s){
        double sum =0;
        int n=0;
        double avg;
        Point prevPt = s.getLastPoint();
        for(Point pt : s.getPoints())
        {
            double length = prevPt.distance(pt);
            prevPt=pt;
            sum = sum+length;
            n++;
        }
        avg=sum/n;
        return avg;
    }
    public double getLargestSide (Shape s){
    double larg=0;
    Point prevPt=s.getLastPoint();
    for(Point pt : s.getPoints())
    {
        double length = prevPt.distance(pt);
        if(length>larg)
        { larg = length;}
    }
    return larg;
    }
    public double LargestX(Shape s){
    double largest = 0;
    for(Point pt : s.getPoints())
    {
        if(pt.getX() > largest)
        {
            largest = pt.getX();
        }
    }
    return largest;
    }
    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int number = getNumPoints(s);
        double avg = getAverageLength(s);
        double largest = getLargestSide(s);
        double largestX = LargestX(s);
        System.out.println("perimeter = " + length + " It contains " + number +"points" 
        + "   It's average " + avg);
        System.out.println("Largest side is" + largest + " And Largest X is " + largestX);
    }
    
    public static void main (String[] args) {
        PerimeterRunner pr = new PerimeterRunner();
        pr.testPerimeter();
    }
}
