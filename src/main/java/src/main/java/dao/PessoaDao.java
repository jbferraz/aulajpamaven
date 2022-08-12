/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.main.java.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import src.main.java.dominio.Pessoa;

/**
 *
 * @author jbferraz
 */
public class PessoaDao {

    private static PessoaDao instance;
    protected EntityManager entityManager;

    public static PessoaDao getInstance() {
        if (instance == null) {
            instance = new PessoaDao();
        }
        return instance;
    }

    private PessoaDao() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory
                = Persistence.createEntityManagerFactory("exemplo-jpa");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }

    public Pessoa getById(final int id) {
        return entityManager.find(Pessoa.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Pessoa> findAll() {
        return entityManager.createQuery("FROM "
                + Pessoa.class.getName()).getResultList();
    }

    public void salvar(Pessoa pessoa) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(pessoa);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remover(Pessoa pessoa) {
        try {
            entityManager.getTransaction().begin();
            pessoa = entityManager.find(Pessoa.class, pessoa.getId());
            entityManager.remove(pessoa);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void removeById(final int id) {
        try {
            Pessoa pessoa = getById(id);
            remover(pessoa);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
