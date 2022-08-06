#include <stdio.h>

int gcd(int a, int b){
   if(b==0){
      return a;
   }
   else{
      return gcd(b,a%b);
   }
}

int main(){

   int t,a,b,k;

   scanf("%d",&t);

   for(int i=0;i<t;i++){
      scanf("%d %d",&a,&b);
      printf("%d\n",a*b/gcd(a,b));
   }

   return 0;
}