package FromJsonToMysql.Processor;

import FromJsonToMysql.Entity.Prodotto;
import org.springframework.batch.item.ItemProcessor;

public class ProductItemProcessor implements ItemProcessor<Prodotto, Prodotto> {
    @Override
    public Prodotto process(Prodotto item) throws Exception {
        final int id = item.getId();
        final String name = item.getName();
        final double prezzo = item.getPrezzo();


        // Calcolo sconto del 10% IN QUESTO CASO
        double prezzo_scontato = CalcoloSconto(prezzo,0.10);
        final Prodotto newProduct = new Prodotto(id,name,prezzo,prezzo_scontato);
//        System.out.println(newProduct);
        return newProduct;
    }


    /*
     * METODO PER IL CALCOLO DELLO SCONTO
     */
    public double CalcoloSconto(double prezzo, double percentualeDiSconto){
        return prezzo-(prezzo*percentualeDiSconto);
    }
}
