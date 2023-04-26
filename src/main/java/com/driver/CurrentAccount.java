package com.driver;

import java.util.*;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        super(name,balance,5000);
        if(balance<5000){
            throw  new Exception("Insufficient Balance");
        }
        this.tradeLicenseId=tradeLicenseId;
        validateLicenseId();
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception

    }

    public void validateLicenseId() throws Exception {
        if(tradeLicenseId.equals(tradeLicenseId.toUpperCase())){
            throw new Exception("Valid License can not be generated");
        }
        HashMap<Character,Integer> hm = new HashMap<>();
        int n = tradeLicenseId.length();
        for(int i=0;i<n;i++){
            hm.put(tradeLicenseId.charAt(i),hm.getOrDefault(tradeLicenseId.charAt(i),0)+1);
        }
        if((n%2==0 && n-hm.size()>=n/2) || (n%2!=0 && n-hm.size()>n/2)){
         throw new Exception("Valid License can not be generated");
        }
        while(!isValid(tradeLicenseId)) {
            List list = Arrays.asList(tradeLicenseId.split(""));
            Collections.shuffle(list);
            String ans="";
            for(int i=0;i<list.size();i++){
                ans+=list.get(i);
            }
            tradeLicenseId =ans;
        }
        return;
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
    }
    private   boolean isValid(String tradeLicenseId){
        for(int i=0;i<tradeLicenseId.length()-1;i++){
            if(tradeLicenseId.charAt(i)==tradeLicenseId.charAt(i+1)){
                return false;
            }
        }
        return true;
    }

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }
}
