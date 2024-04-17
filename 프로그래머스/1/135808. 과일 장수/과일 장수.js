function solution(k, m, score) {
    score = score.sort((a, b) => b-a)
    
    let sum = 0
    for(let i=0 ; i<score.length ; i+=m){
        const box = score.slice(i,i+m)
        if(box[m-1]){
            sum += box[m-1] * m
        }   
    }
    
    return sum
}