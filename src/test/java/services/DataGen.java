package services;

import org.apache.commons.lang3.RandomStringUtils;

public class DataGen {
    public static String getName(){
        String generatedString = RandomStringUtils.randomAlphabetic(3);
        return ( "Ivan" + generatedString);
    }

    public static String getUsername(){
        String generatedString = RandomStringUtils.randomAlphabetic(3);
        return ( "Van" + generatedString);
    }

    public static String getEmail(){
        String generatedString = RandomStringUtils.randomAlphabetic(3);
        return (generatedString + "@mail.ru");
    }
}
