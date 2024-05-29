function solution(s) {
    
    function compress(k, str){
        let arr = []
        for(let i=0 ; i<str.length ; i+=k){
            arr.push(str.slice(i, i+k))
        }
        let res = ""
        let cnt = 1
        let tmp = ""
        for(let a of arr){
            if(tmp === a){
                cnt++
            }  else {
                if(tmp !== ""){
                    res += cnt > 1 ? cnt + tmp : tmp
                }
                tmp = a
                cnt = 1
            }  
        }
        res += cnt > 1 ? cnt + tmp : tmp
        
        return res.length
    }
    
    let min = s.length
    for(let i=1 ; i<=Math.floor(s.length/2) ; i++){
        let k = compress(i, s)
        min = Math.min(k, min)
    }
    
    return min
}