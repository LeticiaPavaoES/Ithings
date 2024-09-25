package br.com.ithings.service;

import br.com.ithings.exception.ResourceNotFoundException;
import br.com.ithings.model.CityModel;
import br.com.ithings.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository repository;

    public CityModel create(CityModel cityModel){
        return repository.save(cityModel);
    }

    public CityModel findById(long id) {
        return repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Cidade não encontrada")
        );
    }

    public CityModel update(CityModel cityModel){
        CityModel found = repository.findById(cityModel.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Cidade não encontrada")
        );
            found.setName(cityModel.getName());
            found.setState(cityModel.getState());
            return repository.save(found);
    }

    public void delete(long id) {
        CityModel found = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Cidade não encontrada")
        );
        repository.delete(found);
    }

    public List<CityModel> findAll(){
        return repository.findAll();
    }
}
