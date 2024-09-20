package br.com.ithings.repository;

import br.com.ithings.model.CityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<CityModel, Long> {

}
