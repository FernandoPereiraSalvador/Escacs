/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.escacspereirafernando;

/**
 *
 * @author Fernando
 */
import java.util.Scanner;

class Funcionetes {

    static Scanner teclat = new Scanner(System.in);
// ----------------------------------------------------------------------------------------

    public static int lligInt(String pregunta) {
        int numero;
        do {
            try {
                System.out.print(pregunta);
                numero = teclat.nextInt(); // Si hem posat lletres, va al catch
                // Si passa per ací, no ha donat error. Buidem \n i tornem el número.
                teclat.nextLine();
                return numero;
            } catch (Exception e) { // Si hem posat lletres, avisa i buida el buffer:
                System.out.println("Ha de ser un número enter:");
                teclat.nextLine();
            }
        } while (true); // Bucle infinit fins que retornem el número correcte.
    }
// ----------------------------------------------------------------------------------------

    public static float lligFloat(String pregunta) {
        float numero;
        do {
            try {
                System.out.print(pregunta);
                numero = teclat.nextFloat(); // Si hem posat lletres, va al catch
                // Si passa per ací, no ha donat error. Buidem \n i tornem el número.
                teclat.nextLine();
                return numero;
            } catch (Exception e) { // Si hem posat lletres, avisa i buida el buffer:
                System.out.println("Ha de ser un número enter:");
                teclat.nextLine();
            }
        } while (true); // Bucle infinit fins que retornem el número correcte.
    }

// ----------------------------------------------------------------------------------------
    public static String lligString(String pregunta) {
        System.out.print(pregunta);
        return teclat.nextLine();

    }

    // ----------------------------------------------------------------------------------------
    public static char lligChar(String pregunta) {
        System.out.print(pregunta);
        String text;
        text = teclat.nextLine();

        while (text.length() != 1) {
            System.out.println("Només 1 lletra.");
            text = teclat.nextLine();
        }
        return text.charAt(0);

    }

}
