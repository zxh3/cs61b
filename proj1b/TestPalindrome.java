import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator offByOne = new OffByOne();

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
    public void testIsPalindrome() {
        String s1 = "a";
        String s2 = "";
        String s3 = "abcda";
        String s4 = "Aba";
        String s5 = "abcddcba";
        String s6 = "abcdcba";
        assertTrue(palindrome.isPalindrome(s1));
        assertTrue(palindrome.isPalindrome(s2));
        assertTrue(palindrome.isPalindrome(s5));
        assertTrue(palindrome.isPalindrome(s6));
        assertFalse(palindrome.isPalindrome(s3));
        assertFalse(palindrome.isPalindrome(s4));
    }

    @Test
    public void testIsPalindromeOffByOne() {
        assertTrue(palindrome.isPalindrome("flake", offByOne));
    }
}
