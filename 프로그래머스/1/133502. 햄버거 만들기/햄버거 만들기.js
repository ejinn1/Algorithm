function solution(ingredient) {
    const stack = []
    let t = -1
    let result = 0
    
    ingredient.forEach((i) => {
        if(i === 1 && stack[t] === 3 && stack[t-1] === 2 && stack[t-2] === 1){
            stack.pop()
            stack.pop()
            stack.pop()
            result++
            t = t-3
        } else {
            t++
            stack.push(i)
        }
    })
    
    
    return result
}