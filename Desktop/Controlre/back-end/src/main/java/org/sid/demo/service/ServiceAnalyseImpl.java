package org.sid.demo.service;

import org.sid.demo.converters.Converter;
import org.sid.demo.dao.AnalyseRepository;
import org.sid.demo.dao.ProductRepository;
import org.sid.demo.documents.Analyse;
import org.sid.demo.forms.ProductForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ServiceProductImpl implements IServiceProduct {


    @Autowired
    Converter converter;

    @Autowired
    public AnalyseRepository analyseRepository;


    @Override
    public Analyse addorUpdateProduct(ProductForm productForm) {


            Analyse product = converter.AnalyseFormToAnalyseAdd(productForm);
            product = productRepository.save(product);
            return product;


    }

    @Override
    public void deleteProduct(String idProduct) {

        productRepository.deleteById(idProduct);
    }

    @Override
    public void deleteProduct(Analyse product) {

        productRepository.delete(product);
    }

    @Override
    public Page<Analyse> listProducts(String motCle, Pageable pageable) {
       return this.productRepository.findAll(motCle,pageable);
    }


    @Override
    public List<Analyse> getDisponibleProducts() {
        return productRepository.findAll();
    }

    @Override
    public Page<Analyse> listProductsByCat(String idCat, String motCle, Pageable pageable) {
        return this.productRepository.findAllByCategory_Id(idCat,motCle,pageable);
    }
}
