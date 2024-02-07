function solution(bridge_length, limit, trucks) {
    const bridge = Array.from({length: bridge_length}, () => 0)
    let weight = 0
    let time = 0
    
    
    while(trucks.length !== 0){
        weight -= bridge.shift()
        
        if(trucks.length > 0){
            let wait = trucks[0]
            if(weight + wait <= limit){
                bridge.push(trucks.shift())
                weight += wait
            } else {
                bridge.push(0)
            }
        }
        time++
    }
    
    
    return time + bridge.length;
}