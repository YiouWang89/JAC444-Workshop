import java.io.Serializable;

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
public abstract class GeometricObject implements Serializable {
    private  String geometricType;
    private String color = "white";
    private Boolean filled;
    Boolean isIllegal = false;
    final double defaultSize = 1.0;
    final double maxSet = 200.0;

    public GeometricObject() {
    }

    protected  GeometricObject(String color, Boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    abstract double getArea();

    abstract double getPerimeter();

    public void checkSize() throws InvalidGOSizeException {
        double size = getArea();
        String message = size + " size is illegal, it should between " + defaultSize + " and " + maxSet;
        if (size < defaultSize || size > maxSet){
            throw new InvalidGOSizeException(message);
        }
    }

    abstract String[] dataNeeded();

    public String getGeometricType() {
        return geometricType;
    }

    public void setGeometricType(String geometricType) {
        this.geometricType = geometricType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getFilled() {
        return filled;
    }

    public void setFilled(Boolean filled) {
        this.filled = filled;
    }
}
