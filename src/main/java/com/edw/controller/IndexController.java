package com.edw.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;

/**
 * <pre>
 *     com.edw.controller.IndexController
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 22 Jun 2022 20:14
 */
@Controller
public class IndexController {

    @Value("classpath:images/tshirt.png")
    private Resource resource;

    @ResponseBody
    @GetMapping(value="/", produces = { MediaType.IMAGE_PNG_VALUE })
    public byte[] displayImage() throws IOException {
        InputStream inputStream = resource.getInputStream();
        return inputStream.readAllBytes();
    }
}
