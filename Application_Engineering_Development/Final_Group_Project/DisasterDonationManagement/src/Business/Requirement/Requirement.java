/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Requirement;

/**
 *
 * @author Eshanee Thakur
 */
public class Requirement {

    public String area;
    public String itemName;
    public String category;

    public int initialRequirementCount; //
    public int requirementCount;
    public int collectedCount;//Group by item name, not considering area
    public int shippedCount;
    public int donorTargetCount;//Group by item name, not considering area

    public enum Category {
        Food("Food"), Medicines("Medicines"), Clothes("Clothes"), BasicAmenities("BasicAmenities");

        private String value;

        private Category(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getRequirementCount() {
        return requirementCount;
    }

    public void setRequirementCount(int requirementCount) {
        this.requirementCount = requirementCount;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCollectedCount() {
        return collectedCount;
    }

    public void setCollectedCount(int collectedCount) {
        this.collectedCount = collectedCount;
    }

    public int getShippedCount() {
        return shippedCount;
    }

    public void setShippedCount(int shippedCount) {
        this.shippedCount = shippedCount;
    }

    public int getDonorTargetCount() {
        return donorTargetCount;
    }

    public void setDonorTargetCount(int donorTargetCount) {
        this.donorTargetCount = donorTargetCount;
    }

    public int getInitialRequirementCount() {
        return initialRequirementCount;
    }

    public void setInitialRequirementCount(int initialRequirementCount) {
        this.initialRequirementCount = initialRequirementCount;
    }

    @Override
    public String toString() {
        return itemName;
    }

}
