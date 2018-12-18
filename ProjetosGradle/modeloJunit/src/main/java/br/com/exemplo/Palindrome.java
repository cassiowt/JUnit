package br.com.exemplo;


public class Palindrome {


    public boolean isPalindrome(String candidate) {

        int length = candidate.length();
        String reverse = "";

        for (int i = length - 1; i >= 0; i--)
            reverse = reverse + candidate.charAt(i);

        if (candidate.equals(reverse))
           return true;
        else
           return false;
    }
}