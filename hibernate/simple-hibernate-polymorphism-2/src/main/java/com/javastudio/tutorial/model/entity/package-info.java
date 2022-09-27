@AnyMetaDefs(
        @AnyMetaDef(name = "ContactMetaDef", metaType = "string", idType = "long",
                metaValues = {
                        @MetaValue(value = "A", targetEntity = Address.class),
                        @MetaValue(value = "T", targetEntity = Telephone.class)
                }
        )
)
package com.javastudio.tutorial.model.entity;

import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.AnyMetaDefs;
import org.hibernate.annotations.MetaValue;