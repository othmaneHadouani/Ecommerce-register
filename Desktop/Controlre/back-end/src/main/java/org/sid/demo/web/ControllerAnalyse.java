package org.sid.demo.web;
import org.sid.demo.documents.Analyse;
import org.sid.demo.forms.AnalyseForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.sid.demo.converters.Converter;
import org.sid.demo.service.ServiceAnalyseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/products")
public class ControllerProduct {

    @Autowired
    public ServiceAnalyseImpl serviceProduct;

    @Autowired
    public Converter converter;

    @PostMapping("/addProduct")
    public Analyse addProduct(@RequestBody AnalyseForm productForm){


        return serviceProduct.addorUpdateProduct(productForm);

    }

    @PutMapping("/editProduct")
    public Analyse editProduct(@RequestBody AnalyseForm productForm){

        return serviceProduct.addorUpdateProduct(productForm);

    }

    @RequestMapping(value = "/getAllProducts" ,method = RequestMethod.GET)
    public Page<Analyse> listProducts(@RequestParam(name = "size",defaultValue = "4")int size,
                                      @RequestParam(name = "page",defaultValue = "0")int page,
                                      @RequestParam(name = "motCle",defaultValue ="")String motCle ){


        Pageable pageable = PageRequest.of(page, size);
        return serviceProduct.listProducts(motCle,pageable);
    }


    @GetMapping(path = "/disponibleProducts")
    public List<Analyse> getDisponibleProductsPerMotCle(){

        List<Analyse> products;
        products= serviceProduct.getDisponibleProducts();
        return products;
    }

    @DeleteMapping(path = "/delete/{idProduct}")
    public void deleteProduct(@PathVariable("idProduct") String idProduit){

        serviceProduct.deleteProduct(idProduit);
    }

    @RequestMapping(value = "/getProductsByCat/{idCat}" ,method = RequestMethod.GET)
    public Page<Analyse> listProducts(@RequestParam(name = "size",defaultValue = "4")int size,
                                      @RequestParam(name = "page",defaultValue = "0")int page,
                                      @RequestParam(name = "motCle",defaultValue ="")String motCle,
                                      @PathVariable("idCat") String idCat
                                      ){


        Pageable pageable = PageRequest.of(page, size);
        return serviceProduct.listProductsByCat(idCat,motCle,pageable);
    }



}
