package org.AhmedAbdullatif.endpoints;

public class APIConstants {


    public final static String baseUrl = "https://fakestoreapi.com";

    //Products
    public final static String getOrCreateProducts = "/products";
    public final static String getProduct = "/products";
    public final static String getProductByCategory = "/products/category/{category}";
    public final static String updateProduct = "/products/{id}";
    public final static String deleteProduct = "/products/{id}";

    //Users
    public final static String getOrCreateUsers = "/users";
    public final static String getUser = "/users/{id}";
    public final static String updateOrDeleteUser = "/users/{id}";
    public final static String invalidRequest = "/users/opa/22";

    //Login
    public final static String loginAuth = "/auth/login";

    //Carts
    public final static String getOrAddCarts = "/carts";
    public final static String deleteCart = "/carts/{cart}";

}
