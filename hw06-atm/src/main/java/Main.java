import dev.andrav.atm.currency.Banknote;
import dev.andrav.atm.currency.RUB;
import dev.andrav.atm.currency.USD;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Banknote<?> rub = new Banknote<>(RUB.getInstance(100));
        Banknote<RUB> rub2 = new Banknote<>(RUB.getInstance(1000));
        Banknote<?> usd = new Banknote<>(USD.getInstance(100));
        System.out.println(rub.getBanknoteCurrencyUnit().getClass());
        rub = usd;
        System.out.println(rub.getBanknoteCurrencyUnit().getClass());

        //System.out.println(rub.compareTo(usd));

    }
}
