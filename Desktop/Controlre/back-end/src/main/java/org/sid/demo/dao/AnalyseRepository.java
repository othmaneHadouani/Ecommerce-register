package org.sid.demo.dao;

import org.sid.demo.documents.Analyse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource

public interface AnalyseRepository extends MongoRepository<Analyse,String>/*,CustomProductRepository*/ {


    @Query("{'name' : {$regex:?0, $options: i}}")
    Page<Analyse> findAll(String motCle, Pageable pageable);

    @Query("{'name' : {$regex:?1, $options: i},'category.id' : ?0 }")
    Page<Analyse> findAllByCategory_Id(String idCat, String motCle, Pageable pageable);
}
