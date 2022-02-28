package com.example.application.views.sample;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.Autocapitalize;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;

@Route(value = "sample", layout = MainLayout.class)
@CssImport(value = "./styles/text-field.css" , themeFor = "vaadin-text-field")
@CssImport("./styles/asset.css")
@StyleSheet("https://fonts.googleapis.com/css2?family=Poppins:wght@200&display=swap")
public class Sample extends Div {

    public Sample() {
        addClassName("parent-layout");
        add(attributionLayout(),processAttributes());
    }


    private Div attributionLayout () {
        final Div div = new Div();
        div.addClassName("attribution-container");
        final FormLayout formLayout = new FormLayout();
        formLayout.addClassName("attribution-form");
        final List<TextField> textFieldList = getTextFieldList();
        textFieldList.forEach(formLayout::add);
        formLayout.setResponsiveSteps(new FormLayout.ResponsiveStep("0",1),
                new FormLayout.ResponsiveStep("300px",2),
                new FormLayout.ResponsiveStep("700px",3));
        div.add(formLayout);
        return div;
    }

    private Div processAttributes () {
        final Div div = new Div();
        div.addClassName("process-div");
        final VerticalLayout verticalLayout = new VerticalLayout();
        Label header = new Label("Process Attributes");
        header.addClassName("process-header");
        final List<HorizontalLayout> horizontalLayoutList = getProcessStages();
        verticalLayout.add(header);
        horizontalLayoutList.forEach(verticalLayout::add);
        div.add(verticalLayout);
        return div;
    }

    private List<TextField> getTextFieldList() {
        final List<TextField> textFieldList = new ArrayList<>();
        textFieldList.add(getTextField("Name","Richard"));
        textFieldList.add(getTextField("Price","20000"));
        textFieldList.add(getTextField("Quote Val","33000"));
        textFieldList.add(getTextField("Created","2 days"));
        textFieldList.add(getTextField("Items","24"));
        textFieldList.add(getTextField("Status","New"));
        textFieldList.add(getTextField("Color","Black"));
        textFieldList.add(getTextField("Weight","20 Tons"));
        textFieldList.add(getTextField("Height","40 M"));
        return textFieldList;
    }

    private TextField getTextField(String label,String value) {
        final TextField textField = new TextField();
        textField.addThemeName("response-label");
        textField.setLabel(label);
        textField.setValue(value);
        textField.setReadOnly(true);
        textField.setAutocapitalize(Autocapitalize.CHARACTERS);
        return textField;
    }

    private List<HorizontalLayout> getProcessStages() {
        List<HorizontalLayout> horizontalLayoutList = new ArrayList<>();
        horizontalLayoutList.add(getHorizontalLayout("Time Taken"));
        horizontalLayoutList.add(getHorizontalLayout("Despecing"));
        horizontalLayoutList.add(getHorizontalLayout("Deskewing"));
        horizontalLayoutList.add(getHorizontalLayout("Denoising"));
        horizontalLayoutList.add(getHorizontalLayout("Punch Hole Removal"));
        horizontalLayoutList.add(getHorizontalLayout("Blanks"));
        horizontalLayoutList.add(getHorizontalLayout("Rotation"));
        return horizontalLayoutList;
    }

    private HorizontalLayout getHorizontalLayout(String value) {
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setWidthFull();
        Label label = new Label(value);
        label.addClassName("process-label");
        Icon icon = new Icon(VaadinIcon.CHECK_CIRCLE);
        icon.setColor("turquoise");
        icon.addClassName("stage-icon");
        horizontalLayout.add(label,icon);
        return horizontalLayout;
    }
}
