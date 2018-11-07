package com.foresee.ss.dsp.rest.inner;


import com.foresee.icap.framework.entity.api.Response;
import com.foresee.ss.dsp.auto.model.SfzjCxjmgrcbxx;
import com.foresee.ss.dsp.service.SbfsjjhptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SbfsjjhptController {
    
    private static final Logger logger = LoggerFactory.getLogger(SbfsjjhptController.class);

    @Autowired
    private SbfsjjhptService sbfsjjhptService;



    @PostMapping("/findOne")
    public Response findOne() {
        SfzjCxjmgrcbxx sfzjCxjmgrcbxx = sbfsjjhptService.findOne();

        return new Response(sfzjCxjmgrcbxx);
    }
}