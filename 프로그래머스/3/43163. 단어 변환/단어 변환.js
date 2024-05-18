function solution(begin, target, words) {
    
    if(!words.includes(target)) return 0
    
    let visited = Array.from({length : words.length}).fill(0)
    
    function check(cur, word){
        if(cur.length !== word.length) return false
        
        let cnt = 0
        for(let i=0 ; i<cur.length ; i++){
            if(cur[i] !== word[i]) cnt++
        }
        
        return cnt === 1
    }
    
    let res = Infinity
    function dfs(cur, cnt){
        if(cur === target){
            res = Math.min(res, cnt)
            return
        }
        
        for(let i=0 ; i<words.length ; i++){
            if(check(cur, words[i]) && visited[i] === 0){
                visited[i] = 1
                dfs(words[i], cnt + 1)
                visited[i] = 0
            }
        }
    }
    
    dfs(begin, 0)
    
    return res
}