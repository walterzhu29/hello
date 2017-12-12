package org.sayHello.model;
import lombok.Data;

import java.util.Date;

@Data
public class SpeakerModel {
    private String speakerId;
    private String speakerName;
    private Date speakTime;
    public void setSpeakerId(String si) {
        this.speakerId = si;
    }
    public void setSpeakerName(String sn) {
        this.speakerName = sn;
    }
    public void setSpeakTime(Date st) {
        this.speakTime = st;
    }
}
