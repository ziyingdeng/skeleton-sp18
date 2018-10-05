public class LinkedListDeque<T> implements Deque<T> {
    public static class Node<T>{
        public T items;
        public Node<T> next;
        public Node<T> prev;

        public Node(Node<T> p,Node<T> n){
            next = n;
            prev = p;
        }

        public Node(T i,Node<T> n,Node<T> p){
            items = i;
            next = n;
            prev = p;
        }
    }

    private Node<T> sentialFront;
    private Node<T> sentialLast;
    private int size;

    public LinkedListDeque(){
        sentialLast = new Node<>(null,null);
        sentialFront = new Node<>(null,sentialLast);
        sentialLast.prev = sentialFront;
        size = 0;
    }

    @Override
    public void addFirst(T item){
        Node<T> temp = new Node<>(item,sentialFront.next,sentialFront);
        sentialFront.next.prev = temp;
        sentialFront.next = temp;
        size += 1;
    }

    @Override
    public void addLast(T item){
        Node<T> temp = new Node<>(item,sentialLast,sentialLast.prev);
        sentialLast.prev.next = temp;
        sentialLast.prev = temp;
        size += 1;
    }

    @Override
    public boolean isEmpty(){
        if(size == 0)
            return true;
        return false;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public void printDeque(){
        Node<T> temp = sentialFront;
        int times = size;
        while(times > 0) {
            System.out.print(temp.items + " ");
            temp = temp.next;
            times--;
        }
    }

    @Override
    public T removeFirst(){
        if(sentialFront.next == sentialLast)
            return null;
        T firstItem = sentialFront.next.items;
        sentialFront.next.next.prev = sentialFront;
        sentialFront.next = sentialFront.next.next;
        size -= 1;
        return firstItem;
    }

    @Override
    public T removeLast(){
        if(sentialLast.prev == sentialFront)
            return null;
        T lastItem = sentialFront.prev.items;
        sentialLast.prev.prev.next = sentialLast;
        sentialLast.prev = sentialLast.prev.prev;
        size -= 1;
        return lastItem;
    }

    @Override
    public T get(int index){
        if(index >= size)
            return null;
        Node<T> point = sentialFront;
        for(int i = 0; i < size ; i++){
            point=point.next;
        }
        return point.items;
    }
}
