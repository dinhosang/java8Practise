package university.adminTools;

import university.degreeModules.DegreeModule;
import university.degreeModules.EnglishModule;
import university.degreeModules.GeographyModule;
import university.degreeModules.HistoryModule;

import java.util.HashMap;
import java.util.Map;
import java.util.function.IntFunction;


public class ModuleBuilder {

    private static final Map<String, IntFunction<DegreeModule>> moduleMap = new HashMap<String, IntFunction<DegreeModule>>() {
        {
            put("history", HistoryModule::new);
            put("english", EnglishModule::new);
            put("geography", GeographyModule::new);
        }
    };

    public static DegreeModule createModule(String degree, int credits) {
        IntFunction<DegreeModule> moduleConstructor = ModuleBuilder.moduleMap.get(degree);
        // should check for null etc, and/or raise errors etc.
        DegreeModule module = moduleConstructor.apply(credits);
        return module;
    }
}
