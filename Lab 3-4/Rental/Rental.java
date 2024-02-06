package Rental;


import BasicIO.ASCIIDataFile;
import BasicIO.ASCIIDisplayer;

import BasicIO.*;
import static BasicIO.Formats.*;


public class Rental {
    
    
    /** Instance Variables */
    ASCIIDataFile file;
    ASCIIDisplayer displayer = new ASCIIDisplayer();
    Node carList;
    Node rentList;
    Node temp;
    Node temp2;
    BasicForm form;
    int user;
    public Rental ( ) {
        String licence;
        double amt;
        Car car;
        file = new ASCIIDataFile();
        while(true){
            car = new Car(file);
            if(file.isEOF()){break;}
            addAvail(car);
        }
        setupForm();
        user = form.accept("rent", "return", "list", "quit");
        while(user != 3){
            if(user == 0){
                while(form.readInt("cat") == -1){
                    form.writeString("msg", "Please select a category");
                    form.accept("rent");
                }
                car = grabAvailCar(form.readInt("cat"));
                if(car == null){
                    form.writeString("msg", "No car available");
                }
                else{
                    fillInfo(car);
                    licence = carList.item.getLicence();
                    form.writeString("msg", "Rented: " + licence);
                    addRented(carList.item);
                    removeAvail(carList.item);
                    displayer.writeString("added front of available to the rented");
                    displayer.newLine();
                    form.accept("ok");
                    clearInfo();
                }
            }
            if(user == 1){
                car = grabRentCar(form.readString("licence"));
                if(car == null){
                    form.writeString("msg", "No car rented with that licence plate");
                }
                else {
                    fillInfo(car);
                    licence = rentList.item.getLicence();
                    form.accept("ok");
                    amt = rentList.item.returned(form.readDouble("nMileage"));
                    form.writeDouble("amt", amt);
                    form.writeString("msg", "Returned: " + licence);
                    form.accept("ok");
                    clearInfo();
                    addAvail(rentList.item);
                    removeRented(rentList.item);
                    displayer.writeString("added front of rented to the available");
                    displayer.newLine();
                }
            }
            if(user == 2){
                displayer.writeString("Available list");
                displayer.newLine();
                listAvail();
                displayer.newLine();
                displayer.writeString("Rented list");
                displayer.newLine();
                listRented();
                displayer.newLine();
                form.accept("ok");
            }
            user = form.accept("rent", "return", "list", "quit");
            form.writeString("msg", "");
        }

        file.close();
        displayer.close();
        
    } // constructor
    public Car grabAvailCar(int i){
        temp = carList;
        while(temp != null){
            if(temp.item.getCategory() ==i){
                return temp.item;
            }
            temp = temp.next;
        }
        return null;
    }
    public Car grabRentCar(String s){
        temp = rentList;
        while(temp != null){
            if(temp.item.getLicence().equals(s)){
                return temp.item;
            }
            temp = temp.next;
        }
        return null;
    }
    private void setupForm ( ) {
        form = new BasicForm();
        form.setTitle("Acme Rentals");
        form.addTextField("licence","Licence",8,10,10);
        form.addRadioButtons("cat","Category",true,10,40,Car.CATEGORIES);
        form.addTextField("rate","Rate",getCurrencyInstance(),8,294,40);
        form.setEditable("rate",false);
        form.addTextField("oMileage","Rental Mileage",getIntegerInstance(),
                8,10,160);
        form.setEditable("oMileage",false);
        form.addTextField("nMileage","Returned Mileage",getIntegerInstance(),
                8,222,160);
        form.addTextField("amt","Amount",getCurrencyInstance(),10,10,190);
        form.setEditable("amt",false);
        form.addTextField("msg","Message",45,10,220);
        form.setEditable("msg",false);

    }  // setupForm
    public void fillInfo(Car c){
        form.writeString("licence", c.getLicence());
        form.writeDouble("rate", c.getRate());
        form.writeDouble("oMileage", c.getMileage());
        form.writeInt("cat", c.getCategory());
    }
    public void clearInfo(){
         form.writeString("licence", "");
         form.writeString("rate", "");
         form.writeString("oMileage", "");
         form.writeInt("cat", -1);
         form.writeString("msg", "");
         form.writeString("amt", "");
         form.writeString("nMileage", "");

    }
    
   /* Methods */
    public void addAvail(Car car){
        if(carList==null){
            carList = new Node(car, null);
        }
        else {
            carList = new Node(car, carList);
        }
    }

    public void listAvail(){
        temp = carList;
        Car car;
        while(temp != null) {
            car = temp.item;
            displayer.writeString(car.getLicence());
            displayer.writeInt(car.getMileage());
            displayer.writeInt(car.getCategory());
            displayer.newLine();
            temp = temp.next;
        }
    }
    public void listRented(){
        temp = rentList;
        Car car;
        while(temp != null) {
            car = temp.item;
            displayer.writeString(car.getLicence());
            displayer.writeInt(car.getMileage());
            displayer.writeInt(car.getCategory());
            displayer.newLine();
            temp = temp.next;
        }
    }
    public void addRented(Car car){
        if(rentList==null){
            rentList = new Node(car, null);
        }
        else {
            rentList = new Node(car, rentList);
        }
    }
    public void removeRented(Car car){
        temp = rentList;

        int x = 0;
        if(rentList.item == car){
            if(rentList.next != null){
                rentList = rentList.next;
            }
            else{
                rentList = null;
            }
            x = 1;
        }
        while(x==0){
            if(temp.next.item == car){
                if(temp.next.next != null) {
                    temp2 = temp.next.next;
                    temp.next = temp2;
                }
                else{
                    temp.next = null;
                }
                x = 1;
            }
            temp = temp.next;
        }
    }
    public void removeAvail(Car car){
        temp = carList;

        int x = 0;
        if(carList.item == car){
            if(carList.next != null){
                carList = carList.next;
            }
            else{
                carList = null;
            }
            x = 1;
        }
       while(x==0){
            if(temp.next.item == car){
                if(temp.next.next != null) {
                    temp2 = temp.next.next;
                    temp.next = temp2;
                }
                else{
                    temp.next = null;
                }
                x = 1;
            }
            temp = temp.next;
        }
    }
    
    public static void main ( String[] args ) { Rental r = new Rental(); }
    
    
}  // Rental