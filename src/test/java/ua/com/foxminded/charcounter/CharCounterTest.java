package ua.com.foxminded.charcounter;

import static org.junit.Assert.assertEquals;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CharCounterTest {

    private CharCounter charCounter;
    
    @BeforeEach
    public void initEach(){
        charCounter = new CharCounter();
    }
    
    @Test
    void testCalculateCharCount_Success_WordWithSingleChars() {
        Map<Character, Integer> actualCharsAmount = charCounter.getCharsAmount("abc");
        LinkedHashMap<Character, Integer> expectedCharsCount = new LinkedHashMap<>();
        expectedCharsCount.put('a', 1);
        expectedCharsCount.put('b', 1);
        expectedCharsCount.put('c', 1);
        assertEquals(expectedCharsCount, actualCharsAmount);
    }

    @Test
    void testCalculateCharCount_Success_WordWithDuplicateChars() {
        Map<Character, Integer> actualCharsAmount = charCounter.getCharsAmount("aabcc");
        LinkedHashMap<Character, Integer> expectedCharsCount = new LinkedHashMap<>();
        expectedCharsCount.put('a', 2);
        expectedCharsCount.put('b', 1);
        expectedCharsCount.put('c', 2);
        assertEquals(expectedCharsCount, actualCharsAmount);
    }

    @Test
    void testCalculateCharCount_Success_WordWithUpperCaseDuplicatesChars() {
        Map<Character, Integer> actualCharsAmount = charCounter.getCharsAmount("aAbcC");
        LinkedHashMap<Character, Integer> expectedCharsCount = new LinkedHashMap<>();
        expectedCharsCount.put('a', 2);
        expectedCharsCount.put('b', 1);
        expectedCharsCount.put('c', 2);
        assertEquals(expectedCharsCount, actualCharsAmount);
     }

    @Test
    void testCalculateCharCount_Success_SpaceOnly() {
        Map<Character, Integer> actualCharsAmount = charCounter.getCharsAmount("   ");
        LinkedHashMap<Character, Integer> expectedCharsCount = new LinkedHashMap<>();
        expectedCharsCount.put(' ', 3);
        assertEquals(expectedCharsCount, actualCharsAmount);
     }
   
    @Test
    void testCalculateCharCount_ShouldAddToCash_FirstCharSequence() {
        charCounter.calculateCharsAmount("abc");
        assertEquals(1, charCounter.cashedCharSequences.size());
     }

    @Test
    void testCalculateCharCount_ShouldNotAddToCash_FewEnteredSameCharSequence() {
        charCounter.calculateCharsAmount("abc");
        charCounter.calculateCharsAmount("abc");
        charCounter.calculateCharsAmount("abc");
        assertEquals(1, charCounter.cashedCharSequences.size());
     }
}
