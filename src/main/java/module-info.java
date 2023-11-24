module com.chicha.demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.chicha.demo to javafx.fxml;
    exports com.chicha.demo;
}