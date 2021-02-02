package data;

import java.math.BigInteger;

public class Messages {


    private BigInteger r1;
    private BigInteger r2;
    private BigInteger r3;
    private BigInteger r4;

    public Messages(BigInteger r1, BigInteger r2, BigInteger r3, BigInteger r4) {
        this.r1 = r1;
        this.r2 = r2;
        this.r3 = r3;
        this.r4 = r4;
    }

    public BigInteger[] messagesList(){
        return new BigInteger[]{ r1,r2,r3,r4};
    }

    public void setR1(BigInteger r1) {
        this.r1 = r1;
    }

    public void setR2(BigInteger r2) {
        this.r2 = r2;
    }

    public void setR3(BigInteger r3) {
        this.r3 = r3;
    }

    public void setR4(BigInteger r4) {
        this.r4 = r4;
    }

    public BigInteger getR1() {
        return r1;
    }

    public BigInteger getR2() {
        return r2;
    }

    public BigInteger getR3() {
        return r3;
    }

    public BigInteger getR4() {
        return r4;
    }
}
