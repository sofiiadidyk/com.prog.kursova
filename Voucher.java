package com.lab;

import touristvoucher.*;
import java.util.ArrayList;
import java.util.Comparator;

public class Voucher {
    public ArrayList<TouristVoucher> vouchers;

    public Voucher() {
        vouchers = new ArrayList<>();
    }

    public void createVoucher() {
        vouchers.add(new Rest());
        vouchers.add(new Excursion());
        vouchers.add(new Treatment());
        vouchers.add(new Shopping());
        vouchers.add(new Cruise());
    }

    public void makeVoucher(int n, String name, String transport, String residence, String food, int days, int people, double coefficient ) {
        vouchers.get(n).setName(name);
        vouchers.get(n).setType_of_transport(transport);
        vouchers.get(n).setType_of_residence(residence);
        vouchers.get(n).setType_of_food(food);
        vouchers.get(n).setNumber_of_days(days);
        vouchers.get(n).setNumber_of_people(people);
        vouchers.get(n).setCoefficient(coefficient);
        vouchers.get(n).setPrice(vouchers.get(n).Price());
    }

    public String showTouristVoucher() {
        String text="Типи путівок:\n";
        for (TouristVoucher voucher : vouchers) {
            text += voucher.getName()+"\n";
        }
        text +="\n";
        return text;
    }

    public String choiceTouristVoucher(int n, String transport, String residence, String food, int days, int people ) {
        String text="Туристична путівка:\n";

        vouchers.get(n).setType_of_transport(transport);
        vouchers.get(n).setType_of_residence(residence);
        vouchers.get(n).setType_of_food(food);
        vouchers.get(n).setNumber_of_days(days);
        vouchers.get(n).setNumber_of_people(people);

        vouchers.get(n).setPrice(vouchers.get(n).Price());

        text += vouchers.get(n).toString();
        //text += "\n";
        return text;
    }

    public String sortByPrice() {
        String text="Посортовані типи путівок за ціною:\n";
        vouchers.sort(Comparator.comparing(TouristVoucher::getPrice));
        for (TouristVoucher voucher : vouchers) {
            text += voucher.toString();
        }
        text += "\n";
        return text;
    }

    public String sortByName() {
        String text="Посортовані типи путівок за типом:\n";
        vouchers.sort(Comparator.comparing(TouristVoucher::getName));
        for (TouristVoucher voucher : vouchers) {
            text += voucher.toString();
        }
        text += "\n";
        return text;
    }

    public String printByPrice(int from, int to) {
        String text;
        if((from<0)||(to<from)) {
            text="Некоректно введено діапазон ціни.\n\n";
            return text;
        }
        vouchers.sort(Comparator.comparing(TouristVoucher::getPrice));
        text="Типи путівок, ціна яких від "+from+" до "+to+":\n";
        for (TouristVoucher voucher : vouchers) {
            if (voucher.getPrice() >= from && voucher.getPrice() <= to) {
                text += voucher.toString();
            }
        }
        text += "\n";
        return text;
    }

}
