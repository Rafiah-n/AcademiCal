package app;

import entity.EventFinder;
import entity.EventFinderService;

public class Main {

    public static void main(String[] args) {

        EventFinder ef = new EventFinderService();

        System.out.println(ef.findEvents(
                "Your classes will be weekly on Fridays at 2:00pm. Tests will be every other Thursday."));

    }

}