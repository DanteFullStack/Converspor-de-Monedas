package com.alurareto.conversormoneda.principal;

import com.alurareto.conversormoneda.modelo.CambioDeMoneda;
import com.alurareto.conversormoneda.servicio.Historial;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<CambioDeMoneda> registro = new ArrayList<CambioDeMoneda>();

    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConversorMon clienteAPI = new ConversorMon();
        System.out.println("AUTOR:Dante Abraham Ruiz Juarez");
        System.out.println("************************************************************************");
        System.out.println("*** BIENVENIDO AL CONVERSOR DE MONEDAS. ***");
        System.out.println("************************************************************************");
        String menu = """
                Por favor, seleccione una opción:
                1. Convertir de Dólares a Pesos argentinos.
                2. Convertir de Pesos argentinos a Dólares.
                3. Convertir de Dólares a pesos mexicanos.
                4. Convertir de pesos mexicanos a Dólares.
                5. Convertir de Real brasileño a Pesos argentinos.
                6. Convertir de Pesos argentinos a Real brasileño .
                7. Salir
                """;
        int opcionDelUsuario = 0;
        double cantidad = 0.0;

        while (opcionDelUsuario != 7) {
            System.out.println(menu);
            opcionDelUsuario = lectura.nextInt();
            switch (opcionDelUsuario) {
                case 1:
                    String base1 = "USD";
                    String target1 = "ARS";
                    System.out.println("Ingrese la cantidad en Dólares a convertir:");
                    cantidad = lectura.nextDouble();
                    try {
                        CambioDeMoneda resultado = clienteAPI.resultadoDeConversion(base1, target1, cantidad);
                        System.out.println("Resultado: " + resultado.conversion_result() + " Pesos argentinos.");
                        registro.add(resultado);
                    } catch (IOException | InterruptedException e) {
                        System.out.println("Lo sentimos, ha ocurrido un error.");
                        System.exit(0);
                    }
                    break;
                case 2:
                    String base2 = "ARS";
                    String target2 = "USD";
                    System.out.println("Ingrese la cantidad en Pesos argentinos a convertir:");
                    cantidad = lectura.nextDouble();
                    try {
                        CambioDeMoneda resultado = clienteAPI.resultadoDeConversion(base2, target2, cantidad);
                        System.out.println("Resultado: " + resultado.conversion_result() + " Dólares.");
                        registro.add(resultado);
                    } catch (IOException | InterruptedException e) {
                        System.out.println("Lo sentimos, ha ocurrido un error.");
                        System.exit(0);
                    }
                    break;
                case 3:
                    String base3 = "USD";
                    String target3 = "MXN";
                    System.out.println("Ingrese la cantidad en Dólares a convertir:");
                    cantidad = lectura.nextDouble();
                    try {
                        CambioDeMoneda resultado = clienteAPI.resultadoDeConversion(base3, target3, cantidad);
                        System.out.println("Resultado: " + resultado.conversion_result() + " Pesos mexicanos.");
                        registro.add(resultado);
                    } catch (IOException |InterruptedException e) {
                        System.out.println("Lo sentimos, ha ocurrido un error.");
                        System.exit(0);
                    }
                    break;
                case 4:
                    String base4 = "MXN";
                    String target4 = "USD";
                    System.out.println("Ingrese la cantidad en Pesos mexicanos a convertir:");
                    cantidad = lectura.nextDouble();
                    try {
                        CambioDeMoneda resultado = clienteAPI.resultadoDeConversion(base4, target4, cantidad);
                        System.out.println("Resultado: " + resultado.conversion_result() + " Dólares.");
                        registro.add(resultado);
                    } catch (IOException | InterruptedException e) {
                        System.out.println("Lo sentimos, ha ocurrido un error.");
                        System.exit(0);
                    }
                    break;
                case 5:
                    String base5 = "BRL";
                    String target5 = "ARS";
                    System.out.println("Ingrese la cantidad en Real brasileño a convertir:");
                    cantidad = lectura.nextDouble();
                    try {
                        CambioDeMoneda resultado = clienteAPI.resultadoDeConversion(base5, target5, cantidad);
                        System.out.println("Resultado: " + resultado.conversion_result() + " Pesos argentinos.");
                        registro.add(resultado);
                    } catch (IOException | InterruptedException e) {
                        System.out.println("Lo sentimos, ha ocurrido un error.");
                        System.exit(0);
                    }
                    break;
                case 6:
                    String base6 = "ARS";
                    String target6 = "BRL";
                    System.out.println("Ingrese la cantidad en Pesos argentinos a convertir:");
                    cantidad = lectura.nextDouble();
                    try {
                        CambioDeMoneda resultado = clienteAPI.resultadoDeConversion(base6, target6, cantidad);
                        System.out.println("Resultado: " + resultado.conversion_result() + " Real brasileño.");
                        registro.add(resultado);
                    } catch (IOException | InterruptedException e) {
                        System.out.println("Lo sentimos, ha ocurrido un error.");
                        System.exit(0);
                    }
                    break;
            }
        }
        Historial historial = new Historial();
        historial.guardarHistorial(registro);
        System.out.println("Su historial de conversiones: ");
        historial.mostrarHistorial(registro);
        System.out.println("Gracias por usar el conversor de monedas. ¡Hasta luego!");
    }
}
