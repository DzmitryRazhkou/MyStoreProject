package com.mystore.utility.xlsxReader;

import java.util.ArrayList;

public class TestUtil {

    public static long PAGE_LOAD_TIMEOUT_DurationOfSeconds = 30;
    public static long WEBDRIVERWAIT_DurationOfSeconds = 10;
    static Xls_Reader reader;

    public static ArrayList<Object[]> getDataFromExcel_CreateAccount() {

        String excelPath = System.getProperty("user.dir") + "/src/main/resources/dataSheet.xlsx";
        String sheetName = "createAccount";

        ArrayList<Object[]> myData = new ArrayList<>();
        try {
            reader = new Xls_Reader(excelPath);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int rowNum = 2; rowNum <= reader.getRowCount(sheetName); rowNum++) {
            String emailCreateAccount = reader.getCellData(sheetName, "emailCreateAccount", rowNum);
            String firstname = reader.getCellData(sheetName, "firstname", rowNum);
            String lastname = reader.getCellData(sheetName, "lastname", rowNum);
            String password = reader.getCellData(sheetName, "password", rowNum);
            String days = reader.getCellData(sheetName, "days", rowNum);
            String months = reader.getCellData(sheetName, "months", rowNum);
            String years = reader.getCellData(sheetName, "years", rowNum);
            String address = reader.getCellData(sheetName, "address", rowNum);
            String address2 = reader.getCellData(sheetName, "address2", rowNum);
            String city = reader.getCellData(sheetName, "city", rowNum);
            String state = reader.getCellData(sheetName, "state", rowNum);
            String zip = reader.getCellData(sheetName, "zip", rowNum);
            String addInfo = reader.getCellData(sheetName, "addInfo", rowNum);
            String phone = reader.getCellData(sheetName, "phone", rowNum);

            Object ob[] = {emailCreateAccount, firstname, lastname, password, days, months, years,
                    address, address2, city, state, zip, addInfo, phone};

            myData.add(ob);
        }

        return myData;
    }

    public static ArrayList<Object[]> getDataFromExcel_ContactUs() {

        String excelPath = System.getProperty("user.dir") + "/src/main/resources/dataSheet.xlsx";
        String sheetName = "contactUs";

        ArrayList<Object[]> myData = new ArrayList<>();
        try {
            reader = new Xls_Reader(excelPath);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int rowNum = 2; rowNum <= reader.getRowCount(sheetName); rowNum++) {
            String message = reader.getCellData(sheetName, "message", rowNum);

            Object ob[] = {message};

            myData.add(ob);
        }

        return myData;
    }

    public static ArrayList<Object[]> getDataFromExcel_SendToFriend() {

        String excelPath = System.getProperty("user.dir") + "/src/main/resources/dataSheet.xlsx";
        String sheetName = "AddToCard_SendToFriend";

        ArrayList<Object[]> myData = new ArrayList<>();
        try {
            reader = new Xls_Reader(excelPath);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int rowNum = 2; rowNum <= reader.getRowCount(sheetName); rowNum++) {
            String nameOfFriend = reader.getCellData(sheetName, "nameOfFriend", rowNum);
            String emailOfFriend = reader.getCellData(sheetName, "emailOfFriend", rowNum);

            Object ob[] = {nameOfFriend, emailOfFriend};

            myData.add(ob);
        }

        return myData;
    }
}
