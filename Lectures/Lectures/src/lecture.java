public class lecture {
    Node counter;
    public lecture(){
        Node hi = new Node(5,null);
        counter = countDown(10);
        printNodes(counter);
    }
    public Node countDown(int number){
        Node result = new Node(0,null);
        Node temp;
        for(int i =1;i<number;i++){
            temp = new Node(i,result);
            result = temp;
        }
        return result;
    }
    public void printNodes(Node input){
        while(input != null){
            System.out.println(input.item);
            input = input.next;
        }
    }

    public static void main(String[] args) {
        lecture t = new lecture();
    }
}
