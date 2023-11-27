package app;

import entity.EventFinder;
import entity.EventFinderService;
import interface_adapters.ViewManagerModel;
import interface_adapters.convertDoc.ConvertDocViewModel;
import interface_adapters.convertDoc.ConvertDocController;
import use_case.convertDoc.ConvertDocInteractor;
import use_case.convertDoc.ConvertDocOutputBoundary;
import use_case.convertDoc.convertDocInputBoundary;
import view.ConvertDocView;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        JFrame application = new JFrame("Convert Doc");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        EventFinder ef = new EventFinderService();
        CardLayout cardLayout = new CardLayout();

        // The various View objects. Only one view is visible at a time.
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        // This keeps track of and manages which view is currently showing.
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        ConvertDocViewModel convertDocViewModel = new ConvertDocViewModel();
        ConvertDocInteractor convertDocInteractor = new ConvertDocInteractor();
        ConvertDocController convertDocController = new ConvertDocController(convertDocInteractor);
        ConvertDocView convertDocView = new ConvertDocView(convertDocController, convertDocViewModel);

        // Add ConvertDocView to views panel
        views.add(convertDocView, convertDocViewModel.getViewName());

        // Set the active view
        viewManagerModel.setActiveView(convertDocViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setSize(350, 150);
        application.setVisible(true);

        System.out.println(ef.findEvents(
                "Your classes will be weekly on Fridays at 2:00pm. Tests will be every other Thursday."));

    }

}