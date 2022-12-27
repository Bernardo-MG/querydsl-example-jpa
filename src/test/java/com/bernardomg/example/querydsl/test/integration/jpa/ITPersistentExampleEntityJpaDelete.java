/**
 * The MIT License (MIT)
 * <p>
 * Copyright (c) 2021 the original author or authors.
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.bernardomg.example.querydsl.test.integration.jpa;

import java.util.Collection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import com.bernardomg.example.querydsl.jpa.model.ExampleEntity;
import com.bernardomg.example.querydsl.jpa.model.QPersistentExampleEntity;
import com.bernardomg.example.querydsl.test.config.annotation.IntegrationTest;
import com.querydsl.jpa.JPQLQueryFactory;

@IntegrationTest
@DisplayName("JPA delete queries")
public class ITPersistentExampleEntityJpaDelete {

    @Autowired
    private JPQLQueryFactory queryFactory;

    /**
     * Default constructor.
     */
    public ITPersistentExampleEntityJpaDelete() {
        super();
    }

    @Test
    @DisplayName("Returns entities with an empty sample")
    @Sql("/sql/test_entity_single.sql")
    public final void testQuery_NoSample() {
        final QPersistentExampleEntity            sample;
        final Collection<? extends ExampleEntity> entities;

        sample = QPersistentExampleEntity.persistentExampleEntity;

        queryFactory.delete(sample)
            .execute();

        entities = queryFactory.selectFrom(sample)
            .fetch();

        Assertions.assertEquals(0, entities.size());
    }

}
