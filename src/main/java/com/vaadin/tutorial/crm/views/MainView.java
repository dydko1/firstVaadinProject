package com.vaadin.tutorial.crm.views;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.datepicker.DatePicker;
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
        Button button2 = new Button("I'm a button");

        HorizontalLayout layout = new HorizontalLayout(button2, new DatePicker("Pick a date"));
        layout.setDefaultVerticalComponentAlignment(Alignment.END);

        buttonAdd.addClickShortcut(Key.ENTER);
        buttonAdd.addClickListener(click -> {
            Checkbox checkboxAdd = new Checkbox(textField.getValue());
            todoList.add(checkboxAdd);
            System.out.println("Test !!!");
        });
        button2.addClickListener(clickEvent ->
                add(new Text("Clicked!")));

        add(new H1("Vaadin todo"), todoList,
                new HorizontalLayout(textField, buttonAdd,button2),layout);
    }
}
