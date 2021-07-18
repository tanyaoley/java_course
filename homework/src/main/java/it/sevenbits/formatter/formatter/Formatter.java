package it.sevenbits.formatter.formatter;


import javax.swing.*;

public class Formatter {
    private  static  String calcRepeated(int bracketCount)
    {
        String repeated = new String(new char[bracketCount]).replace("\0", "    ");
        return  repeated;
    }

    public static StringBuilder format(String inputStr) {
        StringBuilder sb = new StringBuilder();
        inputStr = inputStr
                .replaceAll("; ", ";")
                .replaceAll("\\{ ", "{")
                .replaceAll(" } ", "}");

        int bracketCount = 0;

        boolean addTab = false;
        boolean closedBracket = false;
        int len = 0;
        for  (char ch: inputStr.toCharArray()){

            if ( ch == ';')
            {
                sb.append(ch).append('\n');
                addTab = true;
            }
            else if (ch != '{' & ch != '}'){
                if (closedBracket & ch == ' ') { closedBracket = false; }
                else {
                        if (addTab) {
                            sb.append(calcRepeated(bracketCount));
                            addTab = false;
                        }
                        sb.append(ch);
                    }
            }
            else {
                if (ch == '{' ) {bracketCount += 1;}
                else {
                    bracketCount -= 1;
                    closedBracket = true;
                }
                String repeated = calcRepeated(bracketCount);
                len = sb.length();
                if (addTab){sb.append(repeated);}
                if (sb.length() > 1)
                {
                    if ((sb.charAt(len -2 ) == '}') | (sb.charAt(len -2 ) == '{'))
                    {sb.append(repeated);}
                    if (ch == '}')
                    {
                        if (sb.charAt(len -  4 * (bracketCount + 1) - 2 ) == '{')
                        {
                            sb = sb.delete(len -  4 * (bracketCount + 1) - 1, len );
                            repeated = calcRepeated(bracketCount);
                            sb.append('\n').append(repeated);}
                    }
                }
                sb.append(ch);
                sb.append("\n");
                if (ch == '{' ) {sb.append(repeated);}
            }
        }
        return sb;
    }




}



