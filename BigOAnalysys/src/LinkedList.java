/**
 * This is my linked list implementation of the CreditCardDatabase by Jason Heard.
 * @author Austin Arndt.
 *
 */
public class LinkedList {
    private Node head = null;
    private int size = 0;

    public void add(String value) {
        Node newHead;
        if (head == null) {
            head = new Node(value);
            size++;
        } else if (value.compareTo(head.getValue()) < 0) {
            Node temp = head;
            newHead = new Node(value, head);
            head = newHead;
            size++;
        } else {
            Node prev = head;
            boolean done = false;
            while (!done) {
                Node curr = prev.getNext();
                if (curr != null && value.compareTo(curr.getValue()) == 0) {
                    //do not
                } else if (curr == null || value.compareTo(curr.getValue()) > 0) {
                    newHead = new Node(value, curr);
                    prev.setNext(newHead);
                    size++;
                    done = true;
                } else {
                    prev = prev.getNext();
                }
            }
        }
    }


    public boolean delete(String value) {
        Node prev = head;
        boolean found = false;
        if (head == null || size <= 0) {
            found = false;
        } else if (size == 1) {
            prev = null;
            size = 0;
            found = true;
        } else {
            Node curr = head;
            while (!found && curr.getNext() != null ) {
                if (value.compareTo(curr.getValue()) == 0) {
                    found = true;
                } else {
                    prev = curr;
                    curr = curr.getNext();
                    if (curr.getNext() == null && value.compareTo(curr.getValue()) == 0) {
                        found = true;
                    }
                }
            }
            Node toRemove = curr;
            if (toRemove != prev) {
                prev.setNext(toRemove.getNext());
                size--;
            } else {
                head = prev.getNext();
                size--;
            }
        }
        return found;
    }




    /**
     * This method can be used to find an account based on its account number.
     *
     * @param accountNumber the account number wanted.
     * @return the node requested.
     * @throws Exception General exception.
     */
    public Node find( String value)  {
        Node curr = head;

        if (curr == null) {
            //do not
        }
        for (int i = 0; i <= (size - 1); i++) {

            if (value.compareTo(curr.getValue()) == 0) {
                return curr;
            } else if (curr.getNext() != null) {
                curr = curr.getNext();
            }
        }
        return head;
    }

    public void printAll() {
        Node curr = head;
        while (curr != null) {
            System.out.println(curr.getValue());
            curr = curr.getNext();
        }

    }

    /**
     * This is an inner class to create a new node account for the link list.
     * @author Austin Arndt.
     *
     */
    private static class Node {
        /**The Account number.*/
        private String value;
        private Node next;

        /**
         * This creates a node with the next set to null.
         *
         * @param creditNum is a long representing the account number.
         * @param creditLimit is a double representing the limit to credit.
         * @param creditBalance is the account balance.
         */
        public Node(String value) {
            this.value = value;
            this.setNext(null);
        }

        /**
         * This is a constructor for a node with a next value.
         *
         * @param creditNum is a long representing the account number.
         * @param creditLimit is a double representing the limit to credit.
         * @param creditBalance is the account balance.
         * @param next which node to point to.
         */
        public Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }

        /**
         * Retrieves the account number.
         * @return credit account number.
         */
        public String getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setValue(String value) {
            this.value = value;
        }


    }
}