package com.lab;

import windows.MainWindow;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileSafe {
    private File myFile;
    private FileWriter myWriter;
    private FileReader myReader;
    private Scanner scan;

    public FileSafe(){  // Створення файлу
        try{
            myFile = new File("Data.txt");
            if (myFile.createNewFile()){
                myFile.deleteOnExit();
            }
            else{
                File f = myFile;
                f.delete();
                myFile = new File("Data.txt");
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void writeIn(String str){    // Запис даних в файл
        try{
            myWriter = new FileWriter("Data.txt", true);
            myWriter.write(str);
            myWriter.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void readData(){ // Зчитуємо дані з файлу
        try{
            myReader = new FileReader("Data.txt");
            scan = new Scanner(myReader);

            MainWindow.center.append("\n\n--- Дані з файлу ---\n");
            while (scan.hasNextLine()){
                MainWindow.center.append(scan.nextLine() + "\n");
            }

            scan.close();
            myReader.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
