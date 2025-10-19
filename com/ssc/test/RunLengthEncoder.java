package com.ssc.test;

public class RunLengthEncoder {

    public static void main(String[] args) {
        var encodedString = encode("aabba");
        System.out.println(encodedString);
    }

    private static String encode(final String input) {
        String[] inputArray = input.split("");
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < inputArray.length; ) {
            int count = 1;
            //append value if input ends without repeating char
            if (i == inputArray.length - 1) {
                appendEncodedString(builder, count, inputArray[i]);
                break;
            }
            for (int j = i + 1; j < inputArray.length; j++) {
                if (inputArray[i].equalsIgnoreCase(inputArray[j])) {
                    count = count + 1;
                    //append value if stream reaches end of string
                    if (j == inputArray.length - 1) {
                        appendEncodedString(builder, count, inputArray[i]);
                        //this helps to break execution from outer loop
                        i = j + 1;
                    }
                } else {
                    appendEncodedString(builder, count, inputArray[i]);
                    i = j;
                    break;
                }
            }

        }
        return builder.toString();
    }

    private static void appendEncodedString(StringBuilder builder, int count, String inputArray) {
        builder.append(inputArray);
        builder.append(count);
    }
}
