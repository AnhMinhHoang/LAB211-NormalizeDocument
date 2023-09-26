/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

public class Algorithm {

    public void normalizePara(StringBuilder s) {
        removeBlankSpace(s);
        lowerCaseAll(s);
        addBlank(s);
        normalizeUpperCase(s);
    }

    public void removeLeadTrail(StringBuilder s) {
        int i = -1;
        //remove lead
        while (Character.isWhitespace(s.charAt(i + 1))) {
            i++;
        }
        if (i != -1) {
            s.delete(0, i + 1);
        }
        //remove trail
        i = s.length();
        while (Character.isWhitespace(s.charAt(i - 1))) {
            i--;
        }
        if (i != s.length()) {
            s.delete(i, s.length());
        }
    }

    public void removeBlankSpace(StringBuilder s) {
        removeLeadTrail(s);
        int current = -1;
        int count = 0;
        String matchStr = ".,:;";
        for (int i = s.length() - 1; i >= 0; i--) {
            if (Character.isWhitespace(s.charAt(i))) {
                if (current == -1) {
                    current = i;
                }
            } else {
                if (current != -1) {
                    if (matchStr.contains(String.valueOf(s.charAt(current+1)))) {
                        current++;
                    }
                    s.delete(i+1, current);
                    current = -1;
                }
            }
        }
        int index = s.indexOf("\"");
        while(index >= 0){
            count++;
            if(count == 1){
                s.deleteCharAt(index + 1);
                index = s.indexOf("\"", index + 1);
            }
            else{
                count = 0;
                s.deleteCharAt(index - 1);
                index = s.indexOf("\"", index);
            }
        }
    }

    public void lowerCaseAll(StringBuilder s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            s.setCharAt(i, Character.toLowerCase(c));
        }
    }

    public void normalizeUpperCase(StringBuilder s) {
        if("\"".contains(String.valueOf(s.charAt(0)))){
            s.setCharAt(1, Character.toUpperCase(s.charAt(1)));
        }
        else{
            s.setCharAt(0, Character.toUpperCase(s.charAt(0)));
        }
        for (int i = 2; i < s.length(); i++) {
            if ('.' == (s.charAt(i - 2))) {
                s.setCharAt(i, Character.toUpperCase(s.charAt(i)));
            }
        }
    }
    
    public void addBlank(StringBuilder s){
        String matchStr = ".,:;";
        for(int i = 0; i < s.length() - 1; i++){
            if(matchStr.contains(String.valueOf(s.charAt(i)))){
                if(!Character.isWhitespace(s.charAt(i + 1))){
                    s.insert(i+1, ' ');
                }
            }
        }
        if(!s.toString().endsWith("."))
            s.append(".");
    }
}
