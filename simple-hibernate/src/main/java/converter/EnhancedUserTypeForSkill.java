package converter;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.usertype.EnhancedUserType;
import type.Skill;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EnhancedUserTypeForSkill implements EnhancedUserType {

    //used for XML Marshalling
    @Override
    public String objectToSQLString(Object value) {
        Skill skill = (Skill) value;
        return '\'' + skill.name() + '\'';
    }

    //used for XML Marshalling
    @Override
    public String toXMLString(Object value) {
        Skill skill = (Skill) value;
        return skill.getId();
    }

    //used for XML Marshalling
    @Override
    public Object fromXMLString(String xmlValue) {
        return Skill.valueOf(xmlValue);
    }

    /**
     * This tells Hibernate to represent the column with the data-type specified here
     */
    @Override
    public int[] sqlTypes() {
        return new int[]{Hibernate.STRING.sqlType()};
    }

    /**
     * method tells Hiberante that data recived from sql row should be mapped to Skill enum
     */
    @SuppressWarnings("rawtypes")
    @Override
    public Class returnedClass() {
        return Skill.class;
    }

    @Override
    public boolean equals(Object o1, Object o2) throws HibernateException {
        boolean isEqual = false;
        if (o1 == o2) {
            isEqual = true;
        }
        if (null == o1 || null == o2) {
            isEqual = false;
        } else {
            isEqual = o1.equals(o2);
        }
        return isEqual;
    }

    @Override
    public int hashCode(Object o) throws HibernateException {
        Skill skill = (Skill) o;
        return skill.hashCode();
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, Object owner) throws HibernateException, SQLException {
        Skill skill = null;
        String name = rs.getString(names[0]);
        if (null != name) { // The actual conversion from string to Enum
            skill = Skill.getSkill(name);
        }
        return skill;
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index) throws HibernateException, SQLException {
        if (null == value) {
            st.setNull(index, Hibernate.STRING.sqlType());
        } else { // the conversion from Enum to string
            Skill skill = (Skill) value;
            st.setString(index, skill.getId());
        }
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        return value; // as Enum is immutable its returns the same reference
    }

    @Override
    public boolean isMutable() {
        return false;//As Enum is immutable
    }

    // called when a Skill object is stored in Hibernate second level cache
    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        return (Serializable) value;
    }

    // called when a Skill object is retrieved from Hibernate second level cache
    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return cached; // returning the same object as is simply a reference to an Enum constant
    }

    // used to merge detached objects
    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return original; // if immutable use this
    }
}
