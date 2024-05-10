package com.example.product_entity.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.product_entity.exception.ProductNotFoundByIdException;
import com.example.product_entity.exception.ProductNotFoundException;
import com.example.product_entity.model.Product;
import com.example.product_entity.productdto.ProductDTO;
import com.example.product_entity.repository.ProductRepository;
import com.example.product_entity.service.ProductService;
import com.example.product_entity.utility.ResponseStructure;
@Service
public class ProductImlp implements ProductService{

	private ProductRepository productRepository;

	private ResponseStructure<Product> responceStructer;

	private ResponseStructure<List<Product>> structureList;

	public ProductImlp(ProductRepository productRepository, ResponseStructure<Product> responceStructer,
			ResponseStructure<List<Product>> structureList) {

		this.productRepository = productRepository;
		this.responceStructer = responceStructer;
		this.structureList = structureList;
	}

	//	@Override
	//	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product) {
	//		// TODO Auto-generated method stub
	//		Product product2 = productRepository.save(product);
	//
	//		ResponseStructure<Product> responceStructer=new ResponseStructure<>();
	//		responceStructer.setStatuscode(HttpStatus.CREATED.value());
	//		responceStructer.setMessage("Product object created successfuly");
	//		responceStructer.setData(product2);
	//
	//
	//		return new ResponseEntity<ResponseStructure<Product>>(responceStructer,HttpStatus.CREATED);
	//
	//	}

	@Override
	public ResponseEntity<ResponseStructure<Product>> findByProductId(int productId) {
		// TODO Auto-generated method stub
		//		Optional<Product> optional = productRepository.findById(productId);
		//		if(optional.isPresent()) {
		//			Product product = optional.get();
		//			
		//			ResponseStructure<Product> responceStructer=new ResponseStructure<>();
		//			responceStructer.setStatuscode(HttpStatus.FOUND.value());
		//			responceStructer.setMessage("data found  successfuly");
		//			responceStructer.setData(product);
		//			
		//			return new ResponseEntity<ResponseStructure<Product>>(responceStructer,HttpStatus.FOUND);
		//		}
		//		else {
		//			throw new ProductNotFoundByIdException("Product not found");
		//		}

		//		****** Or using lambda function *****

		return productRepository.findById(productId).map(product -> ResponseEntity.ok(
				responceStructer.setStatuscode(HttpStatus.OK.value())
				.setMessage("Product found ")
				.setData(product)))
				.orElseThrow(()-> new ProductNotFoundByIdException("Product not found"));		
	}

	@Override
	public ResponseEntity<ResponseStructure<Product>> updateByProductId(int productId, Product updatedProduct) {
		// TODO Auto-generated method stub
		//		Optional<Product> optional = productRepository.findById(productId);
		//		if(optional.isPresent()) {
		//			Product existingActor = optional.get();
		//
		//			updatedProduct.setProductId(existingActor.getProductId()); //this line helps to setting same id to new one
		//			ResponseStructure<Product> responceStructer=new ResponseStructure<>();
		//			responceStructer.setStatuscode(HttpStatus.OK.value());
		//			responceStructer.setMessage("updated id  successfuly");
		//			responceStructer.setData(updatedProduct);
		//			
		//			Product product2 = productRepository.save(updatedProduct);
		//
		//			return new ResponseEntity<ResponseStructure<Product>>(responceStructer,HttpStatus.OK);
		//		}
		//
		//		throw new ProductNotFoundByIdException("Product not found");

		//		****** Or using lambda function *****

		return productRepository.findById(productId).map(existingProduct -> {
			updatedProduct.setProductId(existingProduct.getProductId());
			Product savedProduct = productRepository.save(updatedProduct);
			return ResponseEntity.ok(responceStructer.setStatuscode(HttpStatus.OK.value())
					.setMessage("Data updated successfully")
					.setData(updatedProduct));
		}).orElseThrow(()->new ProductNotFoundException("Not Found"));


	}

	@Override
	public ResponseEntity<ResponseStructure<Product>> deleteByProductId(int productId) {
		// TODO Auto-generated method stub

		Optional<Product> optional = productRepository.findById(productId);

		if(optional.isPresent()) {
			Product product = optional.get();

			productRepository.deleteById(productId);
			ResponseStructure<Product> responceStructer=new ResponseStructure<>();
			responceStructer.setStatuscode(HttpStatus.OK.value());
			responceStructer.setMessage("Product deleted successfuly");
			responceStructer.setData(product);

			return new ResponseEntity<ResponseStructure<Product>>(responceStructer,HttpStatus.OK);
		}
		else {

			throw new ProductNotFoundByIdException("Product not found");
		}

		//		return productRepository.findById(productId).map(product -> ResponseEntity.ok(
		//				responceStructer.setStatuscode(HttpStatus.OK.value())
		//				.setMessage("Product found ")
		//				.setData(product)))
		//				.orElseThrow(()-> new ProductNotFoundByIdException("Product not found"));		

	}

	@Override
	public ResponseEntity<ResponseStructure<List<Product>>> findAllProduct() {
		// TODO Auto-generated method stub
		//		List<Product> list = productRepository.findAll();
		//		
		//		if(list.isEmpty()) {
		//			throw new ProductNotFoundException("No product in database");
		//		}else {
		//			ResponseStructure<Product> responceStructer=new ResponseStructure<>();
		//			responceStructer.setStatuscode(HttpStatus.FOUND.value());
		//			responceStructer.setMessage("data feched successfuly");
		//			
		//			return new ResponseEntity<ResponseStructure<Product>>(responceStructer,HttpStatus.FOUND);
		//		}
		//	}

		//		****** Or using lambda function ****

		List<Product> products=productRepository.findAll();
		if(!products.isEmpty()) {
			return ResponseEntity.ok(
					structureList.setStatuscode(HttpStatus.OK.value())
					.setMessage("Data found all")
					.setData(products)
					);
		}else throw new ProductNotFoundException("not found");

	}


	//	***mapping DTO to entity***
	@Override
	public ResponseEntity<ResponseStructure<Product>> saveProduct(ProductDTO productdto) {

		Product product=productRepository.save(mapToProduct(productdto,new Product()));
        return ResponseEntity.ok(responceStructer.setStatuscode(HttpStatus.OK.value()).setData(product).setMessage("saved susssfully"));
      
	}

	private Product mapToProduct(ProductDTO productdto, Product product) {
		product.setProductName(productdto.getProductName());
		product.setProductBrand(productdto.getProductBrand());
		product.setProductPrice(productdto.getProductPrice());

		return product;
	}
}
