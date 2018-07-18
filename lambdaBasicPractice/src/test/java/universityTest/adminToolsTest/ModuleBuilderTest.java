package universityTest.adminToolsTest;

import org.junit.Test;
import university.adminTools.ModuleBuilder;
import university.degreeModules.DegreeModule;

import static org.junit.Assert.assertEquals;

public class ModuleBuilderTest {

    @Test
    public void canGetEnglishModule() {
        DegreeModule module = ModuleBuilder.createModule("english", 40);
        assertEquals(40, module.getCredits());
    }

    @Test
    public void canGetHistoryModule() {
        assertEquals("history", ModuleBuilder.createModule("history", 20).getDegreeTopic());
    }
}
