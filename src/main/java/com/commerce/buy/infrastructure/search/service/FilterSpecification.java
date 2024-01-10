package com.commerce.buy.infrastructure.search.service;

import com.commerce.buy.infrastructure.search.dto.SearchRequestDto;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilterSpecification<T> {

    public enum TYPE {
        OR,
        AND
    }

    /**
     * Filtre par nom chaque entite
     * @param searchRequestDto SearchRequestDto
     * @param type TYPE
     * @return Specification<T>
     */
    public Specification<T> getSearchSpecification(SearchRequestDto searchRequestDto,TYPE type)
    {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(searchRequestDto.getName()),"%"+ searchRequestDto.getValue()+"%");
    }

    /**
     * Filtre par cle d'entite chaque entite en parametre un tableau de parametre
     */
    public Specification<T> getSearchSpecification(List<SearchRequestDto> searchRequestDto,TYPE type)
    {
        return ((root, query, criteriaBuilder) -> {
           List<Predicate> predicates = new ArrayList<>();

           for(SearchRequestDto searchDto: searchRequestDto)
           {
               Predicate equal =  criteriaBuilder.equal(root.get(searchDto.getName()),searchDto.getValue());
               predicates.add(equal);
           }
           if(type == TYPE.OR)
           {
                return criteriaBuilder.or(predicates.toArray(new Predicate[0]));
           }

           return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }
}
