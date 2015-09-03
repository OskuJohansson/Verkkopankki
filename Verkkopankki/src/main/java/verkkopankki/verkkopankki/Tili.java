
package verkkopankki.verkkopankki;


public class Tili {
    
   private final int tilinro; 
   private int saldo;
   
   public Tili(int tilinro) {
       saldo = 0;
       this.tilinro = tilinro;
   }
   
   public void lisaaRahaa(int summa) {
      this.saldo += summa; 
   }
   
   public void vahennaRahaa(int summa) {
       this.saldo -= summa;
   }
   
   public int getSaldo() {
       return this.saldo;
   }
}
