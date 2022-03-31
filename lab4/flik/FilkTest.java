package flik;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

public class FilkTest {
    @Test
    public void testIsSameNumber(){
        assertTrue(Flik.isSameNumber(128,128));
    }
}
