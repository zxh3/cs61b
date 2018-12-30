public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++)
            deque.addLast(word.charAt(i));
        return deque;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> deque = wordToDeque(word);
        while (!deque.isEmpty()) {
            Character first = deque.removeFirst();
            if (deque.isEmpty())
                return true;
            Character last = deque.removeLast();
            if (first != last)
                return false;
        }
        return true;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> deque = wordToDeque(word);
        while (!deque.isEmpty()) {
            Character first = deque.removeFirst();
            if (deque.isEmpty())
                return true;
            Character last = deque.removeLast();
            if (!cc.equalChars(first, last))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        CharacterComparator cc = new OffByOne();
        Palindrome p = new Palindrome();
        System.out.println(p.isPalindrome("flake", cc));
    }
}
