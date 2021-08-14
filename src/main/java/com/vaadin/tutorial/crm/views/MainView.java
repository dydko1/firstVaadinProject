package com.vaadin.tutorial.crm.views;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route
public class MainView extends VerticalLayout {

    public MainView() {
        VerticalLayout todoList = new VerticalLayout();
        TextField textField = new TextField();
        Button buttonAdd = new Button("Add");

        buttonAdd.addClickShortcut(Key.ENTER);
        buttonAdd.addClickListener(click -> {
            Checkbox checkboxAdd = new Checkbox(textField.getValue());
            todoList.add(checkboxAdd);
            System.out.println("Test !!!");
        });

        add(new H1("Vaadin todo"), todoList,
                new HorizontalLayout(textField, buttonAdd));
    }
}
