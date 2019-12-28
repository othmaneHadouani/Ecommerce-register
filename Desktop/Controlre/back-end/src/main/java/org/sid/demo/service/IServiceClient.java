package org.sid.demo.service;

import org.sid.demo.documents.Client;
import org.sid.demo.forms.CategoryForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IServiceClient {

    public Client addorUpdateCategory(CategoryForm categoryForm);
    public void deleteCategory(String idCategory);
    public void deleteCategory(Client category);
    public Page<Client> listCategories(String motCle, Pageable pageable);
    public List<Client> listCategories();
    public Optional<Client> getCategoryById(String id);
}
