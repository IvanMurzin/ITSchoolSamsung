package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        File file = new File("file");
        file.exists(); // true если файл существует
        file.canRead(); // true если файл можно читать
        file.canWrite(); // true если в файл можно писать
        file.canExecute(); // true если файл можно исполнять
        file.getName(); // имя файла
        file.getAbsolutePath(); // путь до файла
        file.getParentFile(); // файл, в котором лежит этот файл
        file.createNewFile(); // создает файл с указанным именем, если такого не существует
        file.isDirectory(); // true если это директория
        file.isFile(); // true если это файл
        file.listFiles(); // получить список всех вложенных файлов
        file.list(); // полчуить список имен всех дочерних файлов


        FileInputStream fileInputStream = new FileInputStream("path/to/file.txt"); // поток, через который можно считывать данные из файла
        FileOutputStream fileOutputStream = new FileOutputStream("path/to/copy.txt"); // поток, через который можно записывать в файл
        fileInputStream.read(); // считать байт из файла, возвращает -1, если считывать уже нечего
        fileOutputStream.write(0); // записать байт в файл
        fileInputStream.close(); // не забыть закрыть поток !!
        fileOutputStream.close(); // не забыть закрыть поток !!


        Scanner in = new Scanner("path/to/file.txt"); // сканнер, через который можно считывать данные из файла
        PrintWriter out = new PrintWriter("path/to/copy.txt"); // writer, через который можно записывать в файл
        in.hasNext(); // можно ли считать еще слово
        in.next(); // считать слово
        in.nextLine(); // считать строку
        out.print("kek"); // записать в файл
        in.close(); // не забыть закрыть поток !!
        out.close(); // не забыть закрыть поток !!

    }
}