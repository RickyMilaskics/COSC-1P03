package Billing;


import BasicIO.*;
import static BasicIO.Formats.*;


public class Update {
    public ASCIIOutputFile outputFile;
    public ASCIIDataFile inputFile;
    Account accounts[];
    private int lastIndex;
    /* Instance Variables */
    private BasicForm        usageForm;  // meter reading form
    public Account acct;
    
    public Update ( ) {
        inputFile = new ASCIIDataFile();
        outputFile = new ASCIIOutputFile();
        accounts = new Account[1000];
        lastIndex = 0;
        loadAccts();
        setUpForm();
        while(usageForm.accept() == 0){
            acct = findAcct(usageForm.readString("acctNum"));
            fillForm(acct);
            usageForm.accept("update","quit");
            acct.takeReading(usageForm.readDouble("reading"));

        };

        writeAccts();
        
    };  // construtor
    
    
    private void loadAccts ( ) {
        int i = 0;
        while(true){
            if(inputFile.isEOF()){break;}
            Account account = new Account(inputFile);
            accounts[lastIndex] = account;
            lastIndex++;

        }
        
    };  // loadAccts
    
    
    private void writeAccts ( ) {
        for(int i =0;i<lastIndex-1;i++){
            accounts[i].write(outputFile);
        }
        
    };  // writeAccts
    
    
    private Account findAcct ( String acctNum ) {
        int i =0;
        String currentAccount;
        while(true){
            currentAccount = accounts[i].getAcctNum();
            if(currentAccount.equals(acctNum)){
                return accounts[i];
            }
            i++;
            if(i==999){
                break;
            }
        }
        return null;
        
    };  // findAcct

    
    private void setUpForm ( ) {
        usageForm = new BasicForm("find","quit");
        usageForm.setTitle("Over The Horizon Utilities");
        usageForm.addTextField("acctNum","Account #",
                               6,10,10);
        usageForm.addTextField("name","Name",20,10,40);
        usageForm.addTextField("prev","Previous Reading",
                               6,10,70);
        usageForm.addTextField("reading","Current Reading",
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