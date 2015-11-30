package axonactive.webapp;

import axonactive.core.SystemPropertiesConfigurationOverwrite;
import net.serenitybdd.jbehave.SerenityStories;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AcceptanceTest extends SerenityStories {

    /* We filter the webapp.stories to execute based on the available webapp.stories for the tenant as defined in the
    test configuration. This is based on a regexp: for example resources/.../webapp.stories/opportunities/...
    will only be included if the resolved config has webapp.stories.opportunities.enabled=true
    */
    @Override
    public List<String> storyPaths() {
        try {
            return storyPathsFilteredByActiveFeatures();
        } catch (Exception ex) {
            ex.printStackTrace();
            // Terminate the runtime to ensure we fail the maven execution - otherwise Thucydides carries on with no webapp.stories defined...
            System.exit(1);
        }
        return null;
    }


    private List<String> storyPathsFilteredByActiveFeatures() throws IOException {
        SystemPropertiesConfigurationOverwrite.loadFile();
        String[] capabilities =  SystemPropertiesConfigurationOverwrite.env.getProperty("sb_order_story").split(",");
        List<String> allStories = super.storyPaths();
        ArrayList<String> result = new ArrayList<String>();
        for (String capability : capabilities) {
            // Filter out any which are for unavailable webapp.stories
            for (String path : allStories) {
                if (path.contains("features/" + capability)) {
                    result.add(path);
                    break;
                }
            }
        }
        return result;

    }
}
