package Rental;


import BasicIO.*;


public class Car {
    
    
    public  static final String[] CATEGORIES = {"Economy","Full Size","Van","SUV"};
    private static final double[] RATES = {0.25,0.50,1.00,1.25};
    
    /* Instance Variables */
    double rate;
    String licence;
    int mileage;
    int category;
    
    public Car ( ASCIIDataFile in ) {
        licence = in.readString();
        mileage = in.readInt();
        category = in.readInt();
        rate = RATES[category];
        
    }  // constructor
    
    
    public String getLicence ( ) {
        return licence;

    } // getLicence
    
    
    public int getMileage ( ) {
        return mileage;

    }  // getMileage
    
    
    public int getCategory ( ) {
        return category;
        

    }  // getCategory
    
    
    public double getRate ( ) {
        return rate;
        

    }  // getRate
    
    
    public double returned ( double m ) {
        return rate*(mileage-m);
        

    }  // returned

    
    
}  // Car