package books.LearnJavaFX8.chapter2;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Monitor {

    public static final String DEFAULT_SCREEN_TYPE = "flat";
    private StringProperty screenType;

    public String getScreenType() {
        return (this.screenType == null) ? this.DEFAULT_SCREEN_TYPE : this.screenType.get();
    }

    public void setScreenType(String newScreenType) {
        if (this.screenType != null || !DEFAULT_SCREEN_TYPE.equals(newScreenType)) {
            this.screenTypeProperty().set(newScreenType);
        }
    }

    public StringProperty screenTypeProperty() {
        if (this.screenType == null) {
            this.screenType = new SimpleStringProperty(this, "screenType", this.DEFAULT_SCREEN_TYPE);
        }
        return this.screenType;
    }
}
