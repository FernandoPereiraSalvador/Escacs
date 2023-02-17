/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.escacspereirafernando;

/**
 *
 * @author Fernando
 */
// Hecho por: Fernando José Pereira Salvador
// Comentario prueba
import java.util.Arrays;

public class EscacsPereiraFernando {

    //Funcion para crear el tablero 
    public static char[][] crearTablero() {
        int numeroFil;
        int numeroCol;
        char tablero[][];

        numeroFil = Teclat.lligInt("¿Cuantas filas tiene el tablero?", 5, 9);

        numeroCol = Teclat.lligInt("¿Cuantas columnas tiene el tablero?", 5, 9);

        tablero = new char[numeroFil][numeroCol];

        for (char[] tablero1 : tablero) {
            for (int i = 0; i < tablero1.length; i++) {
                tablero1[i] = '\0';
            }
        }

        return tablero;
    }

    // Funcion para mostrar el tablero 
    public static void mostrarTablero(char tablero[][], char[] letras) {

        int numeroFil = tablero.length;
        int numeroCol = tablero[0].length;

        titol(numeroFil);

        System.out.println();
        System.out.print("   ");
        for (int i = 1; i != numeroCol + 1; i++) {

            System.out.print(i + "  ");

        }
        System.out.println();

        for (int fil = 0; fil < numeroFil; fil++) {

            System.out.print(letras[fil] + "  ");
            for (int col = 0; col < numeroCol; col++) {
                System.out.print(tablero[fil][col]);
                switch (tablero[fil][col]) {
                    case 'x' ->
                        System.out.print("  ");
                    case '\0' ->
                        System.out.print("   ");
                    default ->
                        System.out.print("  ");
                }

            }
            System.out.println("");
        }
    }

    public static boolean hayPieza(char posicion_tablero) {
        return posicion_tablero == '\0';
    }

    // Funcion para mostrar los posibles movimientos de la torre 
    public static void movimientoTorre(int PosicionSeleccionada, int ColumnaSeleccionada, char tablero[][], char Movimiento) {

        // Derecha 
        for (int fil = PosicionSeleccionada; fil != tablero.length; fil++) {

            if (hayPieza(tablero[ColumnaSeleccionada][fil]) == false) {
                break;
            } else {
                tablero[ColumnaSeleccionada][fil] = Movimiento;
            }
        }

        // Izquierda 
        for (int fil = PosicionSeleccionada - 2; fil != -1; fil--) {

            if (hayPieza(tablero[ColumnaSeleccionada][fil]) == false) {
                break;
            } else {
                tablero[ColumnaSeleccionada][fil] = Movimiento;
            }

        }

        // Abajo 
        for (int fil = ColumnaSeleccionada + 1; fil != tablero.length; fil++) {

            if (hayPieza(tablero[fil][PosicionSeleccionada - 1]) == false) {
                break;
            } else {
                tablero[fil][PosicionSeleccionada - 1] = Movimiento;
            }
        }

        // Arriba
        for (int fil = ColumnaSeleccionada - 1; fil != -1; fil--) {

            if (hayPieza(tablero[fil][PosicionSeleccionada - 1]) == false) {
                break;
            } else {
                tablero[fil][PosicionSeleccionada - 1] = Movimiento;
            }
        }
    }

