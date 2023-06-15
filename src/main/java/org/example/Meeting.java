package org.example;

public class Meeting extends Task {
    protected String topic;
    protected String project;
    protected String start;


    public Meeting(int id, String topic, String project, String start) {
        super(id); // вызов родительского конструктора
        this.topic = topic; // заполнение своих полей
        this.project = project;
        this.start = start;
    }

    public String getTopic() {
        return topic;
    }
        public String getProject() {
        return project;}
    public String getStart() {
        return start;}
    }

