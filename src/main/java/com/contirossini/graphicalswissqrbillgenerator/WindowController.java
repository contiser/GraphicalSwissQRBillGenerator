package com.contirossini.graphicalswissqrbillgenerator;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

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

    @FXML
    protected void onSubmit() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialFileName("qrbill");
        File selectedFile = fileChooser.showSaveDialog(SwissQRBillGenerator.getScene().getWindow());
        if (!selectedFile.toString().endsWith(".svg")) {
            selectedFile = new File(selectedFile.toString() + ".svg");
        }
        BillGenerator.GenerateBill(iban.getText(), amount.getText(), creditorFLName.getText(), creditorStreet.getText(),
                creditorLocation.getText(), message.getText(), debtorFLName.getText(), debtorStreet.getText(),
                debtorLocation.getText(), selectedFile.toString());
        System.out.println("Saved to:" + selectedFile);
    }
}