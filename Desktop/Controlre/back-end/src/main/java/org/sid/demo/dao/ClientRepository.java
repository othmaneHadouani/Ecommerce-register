package org.sid.demo.dao;


import org.sid.demo.documents.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface ClientRepository extends MongoRepository<Client,String> {

   /* @Query("{'name' : {$regex:?0, $options: i}}")
    Page<Client> findAll(String motCle, Pageable pageable);*/

}