    // Funcion para mostrar los posibles movimientos del alfil 
    public static void movimientoAlfil(int nPosicionSeleccionada, int numeroCharPosicionSeleccionada, char tablero[][], char Movimiento) {

        // Diagonal derecha abajo
        for (int fil = nPosicionSeleccionada, col = numeroCharPosicionSeleccionada + 1; fil < tablero.length && col < tablero[0].length; fil++, col++) {
            if ((hayPieza(tablero[col][fil]) == false)) {
                break;
            } else {
                tablero[col][fil] = Movimiento;
            }
        }

        // Diagonal izquierda arriba
        for (int fil = nPosicionSeleccionada - 1, col = numeroCharPosicionSeleccionada - 1; fil >= 0 && col >= 0; fil--, col--) {
            if ((hayPieza(tablero[col][fil]) == false)) {
                break;
            } else {
                tablero[col][fil - 1] = Movimiento;
            }
        }

        // Diagonal derecha arriba
        for (int fil = nPosicionSeleccionada, col = numeroCharPosicionSeleccionada - 1; fil != tablero.length && col != -1; fil++, col--) {
            if ((hayPieza(tablero[col][fil]) == false) && (fil + col) == ((nPosicionSeleccionada + numeroCharPosicionSeleccionada) - 1)) {
                break;
            } else if ((fil + col) == ((nPosicionSeleccionada + numeroCharPosicionSeleccionada) - 1)) {
                tablero[col][fil] = Movimiento;
            }
        }
        // Diagonal izquierda abajo
        for (int fil = nPosicionSeleccionada - 2, col = numeroCharPosicionSeleccionada + 1; fil != -1 && col != tablero.length; fil--, col++) {

            if ((hayPieza(tablero[col][fil]) == false) && (fil + col) == ((nPosicionSeleccionada + numeroCharPosicionSeleccionada) - 1)) {
                break;
            } else if ((fil + col) == ((nPosicionSeleccionada + numeroCharPosicionSeleccionada) - 1)) {
                tablero[col][fil] = Movimiento;
            }
        }

    }

    // Funcion para mostrar los posibles movimientos del caballo 
    public static void movimientoCaballo(int PosicionSeleccionada, int ColumnaSeleccionada, char tablero[][], char Movimiento) {

        // dos casillas abajo y una a la derecha
        try {
            if (hayPieza(tablero[ColumnaSeleccionada + 2][PosicionSeleccionada])) {
                tablero[ColumnaSeleccionada + 2][PosicionSeleccionada] = Movimiento;
            }
        } catch (Exception e) {

        }

        // dos casillas arriba y una a la derecha
        try {
            if (hayPieza(tablero[ColumnaSeleccionada - 2][PosicionSeleccionada])) {
                tablero[ColumnaSeleccionada - 2][PosicionSeleccionada] = Movimiento;
            }

        } catch (Exception e) {

        }

        //dos casillas abajo y una a la izquierda
        try {
            if (hayPieza(tablero[ColumnaSeleccionada + 2][PosicionSeleccionada - 2])) {
                tablero[ColumnaSeleccionada + 2][PosicionSeleccionada - 2] = Movimiento;
            }
        } catch (Exception e) {

        }

        //dos casillas arriba y una a la izquierda
        try {
            if (hayPieza(tablero[ColumnaSeleccionada - 2][PosicionSeleccionada - 2])) {
                tablero[ColumnaSeleccionada - 2][PosicionSeleccionada - 2] = Movimiento;
            }
        } catch (Exception e) {

        }

        // dos casillas en medio derecha y una abajo
        try {
            if (hayPieza(tablero[ColumnaSeleccionada + 1][PosicionSeleccionada + 1])) {
                tablero[ColumnaSeleccionada + 1][PosicionSeleccionada + 1] = Movimiento;
            }
        } catch (Exception e) {

        }

        // dos casillas en medio derecha y una arriba
        try {
            if (hayPieza(tablero[ColumnaSeleccionada - 1][PosicionSeleccionada + 1])) {
                tablero[ColumnaSeleccionada - 1][PosicionSeleccionada + 1] = Movimiento;
            }
        } catch (Exception e) {

        }

        // dos casillas en medio derecha y una arriba
        try {
            if (hayPieza(tablero[ColumnaSeleccionada - 1][PosicionSeleccionada - 3])) {
                tablero[ColumnaSeleccionada - 1][PosicionSeleccionada - 3] = Movimiento;
            }
        } catch (Exception e) {

        }

        // dos casillas en medio izquierda y una abajo
        try {
            if (hayPieza(tablero[ColumnaSeleccionada + 1][PosicionSeleccionada - 3])) {
                tablero[ColumnaSeleccionada + 1][PosicionSeleccionada - 3] = Movimiento;
            }
        } catch (Exception e) {

        }

    }

