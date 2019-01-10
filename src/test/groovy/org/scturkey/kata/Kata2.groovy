package org.scturkey.kata

import spock.lang.Specification

class Kata2 extends Specification {

    def "checks if file can be added to disk block"() {
        expect:
        result == isWritable(blockSize, fileSize, occupiedSectors)

        where:
        blockSize | fileSize | occupiedSectors | result
        1         | 1        | []              | false
        1         | 1        | [1]             | false
        4         | 2        | [1, 4]          | true
        4         | 2        | [1, 3]          | false
        10        | 2        | [1, 3, 6]       | true
        10        | 2        | [1, 3, 5, 8]    | true
        10        | 4        | [1, 3, 8]       | true
        10        | 2        | [1, 3, 5]       | true
        10        | 5        | [1, 3, 5]       | true
        10        | 6        | [1, 3, 5]       | false
    }

    boolean isWritable(int blockSize, int fileSize, List<Integer> occupiedSectors) {
        for (int i = 0; i < occupiedSectors.size() - 1; i++) {
            if (occupiedSectors[i + 1] - occupiedSectors[i] > fileSize) {
                return true
            }
            if (blockSize - occupiedSectors.last() >= fileSize) return true
        }
        return false
    }
}
