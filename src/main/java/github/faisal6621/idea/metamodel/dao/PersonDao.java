package github.faisal6621.idea.metamodel.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.Root;

import github.faisal6621.idea.metamodel.Person;
import github.faisal6621.idea.metamodel.Person_;

public class PersonDao
{
    @PersistenceContext
    EntityManager entityManager;

    public Person getPersonById(Long id)
    {
        var criteriaBuilder = entityManager.getCriteriaBuilder();
        var query = criteriaBuilder.createQuery(Person.class);
        Root<Person> root = query.from(Person.class);
        query.where(criteriaBuilder.equal(root.get(Person_.ID), id));
        return entityManager.createQuery(query)
            .getSingleResult();
    }
}
