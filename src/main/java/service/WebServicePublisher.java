package service;

import javax.xml.ws.Endpoint;
// класс нашего веб-сервиса

public class WebServicePublisher {
    public static void main(String... args) {

        Endpoint.publish("http://localhost:1986/wss/hello", new WebServiceImpl());
    }
}