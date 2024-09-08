package com.topia.epdms.constant;
public class EpdmsExceptionConstant {
    public static class NotFoundException {
        public static String NOT_FOUND_EXCEPTION = "Employee Not Found";
    }

    public static class Attribute {
        public static String EMPLOYEE_FIELD = "Employee ID";
        public static String BAD_REQUEST_EMPLOYEE_FIELD = "Employee ID should be greater than 0";
    }

    public static class TimeoutException {
        public static String TIMEOUT_EXCEPTION = "TimeOut Exception";
    }

    public static class BadRequestException {
        public static String BAD_REQUEST_EXCEPTION = "Bad Request Exception";
    }
}
