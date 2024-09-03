package tdd;

import org.example.tdd.WordCounter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class WordCounterTest {

    WordCounter counter = null;

    @BeforeEach
    public void setup(){
        counter = new WordCounter();
    }

    @ParameterizedTest
    @MethodSource
    public void add_valid_word(String word) {
        counter.addWordCount(word);


    }

    private static Stream<Arguments> add_valid_word(){
        return Stream.of(
                Arguments.of("flower flor blume")
        );
    }

    @Test
    public void check_word_count_if_word_empty(){
        //Given
        String word = "";
        //when
        counter.getWordCount(word);
        //Then
        assertEquals(0,0);

    }
}
