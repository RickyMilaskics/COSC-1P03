//Ricky Milaskics
//7752041
import BasicIO.ASCIIDataFile;
import Media.Turtle;
import Media.TurtleDisplayer;


public class Homework1 {
    Turtle yertle;
    TurtleDisplayer displayer;
    ASCIIDataFile essay;
    ASCIIDataFile stopWords;
    String[] wordList;
    String[] stopList;
    int[] wordAmounts;
    public Homework1(){
        essay = new ASCIIDataFile();
        stopWords = new ASCIIDataFile();
        String[] uniqueWordList;

        //get the word amounts
        wordList = wordArray(essay); // convert into array of words
        stopList = wordArray(stopWords); // convert into array of words

        wordList = removeStop(stopList, wordList); // removes the stop words
        wordList = removeNull(wordList); // removes the "" in the array
        uniqueWordList = uniqueArray(wordList);
        wordAmounts = wordCount(uniqueWordList, wordList);
        printDuoArray(uniqueWordList, wordAmounts); // prints how many of each word is in the essay

        //get word length amounts in an array
        int[] wordLengths = getWordLengths(wordList);
        //print out the list of wordLength amounts (to check if graph is correct)
        for(int i =0; i<wordLengths.length; i++){
            System.out.println(i+": "+wordLengths[i]);
        }
        //find the largest number to scale the displayer
        int largestNumber = findLargest(wordLengths);
        //turtle making graph part
        int y = (largestNumber*10)+20; //scale with the size of any inputs with a small gap on top
        int x = wordLengths.length*20; //scale with the size of any inputs
        yertle = new Turtle(0);
        displayer = new TurtleDisplayer(yertle, x, y);

        //put yertle in the very bottom left
        yertle.backward((x)/2);
        yertle.right(Math.PI/2);
        yertle.forward(y/2);
        yertle.left(Math.PI/2);
        yertle.penDown();

        //make the graph
        graphMaker(wordLengths);
        System.out.println(wordLengths.length);
        displayer.close();
    }
    public String[] wordArray(ASCIIDataFile file){ // This is a function that will take in a txt file and return an array with all the words seperated into their own cell
        String words;
        String essay = "";
        while(true){
            words = file.readString();
            if (file.isEOF() ) break;
            essay =  essay + " " + words; // add a space in betweeen so the split function can work between lines
        }
        String[] arrayOfWords = essay.split(" ");
        arrayOfWords = removeSpecial(arrayOfWords);
        return arrayOfWords;
    }
    public String[] removeSpecial(String[] array){ // remove any special characters in the array
        for(int i =0; i < array.length; i++){ //loop through all the words in the array
            array[i] = specialCheck(array[i]);
        }
        return array;
    }
    public String specialCheck(String word) { // remove any special characters in a string and return it
        String[] specialCharacters = {".",",",";",":","!","?","-","'"}; // array of special characters, so I can just loop the following statements and if I want to add more its VERY easy
        for(int i =0; i<specialCharacters.length; i++) {
            word = word.replace(specialCharacters[i], ""); // replace them with nothing as to delete them
        }
        return word;
    }
    public void printArray(String[] array){ // simple print array function so I can see what going on in my arrays when needed
        for(int i =0; i<array.length; i++){
            System.out.println(array[i]);
        }
    }
    public String[] removeStop(String[] stopList, String[] essay){ //function that removes words from one string array to another one
        for(int j = 0; j<essay.length; j++) {
            for (int i = 0; i < stopList.length; i++) {
                if(essay[j].toLowerCase().equals(stopList[i])){
                    essay[j] = "";
                }
            }
        }
        return essay;
    }
    public String[] removeNull(String[] array){ //removes all "" in the array
        int added = 0;
        int arrayAmount;
        String[] newArray = new String[1000]; // make a big empty array first
        for(int i =0; i<array.length; i++){
            if(array[i].isEmpty()){
            }
            else{
                newArray[added] = array[i];
                added++;
            }
        }
        newArray[added] = ""; //marks the end of the array for me
        int index = 0;
        while(true){ //find out how many words are in the list
            if(newArray[index].isEmpty()){
                arrayAmount = index;
                break;
            }
            index++;
        }
        String[] finishedArray = new String[arrayAmount];
        for(int j = 0; j<arrayAmount; j++){ //adds the words into the list
            finishedArray[j] = newArray[j];
        }
        return finishedArray;

    }
    public boolean isIn(String[] array, String s){ //function to check if a string is in a string array
        for(int i = 0; i<array.length; i++){
            if(array[i].equalsIgnoreCase(s)){
                return true;
            }
        }
        return false;
    }
    public String[] uniqueArray(String[] array){ //returns an array of the unique words in the array
        String[] tempArray = new String[array.length];
        tempArray = fillArray(tempArray);
        int index = 0;
        for(int i = 0; i<array.length; i++){ //puts words from an array into another but only once so no duplicates
            if(!isIn(tempArray, array[i])){
                tempArray[index] = array[i];
                index++;
            }
        }
        return removeNull(tempArray);
    }
    public String[] fillArray(String[] array){ //fills the array with empty strings to prevent the null pointer error
        for(int i =0; i<array.length; i++){
            array[i] = "";
        }
        return array;
    }
    public int[] wordCount(String[] uniqueArray, String[] wordList){ //makes the list of how many of one unique word there is an a string array
        int index;
        int[] wordAmount = new int[uniqueArray.length];
        for(int i = 0; i<wordList.length; i++){
            index = searchElement(uniqueArray, wordList[i]);
            wordAmount[index]++;
        }
        return wordAmount;
    }
    public int searchElement(String[] array, String s){ //finds where an element is in an array
        for(int i =0;i<array.length; i++){
            if(array[i].equalsIgnoreCase(s)){
                return i;
            }
        }
        return 0; //this should never happen
    }
    public void printDuoArray(String[] array, int[] count){ //makes it so I can print two different array types together on the same line easily
        for(int i =0;i<array.length; i++){
            System.out.println(array[i]+": "+ count[i]);
        }
    }
    public int[] getWordLengths(String[] array){ //gets all the word lengths in a string array
        int largestWordLength = getLargestWord(array);
        int[] lengthArray = new int[largestWordLength+1];
        for(int i=0; i<array.length; i++){
            lengthArray[array[i].length()]++; //adds one to the slot of the word length
        }
        return lengthArray;
    }
    public int getLargestWord(String[] array){ //finds the largest string in a string array
        int largest = 0;
        for(int i = 0;i< array.length; i++){
            if(array[i].length() > largest){
                largest = array[i].length();
            }
        }
        return largest;
    }
    public void graphMaker(int[] wordAmounts){ //makes a graph with yertle
        for(int i = 0;i<wordAmounts.length; i++){
            yertle.left(Math.PI/2);
            yertle.forward(10*wordAmounts[i]);
            yertle.right(Math.PI/2);
            yertle.forward(20);
            yertle.right(Math.PI/2);
            yertle.forward(10*wordAmounts[i]);
            yertle.left(Math.PI/2);

        }
    }
    public int findLargest(int[] array){ //finds the largest number in an int array
        int largest = 0;
        for(int i =0; i<array.length; i++){
            if(array[i] > largest){
                largest = array[i];
            }
        }
        return largest;
    }

    public static void main(String[] args) {Homework1 t = new Homework1();}
}