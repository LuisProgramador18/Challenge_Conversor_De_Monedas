import com.aluracursos.Entidades.ConversionMoneda;
import com.aluracursos.Entidades.ConversorMoneda;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido/a al Conversor de Monedas =)");
        System.out.println("Por favor, elija una de las siguientes opciones:\n");

        int opMenu = 0;
        do {
            double montoConvertido;
            ConversorMoneda cvm = new ConversorMoneda();
            ConversionMoneda datosMonedas = null;
            System.out.println("""
                    1) Dólar =>> Peso argentino
                    2) Peso argentino =>> Dólar
                    3) Dólar =>> Real brasileño
                    4) Real brasileño =>> Dólar
                    5) Dólar =>> Peso colombiano
                    6) Peso colombiano =>> Dólar
                    7) Salir
                    Elija una opción válida:""");

            opMenu = scanner.nextInt();
            if (opMenu < 0 || opMenu > 7) {
                System.out.println("Opción no válida");
                continue;
            }
            System.out.println("Ingrese el monto de la moneda origen que desea convertir: ");
            float monto = scanner.nextFloat();
            switch(opMenu){
                case 1:
                    datosMonedas = cvm.convetirMonto("USD");
                    cvm.logicaConversion("ARS", monto, datosMonedas);
                    break;
                case 2:
                    datosMonedas = cvm.convetirMonto("ARS");
                    cvm.logicaConversion("USD", monto, datosMonedas);
                    break;
                case 3:
                    datosMonedas = cvm.convetirMonto("USD");
                    cvm.logicaConversion("BRL", monto, datosMonedas);
                    break;
                case 4:
                    datosMonedas = cvm.convetirMonto("BRL");
                    cvm.logicaConversion("USD", monto, datosMonedas);
                    break;
                case 5:
                    datosMonedas = cvm.convetirMonto("USD");
                    cvm.logicaConversion("COP", monto, datosMonedas);
                    break;
                case 6:
                    datosMonedas = cvm.convetirMonto("COP");
                    cvm.logicaConversion("USD", monto, datosMonedas);
                    break;
                case 7:
                    System.out.println("Gracias por utilizar el sistema!");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;

            }
            System.out.println("\n");
        } while (opMenu != 7);
    }
}