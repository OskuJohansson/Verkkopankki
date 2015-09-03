
package verkkopankki.logiikka;


public class Tili {
    
   private final String tilinro;
   private final String salasana;
   private int saldo;
   
   public Tili(String tilinro, String sana) {
       saldo = 0;
       salasana = sana;
       this.tilinro = tilinro;
   }
   
   public void muutaSaldoa(int summa) {
      this.saldo += summa; 
   }

    public String getTilinro() {
        return tilinro;
    }
   
  
   
   public int getSaldo() {
       return this.saldo;
   }
}
