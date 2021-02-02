import data.Key;
import data.Messages;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.sql.SQLOutput;
import java.util.Scanner;


public class Cryptosystem {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce message: ");
        String message = teclado.nextLine();
        System.out.println("Message introduce is: " + message);

        long time_start, time_end;
        time_start = System.currentTimeMillis();

        Key key = Encrypt.generateKey(1024);
        BigInteger n = key.getN();
        BigInteger p = key.getP();
        BigInteger q = key.getQ();

        BigInteger messageInBytes = new BigInteger(message.getBytes(Charset.forName("ascii")));
        BigInteger c = Encrypt.encrypt(messageInBytes, n);
        time_end = System.currentTimeMillis();

        System.out.println("Encrypted Message : " + c);
        System.out.println("The encryption has taken "+ ( time_end - time_start ) +" milliseconds" + "\n");

        Messages roots = Decrypt.decrypt(c, p, q);
        System.out.println("Possible messages");
        System.out.println("r1 = "+ roots.getR1());
        System.out.println("r2 = "+ roots.getR2());
        System.out.println("r3 = "+ roots.getR3());
        System.out.println("r4 = "+ roots.getR4()+ "\n");

        for (int i = 0; i < roots.messagesList().length; i++) {

            String r = new String(roots.messagesList()[i].toByteArray(), Charset.forName("ascii"));
            if (r.equals(message)) {
                System.out.println("The root containt the message is r" + (i+1) + " and the message is: " + r);
            }
        }

    }
}
