package org.AhmedAbdullatif.dataobjects;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "userID",
        "products"
})

public class CartDetails {

    @JsonProperty("userID")
    private String title;
    @JsonProperty("products")
    private ArrayList Products;
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList getProducts() {
        return Products;
    }

    public void setProducts(ArrayList products) {
        Products = products;
    }
}
