package com.vaadin.tutorial.crm.views;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

@Route("")
public class HelloWorld extends Div {
    public HelloWorld() {
        setText("Hello world");
    }
}