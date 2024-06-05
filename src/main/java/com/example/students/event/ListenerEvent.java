package com.example.students.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
public class ListenerEvent {
    @EventListener
    public void handleEvent(Event event) {
        if (event.getEventType().equals("add")) {
            System.out.println(MessageFormat.format("Сохранен студент {0} {1}",
                    event.getStudent().getFirstName(),
                    event.getStudent().getFirstName()));
        }

        if (event.getEventType().equals("rm")) {
            System.out.println(MessageFormat.format("Удален студент c id = {0}",
                    event.getStudent().getId()));
        }
    }
}
