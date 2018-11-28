package com.mjolnir.design.event;

import java.util.*;
import java.util.function.Consumer;

/**
 * @author huangzhibo
 * @date 18/01/2018
 */
public class EventManager {

    private static final Map<DemoEvent, List<Consumer<String>>> demoEventConsumerMap = new HashMap<>();

    public static void registerEvent(DemoEvent event, Consumer<String> consumer) {
        List<Consumer<String>> consumers = demoEventConsumerMap.get(event);
        if (consumers == null) {
            consumers = new ArrayList<>();
        }
        consumers.add(consumer);
        demoEventConsumerMap.put(event, consumers);
    }

    public static void fireEvent(DemoEvent event, String s) {
        Optional.ofNullable(demoEventConsumerMap.get(event)).ifPresent(consumers ->
            consumers.forEach(consumer -> consumer.accept(s))
        );
    }

}
