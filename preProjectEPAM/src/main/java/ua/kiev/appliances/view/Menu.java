package ua.kiev.appliances.view;

import org.springframework.beans.factory.annotation.Autowired;
import ua.kiev.appliances.domain.user.AdminEntity;
import ua.kiev.appliances.domain.user.CustomerEntity;
import ua.kiev.appliances.domain.user.RoleEntity;
import ua.kiev.appliances.repository.impl.ApplianceRepositoryImpl;
import ua.kiev.appliances.repository.impl.OrderRepositoryImpl;
import ua.kiev.appliances.repository.impl.UserRepositoryImpl;
import ua.kiev.appliances.service.AdminService;
import ua.kiev.appliances.service.CustomerService;
import ua.kiev.appliances.service.PasswordEncoderImpl;
import ua.kiev.appliances.service.exception.EntityNotFoundException;
import ua.kiev.appliances.service.impl.AdminServiceImpl;
import ua.kiev.appliances.service.impl.CustomerServiceImpl;
import ua.kiev.appliances.validator.Validator;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;


public class Menu {
    @Autowired
    private AdminService adminService = new AdminServiceImpl(new UserRepositoryImpl(),new PasswordEncoderImpl());
    private CustomerService customerService = new CustomerServiceImpl(new UserRepositoryImpl(),new Validator(),new PasswordEncoderImpl(),
            new OrderRepositoryImpl(),new ApplianceRepositoryImpl());
    private ResourceBundle resourceBundle;
    private Locale locale;
    private Scanner scanner = new Scanner(System.in);


    public Menu() {
    }

    public void run() {
        selectLang();
        selectLoginOrRegister();
    }

    public void selectLang() {
        System.out.println("Please, choose your language:");
        System.out.println("1 - English\n 2 - Russian\n");
        int j = 0;
        try {
            Scanner sc = new Scanner(System.in);
            j = sc.nextInt();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        String country = "";
        switch (j) {
            case 1:
                country = "us";
                break;
            case 2:
                country = "ru";
                break;
            default:
                selectLang();
        }
        locale = new Locale(country);
        resourceBundle = ResourceBundle.getBundle("text", locale, new Converter());
        String message = resourceBundle.getString("message");
        System.out.println(message);
    }

    public void selectLoginOrRegister() {
        char choice = 0;
        try {
            choice = (char) System.in.read();
            switch (choice) {
                case '1':
                    register();
                    break;
                case '2':
                    login();
                    break;
                case '3':
                    selectLang();
                    break;
                case '4':
                    break;///
                default:
                    System.out.println("Incorrect choice");
            }
            order();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public void register() {
        System.out.println(resourceBundle.getString("role"));
        String answer = scanner.next();
        RoleEntity role;
        System.out.println(resourceBundle.getString("email"));
        String email = scanner.next();
        System.out.println(resourceBundle.getString("password"));
        String password = scanner.next();
        switch (answer) {
            case "1":
                role = RoleEntity.CUSTOMER;
                customerService.register(new CustomerEntity.CustomerBuilder()
                        .withEmail(email)
                        .withPassword(password)
                        .withRole(role)
                        .build());
                break;
            case "2":
                role = RoleEntity.ADMIN;
                adminService.register(new AdminEntity.AdminBuilder()
                        .withEmail(email)
                        .withPassword(password)
                        .withRole(role)
                        .build());
                break;
            default:
                System.out.println("Illegal argument");
        }
    }


    public void login() {
        System.out.println(resourceBundle.getString("email"));
        String email = scanner.next();
        System.out.println(resourceBundle.getString("password"));
        String password = scanner.next();
        adminService.login(email, password);
        System.out.println(resourceBundle.getString("welcome"));
    }

    public void order() {
        System.out.println(resourceBundle.getString("buy"));
        String answer = scanner.next();
        if (answer.equals("1")) {
            System.out.printf(resourceBundle.getString("filters"));
            String filter = scanner.next();
            switch (filter) {
                case "1":
                    customerService.filterByPowerConsumption().forEach(System.out::println);
                    break;
                case "2":
                  customerService.filterByType().forEach(System.out::println);
                    break;
                case "3":
                    customerService.filterByManufacturer().forEach(System.out::println);
                    break;
                case "4":
                    customerService.allAppliances().forEach(System.out::println);
                    break;
                default:
                    System.out.println("Enter the number from 1 to 4");
            }
            System.out.println();
            System.out.printf(resourceBundle.getString("choise"));
            Long id = scanner.nextLong();
            try{
                customerService.makeOrder(customerService.findById(id));
                System.out.println("Successful!");
            }catch (EntityNotFoundException e){
                e.getMessage();
            }
        } else {
            System.out.println(":(");
        }
    }
}
