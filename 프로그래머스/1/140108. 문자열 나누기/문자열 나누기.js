function solution(s) {
    
    const str = s.split('')
    let cur = str[0]
    let x = 0
    let y = 0
    let result = 0
    
    for(let i=0 ; i<str.length ; i++){
        if(cur === ""){
            cur = str[i]
        }
        
        if(str[i] === cur){
            x++
        } else {
            y++
        }
        
        if(x === y){
            cur = ""
            result++
        }
    }
    
    if(cur !== ""){
        result++
    }
    
    return result
}