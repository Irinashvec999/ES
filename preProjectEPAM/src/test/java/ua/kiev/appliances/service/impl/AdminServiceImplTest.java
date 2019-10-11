package ua.kiev.appliances.service.impl;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ua.kiev.appliances.domain.user.AdminEntity;
import ua.kiev.appliances.domain.user.RoleEntity;
import ua.kiev.appliances.domain.user.UserEntity;
import ua.kiev.appliances.repository.UserRepository;
import ua.kiev.appliances.repository.impl.UserRepositoryImpl;
import ua.kiev.appliances.service.AdminService;
import ua.kiev.appliances.service.PasswordEncoderImpl;
import ua.kiev.appliances.service.exception.EntityNotFoundException;

import static org.junit.Assert.assertEquals;


public class AdminServiceImplTest {
    private UserRepository userRepository;
    private AdminService adminService;

    @Before
    public void init() {
        userRepository = new UserRepositoryImpl();
        adminService = new AdminServiceImpl(userRepository, new PasswordEncoderImpl());
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Test
    public void checkMassagingBetweenRepoAndServiceInFindingById() throws NoSuchFieldException {
        UserEntity expected = userRepository.findById(1L);
        UserEntity actual = adminService.findById(1L);
        assertEquals(expected, actual);
    }

    @Test
    public void checkMassagingBetweenRepoAndServiceInDeletingById() throws NoSuchFieldException {
        UserEntity expected = userRepository.deleteById(1L);
        UserEntity actual = adminService.deleteById(1L);
        assertEquals(expected, actual);
    }

    @Test
    public void checkUpdatingDataTable() {
        UserEntity userEntity = new UserEntity.UserBuilder()
                .withId(1L)
                .withEmail("alex52@gmail.com")
                .withPassword("alex52")
                .withRole(RoleEntity.CUSTOMER)
                .build();
        String expected = "alex999";
        adminService.update(userEntity, expected);
        UserEntity userInBase = adminService.findByEmail("alex52@gmail.com");
        String actual = userInBase.getPassword();
        assertEquals(expected, actual);
    }
    @Test
    public void registeredUserEqualsUserFromDatabase() {
        AdminEntity userEntity = new AdminEntity.AdminBuilder()
                .withId(8L)
                .withEmail("alex999@gmail.com")
                .withPassword("alex999")
                .withRole(RoleEntity.CUSTOMER)
                .build();
        String expected = "alex999@gmail.com";
        adminService.register(userEntity);
        UserEntity userInBase = adminService.findByEmail("alex999@gmail.com");
        String actual = userInBase.getEmail();
        assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void checkForNullArgument() {
        if (adminService.login(null,null)==null){
            throw new EntityNotFoundException("");
        }
    }

    @Test(expected = Exception.class)
    public void checkForNullAdminData() {
        AdminEntity adminEntity = new AdminEntity.AdminBuilder().build();
        adminService.sendAdvertisements(adminEntity,null);
        if (adminEntity == null){
            throw new EntityNotFoundException("");
        }
    }
}
