package com.example.application.views.dialog;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Dialog")
@Route(value = "dialog",layout = MainLayout.class)
public class DialogView extends Div {
    public DialogView() {
    }
}
