package week2;

public class subsetfinder {


        int realArrayLength;
        int[] a;
    
        subsetfinder(int realArrayLength, int[] a) {
    
            this.realArrayLength = realArrayLength;
            // this.a = a;
            int len = 0;
            int[] passer = new int[a.length];
    
            for (int i = 0; i < a.length; i++) {
                boolean push = false;
                for (int j = 0; j < a.length; j++) {
                    if (i >= j) {
                        if (i == a.length - 1) {
                            push = true;
                            break;
                        }
                        continue;
                    }
    
                    if (a[i] == a[j]) {
                        push = false;
                        break;
                    } else if (a[i] != a[j]) {
                        push = true;
                    }
                }
                if (push) {
                    passer[len] = a[i];
                    push = false;
                    len++;
                }
            }
    
            int[] originalPasser = new int[len];
    
            for (int i = 0; i < len; i++) {
                originalPasser[i] = passer[i];

            }
    
            this.a = originalPasser;
    
        }
    
        void resultFinder() {
    
            // gathering all necessary processes or actions in one place
    
            int[][] outputValues = findPrime(a);
            int[] primeValues = outputValues[0];
            int primeItterator = outputValues[1][0];
            if (primeItterator == realArrayLength) {
    
                for (int i = 0; i < primeItterator; i++) {
                    System.out.println(primeValues[i]);
                }
            } else {
    
                int[] extra = extrasSearch(primeValues, primeItterator);
                for (int i = 0; i < realArrayLength; i++) {
                    if (i >= primeItterator) {
                        int num = i - primeItterator;
                        System.out.println(extra[num]);
                    } else {
                        System.out.println(primeValues[i]);
                    }
    
                }
            }
    
        }
    
        int[] extrasSearch(int[] primes, int primeItterator) {
    
            int[] extras = new int[realArrayLength];
            int extrasin = 0;
            boolean skip = false;
            for (int i = 0; i < a.length; i++) {
                for (int ext = 0; ext < primes.length; ext++) {
                    if (a[i] == primes[ext]) {
                        skip = true;
                        break;
                    }
                }
                if (skip) {
                    skip = false;
                    continue;
                }
    
                boolean push = true;
    
                for (int j = 0; j < primeItterator; j++) {
    
                    if (primes[j] == 1) {
                        continue;
                    } else {
                        float checkval = (float) a[i] / (float) primes[j];
                        if (checkval == Math.floorDiv(a[i], primes[j])) {
                            push = false;
                        }
                    }
                }
    
                if (push) {
                    extras[extrasin] = a[i];
                    extrasin++;
                }
    
            }
    
            return extras;
    
        }
    
        int[][] findPrime(int[] arr) {
            // Find the prime numbers in the provided array's elements using arr.
    
            int[] ourPrimeElements = new int[realArrayLength];
            int primeItterator = 0;
    
            for (int i = 0; i < arr.length; i++) {
    
                if (arr[i] == 0) {
                    continue;
                } else if (arr[i] == 1) {
                    ourPrimeElements[primeItterator] = 1;
                    primeItterator++;
    
                } else if (arr[i] == 2) {
                    ourPrimeElements[primeItterator] = 2;
                    primeItterator++;
                } else if (arr[i] == 3) {
                    ourPrimeElements[primeItterator] = 3;
                    primeItterator++;
                }
    
                else {
    
                    boolean prime = true;
                    // int element = Math.floorDiv(arr[i], 2);
                    int divideLimit = Math.floorDiv(arr[i], 2);
                    for (int j = 2; j <= divideLimit; j++) {
    
                        float check = (float) a[i] / j;
                        // System.out.println(a[i]);
                        // System.out.println(j);
                        // System.out.println(check);
    
                        if (check == Math.floorDiv(a[i], j)) {
    
                            prime = false;
    
                        }
                    }
    
                    if (prime == true) {
    
                        ourPrimeElements[primeItterator] = a[i];
                        primeItterator++;
                    }
    
                }
    
            }
    
            int[][] returner = { ourPrimeElements, { primeItterator } };
    
            return returner;
    
        }
    
        // int[] filter(int[] primes) {
        // // Filter the elements in arr and look for certain elements.
        // // Using whole-number division from several numbers
    
        // int wholeNumSuccess = 0;
    
        // for(int i=0; i<a.length;i++){
        // for(int j=0; )
        // }
    
        // }
    
        public static void main(String[] args) {
    
            int[] input = { 10, 10, 5, 0, 2, 1, 2, 5 };
    
            subsetfinder sub = new subsetfinder(3, input);
            sub.resultFinder();
        }
    
    }

