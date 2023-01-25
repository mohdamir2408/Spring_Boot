package com.crud.EmployeeMgtBackend.criteriaQuery;

import com.crud.EmployeeMgtBackend.entities.Employee;
import com.crud.EmployeeMgtBackend.entities.Pagination;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.*;
import javax.transaction.*;
import java.util.List;

@Repository
@Transactional
public class EmployeeRepoImpl implements EmployeeRepo {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Employee> findByFirstName(String firstName) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);

        Root<Employee> employee = cq.from(Employee.class);
        Predicate firstNamePredicate = cb.equal(employee.get("firstName"), firstName);

        cq.where(firstNamePredicate);

        TypedQuery query = em.createQuery(cq);

        return query.getResultList();
    }

    @Override
    public List<Employee> findAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> employee = cq.from(Employee.class);
        cq.select(employee);

        TypedQuery query = em.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);

        Root<Employee> employee = cq.from(Employee.class);
        Predicate idPredicate = cb.equal(employee.get("id"), id);

        cq.where(idPredicate);

        TypedQuery query = em.createQuery(cq);

        return (Employee) query.getSingleResult();
    }

    @Override
    public Employee save(Employee employee) {
        em.persist(employee);
        return employee;
    }

    @Override
    public void delete(Employee employee) {
        em.remove(employee);
    }

    @Override
    public Employee update(Employee employeeDetails) {
        return em.merge(employeeDetails);

    }

    @Override
    public List<Employee> findAll(int offset, int limit) {
        return null;
    }

    // Pagination Method

    @Override
    public List<Employee> findAll(Pagination pagination) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> root = cq.from(Employee.class);

        //Condition For Searching

        if (pagination.getSearchItem() != null && !pagination.getSearchItem().isEmpty()){
            cq.where(cb.like(cb.upper(root.get("firstName")), pagination.getSearchItem()));
        }


            // Condition for sorting.
        Order order;
        if (pagination.getShortField() != null && !pagination.getShortField().isEmpty()) {
            if (pagination.getShortType().equals("desc")) {
                order = cb.desc(root.get(pagination.getShortField()));
            } else {
                order = cb.asc(root.get(pagination.getShortField()));
            }
        } else {
            order = cb.desc(root.get("id"));
        }
        cq.orderBy(order);
        List<Employee> result = em
                .createQuery(cq)
                .setFirstResult((pagination.getPageNo()-1)* pagination.getLimit())
                .setMaxResults(pagination.getLimit())
                .getResultList();

        return result;
    }
}