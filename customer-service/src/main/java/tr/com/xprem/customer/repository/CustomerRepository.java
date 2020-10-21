package tr.com.xprem.customer.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tr.com.xprem.customer.model.Customer;

import java.util.List;

public interface CustomerRepository
        extends CrudRepository<Customer, Integer> {

    @Query("SELECT c FROM Customer c WHERE c.premiumUyelikBitisTarihi<=CURRENT_DATE and c.uyelikDurumu='P'")
    List<Customer> findUyelikSuresiDolanPremiumCustomer();

}
