#include <stdio.h>
#include <stdlib.h>

int compare(const void *a, const void *b){
	if(*(int*)a > *(int*)b)
		return 1;
	else if(*(int*)a < *(int*)b)
		return -1;
	else
		return 0;

}

int main() {

	int n,i,j,sum=0,k;
	int arr[10001]={0,};

	scanf("%d",&n);

	for (i = 0; i < n; i++){
		scanf("%d",&arr[i]);
	}

	qsort(arr, n, sizeof(int), compare);

	for (i = 0; i < n; i++){
		k=0;
		for(j = 0; j <= i; j++){
			k+=arr[j];
		}
		sum+=k;
	}
	
	printf("%d\n",sum);
	

	
	return 0;
}