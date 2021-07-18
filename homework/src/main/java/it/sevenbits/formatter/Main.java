package it.sevenbits.formatter;

import it.sevenbits.formatter.formatter.Formatter;

public class Main {
    public static void main(String[] args) {
        String str1 = "{{{{}}}}";
        String str2 = "aaa { bbbb; ccc;}";
        String str3 = "aaa { bbbb; fff { trtryy; hhhh; } else { bsufg; } ccc;}";
        String str4 = "public class HelloWorld { public static void main(String[] args) { System.out.println(\"Hello, World\");}}";

        System.out.println(Formatter.format(str1));
        System.out.println(Formatter.format(str2));
        System.out.println(Formatter.format(str3));
        System.out.println(Formatter.format(str4));

    }
}
