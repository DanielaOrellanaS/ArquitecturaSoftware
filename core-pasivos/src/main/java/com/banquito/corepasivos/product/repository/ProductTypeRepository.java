package com.banquito.corepasivos.product.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.banquito.corepasivos.product.model.ProductType;


@Repository
public interface ProductTypeRepository extends JpaRepository<ProductType, String> {
    List<ProductType> findByCodeProductType(String codeProductType);

    
}
