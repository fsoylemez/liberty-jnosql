package com.fms.jnosql;

import jakarta.nosql.document.DocumentQuery;
import jakarta.nosql.mapping.document.DocumentTemplate;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static jakarta.nosql.document.DocumentQuery.select;

@ApplicationScoped
public class HeroService {

    @Inject
    DocumentTemplate template;

    public void create() {
        Hero ironMan = Hero.builder().withRealName("Tony Stark")
                .withName("iron_man")
                .withAge(34)
                .withPowers(Collections.singleton("rich"))
                .build();

        template.insert(ironMan);

        DocumentQuery query = select().from("Hero").where("name").eq("iron_man").build();
        List<Hero> heroes = template.<Hero>select(query).collect(Collectors.toList());
    }
}
