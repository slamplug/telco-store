package com.firstutility.telco.store.domain;

import com.firstutility.telco.store.jsonb.types.StringJsonUserType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "event")
@TypeDefs({
        @TypeDef(name = "StringJsonObject", typeClass = StringJsonUserType.class)
})

public class Event implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "application_id")
    private String applicationId;

    @Column(name = "event_type")
    private String eventType;

    @Column(name = "event_datetime")
    private Timestamp eventDateTime;

    @Type(type = "StringJsonObject")
    @Column(name = "event_data")
    private String eventData;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Timestamp getEventDateTime() {
        return eventDateTime;
    }

    public void setEventDateTime(Timestamp eventDateTime) {
        this.eventDateTime = eventDateTime;
    }

    @Type(type = "StringJsonObject")
    public String getEventData() {
        return eventData;
    }

    public void setEventData(String eventData) {
        this.eventData = eventData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (id != null ? !id.equals(event.id) : event.id != null) return false;
        if (applicationId != null ? !applicationId.equals(event.applicationId) : event.applicationId != null)
            return false;
        if (eventType != null ? !eventType.equals(event.eventType) : event.eventType != null) return false;
        if (eventDateTime != null ? !eventDateTime.equals(event.eventDateTime) : event.eventDateTime != null)
            return false;
        return eventData != null ? eventData.equals(event.eventData) : event.eventData == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (applicationId != null ? applicationId.hashCode() : 0);
        result = 31 * result + (eventType != null ? eventType.hashCode() : 0);
        result = 31 * result + (eventDateTime != null ? eventDateTime.hashCode() : 0);
        result = 31 * result + (eventData != null ? eventData.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", applicationId='" + applicationId + '\'' +
                ", eventType='" + eventType + '\'' +
                ", eventDateTime=" + eventDateTime +
                ", eventData='" + eventData + '\'' +
                '}';
    }
}
