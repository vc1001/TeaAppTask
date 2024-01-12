package com.example.tea.model;

public class CategoryModel {

        int image;
        String catname;
        public CategoryModel(int image, String catname) {
            this.image = image;
            this.catname = catname;
        }
        public int getImage() {
            return image;
        }
        public void setImage(int image) {
            this.image = image;
        }
        public String getCatname() {
            return catname;
        }
        public void setCatname(String catname) {
            this.catname = catname;
        }
}
