package model.program;

import model.entities.Reserva;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Digite o número do quarto: ");
        int numeroQuarto = sc.nextInt();
        System.out.println("Entre com a data de check-in (dia/mês/Ano)");
        Date checkIn = sdf.parse(sc.next());
        System.out.println("Entre com a data de check-out (dia/mês/Ano)");
        Date checkOut = sdf.parse(sc.next());
        if (!checkOut.after(checkIn)) {
            System.out.println("Erro na reserva: data de check-out deve ser posterior à data de check-in");
        } else {
            Reserva reserva = new Reserva(numeroQuarto, checkIn, checkOut);
            System.out.println("reserva: " + reserva);

            System.out.println();
            System.out.println("Entre com uma data nova para a reserva:");
            System.out.println("Entre com a data de check-in (dia/mês/Ano)");
            checkIn = sdf.parse(sc.next());
            System.out.println("Entre com a data de check-out (dia/mês/Ano)");
            checkOut = sdf.parse(sc.next());
            String error = reserva.UpdateDatas(checkIn, checkOut);
            if (error != null){
                System.out.println("Erro na reserva: " + error);
            }else {
                System.out.println("reserva: " + reserva );
            }


        }
        sc.close();
    }
}
