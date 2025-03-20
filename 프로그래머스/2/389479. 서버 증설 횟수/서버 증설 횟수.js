function solution(players, m, k) {
    const server = Array.from({length: players.length}, () => 0)
    let cnt = 0
    
    for(let i=0 ; i<players.length ; i++){
        if(i > 0){
            server[i] += server[i-1]
        }
        
        let need = parseInt(players[i] / m) - server[i]
        if(need > 0){
            cnt += need
            server[i] += need
            
            if(server.length > i+k){
                server[i+k] -= need   
            }    
        }
        
    }
    
    return cnt
}

