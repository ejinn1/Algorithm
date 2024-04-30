function solution(left, right) {
    function count(number){
        let cnt=0
        for(let i=0 ; i<number ; i++){
            if(number%i === 0){
                cnt++
            }
        }
        return cnt+1
    }
    
    let sum=0
    for(let i=left ; i<right+1 ; i++){
        if(count(i)%2 === 0){
            sum += i
        } else {
            sum -= i
        }
    }

    return sum

}