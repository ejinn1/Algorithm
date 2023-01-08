#include<stdio.h>
#pragma warning(disable:4996)

int main() {

    int a, b;
    int b1,b2,b3;
    int n1, n2, n3;
    char t;

    scanf("%d%c", &a, &t);
    scanf("%d", &b);
    b1 = b % 10;
    n1 = a * b1;
    printf("%d\n", n1);
    b /= 10;
    b2 = b % 10;
    n2 = a * b2;
    printf("%d\n", n2);
    n2 *= 10;
    b /= 10;
    b3 = b % 10;
    n3 = a * b3;
    printf("%d\n", n3);
    n3 *= 100;
    printf("%d\n", n1 + n2 + n3);


    return 0;
}