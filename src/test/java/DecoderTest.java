import accounts.PlayerCommandDecoder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static  org.junit.Assert.assertEquals;

public class DecoderTest {
    @Test
    public void CommandDecoderTest(){
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(11,451,4));
        ArrayList<Integer> actual = PlayerCommandDecoder.CommandDecoder("11 451 4");
        for(int i:actual){
            System.out.println(i);
        }
        assertEquals(expected, actual);
        actual = PlayerCommandDecoder.CommandDecoder(" 11 451 4");
        for(int i:actual){
            System.out.println(i);
        }
        assertEquals(expected, actual);
        actual = PlayerCommandDecoder.CommandDecoder(" 11 451 4 ");
        for(int i:actual){
            System.out.println(i);
        }
        assertEquals(expected, actual);
    }
}
