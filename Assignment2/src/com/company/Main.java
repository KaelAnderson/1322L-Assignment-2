package com.company;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        Encryption encrypt = new Encryption();
        Scanner scan = new Scanner(System.in);
        boolean cont = true;
        while (cont == true){
        System.out.println("1 Encrypt a message\n" +
                "2 Decrypt a message\n" +
                "3 Quit\n" +
                "Enter Choice");
            switch (scan.nextInt()) {
                case 1 -> {
                    System.out.println("Enter the plain text message:");
                    String input1 = scan.next();
                    if(encrypt.encrypt_message(input1) != "false"){
                        System.out.println("Encrypted Msg: " + encrypt.encrypt_message(input1));
                    }else {
                        cont = false;
                    }
                    break;


                }
                case 2 -> {
                    System.out.println("Enter the encrypted message:");
                    String input2 = scan.next();
                    if (encrypt.decrypt_message(input2) != "false"){
                        System.out.println("Decrypted Msg: " + encrypt.decrypt_message(input2));
                    }else{
                        cont = false;
                    }
                    break;


                }
                case 3 -> cont = false;
            }
        }
    }
}
