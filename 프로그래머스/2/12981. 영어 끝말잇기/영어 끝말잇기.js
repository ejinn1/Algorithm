function solution(n, words) {
    
    const stack = []
    const result = []
    stack.push(words[0])
    let tmp = words[0].slice(-1)
    
    for(let i=1 ; i<words.length ; i++){
        if(tmp !== words[i].slice(0,1) || stack.includes(words[i])){
            const a = (i+1) % n === 0 ? n : (i+1) % n
            const b = Math.ceil((i+1) / n)
            result.push(a, b)
            break
        } else {
            tmp = words[i].slice(-1)
            stack.push(words[i])
        }
    }
    
    if(result.length === 0){
        return [0, 0]
    }
    
    return result
}