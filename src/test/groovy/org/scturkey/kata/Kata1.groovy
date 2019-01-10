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
        rejectedTransactions == findRejectedTransactions(transactionList, creditLimit)

        where:
        transactionList                                                                                           | creditLimit | rejectedTransactions
        []                                                                                                        | 100         | []
        ["John,Doe,john@doe.com,100,TR0001"]                                                                      | 100         | []
        ["John,Doe,john@doe.com,101,TR0001"]                                                                      | 100         | ["John,Doe,john@doe.com,101,TR0001"]
        ["John,Doe,john@doe.com,100,TR0001", "John,Doe,john@doe.com,1,TR0001"]                                    | 100         | ["John,Doe,john@doe.com,1,TR0001"]
        ["John,Doe,john@doe.com,50,TR0001", "John,Doe,john@doe.com,1,TR0001"]                                     | 100         | []
        ["John,Doe,john@doe.com,50,TR0001", "John,Doe,john@doe.com,1,TR0001", "John,Doe,john2@doe.com,51,TR0001"] | 100         | []

    }

    List findRejectedTransactions(List<String> transactionList, int creditLimit) {
        def sumOfTransactionAmountByUser = [:]

        return transactionList.findAll { it ->
            def splittedTransaction = it.split(",")
            def identifier = splittedTransaction[0] + splittedTransaction[1] + splittedTransaction[2]
            def transactionAmount = valueOf(splittedTransaction[3])
            
            sumOfTransactionAmountByUser."$identifier" = (sumOfTransactionAmountByUser."$identifier" ?: 0) + transactionAmount
            creditLimit < sumOfTransactionAmountByUser[identifier]
        }
    }
}