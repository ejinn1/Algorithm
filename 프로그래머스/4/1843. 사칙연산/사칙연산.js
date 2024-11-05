function solution(arr){
    const n = Math.floor(arr.length / 2) + 1
    const maxDP = Array.from({length: n}, () => Array(n).fill(-Infinity))
    const minDP = Array.from({length: n}, () => Array(n).fill(Infinity))
    
    // ?
    for(let i=0 ; i<n ; i++){
        maxDP[i][i] = parseInt(arr[i*2])
        minDP[i][i] = parseInt(arr[i*2])
    }
    
    for(let len=1 ; len<n ; len++){
        for(let i=0 ; i<n-len ; i++){
            let j = i + len
            for(let k=i ; k<j ; k++){
                const operator = arr[k*2+1]
                
                if(operator === '+'){
                    maxDP[i][j] = Math.max(maxDP[i][j], maxDP[i][k] + maxDP[k+1][j])
                    minDP[i][j] = Math.min(minDP[i][j], minDP[i][k] + minDP[k+1][j])
                } else if(operator === '-'){
                    maxDP[i][j] = Math.max(maxDP[i][j], maxDP[i][k] - minDP[k+1][j])
                    minDP[i][j] = Math.min(minDP[i][j], minDP[i][k] - maxDP[k+1][j])
                }
            }
        }
    }
    
    return maxDP[0][n-1]
}