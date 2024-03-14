/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.berkeko.online.shopping;

import java.util.Scanner;

/**
 *
 * @author berkeko
 */
public class OnlineShopping {

    public static void main(String[] args) {
        System.out.println("Welcome to our online shopping website!");
        System.out.println("What would you like to do ? ");
        System.out.println("-----------------------------");
        System.out.println("1 - See categories");
        System.out.println("2 - Go to cart");
        System.out.println("3 - Show orders");
        System.out.println("4 - ");
        
        // Scanner object
        Scanner scanner = new Scanner(System.in);
        
        String operation = scanner.nextLine();
        
        switch(operation) {
            case "1":
                break;
            case "2":
                break;
            case "3":
                break;
            case "4":
                break;
            default:
                System.out.println("Invalid operation!");
                break;
        }
    }
}

