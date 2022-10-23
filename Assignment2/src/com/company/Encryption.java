package com.company;
import java.util.Locale;
import java.util.ArrayList;
class Encryption
{
    ArrayList<Character> symbols = new ArrayList<Character>();
    ArrayList<Character> alphabets = new ArrayList<Character>();
    public Encryption()
    {
        symbols.add('!');
        symbols.add('@');
        symbols.add('#');
        symbols.add('$');
        symbols.add('^');
        symbols.add('&');
        symbols.add('*');
        symbols.add('(');
        symbols.add(')');
        symbols.add('_');
        symbols.add('-');
        symbols.add('+');
        symbols.add('=');
        symbols.add('?');
        symbols.add(',');
        symbols.add('{');
        symbols.add('}');
        symbols.add('[');
        symbols.add(']');
        symbols.add('/');
        symbols.add('|');
        symbols.add(';');
        symbols.add(':');
        symbols.add('.');
        symbols.add('<');
        symbols.add('>');
        for(char letter='a';letter<='z';letter++)
        {
            alphabets.add(letter);
        }
    }
    char return_alphabet(int index){
        return alphabets.get(index);
    }
    int return_alphabet_index(char index){
        int answer = -100;
        for(int i = 0; i < 26; i++){
            if(return_alphabet(i) == index){
                answer = i;
            }
        }
        return answer;
    }
    char return_symbol(int index){
        return symbols.get(index);
    }
    int return_symbol_index(char index){
        int answer = -100;
        boolean valid = true;
        for(int i = 0; i < 26;i++){
            if(index == return_symbol(i)){
                answer = i;

            }
        }
        return answer;
    }
    String encrypt_message(String message){
        String EncryptedMessage;
        boolean brk = false;
        boolean hashaderror = false;

        message = message.toLowerCase(Locale.ROOT);
        char[] strng = new char[message.length()];
        for (int i = 0; i < message.length(); i++){
            int index = return_alphabet_index(message.charAt(i));
            if(return_alphabet_index(message.charAt(i)) == -100){
                if (hashaderror == false){
                    System.out.println("ERROR: invalid symbol");
                    hashaderror = true;
                }                brk = true;
            }else {
                strng[i] = return_symbol(index);
            }

        }

        if(brk == true){
            return "false";
        }else {
            EncryptedMessage = String.valueOf(strng);
        }
        return EncryptedMessage;
    }
    String decrypt_message(String cypher){
        String DecryptedMessage;
        boolean brk = false;
        boolean hashaderror = false;
        cypher = cypher.toLowerCase(Locale.ROOT);
        char[] strng = new char[cypher.length()];
        for (int i = 0; i < cypher.length(); i++){
            int index = return_symbol_index(cypher.charAt(i));
            if(return_symbol_index(cypher.charAt(i)) == -100){
                if (hashaderror == false){
                    System.out.println("ERROR: invalid symbol");
                    hashaderror = true;
                }

                brk = true;
            }else {
                strng[i] = return_alphabet(index);
            }
        }

        if(brk == true){
            return "false";
        }else {
            DecryptedMessage = String.valueOf(strng);
        }
        return DecryptedMessage;
    }
}