package com.j2ustc.action;

import com.spotify.docker.client.DefaultDockerClient;
import com.spotify.docker.client.exceptions.DockerException;
import com.spotify.docker.client.messages.Container;
import com.spotify.docker.client.messages.Image;
import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Yenole on 2017/1/12.
 */
@RestController
public class SystemAction {

    @Autowired
    DefaultDockerClient docker;

    @RequestMapping("/index")
    public ModelAndView index(ModelAndView model) {
        model.setViewName("/index.html");
        List<Image> images = null;
        try {
            images = docker.listImages();
        } catch (DockerException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        model.addObject("images", images);
        return model;
    }

}
