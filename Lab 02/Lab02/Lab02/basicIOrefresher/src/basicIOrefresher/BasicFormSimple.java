package basicIOrefresher;

import BasicIO.*;

/**
 * Shows how to read a button press from BasicForm.
 * We will have three buttons and when you click on one,
 * a message will be written on the console saying which
 * button was clicked.
 * 
 * NOTE, make the form dialog box a little bit larger 
 * (i.e., maximize the size of the window). 
 * 
 * @author Maysara Al Jumaily
 * @since  November 21, 2020
 * 
 */
public class BasicFormSimple {
  
  private BasicForm form;//the form to create
  
  /** The constructor creates and displays */
  
  public BasicFormSimple ( ) {
    //create a simple form with three buttons
    form = new BasicForm("Left", "Middle", "Right/Quit");
    int button;//reads which button the user has clicked.
    //if button is 0, then user clicked "Left"
    //if button is 1, then user clicked "Middle"
    //if button is 2, then user clicked "Right/Quit"
    buildForm();
    while(true){
      button = form.accept();//wait for user to press a button, and 
      //store the value (0, 1, 2) in button variable. We have 0, 1, 2 
      //as the options since we have three buttons. If we have four 
      //buttons, we would have the options 0, 1, 2, 3.
      if(button == 0){
        System.out.println("Left button pressed!");
      }else if(button == 1){
        System.out.println("Middle button pressed!");
      }else if(button == 2){
        System.out.println("Right/Quit button pressed!");
        break;//breaks out of the while true.
      }
    }
    
    form.close();
  }
  
  /*
   * Builds the form by setting the title. We can add more components
   * such as textfield, radiobuttons, etc... You can see a more complete
   * example if you check BasicFormComplete.java file.
   */
  private void buildForm(){
    form.setTitle("Testing BasicForm");
    //we can more components here such as textfield, radiobuttons, etc...
  }
  
  public static void main ( String[] args ){ 
    BasicFormSimple c = new BasicFormSimple(); 
  }
}
