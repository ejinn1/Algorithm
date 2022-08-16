#include <stdio.h>

int main(){

   int n,i,j,t,c=0;
   int a[51], b[51];

   scanf("%d",&n);

   for(i=0;i<n;i++){
      scanf("%d",&a[i]);
   }
   for(i=0;i<n;i++){
      scanf("%d",&b[i]);
   }

   for(i=0;i<n-1;i++){
      for(j=i+1;j<n;j++){
         if(a[i]>a[j]){
            t = a[i];
            a[i] = a[j];
            a[j] = t;
         }
      }
   }

   for(i=0;i<n-1;i++){
      for(j=i+1;j<n;j++){
         if(b[i]<b[j]){
            t = b[i];
            b[i] = b[j];
            b[j] = t;
         }
      }
   }

   for(i=0;i<n;i++){
      c+=(a[i]*b[i]);
   }

   printf("%d\n",c);

   return 0;
}