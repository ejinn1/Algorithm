function solution(n) {
    
    function hanoi(n, from, tmp, to){
        if(n === 1) return [[from, to]]
        let res = []
        res = res.concat(hanoi(n-1, from, to, tmp))
        res.push([from, to])
        res = res.concat(hanoi(n-1, tmp, from, to))
        
        return res
    }
    
    return hanoi(n, 1, 2, 3)
}