// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


public class CopyListWithRandom {

    // TC : O(n) n - number of nodes in a linked list
    // SC : O(1)
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        // Step 1 - Create deep copy
        Node curr = head;
        while(curr != null) {
            Node copyCurr = new Node(curr.val);
            copyCurr.next = curr.next;
            curr.next = copyCurr;
            curr = curr.next.next;
        }

        // Step 2 - Take care of random pointer
        curr = head;
        while(curr != null) {
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3 - Split the two nodes
        curr = head;
        Node copyHead = head.next;
        Node copyCurr = curr.next;

        while(true) {
            curr.next = copyCurr.next;
            if(copyCurr.next == null) break;
            copyCurr.next = copyCurr.next.next;

            curr = curr.next;
            copyCurr = copyCurr.next;
        }


        return copyHead;
    }
}
