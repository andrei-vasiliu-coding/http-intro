package org.northcoders.fakerapi;

import org.northcoders.fakerapi.common.Locale;
import org.northcoders.fakerapi.dao.FakeBooksDAO;

public class Main {
    public static void main(String[] args) {

//        System.out.println(FakeBooksDAO.getAllBooks());

        FakeBooksDAO fakeBooksDAO = new FakeBooksDAO();

        System.out.println(fakeBooksDAO.getAllBooks());

        System.out.println(fakeBooksDAO.getAllBooks(3));

        System.out.println(fakeBooksDAO.getAllBooks(Locale.it_IT));
    }
}
