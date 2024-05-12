function solution(n,a,b){
    
    let cnt = 0
    while(a !== b){
        if(a % 2 === 0){
            a = Math.floor(a / 2)
        } else {
            a = Math.floor((a + 1) / 2)
        }
        if(b % 2 === 0){
            b = Math.floor(b / 2)
        } else {
            b = Math.floor((b + 1) / 2)
        }
        cnt++ 
    }
    
    return cnt
}