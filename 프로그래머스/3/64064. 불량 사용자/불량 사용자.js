

function solution(user_id, banned_id) {
    function check(id, ban){
        if(id.length !== ban.length) return false
        
        for(let i=0 ; i<id.length ; i++){
            if(id[i] !== ban[i] && ban[i] !== '*') return false
        }
        
        return true
    }
    
    let res = new Set()
    let path = []
    
    function back(idx){
        if(idx === banned_id.length){
            res.add(path.slice().sort().join(','))
            return
        }
        
        for(let i=0 ; i<user_id.length ; i++){
            if(check(user_id[i], banned_id[idx]) && !path.includes(user_id[i])){
                path.push(user_id[i])
                back(idx + 1)
                path.pop()
            }
        }
    }
    
    back(0)
    console.log(res)
    
    return res.size
}