package Week_4.task1;

public class Square extends Rectangle {
    public Square(String colour, double side) {
        super(colour, side, side);
    }
    
    @Override 
    public void setWidth(double w) { 
        super.setWidth(w);  
        super.setHeight(w); 
    }
    
    @Override 
    public void setHeight(double h) { 
        super.setHeight(h); 
        super.setWidth(h); 
    }
}
