# AcademiCal

Project Blueprint:
The user is able to sign in with their Google account (google OAUTH pop-up). The system should automatically convert syllabus/academic calendar (.pdf, .docx, or web-based formats) into usable plaintext, and then aid the user by streamlining the process of inputting the dates and times into the software’s database/google calendar.
It should then automatically create events, on the user’s calendar, based on these syllabus events. If some events are not included on the syllabus, the user should be able to manually input assignments. Users should also be able to edit/update events. The user can preview their Google Calendar on the interface to view their created events.

Postponed features:
  - Link and attach resources involved with the event for ease of user  
  - If the user wants to change something (appearance, notification settings, date/time format or timezone) there should be a settings menu to change it, and a way to save settings upon closing the app.
  - Automatically plan and schedule studying blocks (eg. 2 weeks before the exam period, the system would create relevant events within the calendar)

CORE use-case (Main workflow):
- User clicks import syllabus and the system opens a window asking for a file.
- User supplies general information (course, year, semester)
Main loop:
  - Program opens file in a view and asks for user to click on/highlight event information (date, time, name)
  - Program creates a temporary event, and allows user to click on/highlight other information to add it to the event details
  - This user-input is how the program will be able to distinguish between potentially ambiguous information (e.g. 10-11-2023 potentially being October 11th or November 10th)
  - User potentially edits information
  - Program finalizes event upon clicking “okay” or “save” or something like that
  - Program stores event locally/in google calendar

UML - Class Diagram:

UML - Sequence Diagram:

<img width="296" alt="image" src="https://github.com/Rafiah-n/AcademiCal/assets/54577192/4c752738-1de2-4c5f-b9da-9cb44de259f6">
