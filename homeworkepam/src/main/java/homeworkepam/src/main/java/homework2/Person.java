package homework2;

public final class Person {
    private final Address address;
    private final String name;

    Person(Address address, String name) {
        if (address != null) {
            this.address = new Address(address.getCity(), address.getCode());
        } else {
            this.address = null;
        }
        this.name = name;
    }

    public static void main(String[] args) {
        Person person1 = new Person(new Address("Odessa", 65000), "Vania");
        System.out.println(person1.getName() + " " + person1.getAddress().getCity());
        person1.getAddress().setCity("Kyiv");
        System.out.println(person1.getName() + " " + person1.getAddress().getCity());
    }

    public Address getAddress() {
        if (address != null) {
            return new Address(address.getCity(), address.getCode());
        } else {
            return null;
        }
    }

    public String getName() {
        return name;
    }
}
