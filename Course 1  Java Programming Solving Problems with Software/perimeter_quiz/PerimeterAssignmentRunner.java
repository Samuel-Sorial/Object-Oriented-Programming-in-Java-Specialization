import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
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
    int n =0;
    for (Point pt : s.getPoints()){
        n++;
    }
    return n;
    }

    public double getAverageLength(Shape s) {
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

    public double getLargestSide(Shape s) {
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

    public double getLargestX(Shape s) {
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

    public double getLargestPerimeterMultipleFiles() {
    DirectoryResource dr = new DirectoryResource();
    double largest =0;
    for (File f : dr.selectedFiles()) {
    FileResource fr = new FileResource(f);
    Shape s = new Shape(fr);
    double pr = getPerimeter(s);
    if(pr>largest)
    {
        largest = pr;
    }
    }
    return largest;
    }
    public String getFileWithLargestPerimeter() {
        DirectoryResource dr = new DirectoryResource();
        File larg=null;
        double largest =0;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double pr = getPerimeter(s);
            if(pr>largest)
            {
                largest = pr;
                larg = f;
            }
        }

        return larg.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
    }
    
    public void testPerimeterMultipleFiles() {
    double largestPer = getLargestPerimeterMultipleFiles();
    System.out.println("Largest Is " + largestPer);
    }

    public void testFileWithLargestPerimeter() {
        String largest = getFileWithLargestPerimeter();
        System.out.println("Largest file is " + largest );
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeterMultipleFiles();
    }
}
