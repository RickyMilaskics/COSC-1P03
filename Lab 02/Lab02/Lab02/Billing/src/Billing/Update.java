package Billing;


import BasicIO.*;
import static BasicIO.Formats.*;


public class Update {
    
    /* Instance Variables */
    private BasicForm        usageForm;  // meter reading form
    
    public Update ( ) {
        
        
    };  // construtor
    
    
    private void loadAccts ( ) {
        
        
    };  // loadAccts
    
    
    private void writeAccts ( ) {
        
        
    };  // writeAccts
    
    
    private Account findAcct ( String acctNum ) {
        
        return null;
        
    };  // findAcct

    
    private void setUpForm ( ) {
        
        usageForm.setTitle("Over The Horizon Utilities");
        usageForm.addTextField("acctNum","Account #",getIntegerInstance(),
                               6,10,10);
        usageForm.addTextField("name","Name",20,10,40);
        usageForm.addTextField("prev","Previous Reading",getDecimalInstance(1),
                               6,10,70);
        usageForm.addTextField("reading","Current Reading",getDecimalInstance(1),
                               6,10,100);
        
    };  // setUpForm
    
    
    private void fillForm ( Account anAcct ) {
        
        usageForm.writeString("acctNum",anAcct.getAcctNum());
        usageForm.writeString("name",anAcct.getName());
        usageForm.writeDouble("prev",anAcct.getPrevReading());
        usageForm.clear("reading");
        
    };  // fillForm
    
    
    public static void main ( String[] args ) { Update u = new Update(); };
    
    
}  // Update