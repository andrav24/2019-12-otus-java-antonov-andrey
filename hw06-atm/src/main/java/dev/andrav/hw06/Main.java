package dev.andrav.hw06;

import dev.andrav.hw06.atm.ATM;
import dev.andrav.hw06.atm.ATMImpl;
import dev.andrav.hw06.currency.Banknote;
import dev.andrav.hw06.currency.MyCurrency;
import dev.andrav.hw06.currency.RUB;
import dev.andrav.hw06.currency.USD;
import dev.andrav.hw06.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /**
         * Инициализация банкомата
         */
        ATM atm = new ATMImpl();
        atm.init();

        /**
         * Формируем пачку банкнот для загрузки в банкомат.
         * В пачке присутсвуют купюры разных валют (RUB, USD).
         * Банкомат принимает только одну валюту, по-умолчанию RUB.
         * Банкноты USD не будут приняты.
         * Банкноты RUB, номиналы которых банкомат не принимает тоже не будут приняты.
         * Принимаются только купюры, номиналы которых установлены в настройке банкомата.
         */
        List<Banknote<?>> listBanknotes = new ArrayList<>();
        int i;
        for (i = 0; i < 10; i++) {
            listBanknotes.add(new Banknote<MyCurrency>(RUB.getInstance(100)));  // 100 RUB
            listBanknotes.add(new Banknote<MyCurrency>(RUB.getInstance(500)));  // 500 RUB
            listBanknotes.add(new Banknote<MyCurrency>(USD.getInstance(50)));   //  50 USD  * не примет, другая валюта
            listBanknotes.add(new Banknote<MyCurrency>(RUB.getInstance(100)));  // 100 RUB
            listBanknotes.add(new Banknote<MyCurrency>(RUB.getInstance(1000))); // 1000 RUB
            listBanknotes.add(new Banknote<MyCurrency>(RUB.getInstance(2000))); // 2000 RUB * не примет, банкомат не принимает
            listBanknotes.add(new Banknote<MyCurrency>(RUB.getInstance(5000))); // 5000 RUB
        }

        System.out.println("DEPOSIT");
        List<Banknote<?>> cash = atm.deposit(listBanknotes);
        Utils.printListOfBanknotesInfo(cash);
        atm.getBalanceATM();

        /**
         * Снятие в банкомате
         */
        System.out.println();
        System.out.println("WITHDRAW");
        List<Banknote<?>> banknotesToHand = (List<Banknote<?>>) atm.withdraw(8000);
        Utils.printListOfBanknotesInfo(banknotesToHand);
        atm.getBalanceATM();

    }
}
