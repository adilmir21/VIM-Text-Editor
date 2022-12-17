module ui.project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens ui.project to javafx.fxml;
    exports ui.project;
    exports BL;
    opens BL to javafx.fxml;
}