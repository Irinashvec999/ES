package homework4_mvc;

import homework4_mvc.domain.*;
import homework4_mvc.repository.StudentRepositoryImpl;
import homework4_mvc.service.AdminService;
import homework4_mvc.service.AdminServiceImpl;
import homework4_mvc.view.Converter;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Menu {
    private AdminServiceImpl adminService = new AdminServiceImpl(new StudentRepositoryImpl());
    private ResourceBundle resourceBundle;
    private Locale locale;

    public void run() {
        init();
        selectLang();
        selectLoginOrRegister();
    }

    public void init() {
        adminService.save((Student.builder()
                .withId(1)
                .withName("Oleg")
                .withSecondName("Olegovich")
                .withSurname("Ivanov")
                .withBDate(14, 11, 2001)
                .withAddress(new Address(11, "Kudryashova", "Kyiv"))
                .withUniversityData(new UniversityData(Faculty.MANAGEMENT, new Course(3, 2)))
                .withLogin("Oleg1411")
                .withPassword("Oleg1411")
                .build()));
        adminService.save(Student.builder()
                .withId(2)
                .withName("Anna")
                .withSecondName("Ivanovna")
                .withSurname("Smirnova")
                .withBDate(29, 11, 1999)
                .withAddress(new Address(5, "Gnata", "Kyiv"))
                .withUniversityData(new UniversityData(Faculty.MECHANICAL, new Course(5, 2)))
                .withLogin("Anna2911")
                .withPassword("Anna2911")
                .build());
    }


    public void selectLang() {
        System.out.println("Please, choose your language:");
        System.out.println("1 - English \n 2 - Russian\n 3 - Ukrainian");
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
            case 3:
                country = "ua";
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
                default:
                    System.out.println("Incorrect choice");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public Student findUser(String login, String password) {
        List<Student> students = adminService.studentData().values()
                .stream()
                .filter(u -> u.getLogin().equals(login))
                .filter(u-> u.getPassword().equals(password))
                .collect(Collectors.toList());
        if (students.size() == 0) {
            return null;
        } else {
            return students.get(0);
        }
    }

    public void register() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the login:");
        String login = sc.next();
        System.out.println("Enter the password:");
        String password = sc.next();
        if (validate(login, password) && (findUser(login, password) == null)) {
            adminService.save(Student.builder().withLogin(login).withPassword(password).build());
            System.out.println("Successful registration!");
        } else {
            System.out.println("User with this login is already registered");
        }
    }

    public boolean validate(String login, String password) {
        String loginRegex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=\\S+$).{8,}$";
        String passwordRegex = "(?=.*[0-9])(?=.*[a-z])(?=\\S+$).{8,}";
        Pattern patternLog = Pattern.compile(loginRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcherLog = patternLog.matcher(login);
        Pattern patternPas = Pattern.compile(passwordRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcherPas = patternPas.matcher(password);
        if ((matcherLog.matches() && matcherPas.matches())) {
            return true;
        } else {
            System.out.println("Incorrect character");
            return false;
        }
    }

    public void login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Login:");
        String login = sc.next();
        System.out.println("Password:");
        String password = sc.next();
        findUser(login, password);
        resourceBundle = ResourceBundle.getBundle("text", locale, new Converter());
        String welcome = resourceBundle.getString("welcome");
        System.out.println(welcome);
    }
}
