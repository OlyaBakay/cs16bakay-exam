package json;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {
    private HashMap<String, Json> obj;

    public JsonObject(JsonPair... jsonPairs) {
        obj = new HashMap<>();
        for (JsonPair pair: jsonPairs) {
            obj.put(pair.getKey(), pair.getValue());
        }
    }


    @Override
    public String toJson() {
        String answ = "{";
        if(obj.size() == 0){
            return answ += "}";
        }

        Set set = obj.entrySet();
        for (Object pair: set){
            Map.Entry nwpr = (Map.Entry) pair;
            answ += '\'' + nwpr.getKey().toString() + '\'' + ": ";
            if (nwpr.getValue() instanceof Json){
                answ += ((Json) nwpr.getValue()).toJson() + ',';
            }
        }
        return answ.substring(0, answ.length() - 1) + '}';

    }

    public void add(JsonPair jsonPair) {
        obj.put(jsonPair.getKey(), jsonPair.getValue());
    }

    public Json find(String name) {
        if (obj.get(name) != null){
            return obj.get(name);
        }
        return null;
    }

    public JsonObject projection(String... names) {
        JsonObject j_object = new JsonObject();
        for (String st: names){
            if (obj.get(st) != null){
                j_object.add(new JsonPair(st, obj.get(st)));

            }
            }
    return j_object;
    }

    public static void main(String[] args){
        JsonObject jsonObject = new JsonObject(new JsonPair("name", new JsonString("Andrii")));
        System.out.println(jsonObject);

    }

}
