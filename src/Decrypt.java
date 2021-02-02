import data.Messages;

import java.math.BigInteger;

public class Decrypt {

    private static BigInteger FOUR = BigInteger.valueOf(4);

    public Decrypt(){}

    public static BigInteger[] egcd(BigInteger p, BigInteger q) {
        BigInteger a = BigInteger.ZERO;
        BigInteger lastA = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;
        BigInteger lastB = BigInteger.ZERO;

        BigInteger tmp;

        while (!q.equals(BigInteger.ZERO)) {

            BigInteger[] quotientAndRemainder = p.divideAndRemainder(q);
            // quotientAndRemainder[0] is saved quotient and quotientAndRemainder[1] is saved remainder

            p = q;
            q = quotientAndRemainder[1];

            tmp = a;
            a = lastA.subtract(quotientAndRemainder[0].multiply(a));
            lastA = tmp;

            tmp = b;
            b = lastB.subtract(quotientAndRemainder[0].multiply(b));
            lastB = tmp;
        }

        return new BigInteger[]{p, lastA, lastB};
    }

    public static Messages decrypt(BigInteger c, BigInteger p, BigInteger q)
    {
        BigInteger n = p.multiply(q);

        BigInteger mP = c.modPow(p.add(BigInteger.ONE).divide(FOUR), p);
        BigInteger mQ = c.modPow(q.add(BigInteger.ONE).divide(FOUR), q);

        BigInteger[] egcd = egcd(p, q);
        BigInteger a = egcd[1];
        BigInteger b = egcd[2];

        BigInteger r1 = a.multiply(p).multiply(mQ).add(b.multiply(q).multiply(mP)).mod(n);
        BigInteger r2 = n.subtract(r1);
        BigInteger r3 = a.multiply(p).multiply(mQ).subtract(b.multiply(q).multiply(mP)).mod(n);
        BigInteger r4 = n.subtract(r3);

        return new Messages(r1, r2, r3, r4);
    }

}
