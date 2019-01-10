package org.scturkey.kata

import spock.lang.Specification

import static java.lang.Integer.valueOf

class Kata1 extends Specification {

    def "should not find any transaction when no transaction passed"() {
        given:
        def transactions = []

        when:
        def rejected = findRejectedTransactions(transactions, 0)


        then:
        rejected.size() == 0
    }


    def "should not find ayn rejected transaction when transaction below limit"() {
        expect:
        size == findRejectedTransactions(transactionList, creditLimit).size()

        where:
        transactionList                                                        | creditLimit | size
        []                                                                     | 100         | 0
        ["John,Doe,john@doe.com,100,TR0001"]                                   | 100         | 0
        ["John,Doe,john@doe.com,101,TR0001"]                                   | 100         | 1
        ["John,Doe,john@doe.com,100,TR0001", "John,Doe,john@doe.com,1,TR0001"] | 100         | 1

    }

    List findRejectedTransactions(List<String> transactionList, int creditLimit) {
        def sum = 0
        return transactionList.findAll { it ->
            def transactionAmount = valueOf(it.split(",")[3])
            sum += transactionAmount
            creditLimit < sum
        }
    }
}