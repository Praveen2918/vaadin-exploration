package com.example.application.views.pdfviewer;

import com.vaadin.componentfactory.pdfviewer.PdfViewer;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.server.StreamResource;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.EnumUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Objects;
import java.util.stream.Collectors;

@Builder
@Getter
@Setter
public class PreviewComponent extends Dialog {

    enum types {
        jpg,jpeg,png,tiff
    }

    private String path ;
    private String type ;

    public void  init() throws IOException {
        removeAll();
        setDialogContent();
        open();
    }

    private void setDialogContent() throws IOException {
        if (Objects.equals(type,"pdf"))
            add(getPdfPreview());
        else if (EnumUtils.isValidEnum(types.class,type))
            add(getImagePreview());
        else
            add(getHandler());
    }

    private Component getPdfPreview() {
        final StreamResource resource = new StreamResource("", this::createInputStream);
        final PdfViewer pdfViewer = new PdfViewer();
        pdfViewer.setSrc(resource);
        pdfViewer.openThumbnailsView();
        setHeight("95%");
        setWidth("95%");
        return pdfViewer;
    }

    private Component getImagePreview() throws IOException {
        final Div div = new Div();
        final Image image = new Image(getImage(path),"image");
        setHeight("auto");
        setWidth("auto");
        div.add(image);
        return div;
    }

    private Component getHandler() {
        return new H4("Provide a valid file type");
    }
    private InputStream getFileResource() throws FileNotFoundException {
        return Base64.getDecoder().wrap(new FileInputStream(path));
    }

    private InputStream createInputStream()  {
        try {
            return getFileResource();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return InputStream.nullInputStream();
    }

    private String getImage(String path) throws IOException {
        return Files.lines(Paths.get(path)).collect(Collectors.joining(System.lineSeparator()));
    }
}
