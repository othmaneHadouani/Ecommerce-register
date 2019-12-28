package org.sid.demo.service;

import org.sid.demo.converters.Converter;
import org.sid.demo.dao.CategoryRepository;
import org.sid.demo.documents.Client;
import org.sid.demo.forms.CategoryForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ServiceCategoryImpl implements IServiceCategory {


    @Autowired
    public CategoryRepository categoryRepository;

    @Autowired
    public Converter converter;


    @Override
    public Client addorUpdateCategory(CategoryForm categoryForm) {

        Client category = converter.categoryFormToCategory(categoryForm);
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(String idCategory) {

        categoryRepository.deleteById(idCategory);
    }

    @Override
    public void deleteCategory(Client category) {

        categoryRepository.delete(category);
    }

    @Override
    public Page<Client> listCategories(String motCle, Pageable pageable) {

        return this.categoryRepository.findAll(motCle,pageable);

    }

    @Override
    public List<Client> listCategories() {
        return this.categoryRepository.findAll();
    }


    @Override
    public Optional<Client> getCategoryById(String id) {
        return categoryRepository.findById(id);
    }
}
