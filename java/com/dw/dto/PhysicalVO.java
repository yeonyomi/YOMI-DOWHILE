package com.dw.dto;

public class PhysicalVO {
   private String id;
   private String physicaldate;
   private String weight;
   private String height;
   private String fat;
   private String muscle;
   
   
   public String getId() {
      return id;
   }
   public void setId(String id) {
      this.id = id;
   }
   public String getPhysicaldate() {
      return physicaldate;
   }
   public void setPhysicaldate(String physicaldate) {
      this.physicaldate = physicaldate;
   }
   public String getWeight() {
      return weight;
   }
   public void setWeight(String weight) {
      this.weight = weight;
   }
   public String getHeight() {
      return height;
   }
   public void setHeight(String height) {
      this.height = height;
   }
   public String getFat() {
      return fat;
   }
   public void setFat(String fat) {
      this.fat = fat;
   }
   public String getMuscle() {
      return muscle;
   }
   public void setMuscle(String muscle) {
      this.muscle = muscle;
   }
   @Override
   public String toString() {
      return "PhysicalVO [id=" + id + ", physicaldate=" + physicaldate + ", weight=" + weight + ", height=" + height
            + ", fat=" + fat + ", muscle=" + muscle + "]";
   }
   

}