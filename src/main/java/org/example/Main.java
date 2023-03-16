package org.example;
import org.example.container.ComponentController;
//import org.example.db.CardDB;
//import org.example.db.ProfileDB;
//import org.example.db.TerminalDB;
import org.example.db.TransactionDB;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    public static void main(String[] args) {
//        ProfileDB.createProfileTable();
//        TerminalDB.createTerminalTable();
//        CardDB.createCardTable();

        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory factory = meta.getSessionFactoryBuilder().build();

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        transaction.commit();
        TransactionDB.createTransactionTable();
        ComponentController.menuController.mainMenu();
        System.out.println("Life is beautiful!");
    }
}