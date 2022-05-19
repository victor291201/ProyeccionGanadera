import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object

        System.out.println("Ingrese la cantidad de vacas: ");
        int CVacas = Integer.valueOf(myObj.nextLine());

        System.out.println("Ingrese la cantidad de liros por vaca: ");
        double LVacas = Double.valueOf(myObj.nextLine());

        System.out.println("Ingrese el valor de cada litro: ");
        double VxLitro = Double.valueOf(myObj.nextLine());
        while(true){
            System.out.println("Ingrese plazo de la proyeccion (en meses 3, 6, 9, 12 o 24): ");
            String Proyeccion = myObj.nextLine();
            int DV=0;
            double VLitros = 0;
            String Recomendacion = "";
            switch(Proyeccion){
                case "3":
                    DV = 10;
                    VLitros = LVacas -1;
                    Recomendacion = "Comprar mas vacas en invierno";
                    break;
                case "6":
                    DV = 20;
                    VLitros = LVacas -1;
                    CVacas = CVacas +1;
                    Recomendacion = "Comprar mas vacas en verano";
                    break;
                case "9":
                    DV = 30;
                    VLitros = LVacas -1;
                    CVacas = CVacas +1;
                    Recomendacion = "Comprar suplemento";
                    break;
                case "12":
                    VLitros = LVacas -1;
                    DV = 40;
                    CVacas = CVacas +2;
                    Recomendacion = "No comprar suplemento";
                    break;
                case "24":
                    DV = 75;
                    VLitros = LVacas - 1.5;
                    CVacas = CVacas +6;
                    Recomendacion = "No comprar mas vacas";
                    break;
            }
            double Pcostos = 0.65;
            double DiasNetos = Double.valueOf(Proyeccion) * 30.5 - Double.valueOf(DV);
            System.out.println("desea comprar el suplemento en verano?(s para si, n para no): ");
            String Suplemento = myObj.nextLine();
            if(Suplemento.equals("s")){
                Pcostos = Pcostos + 0.08;
                VLitros = VLitros+ 3;
            }
            double NIngresos = DiasNetos * CVacas * LVacas * VxLitro;
            double VIngresos = DV * CVacas * VLitros * VxLitro;
            double IngresosTotales = NIngresos + VIngresos;
            double CostosTotales = IngresosTotales * Pcostos;
            double Utilidad = IngresosTotales - CostosTotales;
            System.out.println("Ingresos totales: "+ IngresosTotales+
                                ", Costos totales: "+CostosTotales+
                                ", Utilidades: "+ Utilidad+
                                ", Basado en la proyeccion escogida se recomienda: "+ Recomendacion 
            );
            
            System.out.println("desea salir del programa?(s para si, n para no): ");
            String Salida = myObj.nextLine();
            if(Salida.equals("s")){
                break;
            }
        }
        
    }
}
