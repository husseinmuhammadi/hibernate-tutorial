package com.javastudio.tutorial.converter;

import com.javastudio.tutorial.type.CharacterEncoding;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

public class CharacterEncodingConverterTest {

    Logger logger = LoggerFactory.getLogger(CharacterEncodingConverterTest.class);

    @Test
    public void objectToSQLString() throws Exception {
        CharacterEncodingConverter converter = new CharacterEncodingConverter();
        logger.info(converter.objectToSQLString(CharacterEncoding.LATIN_1_WESTERN_EUROPEAN));
    }

    @Test
    public void toXMLString() throws Exception {
        CharacterEncodingConverter converter = new CharacterEncodingConverter();
        String xmlString = converter.toXMLString(CharacterEncoding.LATIN_2_CENTRAL_EUROPEAN);
        logger.info(xmlString);
        CharacterEncoding characterEncoding = (CharacterEncoding) converter.fromXMLString(xmlString);
        logger.info(characterEncoding.getString());
    }

    @Test
    public void fromXMLString() throws Exception {
        CharacterEncodingConverter converter = new CharacterEncodingConverter();
        String xmlString = converter.toXMLString(CharacterEncoding.LATIN_4_NORTH_EUROPEAN);
        logger.info(xmlString);
        CharacterEncoding characterEncoding = (CharacterEncoding) converter.fromXMLString(xmlString);
        logger.info(characterEncoding.getString());
    }

    @Test
    public void sqlTypes() throws Exception {
    }

    @Test
    public void returnedClass() throws Exception {
    }

    @Test
    public void equals() throws Exception {
    }

    @Test
    public void testHashCode() throws Exception {
    }

    @Test
    public void nullSafeGet() throws Exception {
    }

    @Test
    public void nullSafeSet() throws Exception {
    }

    @Test
    public void deepCopy() throws Exception {
    }

    @Test
    public void isMutable() throws Exception {
    }

    @Test
    public void disassemble() throws Exception {
    }

    @Test
    public void assemble() throws Exception {
    }

    @Test
    public void replace() throws Exception {
    }
}