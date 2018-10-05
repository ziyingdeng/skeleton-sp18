public class ArrayDeque<T> implements Deque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque(){
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 0;
        nextLast = 0;
    }

    /** Resize the length when array is full  */
    private T[] resize(){
        T[] temp = (T[]) new Object[2*size];
        System.arraycopy(items,0,temp,0,size);
        nextFirst = temp.length - 1;
        nextLast = items.length;
        return temp;
    }

    /** Resize the length when array's use-rate lower than 25% */
    private void removeResize(){
        double rate = (double)size / (double)items.length;
        if(rate < 0.25){
            T[] temp = (T[]) new Object[2*size];
            int start = (nextFirst + 1)%items.length;
            int i = 0;
            while(start !=nextLast){
                temp[i] = items[start];
                start = (start+1)%items.length;
                i += 1;
            }
            items = temp;
            nextFirst = temp.length - 1;
            nextLast = size;
        }
    }

    /** First time Add use.    In order to set the nextLast and nextFirst  */
    private void firstAdd(T x){
        items[0] = x;
        nextLast = 1;
        nextFirst = items.length - 1;
        size += 1;
    }

    @Override
    public void addFirst(T x){
        if(size == 0){
            firstAdd(x);
            return ;
        }
        if(size >= items.length)
            items = resize();
        items[nextFirst] = x;
        nextFirst = nextFirst - 1;      //nextFirst only be minus when the first time, so set in firstAdd.
        size += 1;
    }

    @Override
    public void addLast(T x){
        if(size == 0){
            firstAdd(x);
            return ;
        }
        if(size >= items.length)
            items = resize();
        items[nextLast] = x;
        nextLast = (nextLast + 1)%items.length;
        size += 1;
    }

    @Override
    public T removeFirst(){
        T returnItem = items[(nextFirst + 1)%items.length];
        items[(nextFirst + 1)%items.length] = null;
        nextFirst = (nextFirst + 1)%items.length;
        size -=1;
        removeResize();
        return returnItem;
    }

    @Override
    public T removeLast(){
        int pos = nextLast == 0 ? (items.length -1) : (nextLast -1);
        T returnItem = items[pos];
        items[pos] = null;
        size -=1;
        nextLast = pos ;
        removeResize();
        return returnItem;
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
        int start = (nextFirst + 1)%items.length;
        while(start !=nextLast){
            System.out.print(items[start]+" ");
            start = (start+1)%items.length;
        }
    }


    @Override
    public T get(int index){
        if(index > items.length)
            return null;
        return items[index - 1];
    }



}
