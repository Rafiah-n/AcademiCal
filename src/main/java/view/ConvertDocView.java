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
                            convertDocController.execute(currentState.getFilename());
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
     */
    public void actionPerformed(ActionEvent evt) {
        JOptionPane.showConfirmDialog(this, "Click" + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        ConvertDocState state = (ConvertDocState) evt.getNewValue();
        setFields(state);
    }

    private void setFields(ConvertDocState state) {
        filepathInputField.setText(state.getFilename());
    }

}

