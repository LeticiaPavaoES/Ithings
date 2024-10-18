package br.com.ithings.service;

import br.com.ithings.dto.CustomerDto;
import br.com.ithings.exception.ResourceNotFoundException;
import br.com.ithings.mapper.CustomModelMapper;
import br.com.ithings.model.CityModel;
import br.com.ithings.model.CustomerModel;
import br.com.ithings.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public CustomerDto create(CustomerDto customerDto){
        CustomerModel customerModel = CustomModelMapper.parseObject(customerDto, CustomerModel.class);
        return CustomModelMapper.parseObject(repository.save(customerModel), CustomerDto.class);
    }

    public CustomerDto findById(long id) {
        CustomerModel found = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Cliente não encontrado")
        );
        return CustomModelMapper.parseObject(found, CustomerDto.class);
    }

    public CustomerDto update(CustomerDto customerDto){
        CustomerModel customerModel = repository.findById(customerDto.getId()).orElseThrow(
                ()-> new ResourceNotFoundException("Cliente não encontrado!")
        );
        customerModel.setBirthDate(customerDto.getBirthDate());
        customerModel.setGender(customerDto.getGender());
        customerModel.setFullName(customerDto.getFullName());
        //parse or convert cityDto to cityModel before setting the value
        customerModel.setCity(CustomModelMapper.parseObject(customerDto.getCity(), CityModel.class));
        //convert the model to dto to return
        return CustomModelMapper.parseObject(repository.save(customerModel), CustomerDto.class);
    }

    public void delete(long id){
        CustomerModel customerModel = repository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("Cliente não encontrado!")
        );
        repository.delete(customerModel);
    }

    public List<CustomerDto> findAll(){
        var customers = repository.findAll();
        return CustomModelMapper.parseObjectList(customers, CustomerDto.class);
    }
}
