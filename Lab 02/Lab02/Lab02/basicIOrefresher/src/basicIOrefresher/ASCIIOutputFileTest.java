package basicIOrefresher;

import BasicIO.*;


/**
 * A minimal and a complete example that shows how to use ASCIIOutputFile.
 * It allows the user to create and write to a .txt file.
 * Make sure to add .txt extension when create the file.
 * 
 * @author Maysara Al Jumaily
 * @since  November 21, 2020
 * 
 */
public class ASCIIOutputFileTest {
  private ASCIIOutputFile file;// allows the user to create and write to a .txt file.
  
  public ASCIIOutputFileTest() { 
    file = new ASCIIOutputFile();//will allow us to select a .txt file
    //To make it easier, we will create 3 columns
    //we will refer to them as left, middle, right
    //left is String, middle is int, right is int
    //NOTE! We will not create columns/table here, we just write to file.
    //We don't have columns to refer to here.
    
    writeInvData("Top line", 0, 1);//write first line in .txt file 
    writeInvData("middle line", 2, 3);//write second line in .txt file
    writeInvData("right line", 4, 5);//write third line in .txt file
    
    file.close();//important to close it!
  }
  
  /*
   * Inserts a row in the file. A tab will be automatically placed between
   * cells.
   * IMPORTANT, you MUST insert left to right. So, first, insert at the 
   * left column, then middle one, then the right.
   * 
   * @param leftValue   the value to be inserted in the left   column
   * @param middleValue the value to be inserted in the middle column
   * @param rightValue  the value to be inserted in the right  column
   */
  private void writeInvData(String left, int middle, int right){
    file.writeString(left);
    file.writeInt(middle);
    file.writeInt(right);
    file.newLine();//jumps to next line.
  }
  public static void main(String[] args) { 
    ASCIIOutputFileTest t = new ASCIIOutputFileTest();
  }
}