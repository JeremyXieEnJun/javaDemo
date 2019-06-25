package com.besjon.pojo;

import java.util.List;
import java.util.Map;

public class JsonRootBean {

    private String zoneName;

    private Map<String, List<String>> triggers;

    private Map<String, List<String>> actions;

    private Map<String, String> timers;

    public String getZoneName() {
        return zoneName;
    }

    public Map<String, List<String>> getTriggers() {
        return triggers;
    }

    public Map<String, List<String>> getActions() {
        return actions;
    }

    public Map<String, String> getTimers() {
        return timers;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public void setTriggers(Map<String, List<String>> triggers) {
        this.triggers = triggers;
    }

    public void setActions(Map<String, List<String>> actions) {
        this.actions = actions;
    }

    public void setTimers(Map<String, String> timers) {
        this.timers = timers;
    }

    @Override
    public String toString() {
        return "JsonRootBean{" +
                "zoneName='" + zoneName + '\'' +
                ", triggers=" + triggers +
                ", actions=" + actions +
                ", timers=" + timers +
                '}';
    }
}