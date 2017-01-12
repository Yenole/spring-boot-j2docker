package com.j2ustc.action;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Yenole on 2017/1/12.
 */
@RestController
public class SystemAction {

    @RequestMapping("/index")
    public ModelAndView index(ModelAndView model) {
        model.setViewName("/index.html");
        return model;
    }
}
