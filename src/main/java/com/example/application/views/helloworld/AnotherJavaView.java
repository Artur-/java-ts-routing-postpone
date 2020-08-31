package com.example.application.views.helloworld;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("anotherjava")
public class AnotherJavaView extends VerticalLayout {

    AnotherJavaView() {
        add(new Label("Another Java view"));
    }
}