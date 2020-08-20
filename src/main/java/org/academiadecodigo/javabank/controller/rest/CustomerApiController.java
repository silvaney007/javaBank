package org.academiadecodigo.javabank.controller.rest;

import org.academiadecodigo.javabank.command.AccountDto;
import org.academiadecodigo.javabank.command.CustomerDto;
import org.academiadecodigo.javabank.converters.AccountToAccountDto;
import org.academiadecodigo.javabank.converters.CustomerDtoToCustomer;
import org.academiadecodigo.javabank.converters.CustomerToCustomerDto;
import org.academiadecodigo.javabank.converters.RecipientToRecipientDto;
import org.academiadecodigo.javabank.exceptions.AssociationExistsException;
import org.academiadecodigo.javabank.exceptions.CustomerNotFoundException;
import org.academiadecodigo.javabank.persistence.model.Customer;
import org.academiadecodigo.javabank.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerApiController {


    private CustomerService customerService;
    private CustomerToCustomerDto customerToCustomerDto;
    private CustomerDtoToCustomer customerDtoToCustomer;
    private AccountToAccountDto accountToAccountDto;

    /**
     * Sets the customer service
     *
     * @param customerService the customer service to set
     */
    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * Sets the converter for converting between customer model objects and customer form objects
     *
     * @param customerToCustomerDto the customer to customer form converter to set
     */
    @Autowired
    public void setCustomerToCustomerDto(CustomerToCustomerDto customerToCustomerDto) {
        this.customerToCustomerDto = customerToCustomerDto;
    }

    /**
     * Sets the converter for converting between customer form and customer model objects
     *
     * @param customerDtoToCustomer the customer form to customer converter to set
     */
    @Autowired
    public void setCustomerDtoToCustomer(CustomerDtoToCustomer customerDtoToCustomer) {
        this.customerDtoToCustomer = customerDtoToCustomer;
    }

    /**
     * Sets the converter for converting between account objects and account dto objects
     *
     * @param accountToAccountDto the account to account dto converter to set
     */
    @Autowired
    public void setAccountToAccountDto(AccountToAccountDto accountToAccountDto) {
        this.accountToAccountDto = accountToAccountDto;
    }

    /**
     * Renders a view with a list of customers
     *
     * @return the view to render
     */
    @RequestMapping(method = RequestMethod.GET, value = {"/list", "", "/"}
    )
    public ResponseEntity<List<CustomerDto>> listCustomersApi() {
        return new ResponseEntity<>(customerToCustomerDto.convert(customerService.list()), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<CustomerDto> showCustomerApi(@PathVariable Integer id) {

        Customer customer = customerService.get(id);
        return new ResponseEntity<>(customerToCustomerDto.convert(customer), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{cid}/account/{aid}")
    public ResponseEntity<AccountDto> showCustomerAccountApi(@PathVariable Integer cid, @PathVariable Integer aid) {

        Customer customer = customerService.get(cid);
        return new ResponseEntity<>(accountToAccountDto.convert(customer.getAccount(aid)), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}/account")
    public ResponseEntity<List<AccountDto>> showCustomerAccountsApi(@PathVariable Integer id) {

        Customer customer = customerService.get(id);
        return new ResponseEntity<>(accountToAccountDto.convert(customer.getAccounts()), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = {"/add"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addCustomerApi(@Valid @RequestBody CustomerDto customerDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        Customer savedCustomer = customerService.save(customerDtoToCustomer.convert(customerDto));
        return new ResponseEntity<>(customerToCustomerDto.convert(savedCustomer), HttpStatus.CREATED);
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerDto> editCustomerApi(@PathVariable Integer id, @Valid @RequestBody CustomerDto customerDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        customerDto.setId(id);
        Customer savedCustomer = customerService.save(customerDtoToCustomer.convert(customerDto));
        return new ResponseEntity<>(customerToCustomerDto.convert(savedCustomer), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerDto> deleteCustomerApi(@PathVariable Integer id){

        Customer deletedCustomer = customerService.get(id);
        try {
            customerService.delete(id);
        } catch (CustomerNotFoundException e) {
            e.printStackTrace();
        } catch (AssociationExistsException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(customerToCustomerDto.convert(deletedCustomer), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{cid}/account/aid", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteAccountApi(@PathVariable Integer cid, @PathVariable Integer aid){

        customerService.get(cid).removeAccount(customerService.get(cid).getAccount(aid));

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
