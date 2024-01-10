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
    public Specification<T> getSearchSpecification(SearchRequestDto searchRequestDto,TYPE type)
    {
        System.out.println("searchRequestDto = " + searchRequestDto.getName());
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(searchRequestDto.getName()),"%"+ searchRequestDto.getValue()+"%");
    }

    public Specification<T> getSearchSpecification(List<SearchRequestDto> searchRequestDto,TYPE type)
    {
        return ((root, query, criteriaBuilder) -> {
           List<Predicate> predicates = new ArrayList<>();

           for(SearchRequestDto searchDto: searchRequestDto)
           {
               Predicate equal =  criteriaBuilder.equal(root.get(searchDto.getName()),searchDto.getValue());
               System.out.println("searchRequestDto = " + searchDto.getValue());

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
