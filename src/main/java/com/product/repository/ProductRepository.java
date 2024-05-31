package com.product.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.product.model.ProductEntity;

public interface ProductRepository extends MongoRepository<ProductEntity, ObjectId> {

	List<ProductEntity> findByActiveStatus(boolean b);

	List<ProductEntity> findByActiveStatusAndCategoryIgnoreCase(boolean b, String category);

}
