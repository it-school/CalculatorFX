package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;


public class Controller
{
    @FXML
    public TextField txtData;
    @FXML
    private Label labelMemory;

    private final Calculator calculator;
    @FXML
    private Button btnnn;
    private boolean isSecondNumber;

    public Controller()
    {
        txtData = new TextField();
        calculator = new Calculator();
        isSecondNumber = false;
    }

    private String delZeroAtEnd(final String input) // Delete last zero
    {
        return input.endsWith(".0") ? input.substring(0, input.length() - 2) : input;
    }
//      new Alert(Alert.AlertType.CONFIRMATION, txtData.getText()).show();

    public void btnNumberClick(final ActionEvent actionEvent) {
        String btnText = ((Button) actionEvent.getSource()).getText();
        txtData.setText(txtData.getText().equals("0") || (isSecondNumber == true) ? btnText : txtData.getText() + btnText);
        isSecondNumber = false;
        calculator.setFirstCalculation(true);
    }

    public void btnCommaClick(final ActionEvent actionEvent) {
/*
        if (!txtData.getText().contains("."))
            txtData.setText(txtData.getText() + "." );
*/
        txtData.setText(txtData.getText() + ((!txtData.getText().contains(".")) ? "." : ""));
        calculator.setFirstCalculation(true);
    }

    public void btnClearClick(final ActionEvent actionEvent) {
        txtData.setText("0");
        calculator.setFirstCalculation(true);
    }

    public void btnSignClick(final ActionEvent actionEvent) {

        txtData.setText(delZeroAtEnd(String.valueOf(-1 * Double.parseDouble(txtData.getText()))));
        calculator.setFirstCalculation(true);
    }

    public void btnOperationClick(final ActionEvent actionEvent)
    {
        try {
            calculator.setNumber1(Double.parseDouble(txtData.getText()));
            switch (((Button) actionEvent.getSource()).getText()) {
                case "+":
                    calculator.setOperation(Operation.PLUS);
                    break;
                case "-":
                    calculator.setOperation(Operation.MINUS);
                    break;
                case "*":
                    calculator.setOperation(Operation.MULTIPLY);
                    break;
                case "/":
                    calculator.setOperation(Operation.DIVIDE);
                    break;
                case "x^y":
                    calculator.setOperation(Operation.POWER);
                    break;
                case "√":
                    calculator.setOperation(Operation.SQRT);
                    calculator.calculate();
                    txtData.setText(delZeroAtEnd(calculator.getResult()));
                    txtData.setAlignment(Pos.CENTER_RIGHT);
                    break;
                default:
                    calculator.setOperation(Operation.UNASSIGNED);
                    break;
            }
            isSecondNumber = true;
            calculator.setFirstCalculation(true);
            //txtData.setText("0");
        } catch (NumberFormatException ex)
        {
            txtData.setText("Number conversion error");
        } catch (Exception ex)
        {
            txtData.setText(ex.getMessage());
        }
    }

    public void btnResultClick(ActionEvent actionEvent) {

        try {
            if (calculator.isFirstCalculation())
                calculator.setNumber2(Double.parseDouble(txtData.getText()));
        } catch (NumberFormatException ex)
        {
            txtData.setText("Number conversion error");
        }

        calculator.calculate();
        calculator.setNumber1(Double.parseDouble(calculator.getResult()));
        calculator.setFirstCalculation(false);

        txtData.setText(delZeroAtEnd(calculator.getResult()));
        txtData.setText(calculator.getResult());
    }

    public void btnMemoryClearClick(ActionEvent actionEvent) {
        calculator.setMemory(0);
        isSecondNumber = true;
        labelMemory.setVisible(false);
    }

    public void btnMemoryReadClick(ActionEvent actionEvent) {
        txtData.setText(delZeroAtEnd(String.valueOf(calculator.getMemory())));
        isSecondNumber = true;
    }

    public void btnMemeoryAddClick(ActionEvent actionEvent) {
        double memory = 0;
        try {
            memory = Double.parseDouble(txtData.getText());
        } catch (NumberFormatException ex)
        {
            txtData.setText("Number conversion error");
            return;
        }
        calculator.setMemory(calculator.getMemory() + memory);
        isSecondNumber = true;
        labelMemory.setVisible(calculator.getMemory() != 0);
    }

    public void btnMemorySubtractClick(ActionEvent actionEvent) {
        double memory = 0;
        try {
            memory = Double.parseDouble(txtData.getText());
        } catch (Exception ex) {
            txtData.setText("Number conversion error");
        }
        calculator.setMemory(calculator.getMemory() - memory);
        isSecondNumber = true;
        labelMemory.setVisible(calculator.getMemory() != 0);
    }

    public void buttonPressed(KeyEvent keyEvent) {
        txtData.setText(txtData.getText() + (keyEvent.getText().contains("0") ? keyEvent.getText() : ""));
        //
    }
}
