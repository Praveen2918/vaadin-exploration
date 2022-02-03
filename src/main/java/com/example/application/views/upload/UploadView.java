package com.example.application.views.upload;


import com.example.application.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.UploadI18N;
import com.vaadin.flow.component.upload.receivers.MultiFileMemoryBuffer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.server.WebBrowser;


@PageTitle("Upload")
@Route(value = "upload", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@CssImport("./styles/hello-world.css")
public class UploadView extends Div {

    private static final int maxFileSize = 5 * 1024 * 1024;
    public UploadView() {
        addClassName("centered");
        getUpload();
    }


    private void getUpload() {
        WebBrowser webBrowser = VaadinSession.getCurrent().getBrowser();
        if (webBrowser.isAndroid() || webBrowser.isWindowsPhone() || webBrowser.isIPhone()) add(getUploadLayout(true));
        else add(getUploadLayout(false));
    }

    private Component getUploadLayout(boolean isPhone) {
        Div phoneDiv = new Div();
        Button uploadBtn = getButton();
        H4 heading = new H4("Upload Forms");
        Paragraph acceptedFiles = new Paragraph("Accepted file formats : .png,.jpg,.jpeg,.pdf");
        Paragraph maxSizeInfo = new Paragraph("Max File Size : 10MB");
        acceptedFiles.getStyle().set("color", "var(--lumo-secondary-text-color)");
        maxSizeInfo.getStyle().set("color", "var(--lumo-secondary-text-color)");
        if (isPhone) {
            Upload phoneUpload = getUploadComponent(false,uploadBtn);
            phoneUpload.getElement().setAttribute("capture", "environment");
            phoneDiv.add(heading,acceptedFiles,maxSizeInfo,phoneUpload);
        }
        else {
            Upload pcUpload = getUploadComponent(true,uploadBtn);
            phoneDiv.add(heading,acceptedFiles,maxSizeInfo,pcUpload);
        }
        return phoneDiv;
    }

    private Upload getUploadComponent(boolean dragEnabled, Button uploadBtn) {
        MultiFileMemoryBuffer buffer = new MultiFileMemoryBuffer();
        Upload upload = new Upload(buffer);
        upload.setMaxFileSize(maxFileSize);
        upload.setAcceptedFileTypes("image/*",".pdf");
        upload.setDropAllowed(dragEnabled);
        upload.setUploadButton(uploadBtn);
        UploadExamplesI18N i18N = new UploadExamplesI18N();
        upload.addFileRejectedListener(fileRejectedEvent -> {
            Notification notification = Notification.show(fileRejectedEvent.getErrorMessage(),3000, Notification.Position.MIDDLE);
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
        });
        i18N.getError().setFileIsTooBig("The file exceeds the maximum allowed size of 10MB.");
        i18N.getError().setIncorrectFileType("The provided file does not have the correct format. Please provide a suggested document.");
        upload.setI18n(i18N);
        return upload;
    }

    private Button getButton() {
        Button button = new Button("Upload");
        button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        button.getElement().getStyle().set("cursor","pointer");
        return button;
    }

    private Div getDiv(String classname) {
        Div div = new Div();
        div.addClassName(classname);
        return div;
    }
}
