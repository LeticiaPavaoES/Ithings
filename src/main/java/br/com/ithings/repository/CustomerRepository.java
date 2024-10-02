package br.com.ithings.repository;

import br.com.ithings.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CustomerRepository {

    @Repository
    public interface CustomerRepository extends JpaRepository<CustomerModel, Long> {

    }
}
