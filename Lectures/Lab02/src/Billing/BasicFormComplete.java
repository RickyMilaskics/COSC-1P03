package Billing;

import BasicIO.*;

/**
 * Shows how to read a button press from BasicForm,
 * how to populate the form as well as read/write to the
 * components added.
 * 
 * @author Maysara Al Jumaily
 * @since  December 4, 2020
 * 
 */
public class BasicFormComplete {
  
  private BasicForm form;//the form to create
  
  /** The constructor creates and displays the form*/
  
  public BasicFormComplete ( ) {
    //create a simple form with three buttons
    form = new BasicForm("Read", "Write", "Exit");
    int button;//reads which button the user has clicked.
    //if button is 0 then "Read" click, 1 then "Write" clicked, 2 then "Exit" clicked 
    
    buildForm();//populate the form with components.
    
    while(true){
      button = form.accept();//wait for user to press a button (could be 0, 1 or 2).
      if(button == 0){
        readForm();
      }else if(button == 1){
        writeToForm();
      }else if(button == 2){
        break;
      }
    }
    
    form.close();
  }
  
  /*
   * Builds the form by setting the title. We can add more components
   * such as textfield, radiobuttons, etc... Here, we only added textboxes.
   * Also, we ensured that the top textbox is read-only and the middle
   * and bottom textboxes can be read/written from.
   */
  private void buildForm(){
    form.setTitle("Testing BasicForm");
    //REMEMBER: Top left of the screen is the (0, 0) coordinates. It is (x, y).
    //Adding a textfield:
    //Notation: form.addTextField("textFieldName", "Textfield Label", width, x, y);
    //where: 
    //"textFieldName" is unique, case-sensitive, with no spaces,
    //"Textfield Label" is the label to the left of the textbox (can be anything),
    //width is the width of the textbox, the bigger the value, the longer the box,
    //x is the x-coordinate on the form,
    //y is the y-coordinate on the form.
    //NOTE! the top left of the canvas is the coordinate (0, 0).
    form.addTextField("top"   , "Top Textbox"   , 10, 20, 20);
    form.addTextField("middle", "Middle Textbox", 5 , 20, 50);
    form.addTextField("bottom", "Bottom Textbox", 5 , 20, 80);
    
    //Changing which text boxes can be read-only or can be written/read from.
    form.setEditable("top", false);
    form.setEditable("middle", true);
    form.setEditable("bottom", true);
    
  }
  
  /**
   * Reads from the form and prints the values as ints first and then as doubles. 
   */
  private void readForm(){
    int topInt    = form.readInt("top");
    int middleInt = form.readInt("middle");
    int bottomInt = form.readInt("bottom");
    System.out.println("----------Reading textfields as ints--------------");
    System.out.println("top textfield as int: "    + topInt);
    System.out.println("middle textfield as int: " + middleInt);
    System.out.println("bottom textfield as int: " + bottomInt);
    
    //Now, we read as double
    double topDouble    = form.readDouble("top");
    double middleDouble = form.readDouble("middle");
    double bottomDouble = form.readDouble("bottom");
    System.out.println("----------Reading textfields as doubles--------------");
    System.out.println("top textfield as double: "    + topDouble);
    System.out.println("middle textfield as double: " + middleDouble);
    System.out.println("bottom textfield as double: " + bottomDouble);
    
    //You can read as String as well:
    String s = form.readString("top");
    //You can read as boolen as well:
    boolean b = form.readBoolean("top");
  }
  
  /**
   * Shows how to write to a specific component. It will write
   * a String to the top textbox, an int to the middle textbox and
   * a double to the bottom textbox.
   */
  private void writeToForm(){
    System.out.println("----------The textboxes have been populated--------------");
    form.writeString("top", "Hello");
    form.writeInt("middle", 5);
    form.writeDouble("bottom", 7.31);
  }
  
  
  public static void main ( String[] args ){ 
    BasicFormComplete c = new BasicFormComplete(); 
  }
}
