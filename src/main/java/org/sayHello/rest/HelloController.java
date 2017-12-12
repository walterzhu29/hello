package org.sayHello.rest;

import com.sun.prism.PixelFormat;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.sayHello.model.SpeakerModel;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/hello-world")
public class HelloController {
    static Map<String, SpeakerModel> speakers= Collections.synchronizedMap(new HashMap<String, SpeakerModel>());
    //@ApiOperation describe the method below
    @ApiOperation(value = "add speaker", notes = "add speaker with Id and name")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", dataType = "String", required = true),
            @ApiImplicitParam(paramType = "query", name = "name", dataType = "String", required = true)
    })
    @RequestMapping(value = "add-speaker", method = RequestMethod.PUT)
    public String addSpeaker(@RequestParam(name = "id") String id,
                             @RequestParam(name = "name") String name) {
        SpeakerModel speaker = new SpeakerModel();
        speaker.setSpeakerId(id);
        speaker.setSpeakerName(name);
        Date date = new Date();
        speaker.setSpeakTime(date);
        speakers.put(id, speaker);
        return "Add speaker success: id = " + id + " name = " + name;
    }

    @ApiOperation(value = "get speaker", notes = "get speaker by id")
    @ApiImplicitParam(paramType = "path", name = "id", dataType = "String", required = true)
    @RequestMapping(value = "search-{id}", method = RequestMethod.GET)
    public SpeakerModel getSpeaker(@PathVariable(name = "id") String id) {
        return speakers.get(id);
    }

    @ApiOperation(value = "delete speaker", notes = "delete speaker by id")
    @ApiImplicitParam(paramType = "path", name = "id", dataType = "String", required = true)
    @RequestMapping(value = "delete-{id}", method = RequestMethod.DELETE)
    public String deleteSpeaker(@PathVariable(name = "id") String id) {
        speakers.remove(id);
        return "delete success!";
    }
}
