#include<stdio.h>
#pragma warning(disable:4996)

int main() {

	int n,k;
	int i = 0;

	scanf("%d", &n);
	k = n;
	
	while (1) {

		if (k < 10) {
			k * 10;
		}
		
		k = (k % 10) * 10 + (k / 10 + k % 10) % 10;
		i++;

		if (k == n) {
			break;
		}
	}
	printf("%d", i);
	

	return 0;
}