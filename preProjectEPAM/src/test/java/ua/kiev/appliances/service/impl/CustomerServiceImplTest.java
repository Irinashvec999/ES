package ua.kiev.appliances.service.impl;

import org.junit.Before;
import org.junit.Test;
import ua.kiev.appliances.domain.appliance.ApplianceEntity;
import ua.kiev.appliances.domain.appliance.ElectricApplianceEntity;
import ua.kiev.appliances.domain.order.OrderEntity;
import ua.kiev.appliances.domain.user.CustomerEntity;
import ua.kiev.appliances.domain.user.RoleEntity;
import ua.kiev.appliances.repository.ApplianceRepository;
import ua.kiev.appliances.repository.OrderRepository;
import ua.kiev.appliances.repository.UserRepository;
import ua.kiev.appliances.repository.impl.ApplianceRepositoryImpl;
import ua.kiev.appliances.repository.impl.OrderRepositoryImpl;
import ua.kiev.appliances.repository.impl.UserRepositoryImpl;
import ua.kiev.appliances.service.CustomerService;
import ua.kiev.appliances.service.PasswordEncoderImpl;
import ua.kiev.appliances.service.exception.EntityNotFoundException;
import ua.kiev.appliances.validator.Validator;

import java.util.List;

import static junit.framework.TestCase.assertSame;
import static org.junit.Assert.assertEquals;

public class CustomerServiceImplTest {
    CustomerService customerService;
    UserRepository userRepository;
    OrderRepository orderRepository;
    ApplianceRepository applianceRepository;

    @Before
    public void init(){
        applianceRepository = new ApplianceRepositoryImpl();
        orderRepository = new OrderRepositoryImpl();
        userRepository = new UserRepositoryImpl();
        customerService = new CustomerServiceImpl(userRepository,new Validator(),
                new PasswordEncoderImpl(),orderRepository,applianceRepository);
    }

    @Test
    public void registeredUserEqualsUserFromDatabase() {
        CustomerEntity userEntity = new CustomerEntity.CustomerBuilder()
                .withId(9L)
                .withEmail("alex9999@gmail.com")
                .withPassword("alex9999")
                .withRole(RoleEntity.CUSTOMER)
                .build();
        String expected = "alex9999@gmail.com";
        String actual = customerService.register(userEntity).getEmail();
        assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void checkForNullArgument() {
        if (customerService.login(null,null)==null){
            throw new EntityNotFoundException("");
        }
    }

    @Test
    public void whileListIsEmptyFirstNodeIs0() {
        if(customerService.allAppliances().isEmpty())
            assertEquals(customerService.allAppliances().get(0),null);
    }

    @Test
    public void filterByPowerConsumptionReturnedAllList() {
        List<? extends ApplianceEntity> actual = customerService.filterByPowerConsumption();
        List<? extends ApplianceEntity> expected = customerService.allAppliances();
        assertEquals(expected.size(),actual.size());
    }

    @Test
    public void filterByManufacturerReturnedAllList() {
        List<? extends ApplianceEntity> actual = customerService.filterByManufacturer();
        List<? extends ApplianceEntity> expected = customerService.allAppliances();
        assertEquals(expected.size(),actual.size());
    }

    @Test
    public void filterByTypeReturnedAllList() {
        List<? extends ApplianceEntity> actual = customerService.filterByType();
        List<? extends ApplianceEntity> expected = customerService.allAppliances();
        assertEquals(expected.size(),actual.size());
    }

    @Test
    public void whenMakingOrderApplianceSavedToOrderRepo() {
        ElectricApplianceEntity applianceEntity = new ElectricApplianceEntity.ElectricApplianceBuilder()
                .withId(13L)
                .withName("refrigerator")
                .withPrice(500D)
                .build();
        customerService.makeOrder(applianceEntity);
        List<OrderEntity> itemsInOrder = orderRepository.getAll();
        assertSame(itemsInOrder.get(0).getId(), applianceEntity.getId());
    }

    @Test
    public void checkMassagingBetweenRepoAndServiceInFindingById() {
        ElectricApplianceEntity expected = applianceRepository.findById(1L);
        ElectricApplianceEntity actual = customerService.findById(1L);
        assertEquals(expected, actual);
    }
}