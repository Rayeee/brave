package com.joindata.zipkin.controller;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Rayee on 2017/9/19.
 */
@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    private OkHttpClient client;

    private Random random = new Random();

    @RequestMapping(value = "start", method = RequestMethod.GET)
    public String start() throws InterruptedException, IOException {
        int sleep = random.nextInt(100);
        TimeUnit.MILLISECONDS.sleep(sleep);
        Request request = new Request.Builder().url("http://localhost:9090/foo").get().build();
        Response response = client.newCall(request).execute();
        return " [service1 sleep " + sleep + " ms]" + response.body().toString();
    }

}
