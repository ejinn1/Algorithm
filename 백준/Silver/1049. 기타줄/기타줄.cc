#include <stdio.h>

int main(){

    int n,m,cash=0;
    int g6,g1;
    int a,b;
    int mg6=1001,mg1=1001;

    scanf("%d %d",&n,&m);

    for (int i = 0; i < m; ++i) {
        scanf("%d %d",&g6, &g1);
        if(g6 < mg6) mg6 = g6;
        if(g1 < mg1) mg1 = g1;
    }

    a = n/6;
    b = n%6;


    if(b*mg1 >= mg6){
        cash = a*mg6 + mg6;
    }
    else if(6*mg1 < mg6){
        cash = n*mg1;
    }
    else{
        cash = a*mg6 + b*mg1;
    }
    printf("%d\n",cash);

    
    
    return 0;
}
