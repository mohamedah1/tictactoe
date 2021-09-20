/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.consoletictactoe.ui;

import java.util.Scanner;

/**
 *
 * @author mohamed
 */
public class UserIOConsoleImpl implements UserIO {

    Scanner sc = new Scanner(System.in);

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public double readDouble(String prompt) {
        print(prompt);
        double a = Double.parseDouble(sc.nextLine());
        return a;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        do {
            print(prompt);
            double a = Double.parseDouble(sc.nextLine());
            if (a >= min && a <= max) {
                return a;
            } else {
                print("Number must be between " + min + " and " + max);
            }
        } while (true);
    }

    @Override
    public float readFloat(String prompt) {
        print(prompt);
        float a = Float.parseFloat(sc.nextLine());
        return a;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        do {
            print(prompt);
            float a = Float.parseFloat(sc.nextLine());
            if (a >= min && a <= max) {
                return a;
            } else {
                print("Number must be between " + min + " and " + max);
            }
        } while (true);
    }

    @Override
    public int readInt(String prompt) {
        print(prompt);
        int a = Integer.parseInt(sc.nextLine());
        return a;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        do {
            print(prompt);
            int a = Integer.parseInt(sc.nextLine());
            if (a >= min && a <= max) {
                return a;
            } else {
                print("Number must be between " + min + " and " + max);
            }
        } while (true);
    }

    @Override
    public long readLong(String prompt) {
        print(prompt);
        long a = Long.parseLong(sc.nextLine());
        return a;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        do {
            print(prompt);
            long a = Long.parseLong(sc.nextLine());
            if (a >= min && a <= max) {
                return a;
            } else {
                print("Number must be between " + min + " and " + max);
            }
        } while (true);
    }

    @Override
    public String readString(String prompt) {
        print(prompt);
        String s = sc.nextLine();
        return s;
    }
}
