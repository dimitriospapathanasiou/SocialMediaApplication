package com.aueb.socialmediaapplication.Database;

import java.io.*;
import java.util.*;
import java.lang.*;

public class UserCredentialsDB {


        // Friendly Message
        public static void welcome() {
            System.out.println("Welcome to Grasp!t");
            System.out.println("     -by DMST/AUEB");
        }



        /***************
         *   Sign-Up   *
         ***************/
        // Sing-Up Process
        public static void signUp() {
            Scanner input = new Scanner(System.in);
            System.out.println("\nChoose a Username");
            String username = input.nextLine();
            System.out.println("Give an Email");
            String email = input.nextLine();
            //verify the user
            boolean alreadyExists = verifySignUp(username, email, "Users_Database.txt", ",");
            while (alreadyExists == true) {
                System.out.println("There is already someone with the same Username or Email.\nConsider change one of these...");
                System.out.println("\nChoose a Username");
                username = input.nextLine();
                System.out.println("Give an Email");
                email = input.nextLine();
                alreadyExists = verifySignUp(username, email, "Users_Database.txt", ",");
            }
            System.out.println("Choose a Password");
            String password = input.nextLine();
            System.out.println("Say something about yourself, if you like");
            String bio = input.nextLine();
            if (bio.isEmpty() == true)
                bio = null;
            System.out.println("Take a pic, if you like");
            //need to upload an image
            String photo = input.nextLine();
            if (photo.isEmpty() == true)
                photo = null;
            //add the user into database
            try {
                File file = new File ("Users_Database.txt");
                PrintWriter pw = new PrintWriter(new FileOutputStream(file, true));
                pw.append("\n" + getAscendingNumber("Users_Database.txt") + "," + username + "," + password + "," + email + "," + bio + "," + photo);
                pw.close();
            } catch (Exception e) {
                System.out.println("Ooops!");
            }

        }

        // Find an ID for the New User
        public static String getAscendingNumber(String database) {
            try {
                File file = new File(database);
                InputStreamReader isr = new InputStreamReader(new FileInputStream(database));
                BufferedReader br = new BufferedReader(isr);
                String line = "";
                while (br.ready()) {
                    line = br.readLine();
                }
                String tmp_array[] = line.split(",");
                String id = tmp_array[0];
                String next_id;
                if (Integer.parseInt(id) < 9) {
                    next_id = "000" + Integer.toString(Integer.parseInt(id) + 1);
                } else {
                    next_id = "00" + Integer.toString(Integer.parseInt(id) + 1);
                }
                return next_id;
            } catch(Exception e) {
                System.out.println("Ooops!");
            }
            return "null";
        }

        // Verify the New User
        public static boolean verifySignUp(String username, String email, String file, String delimiter) {
            String currentLine;
            String data[];
            try {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                while((currentLine = br.readLine()) != null) {
                    data = currentLine.split(delimiter);
                    if (data[1].equals(username) || data[3].equals(email)) {
                        return true;
                    }
                }
            } catch(Exception e) {
                System.out.println("Ooops!");
            }
            return false;
        }



        /**************
         *   Log-In   *
         **************/
        // Log-In Process
        public static void logIn() {
            Scanner input = new Scanner(System.in);
            //give either a username or the email
            System.out.println("\nWho are you?");
            String user = input.nextLine();
            System.out.println("if it real you then what is your password?");
            String password = input.nextLine();

            boolean alreadyExists = verifyLogIn(user, password, "Users_Database.txt", ",");
            if (alreadyExists == true) {
                System.out.println("Welcome " + user + "\nNice to see you back here!");
            } else {
                System.out.println("Who the hell are you?");
            }
        }

        // Verify the User
        public static boolean verifyLogIn(String user, String password, String file, String delimiter) {
            String currentLine;
            String data[];
            try {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                while ((currentLine = br.readLine()) != null) {
                    data = currentLine.split(delimiter);
                    //check whether it is a username ot an email
                    if ((data[1].equals(user) || data[3].equals(user)) && data[2].equals(password)) {
                        return true;
                    }
                }
            } catch(Exception e) {
                System.out.println("Ooops!");
            }
            return false;
        }
    }

