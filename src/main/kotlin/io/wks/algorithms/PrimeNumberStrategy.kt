package io.wks.algorithms

import kotlin.math.sqrt

interface PrimeNumberStrategy {
    fun isPrime(n: Int): Boolean
}

/**
 * Check if a number N is prime by dividing it by all number from 2 to N-1.
 * If the nuber is exactly divisible by any number from 2 to N-1, it is not priem
 */
class BruteForcePrimeNumberStrategy : PrimeNumberStrategy {
    override fun isPrime(n: Int): Boolean {
        for (i in 2 until n) {
            if (n % i == 0) {
                return false
            }
        }
        return true
    }
}

/**
 * When determining if a number n is prime, we are essentially checking if it has any factors other than 1 and itself.
 *
 * If n has a factor f, then it can be expressed as n = f * d,
 * where d is another factor of n.
 *
 * If both f and d are greater than the square root of n,
 * then their product (f * d) will be greater than n,
 * which contradicts the assumption that n = f * d.
 *
 * Therefore, if there are no factors less than or equal to the square root of n,
 * there will also be no factors greater than the square root of n.
 *
 * This property allows us to optimize the prime number checking algorithm.
 */
class SquareRootPrimeNumberStrategy : PrimeNumberStrategy {
    override fun isPrime(n: Int): Boolean {
        for (i in 2..sqrt(n.toDouble()).toInt()) {
            if (n % i == 0) {
                return false
            }
        }
        return true
    }
}