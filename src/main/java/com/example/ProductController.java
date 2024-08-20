package com.example;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductController {

    @GET
    public List<Product> getAllProducts() {
        return Product.listAll();
    }

    @GET
    @Path("{id}")
    public Product getProduct(@PathParam("id") Long id) {
        return Product.findById(id);
    }

    @POST
    @Transactional
    public Product addProduct(Product product) {
        product.persist();
        return product;
    }

    @PUT
    @Path("{id}")
    @Transactional
    public Product updateProduct(@PathParam("id") Long id, Product product) {
        Product entity = Product.findById(id);
        if(entity == null) {
            throw new NotFoundException();
        }
        entity.name = product.name;
        entity.price = product.price;
        return entity;
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void deleteProduct(@PathParam("id") Long id) {
        Product entity = Product.findById(id);
        if(entity == null) {
            throw new NotFoundException();
        }
        entity.delete();
    }
}
