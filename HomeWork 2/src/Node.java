public class Node {
    Node prev;
    String s;
    Node next;
    public Node(Node prevs, String ss, Node nexts){
        s = ss;
        prev = prevs;
        next = nexts;
    }
    public String item(){
        return s;
    }
    public Node prev(){
        return prev;
    }
    public Node next(){
        return next;
    }
}
