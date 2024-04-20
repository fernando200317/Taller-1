
import java.util.Scanner;
/**
 * La clase `Clientes` en Java implementa un sistema de reserva de hotel que recopila información del cliente,
 * valida la entrada, calcula costos, aplica descuentos según la edad y la duración de la estadía, y muestra un
 * resumen de la reserva.
 */
public class Clientes {
/** 
     * El método principal es el punto de entrada del programa. Recopila la entrada del usuario, la valida, calcula
     * los costos, aplica descuentos y muestra un resumen de la reserva.
     * 
     * @param args Los argumentos de línea de comandos (no se usan en este programa).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Mensaje de bienvenida
        System.out.println("Bienvenido al Hotel");
        System.out.println("-------------------");
        System.out.println("Sistema de Reserva de habitacion");
        System.out.println("--------------------------------");
        // Recopilar información del cliente
        System.out.print("Ingrese el nombre del cliente: ");
        String nombreCliente = scanner.nextLine();
        String rutCliente = "";
        boolean rutValido = false;

        Validador validador = new Validador();

        // Validar el número RUT (Rol Único Tributario) del cliente
        while (!rutValido) {
            System.out.print("Ingrese el RUT del cliente (Formato XXXXXXX-X): ");
            rutCliente = scanner.nextLine();

            if (validador.validaRut(rutCliente)) {
                rutValido = true;
                System.out.println("RUT válido");
            } else {
                System.out.println("RUT inválido. Por favor, ingrese un RUT válido.");
            }
        }

        // Recopilar detalles de la reserva
        System.out.print("Ingrese el día de llegada al hotel: ");
        String diaLlegada = scanner.nextLine();
        System.out.print("Ingrese la duración de la estadía (en días): ");
        int duracionEstadia = scanner.nextInt();

        // Seleccionar tipo de habitación
        int opcionHabitacion = 0;
        boolean habitacionValida = false;
        double costoHabitacion = 0;
        while (!habitacionValida) {
            System.out.println("Opciones de habitaciones:");
            System.out.println("1. Habitación individual - $100");
            System.out.println("2. Habitación doble - $150");
            System.out.println("3. Habitación suite - $300");
            System.out.print("Ingrese el número de la habitación elegida: ");
            opcionHabitacion = scanner.nextInt();

            switch (opcionHabitacion) {
                case 1:
                    costoHabitacion = 100.0;
                    habitacionValida = true;
                    break;
                case 2:
                    costoHabitacion = 150.0;
                    habitacionValida = true;
                    break;
                case 3:
                    costoHabitacion = 300.0;
                    habitacionValida = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
// Solicitar servicios adicionales
        System.out.print("¿Desea agregar servicios adicionales? (S/N): ");
        String respuestaServicios = scanner.next();

        double costoServicios = 0.0;

        if (respuestaServicios.equalsIgnoreCase("S")) {
            System.out.println("Lista de servicios adicionales:");
            System.out.println("1. Servicio de limpieza - $20");
            System.out.println("2. Desayuno incluido - $10");
            System.out.println("3. Acceso al gimnasio - $15");
            System.out.println("4. Salir");

            boolean agregarServicios = true;
            while (agregarServicios) {
                System.out.print("Ingrese el número del servicio adicional elegido (4 para salir): ");
                int opcionServicio = scanner.nextInt();

                switch (opcionServicio) {
                    case 1:
                        costoServicios += 20.0;
                        break;
                    case 2:
                        costoServicios += 10.0;
                        break;
                    case 3:
                        costoServicios += 15.0;
                        break;
                    case 4:
                        agregarServicios = false;
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
                        break;
                }
            }
        }
        // La línea `double costoTotal = costoHabitacion * duracionEstadia + costoServicios;` en el código está calculando el costo total de la reserva.
        double costoTotal = costoHabitacion * duracionEstadia + costoServicios;

        System.out.print("Ingrese la edad del cliente: ");
        int edadCliente = scanner.nextInt();
// Aplicar descuentos basados en la edad del cliente y la duración de la estadía
        if (edadCliente >= 65) {
            double descuento = costoTotal * 0.1;
            costoTotal -= descuento;
            System.out.println("Se aplicó un descuento del 10% para personas mayores de 65 años.");
        }

        if (duracionEstadia > 7) {
            double descuento = costoTotal * 0.05;
            costoTotal -= descuento;
            System.out.println("Se aplicó un descuento del 5% para estadías de más de 7 días.");
        }

        // Mostrar resumen de la reserva
        scanner.close();
        System.out.println("-------------------");
        System.out.println("Resumen de la reserva");
        System.out.println("-------------------");
        System.out.println("Cliente: " + nombreCliente);
        System.out.println("RUT del cliente: " + rutCliente);
        System.out.println("Duración de la estadía: " + duracionEstadia + " días");
        System.out.println("Día de llegada al hotel: " + diaLlegada);
        System.out.println("Habitación elegida: " + opcionHabitacion);
        System.out.println("Costo de la habitación: $" + costoHabitacion);
        System.out.println("Costo de los servicios adicionales: $" + costoServicios);
        System.out.println("Costo total: $" + costoTotal);
        if (edadCliente >= 65) {
            System.out.println("Descuento aplicado: 10% por ser mayor de 65 años");
        }
        if (duracionEstadia > 7) {
            System.out.println("Descuento aplicado: 5% por estadía de más de 7 días");
        }
    }

}
