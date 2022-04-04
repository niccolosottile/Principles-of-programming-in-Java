package question_3;

public class SortedLinkedList implements SortedList {

    private Node head = new Node("head");

    private boolean descendingOrder = false;

    @Override
    public int size() {

        int size = 0;

        Node curr = this.head;

        while(curr.getNext() != null){
            size += 1;
            curr = curr.getNext();
        }

        return size;
    }

    @Override
    public void add(String string) {

        // If string is not alphabetical, don't add
        if(!string.matches("[a-zA-Z]+")){
            return;
        }

        // If string is already present, don't add
        Node curr = this.head;

        while(curr.getNext() != null){
            if(curr.getString().equalsIgnoreCase(string)){
                return;
            }

            curr = curr.getNext();
        }

        // Add node to the doubly linked list
        Node prev = curr;
        Node new_node = new Node(prev, string);
        prev.setNext(new_node);

        // Order depending on alphabetical order
        if(descendingOrder){
            orderDescending();
        } else{
            orderAscending();
        }  
    }

    @Override
    public void add(Node node) {
        // If string is not alphabetical, don't add
        if(!node.getString().matches("[a-zA-Z]+")){
            return;
        }

        // If string is already present, don't add
        Node curr = this.head;

        while(curr.getNext() != null){
            if(curr.getString().equalsIgnoreCase(node.getString())){
                return;
            }

            curr = curr.getNext();
        }

        // Add node to the doubly linked list
        Node prev = curr;
        node.setPrev(prev);
        prev.setNext(node);

        // Order depending on alphabetical order
        if(descendingOrder){
            orderDescending();
        } else{
            orderAscending();
        }
    }

    @Override
    public Node getFirst() {
        // Return the first node of the doubly linked list
        return this.head.getNext();
    }

    @Override
    public Node getLast() {
        // Return the last node of the doubly linked list
        Node curr = this.head;

        while(curr.getNext() != null){
            curr = curr.getNext();
        }

        return curr;
    }

    @Override
    public Node get(int index) {
        // If index is less than 0 or bigger than size - 1, return null
        if(index < 0 || index > (size() - 1)){
            return null;
        }

        // Return the node of the doubly linked list at the specified index
        Node curr = this.head;
        int count = -1; // head index is -1

        while(curr.getNext() != null){
            // If counter is equal to index, break
            if(count == index){
                break;
            }

            curr = curr.getNext();
            count++;
        }
    
        return curr;
    }

    @Override
    public boolean isPresent(String string) {
        // Check if a node with the given string is present in the doubly linked list
        Node curr = this.head;

        while(curr.getNext() != null){
            if(curr.getString().equalsIgnoreCase(string)){
                return true;
            }

            curr = curr.getNext();
        }

        return false;
    }

    @Override
    public boolean removeFirst() {
        // Remove first node in the doubly linked list (checking for size)
        if(size() == 0){
            return false;
        } else{
            Node next = this.head.getNext().getNext();
            this.head.setNext(next);
        }
        return true;
    }

    @Override
    public boolean removeLast() {
        // Remove the last node in the doubly linked list
        if(size() == 0){
            return false;
        }

        Node curr = this.head;

        while(curr.getNext() != null){
            curr = curr.getNext();
        }

        Node prev = curr.getPrev();
        prev.setNext(null);
        return true;
    }

    @Override
    public boolean remove(int index) {
        // If index is less than 0 or bigger than size - 1, return false
        if(index < 0 || index > (size() - 1)){
            return false;
        }

        // Remove the node in the doubly linked list at the specified index
        Node curr = this.head;
        int count = -1; // head index is -1

        while(curr.getNext() != null){
            // If counter is equal to index, remove it
            if(count == index){
                Node prev = curr.getPrev();
                Node next = curr.getNext();

                prev.setNext(next);
                next.setPrev(prev);

                break;
            }

            curr = curr.getNext();
            count++;
        }
        return true;
    }

    @Override
    public boolean remove(String string) {
        // If string is found in the doubly linked list, remove it
        Node curr = this.head;

        while(curr.getNext() != null){
            if(curr.getString().equalsIgnoreCase(string)){
                Node prev = curr.getPrev();
                Node next = curr.getNext();

                prev.setNext(next);
                next.setPrev(prev);

                return true;
            }

            curr = curr.getNext();
        }

        return false;
    }

    @Override
    public void orderAscending() {
        // Nothing to sort if there's only one node
        if(size() == 1){
            return;
        }

        // Set flag to ascending order
        descendingOrder = false;

        // Order the doubly linked list in ascending alphabetical order
        // Continue sorting while a change has been made
        Node prev, curr, next;
        boolean sorted;

        do{
            prev = null;
            curr = this.head;
            next = curr.getNext();

            sorted = false;

            while(curr.getNext() != null){

                // Skip at head
                if(!curr.getString().equalsIgnoreCase("head")){
                    // If curr is bigger than next, switch them
                    if(curr.getString().compareToIgnoreCase(next.getString()) > 0){

                        // Prev points to next, next back to prev
                        prev.setNext(next);
                        next.setPrev(prev);

                        // Next points to curr, curr back to next
                        next.setNext(curr);
                        curr.setPrev(next);

                        sorted = true;
                    }
                }

                prev = curr;
                curr = next;
                next = next.getNext();

            }
        } while(sorted);
    }

    @Override
    public void orderDescending() {
        // Nothing to sort if there's only one node
        if(size() == 1){
            return;
        }

        // Set flag to descending order
        descendingOrder = true;

        // Order the doubly linked list in ascending alphabetical order
        // Continue sorting while a change has been made
        Node prev, curr, next;
        boolean sorted;

        do{
            prev = null;
            curr = this.head;
            next = curr.getNext();

            sorted = false;

            while(curr.getNext() != null){

                // Skip at head
                if(!curr.getString().equalsIgnoreCase("head")){
                    // If curr is smaller than next, switch them
                    if(curr.getString().compareToIgnoreCase(next.getString()) < 0){

                        // Prev points to next, next back to prev
                        prev.setNext(next);
                        next.setPrev(prev);

                        // Next points to curr, curr back to next
                        next.setNext(curr);
                        curr.setPrev(next);

                        sorted = true;
                    }
                }

                prev = curr;
                curr = next;
                next = next.getNext();

            }
        } while(sorted);
    }

    @Override
    public void print() {
        // Print each string in the doubly linked list in a line
        Node curr = this.head;

        while(curr.getNext() != null){

            if(!curr.getString().equalsIgnoreCase("head")){
                System.out.println(curr.getString());
            }

            curr = curr.getNext();
        }

        System.out.println(curr.getString());
    }

    public static void main(String[] args) {

        SortedLinkedList testing = new SortedLinkedList();

        testing.add("Alpha");
        testing.add("Bravo");

        Node charlie = new Node("Charlie");
        testing.add(charlie);

        testing.print();

        System.out.println(testing.size());

    }
    
}