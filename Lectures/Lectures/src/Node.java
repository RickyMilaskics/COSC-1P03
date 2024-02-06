public class Node {
    int item;
    Node next;
    public Node(int number, Node point){
        item = number;
        next = point;
    }
    public int item(){
        return item;
    }
    public Node next(){
        return next;
    }
}
