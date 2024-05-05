function solution(d, budget) {
    
    let sum = 0
    let result = 0
    d.sort((a,b) => a-b).forEach((x) => {
        if(sum + x <= budget){
            sum += x
            result++
        }
    })
    
    return result
}