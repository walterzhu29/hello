package org.sayHello.rest;

import com.sun.prism.PixelFormat;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/hello-world")
public class HelloController {
    //@ApiOperation describe the method below
    @ApiOperation(value = "print hello world and the speaker in the page", notes = "nothing")
    @ApiImplicitParam(paramType = "path", name = "speakerName", required = true, dataType = "String")
    @RequestMapping(value = "/{speakerName}-says-hello", method = RequestMethod.PUT)
    public String helloWorld(@PathVariable(value = "speakerName") String speakerName) {
        return speakerName+ " " + "says: Hello World!";
    }
}
