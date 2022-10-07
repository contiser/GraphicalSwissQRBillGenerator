module com.contirossini.graphicalswissqrbillgenerator {
    requires javafx.controls;
    requires javafx.fxml;
    requires qrbill.generator;


    opens com.contirossini.graphicalswissqrbillgenerator to javafx.fxml;
    exports com.contirossini.graphicalswissqrbillgenerator;
}