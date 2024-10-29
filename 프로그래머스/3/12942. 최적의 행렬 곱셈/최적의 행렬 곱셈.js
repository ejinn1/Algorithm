function solution(matrix_sizes) {
    const n = matrix_sizes.length
    const dims = [matrix_sizes[0][0], ...matrix_sizes.map((matrix) => matrix[1])]
    const dp = Array.from({length: n}, () => Array(n).fill(Infinity))
    
    for(let i=0 ; i<n ; i++){
        dp[i][i] = 0
    }
    
    for(let cnt=2 ; cnt<=n ; cnt++){
        for(let i=0 ; i<=n-cnt ; i++){
            const j = i + cnt - 1
            for(let k=i ; k<j ; k++){
                const cost = dp[i][k] + dp[k+1][j] + dims[i] * dims[k+1] * dims[j+1]
                dp[i][j] = Math.min(dp[i][j], cost)
            }
        }
    }

    
    console.log(dp)
    
    return dp[0][n - 1];
}