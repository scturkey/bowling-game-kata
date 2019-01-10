package org.scturkey.kata

import spock.lang.Specification

class Kata1 extends Specification {

    def "should not find any transaction when no transaction passed"() {
        given:
        def transactions = []

        when:
        def rejected = findRejectedTransactions(transactions, 0)


        then:
        rejected.size() == 0
    }


}
