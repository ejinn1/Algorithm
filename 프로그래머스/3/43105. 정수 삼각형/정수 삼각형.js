function solution(triangle) {
    const len = triangle.length
    let dp = Array.from({length: len}, () => [])
    dp[0][0] = triangle[0][0]
    
    console.log(dp)
    for(let i=1 ; i<len ; i++){
        for(let j=0 ; j<i+1 ; j++){
            if(j === 0){
                dp[i][j] = dp[i-1][j] + triangle[i][j]
            } else if(j === i){
                dp[i][j] = dp[i-1][j-1] + triangle[i][j]
            } else {
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j]    
            }
        }
    }
    
    return Math.max(...dp[len-1])
}