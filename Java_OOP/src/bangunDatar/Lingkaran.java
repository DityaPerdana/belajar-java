package bangunDatar;

public class Lingkaran extends bangunDatar {
    int r;
    
    public Lingkaran(int r) {
        this.r = r;
    }

    public float luas() {
        return (float) (Math.PI * this.r * this.r);
    }

    public float keliling() {
        return (float) (2 * Math.PI * this.r);
    }
}