package main.java.com.collection.hashMap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by huangzhibo on 01/06/2017.
 */
public class MutableMap {

    public enum PandaModel {
        ECIF,
        CLUE,
        CUSTOMER
    }

    public enum DistributeType {
        CLUE_DX,
        CLUE_CONSULT,
        ECIF_PERSON,
        ECIF_ORG

    }
    private static final String ECIF_QUEUE = "";
    private static final String CLUE_QUEUE = "";
    private static final String CUSTOMER_QUEUE = "";
    private static final String CLUR_CONSULT_DISTRUBUTE_QUEUE = "";

    // ConcurrentHashMap  考虑线程安全换这个
    public static final Map<String, String> siaQueue = Collections.unmodifiableMap(new HashMap<String, String>(5) {{
        put(PandaModel.ECIF.name(), ECIF_QUEUE);
        put(PandaModel.CLUE.name(), CLUE_QUEUE);
        put(PandaModel.CUSTOMER.name(), CUSTOMER_QUEUE);

        put(PandaModel.CUSTOMER.name(), CUSTOMER_QUEUE);
        put(DistributeType.CLUE_CONSULT.name(), CLUR_CONSULT_DISTRUBUTE_QUEUE);
    }});

    public static void main(String[] args) {

    }
}
