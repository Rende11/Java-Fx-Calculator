package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.TextField;



import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    double currentNumber;
    double newNumber;
    private final String DEFAULT_OPERATION = "0";
    String currentOperation = DEFAULT_OPERATION;

    @FXML
    private TextField display;


    @FXML
    private void handleNumberAction(ActionEvent event){
        String textFromButton = ((ButtonBase) event.getSource()).getText();
        String oldTextFromDisplay = display.getText();
        String newTextToDisplay = oldTextFromDisplay.concat(textFromButton);

        if (!display.getText().equals("0"))
        display.setText(newTextToDisplay);
    }

    @FXML
    private void handleZeroAction(ActionEvent event){
        String textFromButton = ((ButtonBase) event.getSource()).getText();

        if (!(display.getText().equals("0"))) {

            String oldTextFromDisplay = display.getText();
            String newTextToDisplay = oldTextFromDisplay.concat(textFromButton);
            display.setText(newTextToDisplay);
        }
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
        if (!display.getText().contains(".")){
            display.setText(display.getText().concat("."));
        }
        if (display.getText().equals(".")){
            display.setText("0.");
        }


    }

    @FXML
    private void handleChandeSignAction(ActionEvent event) {
        if (!display.getText().equals("")) {

            currentNumber=((Double.parseDouble(display.getText()))*-1);
            showResult();
        }

    }

    @FXML
    private void handleClearAction(ActionEvent event) {

        display.setText("");
        currentNumber=0;
        currentOperation=DEFAULT_OPERATION;

    }

    @FXML
    private void handleRemoveSymbolAction(ActionEvent event) {
        if (!display.getText().equals("")) {
            String textToDisplay="";
            char [] charsFromDisplay = display.getText().toCharArray();

            List textFromDisplay = new ArrayList();

            for (char c : charsFromDisplay) {

                textFromDisplay.add(c);
            }

            textFromDisplay.remove(charsFromDisplay.length-1);

            for (Object o : textFromDisplay ){
                   textToDisplay=textToDisplay.concat(o.toString());
            }

            display.setText(textToDisplay);
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
    private void handle1xAction (ActionEvent event) {
        if (!display.getText().equals("")) {

            currentNumber=1/Double.parseDouble(display.getText());
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
