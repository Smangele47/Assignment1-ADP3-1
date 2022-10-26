
package za.ac.cput.domain;

/* Meal.java
 * Entity for Meal
 * Author: Smangele Witness Mabaso (220047154)
 * Date: 30 March 2022
 */

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
public class Meal implements Serializable {
    //Objects
    @NotNull
    @Id
    private String mealCode;
    private String mealName, mealStatus;
    private double mealPrice;
    private boolean isTakeAway;


    private Meal(){}

    //Private Constructor
    private Meal(Builder builder){
        this.mealName = builder.mealName;
        this.mealCode = builder.mealCode;
        this.mealPrice = builder.mealPrice;
        this.isTakeAway = builder.isTakeAway;
        this.mealStatus = builder.mealStatus;
    }

    //Constructor
    public Meal(String mealName, String mealCode, double mealPrice, boolean isTakeAway, String mealStatus) {
        this.mealName = mealName;
        this.mealCode = mealCode;
        this.mealPrice = mealPrice;
        this.isTakeAway = isTakeAway;
        this.mealStatus = mealStatus;
    }

    //Getters and Setters
    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getMealCode() {
        return mealCode;
    }

    public void setMealCode(String mealCode) {
        this.mealCode = mealCode;
    }

    public double getMealPrice() {
        return mealPrice;
    }

    public void setMealPrice(double mealPrice) {
        this.mealPrice = mealPrice;
    }

    public boolean isTakeAway() {
        return isTakeAway;
    }

    public void setTakeAway(boolean takeAway) {
        isTakeAway = takeAway;
    }

    public String getMealStatus() {
        return mealStatus;
    }

    public void setMealStatus(String mealStatus) {
        this.mealStatus = mealStatus;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "mealName='" + mealName + '\'' +
                ", mealCode='" + mealCode + '\'' +
                ", mealPrice=" + mealPrice +
                ", isTakeAway=" + isTakeAway +
                ", mealStatus='" + mealStatus + '\'' +
                '}';
    }

    //Builder
    public static class Builder{
        private String mealName;
        private String mealCode;
        private double mealPrice;
        private boolean isTakeAway;
        private String mealStatus;

        public String getMealName() {
            return mealName;
        }

        public Builder setMealName(String mealName) {
            this.mealName = mealName;
            return this;
        }

        public String getMealCode() {
            return mealCode;
        }

        public Builder setMealCode(String mealCode) {
            this.mealCode = mealCode;
            return this;
        }

        public double getMealPrice() {
            return mealPrice;
        }

        public Builder setMealPrice(double mealPrice) {
            this.mealPrice = mealPrice;
            return this;
        }

        public boolean isTakeAway() {
            return isTakeAway;
        }

        public Builder setTakeAway(boolean takeAway) {
            isTakeAway = takeAway;
            return this;
        }

        public String getMealStatus() {
            return mealStatus;
        }

        public Builder setMealStatus(String mealStatus) {
            this.mealStatus = mealStatus;
            return this;
        }

        public Builder copy(Meal meal){
            this.mealName=meal.mealName;
            this.mealCode = meal.mealCode;
            this.mealPrice = meal.mealPrice;
            this.isTakeAway = meal.isTakeAway;
            this.mealStatus = meal.mealStatus;
            return this;
        }

        public Meal build(){
            return new Meal(this);
        }

    }

}
