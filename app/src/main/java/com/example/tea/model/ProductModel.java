package com.example.tea.model;

public class ProductModel {
    int ProductImage,ProductRating;
    String ProductName,ProductPrice;

    public ProductModel(int productImage, int productRating, String productPrice, String productName) {
        ProductImage = productImage;
        ProductRating = productRating;
        ProductPrice= productPrice;
        ProductName = productName;
    }

    public int getProductImage() {
        return ProductImage;
    }

    public void setProductImage(int productImage) {
        ProductImage = productImage;
    }

    public int getProductRating() {
        return ProductRating;
    }

    public void setProductRating(int productRating) {
        ProductRating = productRating;
    }

    public String getProductPrice() {
        return ProductPrice;
    }

    public void setProductPrice(String productPrice) {
        ProductPrice = productPrice;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }
}
