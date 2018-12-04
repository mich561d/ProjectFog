package FunctionLayer;

import FunctionLayer.Entities.Part;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Michael
 */
public class ListToMap {

    public static HashMap<String, ArrayList<Part>> convertListToMap(ArrayList<Part> list) {
        HashMap<String, ArrayList<Part>> map = new HashMap();
        for (Part part : list) {
            String key = part.getType(); // TODO: What about size difference???
            ArrayList<Part> al;
            if (map.containsKey(key)) {

                al = (ArrayList<Part>) map.get(key);
            } else {
                al = new ArrayList();
            }
            al.add(part);
            map.put(key, al);
        }
        return map;
    }
}
