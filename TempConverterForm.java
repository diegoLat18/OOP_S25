package CelsiusesFahrenheit;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TempConverterForm {
    public JPanel mainPanel;
    public JTextField celsiusInput;
    public JTextField fahrenheitOutput;
    public JButton switchButton;     // formerly toggleButton
    public JButton convertButton;
    private JLabel celsiusLabel;
    private JLabel fahrenheitLabel;

    private boolean isCelsiusToFahrenheit = true;

    public TempConverterForm() {
        updateMode();

        switchButton.addActionListener(new ActionListener() { //button to switch from cel to far and viceversa
            @Override
            public void actionPerformed(ActionEvent e) {
                isCelsiusToFahrenheit = !isCelsiusToFahrenheit;
                updateMode();
            }
        });

        convertButton.addActionListener(new ActionListener() { // button for activate the conversion
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (isCelsiusToFahrenheit) {
                        String input = celsiusInput.getText().trim();
                        double celsius = Double.parseDouble(input);
                        double fahrenheit = (celsius * 9.0 / 5.0) + 32;
                        fahrenheitOutput.setText(String.format("%.1f", fahrenheit));
                    } else {
                        String input = fahrenheitOutput.getText().trim();
                        double fahrenheit = Double.parseDouble(input);
                        double celsius = (fahrenheit - 32) * 5.0 / 9.0;
                        celsiusInput.setText(String.format("%.1f", celsius));
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(mainPanel, "Please enter a valid number.");
                }
            }
        });
    }

    private void updateMode() {
        if (isCelsiusToFahrenheit) {
            switchButton.setText("Celsius to Fahrenheit");
            celsiusLabel.setText("Celsius");
            fahrenheitLabel.setText("Fahrenheit");

            celsiusInput.setEditable(true);
            fahrenheitOutput.setEditable(false);

            celsiusInput.setText("");
            fahrenheitOutput.setText("");
            celsiusInput.requestFocusInWindow();
        } else {
            switchButton.setText("Fahrenheit to Celsius");
            celsiusLabel.setText("Fahrenheit");
            fahrenheitLabel.setText("Celsius");

            fahrenheitOutput.setEditable(true);
            celsiusInput.setEditable(false);

            fahrenheitOutput.setText("");
            celsiusInput.setText("");
            fahrenheitOutput.requestFocusInWindow();
        }
    }

}

