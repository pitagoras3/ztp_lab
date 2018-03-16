package com.marcinkiewicz.application;

import com.marcinkiewicz.view_controller.HomeViewController;

public class Application {

    public static void main(String[] args) {
        HomeViewController homeViewController = new HomeViewController();
        homeViewController.start();
    }
}