    /* Funcion para mostrar los posibles movimientos del rey */
    public static void movimientoRey(int PosicionSeleccionada, int ColumnaSeleccionada, char tablero[][], char Movimiento) {

        // Diagonal derecha abajo
        try {
            if (hayPieza(tablero[ColumnaSeleccionada + 1][PosicionSeleccionada])) {
                tablero[ColumnaSeleccionada + 1][PosicionSeleccionada] = Movimiento;
            }
        } catch (Exception e) {

        }

        // Diagonal derecha 
        try {
            if (hayPieza(tablero[ColumnaSeleccionada - 1][PosicionSeleccionada])) {
                tablero[ColumnaSeleccionada - 1][PosicionSeleccionada] = Movimiento;
            }
        } catch (Exception e) {

        }

        // Arriba
        try {
            if (hayPieza(tablero[ColumnaSeleccionada - 1][PosicionSeleccionada - 1])) {
                tablero[ColumnaSeleccionada - 1][PosicionSeleccionada - 1] = Movimiento;
            }
        } catch (Exception e) {

        }

        // Diagonal izquierda arriba
        try {
            if (hayPieza(tablero[ColumnaSeleccionada - 1][PosicionSeleccionada - 2])) {
                tablero[ColumnaSeleccionada - 1][PosicionSeleccionada - 2] = Movimiento;
            }

        } catch (Exception e) {

        }

        // Diagonal izquierda abajo
        try {
            if (hayPieza(tablero[ColumnaSeleccionada + 1][PosicionSeleccionada - 2])) {
                tablero[ColumnaSeleccionada + 1][PosicionSeleccionada - 2] = Movimiento;
            }
        } catch (Exception e) {

        }

        // En medio izquierda
        try {
            if (hayPieza(tablero[ColumnaSeleccionada][PosicionSeleccionada - 2])) {
                tablero[ColumnaSeleccionada][PosicionSeleccionada - 2] = Movimiento;
            }
        } catch (Exception e) {

        }

        // En medio derecha
        try {

            if (hayPieza(tablero[ColumnaSeleccionada][PosicionSeleccionada])) {
                tablero[ColumnaSeleccionada][PosicionSeleccionada] = Movimiento;
            }

        } catch (Exception e) {

        }

        // Abajo
        try {
            if (hayPieza(tablero[ColumnaSeleccionada + 1][PosicionSeleccionada - 1])) {
                tablero[ColumnaSeleccionada + 1][PosicionSeleccionada - 1] = Movimiento;
            }
        } catch (Exception e) {

        }

    }

    /* Funcion para mostrar los posibles movimientos del peon */
    public static void movimientoPeon(int nPosicionSeleccionada, int numeroCharPosicionSeleccionada, char tablero[][], char Movimiento) {

        try {
            // Si esta en la segunda fila
            if (numeroCharPosicionSeleccionada == tablero.length - 2) {

                // Una arriba
                try {
                    if (hayPieza(tablero[numeroCharPosicionSeleccionada - 1][nPosicionSeleccionada - 1])) {
                        tablero[numeroCharPosicionSeleccionada - 1][nPosicionSeleccionada - 1] = Movimiento;
                    }
                } catch (Exception e) {

                }

                // Dos arriba
                try {
                    if (hayPieza(tablero[numeroCharPosicionSeleccionada - 2][nPosicionSeleccionada - 1])) {
                        tablero[numeroCharPosicionSeleccionada - 2][nPosicionSeleccionada - 1] = Movimiento;
                    }
                } catch (Exception e) {

                }

                // Si esta en otra fila
            } else if (hayPieza(tablero[numeroCharPosicionSeleccionada - 1][nPosicionSeleccionada - 1])) {

                // Una arriba
                try {
                    if (hayPieza(tablero[numeroCharPosicionSeleccionada - 1][nPosicionSeleccionada - 1])) {
                        tablero[numeroCharPosicionSeleccionada - 1][nPosicionSeleccionada - 1] = Movimiento;
                    }
                } catch (Exception e) {

                }
            }
        } catch (Exception e) {

        }
    }

