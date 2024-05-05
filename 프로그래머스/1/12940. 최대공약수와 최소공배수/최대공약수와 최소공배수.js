function solution(n, m) {
    function GCD(n, m){
        let gcd = 1
        for(let i=2 ; i<=Math.min(n, m) ; i++){
            if(n%i === 0 && m%i === 0){
                gcd = i
            }
        }
        
        return gcd
    }
    
    function LCM(n, m){
        let lcm = 1
        while(true){
            if(lcm%n === 0 && lcm%m === 0){
                break
            }
            lcm++
        }
        
        return lcm
    }
    
    return [GCD(n, m), LCM(n ,m)]

}