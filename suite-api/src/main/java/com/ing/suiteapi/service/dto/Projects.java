package com.ing.suiteapi.service.dto;


public class Projects {

    private Long id;
    private String name;
    private Long passedCount;
    private Long failedCount;

    private Projects(Builder builder) {
        id = builder.id;
        name = builder.name;
        passedCount = builder.passedCount;
        failedCount = builder.failedCount;
    }

    public static final class Builder {
        private Long id;
        private String name;
        private Long passedCount;
        private Long failedCount;

        public Builder() {
        }

        public Builder id(Long val) {
            id = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder passedCount(Long val) {
            passedCount = val;
            return this;
        }

        public Builder failedCount(Long val) {
            failedCount = val;
            return this;
        }

        public Projects build() {
            return new Projects(this);
        }
    }
}
