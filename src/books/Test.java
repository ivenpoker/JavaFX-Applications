package books;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Test {

    public class Monitor {

        public static final String DEFAULT_SCREEN_TYPE = "flat";
        private StringProperty screenType;

        public String getScreenType() {
            return (this.screenType == null) ? DEFAULT_SCREEN_TYPE : this.screenType.get();
        }

        public void setScreenType(String newScreenType) {
            if (this.screenType != null || !DEFAULT_SCREEN_TYPE.equals(newScreenType)) {
                this.screenTypeProperty().set(newScreenType);
            }
        }

        public StringProperty screenTypeProperty() {
            if (this.screenType == null) {
                this.screenType = new SimpleStringProperty(this, "screenType", DEFAULT_SCREEN_TYPE);
            }
            return this.screenType;
        }
    }

    public class Item {

        private DoubleProperty weight;
        private double _weight = 150;

        public double getWeight() {
            return (this.weight == null) ? this._weight : this.weight.get();
        }

        public void setWeight(double newWeight) {
            if (this.weight == null) {
                this._weight = newWeight;
            } else {
                this.weight.set(newWeight);
            }
        }

        public DoubleProperty weightProperty() {
            if (this.weight == null) {
                this.weight = new SimpleDoubleProperty(this, "weight", this._weight);
            }
            return weight;
        }
    }
}
