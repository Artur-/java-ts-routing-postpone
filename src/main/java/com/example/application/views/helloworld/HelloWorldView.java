package com.example.application.views.helloworld;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.BeforeLeaveEvent;
import com.vaadin.flow.router.BeforeLeaveEvent.ContinueNavigationAction;
import com.vaadin.flow.router.BeforeLeaveObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@Route(value = "hello")
@RouteAlias(value = "")
@PageTitle("Hello World")
@CssImport("./views/helloworld/hello-world-view.css")
public class HelloWorldView extends HorizontalLayout implements BeforeLeaveObserver {

    private Button sayHello;
    private ContinueNavigationAction postponed;

    public HelloWorldView() {
        setId("hello-world-view");
        sayHello = new Button("Navigate away by clicking on 'About'");
        add(sayHello);
        sayHello.addClickListener(e -> {
            if (postponed != null) {
                postponed.proceed();
                postponed = null;
            }
        });
    }

    @Override
    public void beforeLeave(BeforeLeaveEvent arg0) {
        this.postponed = arg0.postpone();
        this.sayHello.setText("Navigation postponed. Click to proceed.");
    }

}
