package it.sevenbits.courses.sm.log;

import it.sevenbits.courses.sm.manager.sm.Pair;
import it.sevenbits.courses.sm.manager.sm.State;

import java.util.HashMap;
import java.util.Map;


public class MessageFormatter {

    private final Map<String, String> states;

    public MessageFormatter() {
        states = new HashMap<>();

        states.put("MESSAGE", "Part of message: %1$s");
        states.put("TRASH", "Trash received");
        states.put("MESSAGE_START", "Message creating started");
        states.put("MESSAGE_FINISH", "Message creating finished");

    }


    public String getStringFormatByType(String message){
        return states.getOrDefault(message, "Unknown package type");
    }

}
