function solution(m, n, puddles) {
    const dp = Array.from({length: n + 1}, () => Array(m + 1).fill(0))
    dp[1][1] = 1
    
    puddles.forEach(([a,b]) => {
        dp[b][a] = -1
    })
    
    
    for(let i=1 ; i<=n ; i++){
        for(let j=1 ; j<=m ; j++){
            if(dp[i][j] === -1){
                dp[i][j] = 0
                continue
            }
            
            if(j > 1) dp[i][j] += dp[i][j-1]
            if(i > 1) dp[i][j] += dp[i-1][j]
            dp[i][j] %= 1000000007
        }
    }
    
    return dp[n][m]
}