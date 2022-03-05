package com.example.application.views.Slider;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("/slider")
@CssImport("./styles/slider.css")
@StyleSheet("https://fonts.googleapis.com/css2?family=Poppins:wght@200&display=swap")
public class Slider extends Div {

    final SliderComponent slider = SliderComponent.builder().build();
    public Slider() {
        add(getButtonLayout());
        slider.getContent().add(getDialogLayout());
        add(slider);
    }

    private Component getDialogLayout() {
        final Div div = new Div();
        final Header header = new Header();
        header.add(getHeaderContent());
        final Div fileInfoComponent = getFileInfoComponent();
        div.add(header,fileInfoComponent);
        return div;
    }

    private HorizontalLayout getHeaderContent() {
        final HorizontalLayout horizontalLayout = new HorizontalLayout();
        final Label title = new Label("File Details");
        final Icon close = new Icon(VaadinIcon.CLOSE);
        close.addClassName("close-icon");
        title.addClassName("title");
        close.addClickListener(iconClickEvent -> slider.close());
        horizontalLayout.setWidthFull();
        horizontalLayout.add(title,close);
        return horizontalLayout;
    }

    private HorizontalLayout getButtonLayout() {
        final HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setWidthFull();
        horizontalLayout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        final Button button = new Button("Test");
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        horizontalLayout.add(button);
        button.addClickListener(buttonClickEvent -> slider.open());
        return horizontalLayout;
    }

    private Div getFileInfoComponent() {
        final Div container = new Div();
        container.addClassName("fileinfo-container");
        final Component image = getImage();
        final Component fileInfo = getFileDetails();
        container.add(image,fileInfo);
        return container;
    }

    private Component getImage() {
        final Div imageContainer = new Div();
        final Image image = new Image("images/logo.png","Sample");
        imageContainer.setHeight("50px");
        imageContainer.setWidth("50%");
        imageContainer.add(image);
        return imageContainer;
    }

    private Component getFileDetails() {
        final Div container = new Div();
        final FormLayout formLayout = new FormLayout();
        final Label phnStrg = new Label("Phone Storage");
        final TextField size = new TextField("Size");
        final TextField resolution = new TextField("Resolution");
        size.setValue("4.5 MB");
        resolution.setValue("700 x 1200");
        formLayout.add(phnStrg,size,resolution);
        formLayout.setResponsiveSteps(new FormLayout.ResponsiveStep("0",1),
                new FormLayout.ResponsiveStep("200px",2),
                new FormLayout.ResponsiveStep("700px",3));
        formLayout.setColspan(phnStrg,2);
        container.add(formLayout);
        return container;
    }
}
