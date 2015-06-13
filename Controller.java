package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.TextField;


import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    double currentNumber;
    double newNumber;
    String currentOperation;

    @FXML
    private TextField display;


    @FXML
    private void handleNumberAction(ActionEvent event){
        String text = ((ButtonBase) event.getSource()).getText();
        String oldText = display.getText();
        String newText = oldText.concat(text);
        display.setText(newText);
    }

    @FXML
    private void handleOperationAction(ActionEvent event){
        if (!display.getText().equals("")) {
            currentNumber = Double.parseDouble(display.getText());
            display.setText("");
            currentOperation = ((ButtonBase) event.getSource()).getText();
        }
    }

    @FXML
    private void handlePointAction(ActionEvent event){
        if (!display.equals(".")){
            display.setText(display.getText().concat("."));
        }
    }

    @FXML
    private void handleChandeSignAction (ActionEvent event) {
        if (!display.getText().equals("")) {

            currentNumber=((Double.parseDouble(display.getText()))*-1);
            showResult();
        }

    }
    @FXML
    private void handleDisplayAction (ActionEvent event) {
        if (!event.getSource().equals("[0-9]")){
            display.setText("QQ");
        }

    }

    @FXML
    private void handleSqrtAction (ActionEvent event) {
        if (!display.getText().equals("")) {

            currentNumber=(Math.sqrt(Double.parseDouble(display.getText())));
            showResult();
        }

    }

    @FXML
    private void handleEqualAction (ActionEvent event){

        if (!display.getText().equals("")) {
            newNumber = Double.parseDouble(display.getText());
            switch (currentOperation) {
                case "+":
                    currentNumber = currentNumber + newNumber;
                    break;
                case "-":
                    currentNumber = currentNumber - newNumber;
                    break;
                case "*":
                    currentNumber = currentNumber * newNumber;
                    break;
                case "/":
                    currentNumber = currentNumber / newNumber;
                    break;
                case "C":
                    display.setText("");
                    break;
                case "+/-":
                    currentNumber=currentNumber*-1;
                    break;
                case "x^y":
                    currentNumber=Math.pow(currentNumber,newNumber);
                    break;

                default:
                    break;
            }

            showResult();
        }


    }

    private void showResult(){
        if (currentNumber%1==0){
            display.setText(Integer.toString((int)currentNumber));
        } else {
            display.setText(Double.toString(currentNumber));
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
