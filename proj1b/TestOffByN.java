import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByN(1);
    static CharacterComparator offByTwo = new OffByN(2);

    // Your tests go here.

    @Test
    public void testEqualChars() {
        assertFalse(offByOne.equalChars('a', 'a'));
        assertTrue(offByOne.equalChars('a', 'b'));
        assertTrue(offByOne.equalChars('b', 'a'));
        assertTrue(offByOne.equalChars('f', 'e'));

        assertTrue(offByTwo.equalChars('a', 'c'));
        assertTrue(offByTwo.equalChars('e', 'c'));
    }
}
