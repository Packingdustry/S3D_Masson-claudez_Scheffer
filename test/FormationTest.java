import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
public class FormationTest {
    private Formation f;

    @BeforeEach
    public void initialisation() {
        f = new Formation("BUT Informatique");
        f.ajouter("Maths", 3);
        f.ajouter("Communication", 0.5);
        f.ajouter("PHP", 2);
    }

    @Test
    public void testAjouter() {
        assertEquals(3, f.);
    }
}