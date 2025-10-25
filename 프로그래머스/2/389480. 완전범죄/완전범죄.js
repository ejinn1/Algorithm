function solution(info, n, m) {
    let dp = Array.from({length: m}).fill(Infinity)
    dp[0] = 0
    
    let result = 0
    
    for(let [a, b] of info){
        const next = Array.from({length: m}).fill(Infinity)
        for(let j=0 ; j<m ; j++){
            if(dp[j] === Infinity) continue
            if(dp[j] + a < n) next[j] = Math.min(next[j], dp[j] + a)
            if(j + b < m) next[j + b] = Math.min(next[j + b], dp[j])
        }
        dp = next
    }
    
    
    return Math.min(...dp) < n ? Math.min(...dp) : -1
}

