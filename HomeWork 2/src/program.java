import BasicIO.ASCIIDataFile;

public class program {
    ASCIIDataFile file;
    Node head;
    Node tail;
    public program(){
        file =  new ASCIIDataFile();
        doubleList(file);



    }
    public void doubleList(ASCIIDataFile f){
        head = new Node(null, f.readString(), null);
        String read;
        while(true) {
            if (f.isEOF()) {break;}
            read = f.readString();

        }
    }

    public static void main(String[] args) {
        program p = new program();
    }
}
