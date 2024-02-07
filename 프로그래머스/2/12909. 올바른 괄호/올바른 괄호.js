function solution(s){
    let stack = []
    
    if(s[0] === ')'){
        return false
    }
    
    for(const a of s){
        if(a == '('){
            stack.push(a)
        } else {
            stack.pop()
        }
    }
    
    return stack.length === 0
}