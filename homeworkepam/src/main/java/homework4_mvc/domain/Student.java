package homework4_mvc.domain;

import java.time.LocalDate;

public class Student {
    private final long id;
    private final String name;
    private final String secondName;
    private final String surname;
    private final LocalDate bDate;
    private final Address address;
    private final UniversityData universityData;
    private final String password;

    private final String login;

    private Student(Builder builder, String login) {
        this.id = builder.id;
        this.name = builder.name;
        this.secondName = builder.secondName;
        this.surname = builder.surname;
        this.bDate = builder.bDate;
        this.address = builder.address;
        this.universityData = builder.universityData;
        this.password = builder.password;
        this.login = builder.login;
    }

    public static Builder builder() {
        return new Builder();
    }

    public UniversityData getUniversityData() {
        return universityData;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getbDate() {
        return bDate;
    }

    public Address getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }
    public String getLogin() {
        return login;
    }


    public static class Builder {
        private long id;
        private String name;
        private String secondName;
        private String surname;
        private LocalDate bDate;
        private Address address;
        private UniversityData universityData;
        private String password;
        private String login;

        private Builder() {
        }

        public Builder withId(long id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withSecondName(String secondName) {
            this.secondName = secondName;
            return this;
        }

        public Builder withSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder withBDate(int day, int month, int year) {
            this.bDate = LocalDate.of(year, month, day);
            return this;
        }

        public Builder withAddress(Address address) {
            if (this.address != null) {
                this.address = new Address(address.getHouseNumber(), address.getStreet(), address.getTown());
            } else {
                this.address = null;
            }
            return this;
        }

        public Builder withUniversityData(UniversityData universityData) {
            this.universityData = universityData;
            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder withLogin(String login) {
            this.login = login;
            return this;
        }


        public Student build() {
            return new Student(this, login);
        }
    }

    @Override
    public String toString() {
        return id + " " +
               name + " " +
               secondName + " " +
               surname + ", " +
               " faculty - " + universityData.getFaculty() +
                ", course - " + universityData.getCourse().getNumber();
    }

}
