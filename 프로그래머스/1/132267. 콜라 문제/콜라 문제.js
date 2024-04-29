function solution(a, b, n) {
    
    let get = 0
    let bottle = n
    
    while(true){
        get += Math.floor(bottle/a)*b
        bottle = Math.floor(bottle/a)*b + Math.floor(bottle%a)
        console.log(bottle)
        if(bottle < a){
            break
        }
    }
    
    return get
}