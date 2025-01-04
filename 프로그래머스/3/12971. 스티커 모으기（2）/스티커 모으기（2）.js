function solution(sticker) {
    const n = sticker.length
    if(sticker.length === 1) return sticker[0]
    
    const dp0 = Array(n).fill(0)
    dp0[0] = sticker[0]
    dp0[1] = Math.max(sticker[0], sticker[1])
    
    for(let i=2 ; i<n ; i++){
        dp0[i] = Math.max(dp0[i-1], dp0[i-2] + sticker[i])
    }
    
    const dp1 = Array(n).fill(0)
    dp1[1] = sticker[1]

    for(let i=2 ; i<n ; i++){
        dp1[i] = Math.max(dp1[i-1], dp1[i-2] + sticker[i])
    }
    
    return Math.max(dp0[n-2], dp1[n-1])

}