package org.libinjection

import spock.lang.Specification

/**
 * Created by manuel on 22/02/17.
 */
class LibInjectionSpec extends Specification {

    def TestText(){

        when:
        Libinjection a = new Libinjection();
        then:
        a.libinjection_sqli("admin' OR 1=1--");

    }

    /* test a file and output its results, with options to urldecode and time */
    def testFile(){

        when:
        Test t = new Test();
        t.testfile("data/sqli.txt", "data/sqli.txt.output", true, false);
        then:
        noExceptionThrown()
    }
}
