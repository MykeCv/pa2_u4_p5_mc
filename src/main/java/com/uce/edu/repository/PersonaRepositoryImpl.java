package com.uce.edu.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.uce.edu.repository.modelo.Persona;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class PersonaRepositoryImpl implements IPersonaRepository {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Persona persona) {
		this.entityManager.persist(persona);
	}

	@Override
	public Persona seleccionarPorCedula(String cedula) {
		TypedQuery<Persona> query = this.entityManager.createQuery("select p from Persona p where p.cedula = :cedula",
				Persona.class);
		query.setParameter("cedula", cedula);
		return query.getSingleResult();
	}

	@Override
	public void actualizar(Persona persona) {
		this.entityManager.merge(persona);
	}

	@Override
	public void eliminar(String cedula) {
		this.entityManager.remove(this.seleccionarPorCedula(cedula));
	}

	@Override
	public List<Persona> selecTodo() {
		TypedQuery<Persona> query = this.entityManager.createQuery("select p from Persona p", Persona.class);
		return query.getResultList();
	}

	@Override
	public Persona select(Integer id) {
		return this.entityManager.find(Persona.class, id);
	}

}
