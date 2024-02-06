package basicIOrefresher;

import BasicIO.*;


/**
 * A minimal and a complete example that shows how to use ReportPrinter.
 * It allows the user to create a .pdf file. First, you need to select to print to a pdf.
 * After the completion of running the program, you will be shown a dialog to save the 
 * pdf file by giving it a name.
 * Note, don't override previously created files. Save the first file as output1.pdf,
 * then the next time you run it, save it as output2.pdf, then output3.pdf, etc.
 * 
 * @author Maysara Al Jumaily
 * @since  November 21, 2020
 * 
 */
public class ReportPrinterTest {
  private ReportPrinter report;//allows us to create a pdf file. 
  
  public ReportPrinterTest() {
    //will allow us to select where to print it.
    //Select printing to pdf.
    report = new ReportPrinter();
    //To make it easier, we have three columns
    //we will refer to them as left, middle, right.
    //We will add these columns by calling the setupReport() method.
    setupReport();
    //we will now insert data in the table we created.
    //Assume the left, middle, right accepts String, int, int, respectively.
    writeDetail("First Row" , 1, -1);
    writeDetail("Second Row", 2, -2);
    writeDetail("Third Row" , 3, -3);
    //IMPORTANT to close this now! If you don't, you cannot create the .pdf file.
    report.close();//IMPORTANT to close it!
  }
  
  /*
   * Inserts a two-lined title on the pdf. Adds columns to the pdf. 
   * Adds columns them starting from the left side and continues inserting to right.
   * 
   */
  private void setupReport(){
    report.setTitle("Main title", "Second Title");
    //Notation: report.addField("uniqueColName", "Column title", width);
    report.addField("left"  , "Left Column"  , 15);
    report.addField("middle", "Middle Column", 15);
    report.addField("right" , "Right Column" , 15);
  }
  
  /*
   * Inserts a row in the table created.
   * IMPORTANT, you MUST insert left to right. So, first, insert at the 
   * left column, then middle one, then the right.
   * 
   * @param leftValue   the value to be inserted in the left   column
   * @param middleValue the value to be inserted in the middle column
   * @param rightValue  the value to be inserted in the right  column
   */
  private void writeDetail(String leftValue, int middleValue, int rightValue){
    //Notation: report.writeString("uniqueColName", stringValue);
    //Notation: report.writeInt("uniqueColName", intValue);
    report.writeString("left"  , leftValue);
    report.writeInt   ("middle", middleValue);
    report.writeInt   ("right" , rightValue);
  }
  
  public static void main(String[] args) { 
    ReportPrinterTest t = new ReportPrinterTest();
  }
}