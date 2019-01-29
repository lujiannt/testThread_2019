package com.thread.basic01.day06_guard;

/**
 * 生产的时间
 */
public class Event {
    public Event() {
    }

    public Event(String eventName, long createTimeStamp) {
        this.eventName = eventName;
        this.createTimeStamp = createTimeStamp;
    }

    /**
     * 事件名称
     */
    private String eventName;
    /**
     * 事件创建时间
     */
    private long createTimeStamp;

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public long getCreateTimeStamp() {
        return createTimeStamp;
    }

    public void setCreateTimeStamp(long createTimeStamp) {
        this.createTimeStamp = createTimeStamp;
    }
}
