function solution(s) {
    
    function check(s) {
        let stack = []
        const matches = {
            ')': '(',
            ']': '[',
            '}': '{'
        }

        for (let ch of s) {
            if (ch === '(' || ch === '[' || ch === '{') {
                stack.push(ch)
            } else if (ch === ')' || ch === ']' || ch === '}') {
                if (stack.length === 0 || stack.pop() !== matches[ch]) {
                    return false
                }
            }
        }

        return stack.length === 0;
    }

    let res = 0
    for(let i=0 ; i<s.length ; i++){
        let arr = s.slice(i) + s.slice(0, i)
        if(check(arr)){
            res++
        }
    }
    
    return res
    
}