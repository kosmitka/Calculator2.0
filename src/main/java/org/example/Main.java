package org.example;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        ReadFile rf = new ReadFile();
        List<String> list = rf.readLines();
        //list.forEach(System.out::println);
        List<String[]> listOfLines = rf.split(list);
        int numbers[] = new int[listOfLines.size()];
        String operations[] = new String[listOfLines.size()];

        for (int i = 0; i < listOfLines.size(); i++) {
            //System.out.println(listOfLines.get(i)[0]);
            operations[i] = listOfLines.get(i)[0];
        }
        for (int i = 0; i < listOfLines.size(); i++) {
            //System.out.println(listOfLines.get(i)[0]);
            try {
                numbers[i] = Integer.parseInt(listOfLines.get(i)[1]);
            } catch (NumberFormatException e) {
                System.out.println("Please provide a number");
            }
             catch (ArrayIndexOutOfBoundsException oob) {
                 System.out.println("Wrong data structure");

             }
        }
        int apply = 0;
        if (operations[operations.length - 1].equals("apply")) {
            apply = numbers[operations.length - 1];
        } else {
            System.out.println("Last operation should be 'apply'");

        }
        double result = apply;

        if (operations.length == 1 && operations[operations.length-1].equals("apply")) {
            System.out.println("Result = " + ((double) numbers[numbers.length - 1]));
        } else {
            for (int i = 0; i < numbers.length - 1; i++) {
                if (operations[i].equals("add")) {
                    Context ctx = new Context(new Addition());
                    result = ctx.execute(result, numbers[i]);
                } else if (operations[i].equals("substract")) {
                    //result = result + Integer.parseInt(String.valueOf(new Context(new Substraction())));
                    Context ctx = new Context(new Substraction());
                    result = ctx.execute(result, numbers[i]);
                } else if (operations[i].equals("multiply")) {
                    Context ctx = new Context(new Multiplication());
                    result = ctx.execute(result, numbers[i]);
                } else if (operations[i].equals("divide")) {
                    Context ctx = new Context(new Division());
                    result = ctx.execute(result, numbers[i]);
                } else {
                    System.out.println("Operation should be add,substract,divide or multiply");
                }
                //System.out.println("Result 1 " + result);
            }
            System.out.println("Result = " + result);
        }

    }
}

