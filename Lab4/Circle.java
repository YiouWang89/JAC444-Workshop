/**********************************************
 *  Workshop 5
 *  Course:<JAC444> - Semester
 *  Last Name:<Wang>
 *  First Name:<Yiou(Anna)>
 *  ID:<151558194>
 *  Section:<NBB>
 *  This assignment represents my own work in accordance with Seneca Academic Policy. Signature
 *  Date:<2022-03-13>
 * **********************************************/
public class Circle extends GeometricObject implements Resizable{
    private double radius = 1.0;
    final double pi = 3.14;

public  Circle(){
    setGeometricType("Circle");
}

    public Circle(String color, Boolean filled, double r) throws InvalidGOSizeException {
        super(color, filled);
        setGeometricType("Circle");
        radius = r;
        checkSize();
    }

    @Override
    public double getArea(){
        double area = pi * radius * radius;
        return area;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String[] dataNeeded(){
        String[] data = {"radius"};
        return data;
    }

    @Override
    public double getPerimeter(){
        double perimeter = pi * 2 * radius;
        return perimeter;
    }

    @Override
    public void  incSize(int percentage){
        radius *= 1+(double)percentage/100;
    }
    @Override
    public void decSize(int percentage){
        radius *= 1-(double)percentage/100;
    }

}
