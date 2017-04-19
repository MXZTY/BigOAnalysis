public class Bucket {
        private Node head;
        private int size = 0;

        public boolean add(String data) {
            if (this.head == null) {
                Node head = new Node(data, null);
                this.size++;
                this.head = head;
                return true;
            } else if(this.head.data.compareTo(data) == 0) {
                return false;
            } else if (this.head.data.compareTo(data) > 0) {
                Node newHead = new Node(data, this.head);
                this.head = newHead;
                this.size ++;
                return true;
            } else {
                boolean added = add(data, head.next, head);
                return added;
            }
        }

        public boolean add(String data, Node current, Node prev) {
            if (current != null){
                if (data.compareTo(current.data) == 0) {
                    return false;
                } else if (data.compareTo(current.data) < 0) {
                    Node newNode = new Node(data, current);
                    prev.next = newNode;
                    this.size ++;
                    return true;
                } else {
                    boolean added = add(data, current.next, current);
                    return added;
                }
            } else {
                Node newNode = new Node(data, null);
                prev.next = newNode;
                this.size ++;
                return true;
            }
        }

        public boolean remove(String data) {
            if (this.head == null) {
                return false;
            } else if (this.head.data.compareTo(data) == 0) {
                this.head = this.head.next;
                this.size--;
                return true;
            } else {
                boolean removed = remove(data, head.next, head);
                return removed;
            }
        }
        public boolean remove(String data, Node current, Node prev) {
            if (current != null) {
                if (current.data.compareTo(data) == 0) {
                    if (current.next != null){
                        prev.next = current.next;
                        this.size--;
                        return true;
                    } else {
                        prev.next = null;
                        this.size--;
                        return true;
                    }
                } else if (current.data.compareTo(data) > 0) {
                    return false;
                } else {
                    boolean removed = remove(data, current.next, current);
                    return removed;
                }
            } else {
                return false;
            }
        }

        public boolean find(String data) {
            boolean found = false;
             if (head == null){
                 return found;
             } else {
                 found = find(head, data);
             }

             return found;
         }

         public boolean find(Node current, String data) {
             if (current == null) {
                 return false;
             } else if (current.data.compareTo(data) == 0) {
                 return true;
             } else if (current.data.compareTo(data) > 0) {
                 return false;
                 //will not be in list as it is greater than currents data.
             } else {
                 boolean found = find(current.next, data);
                 return found;
             }
         }

         public void printIt(){
             Node node = this.head;
             while(node != null) {
                 System.out.println(node.data + " ");
                 node = node.next;
             }
         }






    private class Node {
        private String data;
        private Node next;
        public Node() {}
        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }
    }






    public int getsize() {

        return this.size;
    }

}
