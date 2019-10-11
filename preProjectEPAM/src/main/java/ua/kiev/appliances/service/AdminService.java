package ua.kiev.appliances.service;

import ua.kiev.appliances.domain.user.AdminEntity;
import ua.kiev.appliances.domain.user.UserEntity;

public interface AdminService {
    void register(AdminEntity adminEntity);

    UserEntity login(String email, String password);

    UserEntity findById(Long id) throws NoSuchFieldException;

    void update(UserEntity userEntity, String password);

    UserEntity deleteById(Long id) throws NoSuchFieldException;

    UserEntity findByEmail(String email);

    void sendAdvertisements (AdminEntity admin,String advertisement);
}
