function solution(players, callings) {
    let playerMap = new Map()

    players.forEach((player, index) => {
        playerMap.set(player, index)
    })
    
    callings.forEach((call) => {
        let idx = playerMap.get(call)
        playerMap.set(call, playerMap.get(call) - 1)
        let prev = players[idx - 1]
        playerMap.set(prev, playerMap.get(prev) + 1)
        
        players[idx - 1] = call
        players[idx] = prev
    })
    
    return players
}