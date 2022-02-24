package com.example.application.views.pdfviewer;

import com.example.application.Constants;
import com.example.application.views.MainLayout;
import com.vaadin.componentfactory.pdfviewer.PdfViewer;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamResource;
import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

@PageTitle("Preview")
@Route(value = "preview" , layout = MainLayout.class)
@CssImport("./styles/preview.css")
public class Preview extends Div {

    private final static PreviewComponent previewComponent = PreviewComponent.builder().build();
    public Preview() throws IOException {
        add(layout());
    }
    private Component layout() throws IOException {

        VerticalLayout container = new VerticalLayout();
        container.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        container.setAlignItems(FlexComponent.Alignment.CENTER);

        Div parent1 = new Div();
        parent1.addClassName("parent-div");
        Div parent2 = new Div();
        parent2.addClassName("parent-div");

        Image img = new Image();
        img.setSrc(getImage(Constants.PNG));
        img.addClassName("png-img");
        Image img1 = new Image();
        img1.setSrc(getImage(Constants.PDF_ICON));
        img1.addClassName("png-img");

        Image preview = new Image();
        preview.setSrc(getImage(Constants.PREVIEW));
        preview.addClassName("preview");
        preview.addClickListener(imageClickEvent -> {
            previewComponent.setPath(Constants.SAMPLE_PNG);
            previewComponent.setType("png");
            add(previewComponent);
            try {
                previewComponent.init();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        Image preview1 = new Image();
        preview1.setSrc(getImage(Constants.PREVIEW));
        preview1.addClassName("preview");
        preview1.addClickListener(imageClickEvent -> {
            previewComponent.setPath(Constants.PDF_FILE);
            previewComponent.setType("pdf");
            try {
                add(previewComponent);
                previewComponent.init();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        parent1.add(img,preview);
        parent2.add(img1,preview1);
        container.add(parent1,parent2);
        return container;
    }

    private String getImage(String path) throws IOException {
        return Files.lines(Paths.get(path)).collect(Collectors.joining(System.lineSeparator()));
    }
}

