package utils;

public class APIPayloadConstants {

    public static String createEmployeePayload(){

        String createEmployeePayload = "{\n" +
                "  \"emp_firstname\": \"olzhars144\",\n" +
                "  \"emp_lastname\": \"Andru2\",\n" +
                "  \"emp_middle_name\": \"elenam123\",\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"1999-01-12\",\n" +
                "  \"emp_status\": \"Employee\",\n" +
                "  \"emp_job_title\": \"API Tester\"\n" +
                "}";
        return createEmployeePayload;
    }
}
