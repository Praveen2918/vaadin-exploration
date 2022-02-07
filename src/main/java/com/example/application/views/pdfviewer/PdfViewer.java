package com.example.application.views.pdfviewer;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("PdfViewer")
@Route(value = "pdfviewer" , layout = MainLayout.class)
public class PdfViewer extends Div {
    public PdfViewer() {
    }
}
