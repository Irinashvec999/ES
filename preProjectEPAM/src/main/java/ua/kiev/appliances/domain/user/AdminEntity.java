package ua.kiev.appliances.domain.user;

public class AdminEntity extends UserEntity {

    private AdminEntity(AdminBuilder adminBuilder) {
        super(adminBuilder);
    }

    public static class AdminBuilder extends UserBuilder<AdminBuilder> {

        public AdminBuilder() {
        }

        @Override
        public AdminBuilder self() {
            return this;
        }

        public AdminEntity build() {
            return new AdminEntity(self());
        }
    }
}
