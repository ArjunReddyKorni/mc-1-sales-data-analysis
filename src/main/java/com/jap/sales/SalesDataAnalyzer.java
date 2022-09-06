package com.jap.sales;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SalesDataAnalyzer {
   public List<SalesRecord> readFile(String fileName) {

       List<SalesRecord> salesRecordList = new ArrayList<>();
       FileReader fileReader = null;
       BufferedReader bufferedReader = null;
       SalesRecord []salesRecord = null;
       try{
           fileReader = new FileReader(fileName);
           bufferedReader = new BufferedReader(fileReader);
           int count = 0;
           while ((bufferedReader.readLine()) != null){
               count++;
           }
           salesRecord = new SalesRecord[count];

           fileReader = new FileReader(fileName);
           bufferedReader = new BufferedReader(fileReader);

           bufferedReader.readLine();
           String line = null;
           int i=0;
           while ((line = bufferedReader.readLine()) != null){
              // date,id,category,payment_method,value,time_on_site,clicks_in_site
               String[] split = line.split(",");
               salesRecord[i] = new SalesRecord();

               salesRecord[i].setDate(split[0]);
               salesRecord[i].setCustomer_id(Integer.parseInt(split[1]));
               salesRecord[i].setProduct_category(Integer.parseInt(split[2]));
               salesRecord[i].setPayment_method(split[3]);
               salesRecord[i].setAmount(Double.parseDouble(split[4]));
               salesRecord[i].setTime_on_site(Double.parseDouble(split[5]));
               salesRecord[i].setClicks_in_site(Integer.parseInt(split[6]));
               salesRecordList.add(salesRecord[i]);
               i++;
           }
       } catch (FileNotFoundException e) {
           System.out.println("e = " + e);
       } catch (IOException e) {
           System.out.println("e = " + e);
       }


       return salesRecordList;
    }






}
