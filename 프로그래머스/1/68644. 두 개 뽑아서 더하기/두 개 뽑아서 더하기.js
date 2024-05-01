function solution(numbers) {
    const stack = []
    
    for(let i=0 ; i<numbers.length-1 ; i++){
        for(let j=i+1 ; j<numbers.length ; j++){
            stack.push(numbers[i] + numbers[j])
        }
    }
    
    return [...new Set(stack)].sort((a,b) => a-b)
}