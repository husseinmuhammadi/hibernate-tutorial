@AnyMetaDefs(
        @AnyMetaDef(
                name = "EntityMetaDef", idType = "long", metaType = "string",
                metaValues = {
                        @MetaValue(targetEntity = Person.class, value = "P"),
                        @MetaValue(targetEntity = Company.class, value = "C"),
                        @MetaValue(targetEntity = Issue.class, value = "I"),
                        @MetaValue(targetEntity = Task.class, value = "T"),
                }
        )
)
package com.javastudio.tutorial.model;

import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.AnyMetaDefs;
import org.hibernate.annotations.MetaValue;