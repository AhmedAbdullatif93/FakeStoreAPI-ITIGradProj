package org.AhmedAbdullatif.payload;

import com.github.javafaker.Faker;
import org.AhmedAbdullatif.dataobjects.CartDetails;
import org.AhmedAbdullatif.dataobjects.ProductDetails;
import org.AhmedAbdullatif.dataobjects.UserDetails;

public class RequestPayloads {

    public ProductDetails setProductPayload(){
        ProductDetails productDetails = new ProductDetails();
        productDetails.setTitle("Pikachu pijama");
        productDetails.setPrice(500);
       productDetails.setDescription("Pijamas Unisex Adult Cosplay Pikachu");
        productDetails.setCategory("women's clothing");
        return productDetails;
    }

    public ProductDetails setToUpdateProductPayload(){
        ProductDetails productDetails = new ProductDetails();
        productDetails.setTitle("Yoda pijama");
        productDetails.setPrice(550);
        return productDetails;
    }

    public UserDetails setUserPayload(){
        Faker faker = new Faker();
        UserDetails userDetails = new UserDetails();
        userDetails.setEmail(faker.internet().emailAddress());
        userDetails.setUsername(faker.name().username());
        userDetails.setPassword(faker.internet().password());
        userDetails.setPhone(faker.phoneNumber().phoneNumber());
        return userDetails;
    }

    public UserDetails setToUpdateUserPayload(){
        Faker faker = new Faker();
        UserDetails userDetails = new UserDetails();
        userDetails.setUsername(faker.name().username());
        userDetails.setEmail(faker.internet().emailAddress());
        return userDetails;
    }

}
