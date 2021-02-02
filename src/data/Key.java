package data;

        import java.math.BigInteger;

public class Key {
    private BigInteger p;
    private BigInteger q;
    private BigInteger n;

    public Key(BigInteger p, BigInteger q, BigInteger n){
        this.p = p;
        this.q = q;
        this.n = n;
    }

    public void setP(BigInteger p) {
        this.p = p;
    }

    public void setQ(BigInteger q) {
        this.q = q;
    }

    public void setN(BigInteger n) {
        this.n = n;
    }

    public BigInteger getP() {
        return p;
    }

    public BigInteger getQ() {
        return q;
    }

    public BigInteger getN() {
        return n;
    }
}
