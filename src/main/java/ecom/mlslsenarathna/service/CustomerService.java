package ecom.mlslsenarathna.service;

import ecom.mlslsenarathna.model.dto.CustomerDTO;
import ecom.mlslsenarathna.model.entity.CustomerEntity;
import ecom.mlslsenarathna.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public CustomerDTO getCustomer(String custId) {
        Optional<CustomerEntity> custbyID=customerRepository.findById(custId);
        CustomerEntity customerEntity=custbyID.orElseThrow();
        return new CustomerDTO(
                customerEntity.getCustId(),
                customerEntity.getCustName(),
                customerEntity.getCustAddress(),
                customerEntity.getCustMobbileNumber()
        );

    }

    public List<CustomerDTO> getAllCustomers() {
        List<CustomerEntity> customerEntityList=customerRepository.findAll();
        List<CustomerDTO> customersList= new ArrayList<>();
        for(CustomerEntity customerEntity:customerEntityList){
            customersList.add(new CustomerDTO(
                    customerEntity.getCustId(),
                    customerEntity.getCustName(),
                    customerEntity.getCustAddress(),
                    customerEntity.getCustMobbileNumber()

            ));


        }
        return customersList;
    }

    public void add(CustomerDTO customerDTO) {
        customerRepository.save(
                new CustomerEntity(
                        customerDTO.getCustId(),
                        customerDTO.getCustName(),
                        customerDTO.getCustAddress(),
                        customerDTO.getCustMobbileNumber()
                )
        );
    }

    public void updateByID(CustomerDTO customerDTO) {
        customerRepository.save(
                new CustomerEntity(
                        customerDTO.getCustId(),
                        customerDTO.getCustName(),
                        customerDTO.getCustAddress(),
                        customerDTO.getCustMobbileNumber()
                )
        );
    }

    public void deleteById(String customerId) {
        customerRepository.deleteById(customerId);
    }
}
