import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Objects;
import java.util.Scanner;
public class Menghitung_gaji_karyawan {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        String nama, gol, istri;
        int jlembur, gapok, glembur, transport, jmasuk, jpulang, ulembur, tistri, uanak, anak, tanak;
        double gajibersih;

        System.out.println("PROGRAM MENGHITUNG GAJI KARYAWAN");
        System.out.println("------------------------------------------------");
        System.out.print("Masukan Nama : ");
        nama=input.next();
        System.out.print("Masukan Kode (spv, hrd, tkn, kry) : ");
        gol=input.next();
        System.out.print("Masukan Jam Masuk (1 - 24): ");
        jmasuk=input.nextInt();
        System.out.print("Masukan Jam Pulang (1 - 24) : ");
        jpulang=input.nextInt();
        System.out.print("Memiliki Istri (y/n) : ");
        istri=input.next();
        System.out.print("Total Anak : ");
        anak=input.nextInt();
        System.out.println("------------------------------------------------");

        switch(gol){
            case "spv" :
                gapok=10000000;
                transport=1000000;
                ulembur=10000;
                tistri=300000;
                uanak=200000;
                break;
            case "hrd" :
                gapok=5000000;
                transport=750000;
                ulembur=7500;
                tistri=250000;
                uanak=190000;
                break;
            case "tkn" :
                gapok=3000000;
                transport=500000;
                ulembur=5000;
                tistri=200000;
                uanak=150000;
                break;
            case "kry" :
                gapok=1500000;
                transport=250000;
                ulembur=5000;
                tistri=200000;
                uanak=130000;
                break;
            default :
                gapok=0;
                transport=0;
                ulembur=0;
                tistri=0;
                uanak=0;
        }

        if (jpulang - jmasuk>9){
            jlembur=jpulang - jmasuk -9;
        }else{
            jlembur=0;
        }

        if (Objects.equals(istri, "n")){
            tistri=0;
        }

        glembur=jlembur*ulembur;
        tanak=uanak*anak;
        gajibersih=(gapok+transport+glembur+tistri+tanak);

        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(formatRp);

        System.out.println("Nama                 : "+nama);
        System.out.println("Gaji Pokok           : "+ kursIndonesia.format(gapok));
        System.out.println("Transport            : "+kursIndonesia.format(transport));
        System.out.println("Gaji Lembur          : "+kursIndonesia.format(glembur));
        System.out.println("Tunjangan Istri      : "+kursIndonesia.format(tistri));
        System.out.println("Tunjangan Anak       : "+kursIndonesia.format(tanak));
        System.out.println("Gaji Diterima        : "+kursIndonesia.format(gajibersih));
    }
}