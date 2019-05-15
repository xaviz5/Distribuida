package com.distribuida.servicios;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.distribuida.entity.Persona;
import java.util.List;


public class Crud  implements CrudInterfaz {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("distribuidaUnit");
    EntityManager em = emf.createEntityManager();

    @Override
    public void Ingresar(Persona persona) {
        em.getTransaction().begin();
        System.out.println(persona);
        em.persist(persona);
        em.getTransaction().commit();
        em.clear();
    }
    @Override
    public void Editar(Persona persona){

        em.getTransaction().begin();
        em.merge(persona);
        em.getTransaction().commit();
    }
    @Override
    public void Eliminar (int id){
        Persona persona = em.find(Persona.class,id);
        em.getTransaction().begin();
        em.remove(persona);
        em.getTransaction().commit();
    }
    @Override
    public Persona Buscar (int id){
        return em.find(Persona.class, id);
    }
    @Override
    public List<Persona> Listar (){
        TypedQuery<Persona> query = em.createQuery("SELECT e FROM Persona e", Persona.class);
        List<Persona> personas = query.getResultList();
        return personas;
    }
}
