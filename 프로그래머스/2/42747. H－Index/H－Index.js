function solution(citations) {
    citations.sort((a, b) => b - a)
    let res = 0
    
    for(let i=0 ; i<citations.length ; i++){
        if(citations[i] >= i + 1){
            res = i+1
        } else {
            break
        }
    }
    
    return res
}