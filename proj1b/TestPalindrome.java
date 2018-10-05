import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testPalindrome1(){
        String input = "";
        boolean excepted = palindrome.isPalindrome(input);
        assertTrue(excepted);

        String input2 ="a";
        boolean excepted2 = palindrome.isPalindrome(input2);
        assertTrue(excepted2);

        String input3 = "B";
        boolean excepted3 = palindrome.isPalindrome(input3);
        assertTrue(excepted3);

        String input4 = "aaabbb";
        boolean excepted4 = palindrome.isPalindrome(input4);
        assertFalse(excepted4);

        String input5 = "abbA";
        boolean excepted5 = palindrome.isPalindrome(input5);
        assertFalse(excepted5);

        String input6 = "abba";
        boolean excepted6 = palindrome.isPalindrome(input6);
        assertTrue(excepted6);

        String input7 = "abbbba";
        boolean excepted7 = palindrome.isPalindrome(input7);
        assertTrue(excepted7);
    }

    @Test
    public void testPalindrome2(){
        CharacterComparator cc = new OffByOne();
        String input = "ab";
        boolean excepted = palindrome.isPalindrome(input,cc);
        assertTrue(excepted);

        String input2 ="flake";
        boolean excepted2 = palindrome.isPalindrome(input2,cc);
        assertTrue(excepted2);


    }
}
