package org_scala_tools_maven;

import org_scala_tools_maven.VersionNumber;

import junit.framework.TestCase;

public class VersionNumberTest extends TestCase {
    public void testCompare() throws Exception {
        assertEquals(1, new VersionNumber("2.7.1").compareTo(new VersionNumber("1.0")));
        assertEquals(1, new VersionNumber("2.7.1").compareTo(new VersionNumber("1.9")));
        assertEquals(1, new VersionNumber("2.7.1").compareTo(new VersionNumber("2.0")));
        assertEquals(1, new VersionNumber("2.7.1").compareTo(new VersionNumber("2.7")));
        assertEquals(1, new VersionNumber("2.7.1").compareTo(new VersionNumber("2.7-rc")));
        assertEquals(1, new VersionNumber("2.7.1").compareTo(new VersionNumber("2.7.0")));
        assertEquals(0, new VersionNumber("2.7.1").compareTo(new VersionNumber("2.7.1")));
        assertEquals(-1, new VersionNumber("2.7.1").compareTo(new VersionNumber("2.7.2-rc1")));
        assertEquals(-1, new VersionNumber("2.7.1").compareTo(new VersionNumber("2.8")));
        assertEquals(-1, new VersionNumber("2.7.1").compareTo(new VersionNumber("3.0")));
    }
    public void testParse() throws Exception {
    	assertParseVN("2.7.1", 2, 7, 1, null);
    	assertParseVN("2.7", 2, 7, 0, null);
    	assertParseVN("2.7.1.RC", 2, 7, 1, ".RC");
    	assertParseVN("2.7.1.RC", 2, 7, 1, ".RC");
    	assertParseVN("2.7.RC", 2, 7, 0, ".RC");
    	assertParseVN("2.7-RC", 2, 7, 0, "-RC");
    	assertParseVN("2.7.1-SNAPSHOT", 2, 7, 1, "-SNAPSHOT");
    }

    private void assertParseVN(String str, int major, int minor, int bugfix, String modifier ) {
    	VersionNumber v = new VersionNumber(str);
        assertEquals("test major of " + str, major, v.major);
        assertEquals("test minor of " + str, minor, v.minor);
        assertEquals("test bugfix of " + str, bugfix, v.bugfix);
        assertEquals("test modifier of " + str, modifier, v.modifier);
    }
}
