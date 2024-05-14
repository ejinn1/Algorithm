function solution(order) {

    let stack = []
    let res = 0
    let i = 0
    let nextBox = 1
    
    while(nextBox <= order.length){
        if(order[i] === nextBox){
            res++
            i++
        } else {
            stack.push(nextBox)
        }
        
        nextBox++
        
        while(stack.length > 0 && stack[stack.length - 1] === order[i]){
            stack.pop()
            res++
            i++
        }
    }
    
    return res

}
