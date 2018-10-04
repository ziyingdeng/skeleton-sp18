import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Test;

public class HorribleSteve {
    @Test
    public void testFlik(){
        boolean res = Flik.isSameNumber(128,128);
        assertTrue(res);
    }

    public static void main(String [] args) {
        int i = 0;
        for (int j = 0; i < 500; ++i, ++j) {
            if (!Flik.isSameNumber(i, j)) {
                break; // break exits the for loop!
            }
        }
        System.out.println("i is " + i);
    }
}
