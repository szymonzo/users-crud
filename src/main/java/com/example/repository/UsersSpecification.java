package com.example.repository;

import com.example.entity.Users;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;


public class UsersSpecification implements Specification<Users> {

    private final Users criteria;

    public UsersSpecification(Users criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        final List<Predicate> predicates = new ArrayList<>();
        Path<Object> name = root.get("name");
        Path<Object> email = root.get("email");
        Path<Object> lastName = root.get("lastName");
        Path<Object> pesel = root.get("pesel");

        if (validPredicate(criteria.getName())) {
            predicates.add(criteriaBuilder.equal(name, criteria.getName()));
        }
        if (validPredicate(criteria.getEmail())) {
            predicates.add(criteriaBuilder.equal(email, criteria.getEmail()));
        }
        if (validPredicate(criteria.getLastName())) {
            predicates.add(criteriaBuilder.equal(lastName, criteria.getLastName()));
        }
        if (validPredicate(criteria.getPesel())) {
            predicates.add(criteriaBuilder.equal(pesel, criteria.getPesel()));
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    }

    private boolean validPredicate(String field) {
        return StringUtils.hasText(field);
    }
}
