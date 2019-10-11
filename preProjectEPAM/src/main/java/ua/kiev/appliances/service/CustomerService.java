package ua.kiev.appliances.service;

import ua.kiev.appliances.domain.appliance.ApplianceEntity;
import ua.kiev.appliances.domain.appliance.ElectricApplianceEntity;
import ua.kiev.appliances.domain.user.CustomerEntity;
import ua.kiev.appliances.domain.user.UserEntity;

import java.util.List;

public interface CustomerService {

    CustomerEntity register(CustomerEntity customerEntity);

    UserEntity login(String login, String password);

    List<? extends ApplianceEntity> allAppliances();

    List<ElectricApplianceEntity> filterByPowerConsumption();

    List<ElectricApplianceEntity> filterByManufacturer();

    List<ElectricApplianceEntity> filterByType();

    void makeOrder(ElectricApplianceEntity applianceEntity);

    ElectricApplianceEntity findById(Long id);


}
