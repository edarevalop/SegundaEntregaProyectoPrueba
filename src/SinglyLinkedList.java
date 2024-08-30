
    class Node<T> {
        T key;
        Node<T> next;

        public Node(T key) {
            this.key = key;
            this.next = null;
        }
    }
class SinglyLinkedList<T> {



    Node<T> head = null;
    Node<T> tail = null;

    public void pushFront(T key) {
        Node<T> newNode = new Node<>(key);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public T topFront() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        return head.key;
    }
    
    public Node<T> topFrontNode() {
            if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        return head;
    }
    
    public void popFront() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }

        head = head.next;

        if (head == null) {
            tail = null;
        }
    }
    
    public void popAll() {
        head = null;
    }

    public void pushBack(T key) {
        Node<T> newNode = new Node<>(key);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public T topBack() {
        if (tail == null) {
            throw new IllegalStateException("List is empty");
        }
        return tail.key;
    }

    public void popBack() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }

        if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        Node<T> current = head;
        Node<T> previous = null;

        while (current.next != null) {
            previous = current;
            current = current.next;
        }

        previous.next = null;
        tail = previous;
    }

    public boolean find(T key) {
        Node<T> current = head;

        while (current != null) {
            if (current.key.equals(key)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public boolean findByName(String nombre) {
        Node<T> current = head;

        while (current != null) {
            if (current.key instanceof nota) {
                nota currentNota = (nota) current.key;

                if (currentNota.getNombre().equals(nombre)) {
                    return true;
                }
            }
            current = current.next;
        }
        return false;
    }

    public void erase(T key) {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }

        if (head.key.equals(key)) {
            head = head.next;
            return;
        }

        Node<T> current = head;
        Node<T> previous = null;

        while (current != null) {
            if (current.key.equals(key)) {
                previous.next = current.next;
                return;
            }
            previous = current;
            current = current.next;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addBefore(T key, T newKey) {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }

        if (head.key.equals(key)) {
            Node<T> newNode = new Node<>(newKey);
            newNode.next = head;
            head = newNode;
            return;
        }

        Node<T> current = head;
        Node<T> previous = null;

        while (current != null) {
            if (current.key.equals(key)) {
                Node<T> newNode = new Node<>(newKey);
                previous.next = newNode;
                newNode.next = current;
                return;
            }
            previous = current;
            current = current.next;
        }

        throw new IllegalArgumentException("Key not found in the list");
    }

    public void addAfter(T key, T newKey) {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }

        Node<T> current = head;

        while (current != null) {
            if (current.key.equals(key)) {
                Node<T> newNode = new Node<>(newKey);
                newNode.next = current.next;
                current.next = newNode;
                return;
            }
            current = current.next;
        }

        throw new IllegalArgumentException("Key not found in the list");
    }

    public void display() {
        Node<T> current = head;

        if (current == null) {
            System.out.println("List is empty");
            return;
        }

        System.out.print("Nodes of singly linked list: ");
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (current.next != null) {
            sb.append(current.key + ", ");
            current = current.next;
        }

        sb.append(current.key);
        sb.append("]");
        System.out.println(sb);
    }

    public String displayT() {
        Node<T> current = head;
        String lista = "";

        if (current == null) {
            lista = "List is empty";
            return lista;
        }

        //System.out.print("[");
        while (current.next != null) {
            lista += current.key.toString() + "\n";
            //System.out.print(current.key.toString() + ", \n");
            current = current.next;
        }
        lista += current.key.toString() + "\n";
        return lista;
        
        //System.out.println(current.key.toString() + "]");
    }

    
}
