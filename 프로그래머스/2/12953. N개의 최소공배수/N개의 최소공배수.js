function solution(arr) {
    function gcd(a, b){
        while(b !== 0){
            const tmp = b
            b = a % b
            a = tmp
        }
        return a
    }
    
    function lcm(a, b){
        return (a * b) / gcd(a, b)
    }
    
    return arr.reduce((acc, val) => lcm(acc, val))
}