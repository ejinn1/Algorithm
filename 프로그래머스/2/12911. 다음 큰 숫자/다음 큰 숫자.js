function solution(n) {
    function countOne(n){
        let b = n.toString(2).split('')
        let cnt = b.reduce((acc, cur) => {return cur === '1' ? acc+1 : acc},0)
        return cnt
    }
    
    let k = countOne(n)
    let res = n+1
    while(true){
        if(k === countOne(res)) return res
        res++
        if(res === 1000000) break
    }
    
    return false
}