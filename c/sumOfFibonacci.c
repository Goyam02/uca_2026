#include <stdio.h>


// int fibonacci(int n){
//     if(n <= 1){
//         return n;
//     }
//     return fibonacci(n-1) + fibonacci(n-2);
// }


// int evenFibonacciSum(int n){
//     int sum =0;
//     for(int i=0;i<=n;i++){
//         int num = fibonacci(i);
//         if(num % 2 ==0 && num<=n){
//             sum+=num;
//         }
//         if(num > n){
//             break;
//         }
//     }
//     return sum;
// }


// Approach 2 : Time Complexity: O(n) and Space Complexity: O(1)
int evenFibonacciSum(int n){
    int term1 = 0;
    int term2 = 1;
    int nextTerm = term1 + term2;
    int sum =0;
    while(nextTerm<=n){
        if(nextTerm  % 2 ==0){
            sum+=nextTerm;
        }
        term1= term2;
        term2=nextTerm;
        nextTerm = term1 + term2;
    }
    return sum;

}

int main(){
    int n;
    printf("Enter the number of terms: ");
    scanf("%d", &n);
    printf("Sum of even Fibonacci numbers up to %d is %d\n", n, evenFibonacciSum(n));
    return 0;
}

