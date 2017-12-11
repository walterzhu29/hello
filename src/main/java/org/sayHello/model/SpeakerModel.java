package org.sayHello.model;
import lombok.Data;

import java.util.Date;

@Data
public class SpeakerModel {
    private String speakerId;
    private String speakerName;
    private Date speakTime;
}
