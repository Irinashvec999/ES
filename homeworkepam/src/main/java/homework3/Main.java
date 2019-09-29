package homework3;

public class Main {
    public static void main(String[] args) {
        User user = User.newBuilder()
                .withName("Alex")
                .withSurname("Ivanov")
                .withEmail("iv@gmail.com")
                .withPassword("ivanov")
                .withCode(25)
                .build();
    }
}
