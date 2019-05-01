@AnyMetaDefs(
        @AnyMetaDef(
                name = "VehicleMetaDef", idType = "long", metaType = "string",
                metaValues = {
                        @MetaValue(targetEntity = Person.class, value = "P"),
                        @MetaValue(targetEntity = Company.class, value = "C")
                }
        )
)
package com.javastudio.tutorial.model;

import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.AnyMetaDefs;
import org.hibernate.annotations.MetaValue;