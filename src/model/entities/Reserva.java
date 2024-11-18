package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
    private Integer NumeroDoQuarto;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reserva(Integer numeroDoQuarto, Date checkIn, Date checkOut) {
        NumeroDoQuarto = numeroDoQuarto;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public long duracao() {
        long diff = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public String UpdateDatas(Date checkIn, Date checkOut) {
        Date now = new Date();
        if (checkIn.before(now) || checkOut.before(now)) {
            return "data de check-out e check-in devem ser futuras";
        } else if ((!checkOut.after(checkIn))) {
            return "data de check-out deve ser posterior à data de check-in";
        }
            this.checkIn = checkIn;
            this.checkOut = checkOut;
            return null;

        }

        public Integer getNumeroDoQuarto () {
            return NumeroDoQuarto;
        }

        public void setNumeroDoQuarto (Integer numeroDoQuarto){
            NumeroDoQuarto = numeroDoQuarto;
        }

        public Date getCheckIn () {
            return checkIn;
        }

        public Date getCheckOut () {
            return checkOut;
        }

        @Override
        public String toString () {
            return "Reserva: " + getNumeroDoQuarto() + ", check-in:" + sdf.format(checkIn) +
                    ", check-out: " + sdf.format(checkOut) + ", noites: " + duracao();
        }
    }
