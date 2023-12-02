package view;

import interface_adapters.convertDoc.ConvertDocController;
import interface_adapters.convertDoc.ConvertDocState;
import interface_adapters.convertDoc.ConvertDocViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ConvertDocView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "Convert Doc";
    final ConvertDocViewModel convertDocViewModel;
    final JTextField filepathInputField = new JTextField(35);
    final JLabel filepathErrorField = new JLabel();
    private final ConvertDocController convertDocController;
    final JButton convert;
    final JButton cancel;

    /**
     * Constructs a new ConvertDocView with the specified controller and ViewModel.
     *
     * @param controller the controller for the Convert Doc use case.
     * @param convertDocViewModel the ViewModel associated with this view.
     */
    public ConvertDocView(ConvertDocController controller, ConvertDocViewModel convertDocViewModel) {
        this.convertDocController = controller;
        this.convertDocViewModel = convertDocViewModel;
        convertDocViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Convert PDF Document to Correct Format");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel filenameInfo = new LabelTextPanel(
                new JLabel("Enter Filepath: "), filepathInputField);

        JPanel buttons = new JPanel();

        convert = new JButton(ConvertDocViewModel.CONVERT_BUTTON_LABEL);
        buttons.add(convert);

        cancel = new JButton(ConvertDocViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancel);

        convert.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(convert)) {
                            ConvertDocState currentState = convertDocViewModel.getState();
                            if (currentState.getFilename() == null || currentState.getFilename().isEmpty()) {
                                showPopup("Problem has occurred:\n Filepath cannot be null or empty." );
                            }
                            else {
                                convertDocController.execute(currentState.getFilename());
                            }
                        }
                    }
                }
        );

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(cancel)) {
                    // return back to a different view? or exit
                    System.exit(0);
                }
            }
        });

        filepathInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                ConvertDocState currentState = convertDocViewModel.getState();
                String text = filepathInputField.getText() + e.getKeyChar();
                currentState.setFilename(text);
                convertDocViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(filenameInfo);
        this.add(filepathErrorField);
        this.add(buttons);
    }

    /**
     * React to a button click that results in evt.
     *
     * @param evt The ActionEvent associated with the button click.
     */
    public void actionPerformed(ActionEvent evt) {
        JOptionPane.showConfirmDialog(this, "Click" + evt.getActionCommand());
    }

    /**
     * Handles property change events, updating the view based on the changes in the ViewModel.
     *
     * @param evt The PropertyChangeEvent associated with the change in the ViewModel.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ConvertDocState state = (ConvertDocState) evt.getNewValue();
        setFields(state);
    }

    /**
     * Sets the fields of the view based on the provided ConvertDocState.
     *
     * @param state the ConvertDocState containing the data to be displayed.
     */
    private void setFields(ConvertDocState state) {
        filepathInputField.setText(state.getFilename());
    }

    /**
     * Displays a popup with the specified message.
     *
     * @param Message the message to be displayed in the popup.
     */
    public void showPopup(String Message) {
        JPanel popupPanel = new JPanel();
        popupPanel.add(new JLabel(Message));

        JOptionPane.showMessageDialog(this, popupPanel, "Important!", JOptionPane.PLAIN_MESSAGE);
    }
}

