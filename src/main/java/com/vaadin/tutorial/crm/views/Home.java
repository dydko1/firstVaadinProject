package com.vaadin.tutorial.crm.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.TextField;

import com.vaadin.flow.router.Route;

@Route("app")
public class Home extends AppLayout {

    TextField textArea = new TextField("Rejestracja na wydarzenie");
    ComboBox<String> comboBox = new ComboBox<>("Wydarzenia");

    public Home() {

        Image img = new Image("https://zielonamapa.pl/wp-content/uploads/2020/05/nicea-francja.jpg", "Vaadin Logo");
        img.setHeight("44px");
        addToNavbar(new DrawerToggle(), img);
        Tabs tabs = new Tabs(new Tab("Home"), new Tab("About"));
        tabs.setOrientation(Tabs.Orientation.VERTICAL);
        addToDrawer(tabs);

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.add(getLayoutTextBoxComboBox());

        setContent(horizontalLayout);
    }

    private HorizontalLayout getLayoutTextBoxComboBox() {
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.add(getTextBoxLayout());
        horizontalLayout.add(getComboBoxLayout());
        return horizontalLayout;
    }

    private Component getTextBoxLayout() {
        VerticalLayout vertical = new VerticalLayout();
        Label label = new Label();

        textArea.setPlaceholder("adres email");

        textArea.addValueChangeListener(e -> {
            if (e.getSource().isEmpty()) {
                label.setText(" nic nie wybrano");
            } else {
                label.setText("[wybrano] " + e.getValue());
            }
        });
        vertical.add(textArea);
        vertical.add(label);
        vertical.add(getSaveButton());
        return vertical;
    }

    private VerticalLayout getComboBoxLayout() {
        VerticalLayout vertical = new VerticalLayout();
        Label label = new Label();

        comboBox.setWidthFull();
        comboBox.setItems("Spring Boot", "konferencja GIT", "webinar Java 8");

        comboBox.addValueChangeListener(e -> {
            if (e.getValue().isEmpty()) {
                label.setText(" nic nie wybrano");
            } else {
                label.setText("[wybrano] " + e.getValue());
            }
        });

        vertical.add(comboBox);
        vertical.add(label);

        return vertical;
    }

    private Button getSaveButton() {
        final Button button = new Button("Zapisz się", e -> {
            Dialog dialog = new Dialog();
            dialog.add(new Label("Podsumowanie zapisu na wydarzenie"));

            VerticalLayout verticalLayout = new VerticalLayout();
            verticalLayout.add(new Label("[email] " + textArea.getValue()));
            verticalLayout.add(new Label("[Wydarzenia " + comboBox.getValue()));

            dialog.add(verticalLayout);

            dialog.setWidth("400px");
            dialog.setHeight("150px");
            dialog.open();
        });
        return button;
    }
}