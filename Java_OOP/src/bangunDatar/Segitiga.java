package bangunDatar;

public class Segitiga extends bangunDatar{
    int alas;
    int tinggi;

    public Segitiga(int alas, int tinggi) {
        this.alas = alas;
        this.tinggi = tinggi;
    }

    @Override
    public float luas() {
        return this.alas * this.tinggi / 2;
    }

    @Override
    public float keliling(){
        return (float) (Math.sqrt(Math.pow(this.alas, 2) + Math.pow(this.tinggi, 2)) + this.alas + this.tinggi);
    }
}