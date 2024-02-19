function solution(brown, yellow) {
    let result = []
    
    for(let i=1 ; i<=yellow ; i++){
        if(i*2 + (yellow/i)*2 + 4 == brown){
            result.push(i+2)
            result.push(yellow/i+2)
            result.sort((a, b) => b - a)
            break
        }
    }
    
    return result
}