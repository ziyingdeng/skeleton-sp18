public class OffByN implements CharacterComparator {
    private int minus;

    public OffByN(int minus){
        this.minus = minus;
    }

    public boolean equalChars(char x, char y) {
        if(x - y == minus || y - x == minus)
            return true;
        return false;
    }
}
