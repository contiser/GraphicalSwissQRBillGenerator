package com.contirossini.graphicalswissqrbillgenerator;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import net.codecrete.qrbill.generator.Payments;

import java.io.File;

public class WindowController {
    public TextField iban;
    public TextField amount;
    public TextField message;
    public TextField debtorFLName;
    public TextField creditorFLName;
    public TextField creditorStreet;
    public TextField creditorLocation;
    public TextField debtorStreet;
    public TextField debtorLocation;
    public Text errorField;
    public TextField qrReferenceCode;
    public Text qrReferenceCodeText;

    @FXML
    protected void onSubmit() {
        if(!checkInput()) return;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialFileName("qrbill");
        File selectedFile = fileChooser.showSaveDialog(SwissQRBillGenerator.getScene().getWindow());
        if(selectedFile.toString().length()==0){
            errorField.setText("Please select a valid Filepath and try again.\n");
        }
        if (!selectedFile.toString().endsWith(".pdf")) {
            selectedFile = new File(selectedFile + ".pdf");
        }
        BillGenerator.GenerateBill(iban.getText(), amount.getText(), creditorFLName.getText(), creditorStreet.getText(),
                creditorLocation.getText(), message.getText(), debtorFLName.getText(), debtorStreet.getText(),
                debtorLocation.getText(), qrReferenceCode.getText(), selectedFile.toString());
        System.out.println("Saved to:" + selectedFile);
    }

    protected boolean checkInput(){
        errorField.setText("");
        String errorMessage = "";
        if(!Payments.isValidIBAN(iban.getText())){
            errorMessage += "The provided iban is not valid, please check and retry.\n";
        }
        try {
            Double.parseDouble(amount.getText());
        } catch (NumberFormatException ignore) {
            errorMessage += "The provided Payable amount is not valid, please check and retry.\n";
        }
        if(Payments.isQRIBAN(iban.getText()) && !Payments.isValidQRReference(qrReferenceCode.getText())){
            errorMessage += "The provided QR Reference is not valid, please check and retry.\n";
        }
        if(errorMessage.length()>0){
            errorField.setText(errorMessage);
            return false;
        }
        errorField.setText("");
        return true;
    }

    public void validateInput() {
        checkInput();
        if (Payments.isQRIBAN(iban.getText())) {
            // Add the field for reference
            qrReferenceCodeText.setVisible(true);
            qrReferenceCode.setVisible(true);
        }
    }
}