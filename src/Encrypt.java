import data.Key;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

public class Encrypt {

    private static BigInteger TWO = BigInteger.valueOf(2);
    private static BigInteger THREE = BigInteger.valueOf(3);
    private static BigInteger FOUR = BigInteger.valueOf(4);


    public static BigInteger generatePrimeNumber(int bitLength) {
        Random rnd = new SecureRandom();
        BigInteger primeNumber = BigInteger.probablePrime(bitLength, rnd);
        while (!primeNumber.mod(FOUR).equals(THREE)) {
            primeNumber = BigInteger.probablePrime(bitLength, rnd);
        }
        return primeNumber;
    }

    public static Key generateKey(int bitLength) {
        BigInteger p = generatePrimeNumber(bitLength);
        BigInteger q = generatePrimeNumber(bitLength);
        BigInteger n = p.multiply(q);
        return new Key(p, q, n);
    }

    public static BigInteger encrypt(BigInteger m, BigInteger N) {
        return m.modPow(TWO, N);
    }
}
