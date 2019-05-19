package com.javastudio.tutorial.converter;

import com.javastudio.tutorial.type.CharacterEncoding;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.type.StandardBasicTypes;
import org.hibernate.usertype.EnhancedUserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CharacterEncodingConverter implements EnhancedUserType {
    /**
     * This tells Hibernate to represent the column with the data-type specified here
     */
    @Override
    public int[] sqlTypes() {
        return new int[]{StandardBasicTypes.STRING.sqlType()};
    }

    @SuppressWarnings("rawtypes")
    @Override
    /**
     * method tells Hiberante that data received from sql row should be mapped to Skill enum
     */
    public Class returnedClass() {
        return CharacterEncoding.class;
    }

    @Override
    //Used for dirty checking
    public boolean equals(Object o1, Object o2) throws HibernateException {
        if (null == o1 || null == o2) {
            return false;
        }
        return o1.equals(o2);
    }

    @Override
    //Used for dirty checking
    public int hashCode(Object o) throws HibernateException {
        CharacterEncoding characterEncoding = (CharacterEncoding) o;
        return characterEncoding.hashCode();
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        return value; //as Enum is immutable its returns the same reference
    }

    @Override
    public boolean isMutable() {
        return false;//As Enum is immutable
    }

    @Override
    //called when a Skill object is stored in Hibernate second level cache
    public Serializable disassemble(Object value) throws HibernateException {
        return (Serializable) value;
    }

    @Override
    //called when a Skill object is retrieved from Hibernate second level cache
    public Object assemble(Serializable cached, Object owner)
            throws HibernateException {
        return cached; //returning the same object as is simply a reference to an Enum constant
    }

    //used to merge detached objects
    @Override
    public Object replace(Object original, Object target, Object owner)
            throws HibernateException {
        return original; // if immutable use this
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, Object owner)
            throws HibernateException, SQLException {

        String name = rs.getString(names[0]);
        if (name == null)
            return null;

        //The actual conversion from string to Enum
        return CharacterEncoding.getInstance(Integer.valueOf(name));
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index)
            throws HibernateException, SQLException {
        if (null == value) {
            st.setNull(index, StandardBasicTypes.STRING.sqlType());
        } else {//the conversion from Enum to string
            CharacterEncoding characterEncoding = (CharacterEncoding) value;
            st.setString(index, characterEncoding.getString());
        }
    }

    //used for XML Marshalling
    @Override
    public String objectToSQLString(Object value) {
        CharacterEncoding characterEncoding = (CharacterEncoding) value;
        return '\'' + characterEncoding.name() + '\'';
    }

    //used for XML Marshalling
    @Override
    public String toXMLString(Object value) {
        CharacterEncoding characterEncoding = (CharacterEncoding) value;
        return characterEncoding.name();
    }

    //used for XML Marshalling
    @Override
    public Object fromXMLString(String xmlValue) {
        return CharacterEncoding.valueOf(xmlValue);
    }
}
