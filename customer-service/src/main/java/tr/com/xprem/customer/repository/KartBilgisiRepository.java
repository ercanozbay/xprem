package tr.com.xprem.customer.repository;

import org.springframework.data.repository.CrudRepository;
import tr.com.xprem.customer.model.KartBilgisi;

import java.util.List;


public interface KartBilgisiRepository
        extends CrudRepository<KartBilgisi, Integer>
{
    List<KartBilgisi> findByCustomerId(Integer customerId);

}
