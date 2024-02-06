package Rental;


class Node {
    
    
    Car   item;   // the Car
    Node  next;  // next node
    
    
    Node ( Car c, Node n ) {
        
        item = c;
        next = n;
        
    }  // constructor
    public Car item(){
        return item;
    }
    public Node next() {
        return next;
    }
    
}  //Node