module Prüfungsleistung_Teil_3 {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires java.sql;
	exports dialog_javafx;
	exports dialog_javafx.einsatzplanung;
	opens start to javafx.graphics, javafx.fxml;
	opens dialog_javafx.einsatzplanung to javafx.graphics, javafx.fxml;
	
}
