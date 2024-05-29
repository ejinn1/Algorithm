function solution(board){
    
    const n = board.length
    const m = board[0].length
    const dp = Array.from({length: n+1}, () => Array.from({length: m+1}).fill(0))
    
    let max = 0
    for(let i=1 ; i<=n ; i++){
        for(let j=1 ; j<=m ; j++){
            if(board[i-1][j-1] === 1){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
                max = Math.max(max, dp[i][j])
            }
            
        }
    }
    
    return max * max
    
}