package homework5.service;

import homework5.domain.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TextServiceImplTest {
    private final TextServiceImpl textService = new TextServiceImpl();



    @Test
    public void shouldReturnNullStringForNullText() {
        String expectedResult = null;
        String actualResult = textService.convertTextToString(null);
        assertEquals("",expectedResult,actualResult);
    }

    @Test
    public void shouldReturnStringForText() {
        String expectedResult = "Hel";
        List<Symbol> symbols = Arrays.asList(new Letter('H'),new Letter('e'),new Letter('l'));
        Sentence header = new Sentence(Arrays.asList(new Word(symbols)));
        Text text = new Text(header,null);
        String actualResult = textService.convertTextToString(text);
        assertEquals("",expectedResult,actualResult);
    }


}