    /* Funcion para convertir la letra de la posicion que se selecciona a un numero*/
    public static int letrasANumeros(char car, int num, char[] letras) {

        int index = Arrays.binarySearch(letras, car);
        if (index >= 0) {
            num = index;
        } else {
            num = -1;
        }
        return num;
    }

    /* Funcion para crear el titulo de ajedrez */
    static void titol(int numeroFil) {

        String text = "Ajedrez";

        int sidePadding = (numeroFil * 3 - text.length()) / 2;
        // linia 1
        System.out.println("");
        linia(numeroFil * 3 + 4, '*');
        System.out.println("");

        // linia 2
        System.out.print("* ");
        linia(sidePadding, ' ');
        System.out.print(text);
        if (numeroFil % 2 != 0) {
            linia(sidePadding - 1, ' ');
        } else {
            linia(sidePadding, ' ');

        }
        if ((text.length() & 1) == 1) {
            System.out.print(" ");
        }
        System.out.println(" *");

        // linia 4
        System.out.print("* ");
        linia(numeroFil * 3, ' ');
        System.out.println(" *");

        // linia 5
        linia(numeroFil * 3 + 4, '*');
        System.out.println("");

    }

    /* Funcion para crear las lineas para el titulo */
    static void linia(int lon, char car) {
        for (int i = 1; i <= lon; i++) {
            System.out.print(car);
        }
    }

