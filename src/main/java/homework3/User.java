package homework3;

import java.util.Objects;

public class User {
    private String name;
    private String surname;
    private String email;
    private String password;
    private int code;


    private User() {
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getCode() {
        return code;
    }

    public static Builder newBuilder() {
        return new User().new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public Builder withName(String userName) {
            User.this.name = userName;
            return this;
        }

        public Builder withSurname(String userSurname) {
            User.this.surname = userSurname;
            return this;
        }

        public Builder withEmail(String userEmail) {
            User.this.email = userEmail;
            return this;
        }

        public Builder withPassword(String userPassword) {
            User.this.password = userPassword;
            return this;
        }

        public Builder withCode(int userCode) {
            User.this.code = userCode;
            return this;
        }

        public User build() {
            return User.this;
        }


    }
}

