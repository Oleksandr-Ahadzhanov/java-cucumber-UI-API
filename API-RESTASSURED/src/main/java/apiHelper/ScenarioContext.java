package apiHelper;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

    private static Map<ContextType, Object> context = new HashMap<>();

    public static void setContext (ContextType contextType, Object value) {context.put(contextType,value);}

    /*unchecked*/
    public static <T> T getContext(ContextType contextType) {
        return (T) context.getOrDefault(contextType,null);
    }

    public enum ContextType {
        HTTP_REQUEST_SPECIFICATION,
        HTTP_RESPONSE_SPECIFICATION,
        HTTP_REQUEST,
        HTTP_RESPONSE,
        DOWNLOADED_FILE,
        SCREENSHOT
    }

}
