package bangunDatar;

public class Persegi extends bangunDatar {
    int sisi;

    public Persegi(int sisi) {
        this.sisi = sisi;
    }

    @Override
    public float luas() {
        return this.sisi * this.sisi;
    }

    @Override
    public float keliling() {
        return 4 * this.sisi;
    }
}
