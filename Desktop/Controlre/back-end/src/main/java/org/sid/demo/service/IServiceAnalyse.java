package org.sid.demo.service;

import org.sid.demo.documents.Analyse;
import org.sid.demo.forms.ProductForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IServiceAnalyse {

    public Analyse addorUpdateProduct(ProductForm productForm);
    public void deleteProduct(String idProduct);
    public void deleteProduct(Analyse product);
    public Page<Analyse> listProducts(String motCle, Pageable pageable);
    public List<Analyse> getDisponibleProducts();

    Page<Analyse> listProductsByCat(String idCat, String motCle, Pageable pageable);
}
