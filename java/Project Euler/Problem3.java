// Problem3.java
// The prime factors of 13195 are 5, 7, 13 and 29.
//
// What is the largest prime factor of the number 600851475143 ?

// In number theory, the fundamental theorem of arithmetic, also called the unique
// factorization theorem or the unique-prime-factorization theorem, states that
// every integer greater than 1 either is prime itself or is the product of prime
// numbers, and that this product is unique, up to the order of the factors.

// So if a number is not a prime, then it can be represented as a product of prime numbers.
// The idea is to find the first prime number that is a factor of the given number. Then we
// divide our number with that prime number and get a smaller number. This new smaller number
// we then keep trying to divide to recieve a 0 remainder.

class Problem3{
  public static void main(String[] args) {
    long number = 600851475143L;
    long newnumber = number;
    long largestPrime = 0;

    int counter = 2;
    while (counter * counter <= newnumber) {
      if (newnumber % counter == 0) {
        newnumber = newnumber / counter;
        largestPrime = counter;
        System.out.println(largestPrime);
      } else {
        counter++;
      }
    }

    if (newnumber > largestPrime) { // the remainder is a prime number
    largestPrime = newnumber;
    }

    System.out.println(largestPrime);

  }
}
