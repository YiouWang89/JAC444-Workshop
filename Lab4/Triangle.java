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
public class Triangle extends GeometricObject implements Resizable{
    private double side1 = 1.0, side2 = 1.0, side3 = 1.0;

public Triangle(){
    setGeometricType("Triangle");
}

    public Triangle(String color, Boolean filled, double s1, double s2, double s3) throws InvalidGOSizeException {
        super(color, filled);
        setGeometricType("Triangle");
        side1 = s1;
        side2 = s2;
        side3 = s3;
        checkSize();
    }

    @Override
    public double getArea(){
    GetData ask = new GetData();
        double perimeter = getPerimeter();
        double temp = perimeter * (perimeter - side1)* (perimeter - side2)* (perimeter - side3);
        while(temp < 0) {
            System.out.println("Invalid Data ");
            double [] data =  ask.askData(this);
            side1 = data[0];
            side2 = data[1];
            side3 = data[2];
            perimeter = getPerimeter();
            temp = perimeter * (perimeter - side1)* (perimeter - side2)* (perimeter - side3);
        }
        double area = Math.sqrt(temp);
       return area;
    }

    @Override
    public double getPerimeter(){
        double perimeter = (side1 + side2 + side3)/2;
        return perimeter;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    @Override
    public String[] dataNeeded(){
        String[] data = {"side1", "side2", "side3"};
        return data;
    }


    @Override
    public void  incSize(int percentage){
    side1 *= 1+(double)percentage/100;
    side2 *= 1+(double)percentage/100;
    side3 *= 1+(double)percentage/100;
    }
    @Override
    public void decSize(int percentage){
        side1 *= 1.0 - (double)percentage/100;
        side2 *= 1.0 - (double)percentage/100;
        side3 *= 1.0 - (double)percentage/100;
    }
}
