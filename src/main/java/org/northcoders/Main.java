package org.northcoders;

import org.northcoders.common.Locale;
import org.northcoders.dao.FakeBooksDAO;

public class Main {
    public static void main(String[] args) {

//        System.out.println(FakeBooksDAO.getAllBooks());

        FakeBooksDAO fakeBooksDAO = new FakeBooksDAO();

        System.out.println(fakeBooksDAO.getAllBooks());

        System.out.println(fakeBooksDAO.getAllBooks(3));

        System.out.println(fakeBooksDAO.getAllBooks(Locale.it_IT));
    }
}
