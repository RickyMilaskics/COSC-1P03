package Billing;

import BasicIO.ASCIIDataFile;
import BasicIO.ASCIIOutputFile;

public class Account {
    private String accountNumber;
    private String accountName;
    private Double prevReading;
    private Double currReading;
    public Account(ASCIIDataFile from){
        accountNumber = from.readString();
        accountName = from.readString();
        prevReading = from.readDouble();
        currReading = from.readDouble();

    }
    public void takeReading(Double reading){
        prevReading = currReading;
        currReading = reading;
    }
    public void write(ASCIIOutputFile to) {
        to.writeString(accountNumber);
        to.writeString("\t");
        to.writeString(accountName);
        to.writeString("\t");
        to.writeDouble(prevReading);
        to.writeString("\t");
        to.writeDouble(currReading);
        to.writeString("\t");
        to.writeDouble(billForUsage());
        to.newLine();
    }
    public double billForUsage(){
        return (currReading-prevReading)*1.25;
    }
    public Double getCurrReading() {
        return currReading;
    }

    public Double getPrevReading() {
        return prevReading;
    }

    public String getName() {
        return accountName;
    }

    public String getAcctNum() {
        return accountNumber;
    }

    public static void main(String[] args) {
        Account t = new Account(new ASCIIDataFile());
    }
}
