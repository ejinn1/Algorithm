#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int compare(const void* a, const void* b) {
	const char* n1 = (const char*)a;
	const char* n2 = (const char*)b;
	if (*n1 > *n2) {
		return -1;
	}
	else if (*n1 == *n2) {
		return 0;
	}
	else {
		return 1;
	}
}

int main(){

   int N,i,n,sum=0,len;
   char arr[100001]={0};

   scanf("%s",arr);
   len = strlen(arr);
   for(i=0;i<len;i++){
      sum+=(arr[i]-'0');
   }
   // printf("%s",arr);
   // printf("\n");
   // for(i=0;i<cnt;i++){
   //    printf("%d",arr[i]);
   // }
   // printf("\n");

   if(sum%3 != 0 || sum == 0){
      printf("-1\n");
   }
   else if(strchr(arr,'0') == NULL){
      printf("-1\n");
   }
   else{
      qsort(arr, len, sizeof(char), compare);
      for(i=0;i<len;i++){
         printf("%c",arr[i]);
      }
      printf("\n");
   }


   return 0;
}