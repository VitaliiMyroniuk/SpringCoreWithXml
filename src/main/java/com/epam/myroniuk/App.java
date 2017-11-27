package com.epam.myroniuk;

import com.epam.myroniuk.entity.Client;
import com.epam.myroniuk.entity.Event;
import com.epam.myroniuk.entity.EventType;
import com.epam.myroniuk.service.EventLogger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.io.IOException;
import java.util.Map;

/**
 * @author Vitalii Myroniuk
 */
public class App {
    private Client client;
    private Map<EventType, EventLogger> loggers;

    public App(Client client, Map<EventType, EventLogger> loggers) {
        this.client = client;
        this.loggers = loggers;
    }

    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) context.getBean("app");
        Event event = (Event) context.getBean("event");
        app.logEvent(EventType.ERROR, event);
        ((ConfigurableApplicationContext) context).close();
    }

    private void logEvent(EventType eventType, Event event) throws IOException {
        EventLogger eventLogger = loggers.get(eventType);
        String message = event.getMsg().replaceAll(client.getId(), client.getFullName());
        event.setMsg(message);
        eventLogger.logEvent(event);
    }
}
