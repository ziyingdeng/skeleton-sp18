import org.junit.Test;

public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque<Character> d = new ArrayDeque<>();
        for(int i = 0; i < word.length(); i++){
            d.addLast(word.charAt(i));
        }
        return d;
    }

    private boolean isPalindromeHelper(Deque<Character> d){
        if(!d.isEmpty()){
            Character first = d.removeFirst();
            Character last = d.removeLast();
            if(first.equals(last)){
                isPalindromeHelper(d);
            }
            else{
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word){
        Deque<Character> d = wordToDeque(word);
        if(d.size() == 0 || d.size() == 1)
            return true;
        return isPalindromeHelper(d);
    }


    /** Overload */
    private boolean isPalindromeHelper(Deque<Character> d,CharacterComparator cc){
        if(!d.isEmpty()){
            Character first = d.removeFirst();
            Character last = d.removeLast();
            if(cc.equalChars(first,last)){
                isPalindromeHelper(d);
            }
            else{
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque<Character> d = wordToDeque(word);
        if(d.size() == 0 || d.size() == 1)
            return true;
        return isPalindromeHelper(d,cc);
    }
}
