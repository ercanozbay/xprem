package tr.com.xprem.customer.web.rest;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.binary.Base64;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;
import tr.com.xprem.customer.CustomerServiceApplication;
import tr.com.xprem.customer.model.Customer;
import tr.com.xprem.customer.repository.CustomerRepository;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Integration tests for the {@link tr.com.xprem.customer.api.Api} REST controller.
 */
@SpringBootTest(classes = CustomerServiceApplication.class)
@AutoConfigureMockMvc
@WithMockUser
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class ApiTest {

    private static final String DEFAULT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_NAME = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_BALANCE = new BigDecimal(1);
    private static final BigDecimal UPDATED_BALANCE = new BigDecimal(2);

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restCustomerMockMvc;

    private Customer customer;
    private  String encodeddata;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Customer createEntity() {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setAd("Ercan");
        customer.setSoyad("Özbay");
        customer.setEmail("ercanozbay@gmail.com");
        customer.setUyelikDurumu("N");



        return customer;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */


    @BeforeEach
    public void initTest() {
        
        customer = createEntity();
         encodeddata = new String(Base64.encodeBase64("1:password".getBytes()));
        System.out.println("encodedBytes " + encodeddata);
    }

    @Test
    @Transactional
    public void getCustomer() throws Exception {
        Customer customer=createEntity();
        customerRepository.save(customer);

        Optional<Customer> customerDb=customerRepository.findById(customer.getId());
        // Create the BankAccount
        String encodeddata = new String(Base64.encodeBase64("1:password".getBytes()));
        System.out.println("encodedBytes " + encodeddata);


       MvcResult result= restCustomerMockMvc.perform(get("/").
                header("Authorization", "Basic "+encodeddata)
                .contentType(MediaType.APPLICATION_JSON)
                //.content(TestUtil.convertObjectToJsonBytes(bankAccount))
                ).andExpect(status().isOk()).andReturn();
       String customerDbJson=new ObjectMapper().writeValueAsString(customerDb.get());

        assertThat(result.getResponse().getContentAsString()).isEqualTo(customerDbJson);
      }
    /*
    @Test
    @Transactional
    public void createBankAccount() throws Exception {

        int databaseSizeBeforeCreate = ((Collection<?>) customerRepository).size();
        // Create the BankAccount
        restBankAccountMockMvc.perform(post("/api/bank-accounts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtil.convertObjectToJsonBytes(bankAccount)))
                .andExpect(status().isCreated());

        // Validate the BankAccount in the database
        List<BankAccount> bankAccountList = customerRepository.findAll();
        assertThat(bankAccountList).hasSize(databaseSizeBeforeCreate + 1);
        BankAccount testBankAccount = bankAccountList.get(bankAccountList.size() - 1);
        assertThat(testBankAccount.getName()).isEqualTo(DEFAULT_NAME);
        assertThat(testBankAccount.getBalance()).isEqualTo(DEFAULT_BALANCE);
    }
*/
}

