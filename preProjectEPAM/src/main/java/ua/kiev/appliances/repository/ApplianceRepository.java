package ua.kiev.appliances.repository;

import org.springframework.stereotype.Repository;
import ua.kiev.appliances.domain.appliance.ElectricApplianceEntity;

import java.util.List;
@Repository
public interface ApplianceRepository {
    List<ElectricApplianceEntity> getAllAppliances();

    <T extends ElectricApplianceEntity> void save(T appliance);

    ElectricApplianceEntity findById(Long id);

    ElectricApplianceEntity deleteById(Long id);
}
