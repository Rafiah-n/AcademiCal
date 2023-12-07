package app;

import interface_adapters.ViewManagerModel;
import data_access.FileUserDataAccessObject;
import entity.CommonUserFactory;
import interface_adapters.logged_in.LoggedInViewModel;
import interface_adapters.login.LoginViewModel;
import view.LoggedInView;
import view.LoginView;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        /*
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
        */
        JFrame application = new JFrame("Login");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        JPanel views = new JPanel(cardLayout);
        application.add(views);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        LoginViewModel loginViewModel = new LoginViewModel();
        LoggedInViewModel loggedInViewModel = new LoggedInViewModel();

        FileUserDataAccessObject userDataAccessObject;
        try {
            userDataAccessObject = new FileUserDataAccessObject("./users.csv", new CommonUserFactory());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, loggedInViewModel, userDataAccessObject);
        views.add(loginView, loginView.viewName);

        LoggedInView loggedInView = new LoggedInView(loggedInViewModel);
        views.add(loggedInView, loggedInView.viewName);

        application.pack();
        application.setVisible(true);
    }
}