    /* Codigo principal */
    public static void main(String[] args) {

        /* Iniciamos las variables */
        char[] letras = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I'};
        int opcion;
        int nPosicionSeleccionada;
        char charPosicionSeleccionada = ' ';
        int numeroCharPosicionSeleccionada = 9;
        String piezaElegida;
        char salir = 'n';
        boolean letraEstaTablero = false;
        final char Movimiento = 'x';

        /* Creamos el tablero */
        char tablero[][] = crearTablero();

        /* Iniciamos el bucle del menu */
        do {

            mostrarTablero(tablero, letras);

            System.out.println("Opcion 1: Poner una pieza");
            System.out.println("Opcion 2: Mostrar los movimientos de una pieza");
            System.out.println("Opcion 3: Eliminar movimientos");
            System.out.println("Opcion 4: Eliminar tablero");
            System.out.println("Opcion 5: Salir");

            opcion = Teclat.lligInt("Introduce la opcion ", 1, 5);

            /* Opcion 1: Poner una pieza */
            switch (opcion) {
                case 1 -> {
                    System.out.println("Peces disponibles: ");
                    System.out.println("T = Torre");
                    System.out.println("A = Alfil");
                    System.out.println("D = Dama");
                    System.out.println("C = Caballo");
                    System.out.println("R= Rey");
                    System.out.println("P= Peon");

                    do {
                        piezaElegida = Funcionetes.lligString("Introduzca la pieza: ");

                    } while (!"A".equals(piezaElegida) && !"T".equals(piezaElegida) && !"D".equals(piezaElegida) && !"C".equals(piezaElegida) && !"R".equals(piezaElegida) && !"P".equals(piezaElegida));

                    System.out.println("Introduzca la posición en el tablero: ");

                    do {
                        nPosicionSeleccionada = Funcionetes.lligInt("Introduzca el número de la posición: ");

                    } while (nPosicionSeleccionada > tablero[0].length);

                    while (letraEstaTablero == false) {
                        charPosicionSeleccionada = Funcionetes.lligChar("Introduzca la letra de la posición: ");

                        if (letrasANumeros(charPosicionSeleccionada, numeroCharPosicionSeleccionada, letras) != -1) {
                            break;

                        }
                    }

                    numeroCharPosicionSeleccionada = letrasANumeros(charPosicionSeleccionada, numeroCharPosicionSeleccionada, letras);

                    letraEstaTablero = false;

                    switch (piezaElegida) {
                        case "T", "Torre" ->
                            tablero[numeroCharPosicionSeleccionada][nPosicionSeleccionada - 1] = 'T';
                        case "A", "Alfil" ->
                            tablero[numeroCharPosicionSeleccionada][nPosicionSeleccionada - 1] = 'A';
                        case "D", "Dama" ->
                            tablero[numeroCharPosicionSeleccionada][nPosicionSeleccionada - 1] = 'D';
                        case "C", "Caballo" ->
                            tablero[numeroCharPosicionSeleccionada][nPosicionSeleccionada - 1] = 'C';
                        case "R", "Rey" ->
                            tablero[numeroCharPosicionSeleccionada][nPosicionSeleccionada - 1] = 'R';
                        case "P", "Peon" ->
                            tablero[numeroCharPosicionSeleccionada][nPosicionSeleccionada - 1] = 'P';
                        default ->
                            System.out.println("No existe la pieza seleccionada o se ha escrito incorrectamente");
                    }
                }
                /* Opcion 2: Mostrar movimientos */
                case 2 -> {
                    System.out.println("Introduzca la posición de la ficha de la que quiere ver los movimientos: ");

                    do {
                        nPosicionSeleccionada = Funcionetes.lligInt("Introduce el número de la posición: ");

                    } while (nPosicionSeleccionada > tablero[0].length);

                    while (letraEstaTablero == false) {
                        charPosicionSeleccionada = Funcionetes.lligChar("Introduce la letra de la posición: ");

                        if (letrasANumeros(charPosicionSeleccionada, numeroCharPosicionSeleccionada, letras) != -1) {
                            break;

                        }
                    }
                    letraEstaTablero = false;

                    numeroCharPosicionSeleccionada = letrasANumeros(charPosicionSeleccionada, numeroCharPosicionSeleccionada, letras);

                    switch (tablero[numeroCharPosicionSeleccionada][nPosicionSeleccionada - 1]) {
                        case 'T' ->
                            movimientoTorre(nPosicionSeleccionada, numeroCharPosicionSeleccionada, tablero, Movimiento);
                        case 'A' ->
                            movimientoAlfil(nPosicionSeleccionada, numeroCharPosicionSeleccionada, tablero, Movimiento);
                        case 'D' -> {
                            movimientoTorre(nPosicionSeleccionada, numeroCharPosicionSeleccionada, tablero, Movimiento);
                            movimientoAlfil(nPosicionSeleccionada, numeroCharPosicionSeleccionada, tablero, Movimiento);
                        }
                        case 'C' -> {
                            movimientoCaballo(nPosicionSeleccionada, numeroCharPosicionSeleccionada, tablero, Movimiento);
                        }
                        case 'R' ->
                            movimientoRey(nPosicionSeleccionada, numeroCharPosicionSeleccionada, tablero, Movimiento);
                        case 'P' ->
                            movimientoPeon(nPosicionSeleccionada, numeroCharPosicionSeleccionada, tablero, Movimiento);
                        default ->
                            System.out.println("No se ha encontrado ninguna ficha en esta posición");

                    }
                }

                /* Opcion 3: Eliminar movimientos */
                case 3 -> {
                    int contadorMarcas = 0;
                    for (char[] tablero1 : tablero) {
                        for (int col = 0; col < tablero.length; col++) {
                            if (tablero1[col] == Movimiento) {
                                tablero1[col] = ' ';
                                contadorMarcas += 1;
                            }
                        }
                    }
                    System.out.println("Se han eliminado " + contadorMarcas + " marcas");
                }
                /* Opcion 4: Vaciar tablero */
                case 4 -> {
                    for (char[] tablero1 : tablero) {
                        for (int col = 0; col < tablero.length; col++) {
                            tablero1[col] = '\0';
                        }
                    }
                }

                /* Opcion 5: Salir */
                case 5 -> {
                    salir = Teclat.lligChar("¿Seguro que quiere salir?", "SN");
                    if (salir != 'S') {
                        System.out.println("El programa continua");
                    }
                }
            }

        } while (salir != 'S');
    }
}
