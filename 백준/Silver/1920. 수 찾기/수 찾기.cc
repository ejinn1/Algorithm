#include <stdio.h>
#include <stdlib.h>

int compare(const void *a,const void *b){
   int num1 = *(int *)a;
   int num2 = *(int *)b;

   if(num1 < num2)
      return -1;
   if(num1 > num2)
      return 1;
   
   return 0;
}
int binarySearch(int left, int right, int key, int *arr){
   int middle;

   while(left<=right){
      middle = (left+right)/2;
      if(key < arr[middle]){
         right = middle-1;
      }
      else if(key > arr[middle]){
         left = middle+1;
      }
      else{
         return 1;
      }
   }

   return 0;

}

int main(){

   int n,m,i,r=0;
   int A[100001], B[100001];

   scanf("%d",&n);
   for(i=0;i<n;i++){
      scanf("%d",&A[i]);
   }

   scanf("%d",&m);
   for(i=0;i<m;i++){
      scanf("%d",&B[i]);
   }

   qsort(A, n, sizeof(int), compare);
   for(i=0;i<m;i++){
      r = binarySearch(0,n-1,B[i],A);
      printf("%d\n",r);
   }



   return 0;
}