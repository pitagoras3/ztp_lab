package com.marcinkiewicz.application;

import com.marcinkiewicz.controller.HomeController;

public class Application {

    public static void main(String[] args) {
        HomeController homeController = new HomeController();
        homeController.start();
    }
}
