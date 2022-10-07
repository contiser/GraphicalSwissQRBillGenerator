package com.contirossini.graphicalswissqrbillgenerator;

import javafx.scene.control.Alert;
import net.codecrete.qrbill.generator.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BillGenerator {
    public static void main(String[] args) {
        SwissQRBillGenerator.main(args);
    }

    public static void GenerateBill(String iban, String amount, String creditorNameLastName, String creditorAddressLine1, String creditorAddressLine2, String communication, String debtorNameLastName, String debtorAddressLine1, String debtorAddressLine2, String saveToFile) {
        // Setup bill
        Bill bill = new Bill();
        bill.setAccount(iban);
        bill.setAmountFromDouble(Double.parseDouble(amount));
        bill.setCurrency("CHF");

        // Set creditor
        Address creditor = new Address();
        creditor.setName(creditorNameLastName);
        creditor.setAddressLine1(creditorAddressLine1);
        creditor.setAddressLine2(creditorAddressLine2);
        creditor.setCountryCode("CH");
        bill.setCreditor(creditor);

        // more bill data
        bill.setUnstructuredMessage(communication);

        // Set debtor
        Address debtor = new Address();
        debtor.setName(debtorNameLastName);
        debtor.setAddressLine1(debtorAddressLine1);
        debtor.setAddressLine2(debtorAddressLine2);
        debtor.setCountryCode("CH");
        bill.setDebtor(debtor);

        // Set output format
        BillFormat format = bill.getFormat();
        format.setGraphicsFormat(GraphicsFormat.PDF);
        format.setOutputSize(OutputSize.A4_PORTRAIT_SHEET);
        format.setLanguage(Language.IT);

        // Generate QR bill
        byte[] generated = QRBill.generate(bill);

        // Save QR bill

        Path path = Paths.get(saveToFile);
        try {
            Files.write(path, generated);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("File saved to: " + saveToFile);
            alert.showAndWait();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
