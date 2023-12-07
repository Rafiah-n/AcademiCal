package app;

import data_access.UpdateEventDataAccessObject;
import entity.*;
import interface_adapters.ViewManagerModel;
import interface_adapters.updateEvent.UpdateEventViewModel;
import view.ViewManager;
import view.updateEvent.*;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

public class UpdateEventMain {

    public static void main(String[] args) {
        System.out.println("hello");
        JFrame application = new JFrame("Update");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        JPanel views = new JPanel(cardLayout);
        application.add(views);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        UpdateEventViewModel updateEventViewModel = new UpdateEventViewModel();
        //LoggedInViewModel loggedInViewModel = new LoggedInViewModel();

        UpdateEventDataAccessObject updateEventDataAccessObject;
        updateEventDataAccessObject = new UpdateEventDataAccessObject();
        Course course = new Course();
        course.setCourseContact("Kubra");

        Location location = new Location();
        AssignmentEvent event = new AssignmentEvent("Assignment: CSC207", course, LocalDateTime.now(),
                LocalDateTime.now(),location, false, "Reading", 15, true,
                LocalDateTime.now());

        updateEventViewModel.getState().setEvent(event);
        UpdateEventView updateEventView = UpdateEventUseCaseFactory.create(viewManagerModel, updateEventViewModel, updateEventDataAccessObject,event);
        views.add(updateEventView, updateEventView.viewName);

        //LoggedInView loggedInView = new LoggedInView(loggedInViewModel);
        //views.add(loggedInView, loggedInView.viewName);

        application.pack();
        application.setVisible(true);

        EventFinder ef = new EventFinderService();

//        System.out.println(ef.findEvents(
//                "Your classes will be weekly on Fridays at 2:00pm. Tests will be every other Thursday."));

    }
}
