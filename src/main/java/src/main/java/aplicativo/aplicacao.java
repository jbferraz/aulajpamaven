/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.main.java.aplicativo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import src.main.java.dominio.Pessoa;

/**
 *
 * @author jairb
 */
public class aplicacao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
//        Pessoa p2 = new Pessoa(null, "Joaquim Torres", "joaquim@gmail.com");
//        Pessoa p3 = new Pessoa(null, "Ana Maria", "ana@gmail.com");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();
//        Primeiro Inseri
//        em.getTransaction().begin();
//        em.persist(p1);
//        em.persist(p2);
//        em.persist(p3);
//        em.getTransaction().commit();

//        Recupera
        Pessoa p = em.find(Pessoa.class, 5);
        p.setEmail("joca@gmail.com");
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
//        Deletar
//        Pessoa p = em.find(Pessoa.class, 5);
//        em.getTransaction().begin();
//        em.remove(p);
//        em.getTransaction().commit();
        System.out.println(p);
        System.out.println("Pronto!");
        em.close();
        emf.close();
    }

}
