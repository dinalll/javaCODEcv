package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    Student s=new Student ("Studo","Studić");
    Student s1= new Student ("Pado","Padić");
    Student s2= new Student ("Pado","Padić");
    @org.junit.jupiter.api.Test
    void getBrIndeksa() {
        assertEquals(s.getBrIndeksa(),s.getBrIndeksa());
        assertEquals(s1.getBrIndeksa(),s1.getBrIndeksa());
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        assertEquals("Pado Padić "+s1.getBrIndeksa(),s1.toString());
    }

    @org.junit.jupiter.api.Test
    void testEquals() {
        assertEquals(true,s1.equals(s1));
        assertEquals(false,s1.equals(s2));
    }

    @Test
    void testHashCode() {
        assertEquals(s.hashCode(),s.hashCode());
        assertNotEquals(s.hashCode(),s1.hashCode());
    }
}