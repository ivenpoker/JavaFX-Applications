package books.LearnJavaFX8.chapter2;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Item {

    private DoubleProperty weight;
    private double _weight = 150;

    public double getWeight() {
        return (this.weight == null)  ? this._weight : this.weight.get();
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
        return this.weight;
    }

}

